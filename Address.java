package in.mecw.entity;


	

	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.OneToOne;

	@Entity
	public class Address {
		@Id
	       private int addressId;
	       private String house;
	       private String street;
	       private String city;
	       private String state;
	       private int pincode;
	       @OneToOne
	       private Student students;
		   public int getAddressId() {
			   return addressId;
		   }
		   public void setAddressId(int addressId) {
			   this.addressId = addressId;
		   }
		   public String getHouse() {
			   return house;
		   }
		   public void setHouse(String house) {
			   this.house = house;
		   }
		   public String getStreet() {
			   return street;
		   }
		   public void setStreet(String street) {
			   this.street = street;
		   }
		   public String getCity() {
			   return city;
		   }
		   public void setCity(String city) {
			   this.city = city;
		   }
		   public String getState() {
			   return state;
		   }
		   public void setState(String state) {
			   this.state = state;
		   }
		   public int getPincode() {
			   return pincode;
		   }
		   public void setPincode(int pincode) {
			   this.pincode = pincode;
		   }
	       
	}

