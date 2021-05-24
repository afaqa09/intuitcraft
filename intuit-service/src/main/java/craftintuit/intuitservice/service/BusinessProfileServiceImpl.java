package craftintuit.intuitservice.service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import craftintuit.intuitservice.entity.BusinessProfile;
import craftintuit.intuitservice.entity.Response;
import craftintuit.intuitservice.exceptions.CustomerFoundException;
import craftintuit.intuitservice.exceptions.CustomerNotFound;
import craftintuit.intuitservice.exceptions.ProductNotFound;
import craftintuit.intuitservice.exceptions.ValidateProductFailed;
import craftintuit.intuitservice.resource.CustomerMapper;
import craftintuit.intuitservice.resource.ICustomerRepository;


@Service
public class BusinessProfileServiceImpl implements IBusinessProfileService {

	ICustomerRepository cr;
	
	RestTemplate restTemplate = new RestTemplate();
	
	public BusinessProfileServiceImpl() {		
		cr = CustomerMapper.getDataManager();
	}
	
	public ResponseEntity<List<String>> getProfile(String ln) {
		if(!cr.validateCustomer(ln))
			throw new CustomerNotFound("CUSTOMER NOT FOUND "+ ln);
		return new ResponseEntity<List<String>>(new ArrayList<String>(cr.getAllSubscribedProducts(ln)) , HttpStatus.OK);

	}
	
	public ResponseEntity<Response> updateProfile(String ln, BusinessProfile bp) {
		if(!cr.validateCustomer(ln))
			throw new CustomerNotFound("CUSTOMER NOT FOUND "+ ln);
		
		try {
			for(String prod: cr.getAllSubscribedProducts(ln)) {
		
				System.out.println("\n CALLING TO VALIDATE : "+ prod);
				validateProduct(ln,prod);
			}
		}
		catch(ResourceAccessException rae) {
			return new ResponseEntity<Response>(new Response(false, rae.getMessage()), HttpStatus.REQUEST_TIMEOUT);
		}
		catch(Exception e) {			
			return new ResponseEntity<Response>(new Response(false, e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
		}
		
		saveBusinessProfile(ln, bp);
		return new ResponseEntity<Response>(new Response(true, "ALL SUBSCRIBED VALIDATED"), HttpStatus.OK);
	}

	private void saveBusinessProfile(String ln, BusinessProfile bp) {
		
		
	}

	private void validateProduct(String p, String prod) throws ResourceAccessException{
		String endpt = cr.getProduct(prod);
		if(endpt==null)
			throw new ProductNotFound("PRODUCT NOT FOUND "+ prod);
		endpt+=p;
		System.out.println("Calling out:  "+endpt);
		Response r ;

		r= restTemplate.getForObject(endpt, Response.class);
		
		System.out.println("VALIDATION SUCCESS FOR "+r.getMesg()+" "+ r.isSuccess());
		
		if(!r.isSuccess())
			throw new ValidateProductFailed("VALIDATE PRODUCT FAILED " + prod + " FOR "+ p);		
	}

	
	public ResponseEntity<Response> createProfile(String prodstring,BusinessProfile bp) {
		if(cr.validateCustomer(bp.getLegalName()))
			throw new CustomerFoundException("CUSTOMER EXIST WITH LEGAL NAME "+ bp.getLegalName());
		String []prodarray = prodstring.split(":");
		HashSet<String> hset = new HashSet<>();
		for(String prod: prodarray)
			hset.add(prod);
		
		cr.addCustomer(bp.getLegalName(), hset);
		System.out.println(bp.getLegalName() + " CREATED "+ hset);
		return new ResponseEntity<Response>(new Response(true, "PROFILE CREATED"), HttpStatus.OK);
	}
	
}
