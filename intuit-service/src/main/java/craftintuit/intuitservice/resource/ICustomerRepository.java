package craftintuit.intuitservice.resource;

import java.util.*;

public interface ICustomerRepository {
	
	public boolean validateCustomer(String ln);
	
	public HashSet<String> getAllSubscribedProducts(String ln) ;
	
	public boolean validateCustomerProduct(String ln, String prod);
	
	public String getProduct(String p);
	
	public void addCustomer(String cust, HashSet<String> hset) ;

}
