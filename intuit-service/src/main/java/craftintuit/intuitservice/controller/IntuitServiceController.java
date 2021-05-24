package craftintuit.intuitservice.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import craftintuit.intuitservice.entity.Address;
import craftintuit.intuitservice.entity.BusinessProfile;
import craftintuit.intuitservice.entity.Response;
import craftintuit.intuitservice.entity.TaxIdentifier;
import craftintuit.intuitservice.service.IBusinessProfileService;


@RestController
@RequestMapping("/intuitservice")
public class IntuitServiceController {
	
	@Autowired
	IBusinessProfileService businessprofService;
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<List<String>> getCustomer(@PathVariable String id) {
		return businessprofService.getProfile(id);
	
	}
	
	@PostMapping("/businessprofile/{custname}")
	public ResponseEntity<Response> createBP(@PathVariable String custname, @RequestBody String prodstring) {
		Address a = new Address ("l11","l2","Delhi", "Delhi", 11002,"India");
		return businessprofService.createProfile(prodstring,new BusinessProfile(custname, custname+"co", a, a, TaxIdentifier.PAN, "bc@email.com", "bc.com"));
	}
	
	@PutMapping("/businessprofile/{id}")
	public ResponseEntity<Response> updateBP(@PathVariable String id) {
		Address a = new Address ("l1","l2","Delhi", "Delhi", 11002,"India");
		return businessprofService.updateProfile(id, new BusinessProfile("gc", "aman", a, a, TaxIdentifier.PAN, "gc@email.com", "gc.com"));
	}

	
}
