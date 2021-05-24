package craftintuit.intuitservice.entity;

public class Address {
	public Address(String line1, String line2, String city, String state, int zip, String country) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	String line1;
	String line2;
	String city;
	String state;
	int zip;
	String country;
}
