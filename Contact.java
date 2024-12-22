
public class Contact {
	// declares variable for the fields needed
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private final String contactId;// set to final so it can't be changed
	
	//
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		// makes sure contactId is not null and less than 10 characters
		if (contactId == null || contactId.length() > 10) {
			 throw new IllegalArgumentException("Contact ID can't be null and no longer than 10 characters.");
	        }
        
		// makes sure firstName is not null and less than 10 characters
		if (firstName == null || firstName.length() > 10) {
			 throw new IllegalArgumentException("First name can't be null and no longer than 10 characters.");
        }
        
		// makes sure lastName is not null and less than 10 characters
		if (lastName == null || lastName.length() > 10) {
			 throw new IllegalArgumentException("Last name can't be null and no longer than 10 characters.");
        }
        
		// makes sure phoneNumber is not null, exactly 10 characters, and digits only 
		if (phoneNumber == null || phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
			 throw new IllegalArgumentException("Phone number can't be null and must be exactly 10 digits.");
        }
        
		// makes sure address is not null and 30 characters and below
		if (address == null || address.length() > 30) {
			 throw new IllegalArgumentException("Address can't be null and no longer than 30 characters.");
        }
		
		// sets each field to the spot in the constructor field
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	//setter methods
	public void setFirstName(String firstName) {
		if (firstName != null && firstName.length() <= 10) {
			this.firstName = firstName;
		}
		else {
			throw new IllegalArgumentException("First name can't be null and no longer than 10 characters.");
		}
	}
	
	public void setLastName(String lastName) {
		if (firstName != null && firstName.length() <= 10) {
			this.lastName = lastName;
		}
		else {
			throw new IllegalArgumentException("Last name can't be null and no longer than 10 characters.");
		}
	}
	
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber != null && phoneNumber.length() == 10 && phoneNumber.matches("\\d+")) {
			this.phoneNumber = phoneNumber;
		}
		else {
			throw new IllegalArgumentException("Phone can't be null and must be exactly 10 digits.");
        }
	}
	
	public void setAddress(String address) {
		if (address != null && address.length() <= 30) {
			this.address = address;
		}
		else {
			throw new IllegalArgumentException("Address can't be null and no longer than 30 characters.");
        }
	}
	
	// getter methods
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}

}
