package craftintuit.intuitservice.resource;

import java.util.*;



public class CustomerMapper implements ICustomerRepository {
	
	HashMap<String, HashSet<String>> customermap;
	HashMap<String, String> productmap;
	
	private static CustomerMapper cm; 
	
	private CustomerMapper() {
		
		customermap = new HashMap<>();
		productmap = new HashMap<>();
		HashSet<String> hset = new HashSet<>();
		hset.add("accounting");
		hset.add("payroll");
		customermap.put("ramco",hset);
		HashSet<String> hset1 = new HashSet<>(hset);

		hset1.add("tsheets");
		hset1.add("payment");
		customermap.put("ganeshco",hset1);
		productmap.put("accounting", "http://localhost:8002/accounting/validate/");
		productmap.put("payroll", "http://localhost:8004/payroll/validate/");
		productmap.put("payment", "http://localhost:8003/payments/validate/");
		productmap.put("tsheets", "http://localhost:8005/tsheets/validate/");
	}
	
	public static CustomerMapper getDataManager() {
		if(cm==null)
			cm = new CustomerMapper();
		return cm;
	}
	
	public boolean validateCustomer(String ln){
		return customermap.get(ln)==null? false:true;
	}
	
	public HashSet<String> getAllSubscribedProducts(String ln) {
		return customermap.get(ln);
	}
	
	public boolean validateCustomerProduct(String ln, String prod) {
		return getAllSubscribedProducts(ln).contains(prod);
	}
	
	public String getProduct(String p) {
		return productmap.get(p);
	}
	
	public void addCustomer(String cust, HashSet<String> hset) {
		customermap.put(cust, hset);
	}

}
