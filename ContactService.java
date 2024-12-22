public class ContactService {
	// declares variables for fields
    private Contact[] contacts;
    private int size;
    static final int maxContacts = 50; // set as static and final so it won't change
    
    // constructor
    public ContactService() {
    	// creates empty array with maxContacts capacity
    	this.contacts = new Contact[maxContacts];
    	
    	// initial size is set to 0 and tracks number of contacts
    	this.size = 0;
    	}
    
    // helper function
    private int getContactIndex(String contactId) {
    	// loop through contact array to compare contactIds
    	for (int i = 0; i < size; i++) {
    		if (contacts[i].getContactId().equals(contactId)) {
    			return i;
    		}
    	}
    	// return -1 if no match
    	return -1;
    }
    
    
    // method to add new contact
    public void addContact(Contact contact) {
    	// checks if array is full
    	if (size >= maxContacts) {
    		throw new IllegalStateException("List is full.");
    	}
    	
        // check if the Id is unique
    	if (getContactIndex(contact.getContactId()) != -1) {
    		throw new IllegalArgumentException("ID already exists.");
    	}
    	
    	// increments size
    	contacts[size++] = contact;
    }
    
    // method to delete contact by Id
    public void deleteContact(String contactId) {
    	// locates contact by Id
    	int index = getContactIndex(contactId);
    	
    	// index doesn't exist throw
    	if (index == -1) {
    		throw new IllegalArgumentException("ID does not exist.");
    	}
    	
    	// shifts all the contacts into the gap
    	for (int i = index; i < size - 1; i++) {
    		contacts[i] = contacts[i + 1];
    	}
    	
    	// sets last slot to null
    	contacts[--size] = null;
    }
    
    // method to update contact
    public void updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
    	// locates contact by the Id
    	int index = getContactIndex(contactId);
    	
    	// if Id doesn't exist throw
    	if (index == -1) {
    		throw new IllegalArgumentException("ID does not exist.");
    	}
    	
    	// pulls the contact at the index 
    	Contact contact = contacts[index];
    	
    	// if firstName is not null update firstName
    	if (firstName != null) contact.setFirstName(firstName);
    	
    	// if lastName is not null update lastName
    	if (lastName != null) contact.setLastName(lastName);
    	
    	// if phoneNumber is not null update phoneNumber
    	if (phoneNumber != null) contact.setPhoneNumber(phoneNumber);
    	
    	// if address is not null update address
    	if (address != null) contact.setAddress(address);
    }
    
    // method to get contact by Id
    public Contact getContact(String contactId) {
    	// locates contact by the Id
    	int index = getContactIndex(contactId);
    	
    	// if contact is not found return null
    	if (index == -1) {
    		return null;
    	}
    	
    	// return the contact found at the index
    	return contacts[index];
    }
    
}