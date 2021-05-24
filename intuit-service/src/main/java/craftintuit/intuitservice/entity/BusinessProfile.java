package craftintuit.intuitservice.entity;

public class BusinessProfile {
	String customerName;
	String legalName;
	Address businessAddress;
	Address legalAddress;
	TaxIdentifier taxIdentifier;
	String email;
	String website;
	
	public BusinessProfile(String customerName, String legalName, Address businessAddress, Address legalAddress,
			TaxIdentifier taxIdentifier, String email, String website) {
		super();
		this.customerName = customerName;
		this.legalName = legalName;
		this.businessAddress = businessAddress;
		this.legalAddress = legalAddress;
		this.taxIdentifier = taxIdentifier;
		this.email = email;
		this.website = website;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public Address getBusinessAddress() {
		return businessAddress;
	}
	public void setBusinessAddress(Address businessAddress) {
		this.businessAddress = businessAddress;
	}
	public Address getLegalAddress() {
		return legalAddress;
	}
	public void setLegalAddress(Address legalAddress) {
		this.legalAddress = legalAddress;
	}
	public TaxIdentifier getTaxIdentifier() {
		return taxIdentifier;
	}
	public void setTaxIdentifier(TaxIdentifier taxIdentifier) {
		this.taxIdentifier = taxIdentifier;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
}
