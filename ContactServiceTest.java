import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
	
    private ContactService contactService;
    
    @BeforeEach
    void setUp() {
    	// makes a new contactService instance before each test
    	contactService = new ContactService();
    }
    
    @Test
    void testAddContact() {
    	// makes new contact for test
    	Contact contact = new Contact("98765", "Nicholas", "Altemoos", "0123456789", "398 Jericho Ln");
    	
    	// adds addContact to the instance
    	contactService.addContact(contact);
    	
    	// gets the contact by Id
    	Contact retrieved = contactService.getContact("98765");
    	
    	// makes sure contact was added and not null
    	assertNotNull(retrieved);
    	
    	// makes sure the name matches the expected value
    	assertEquals("Nicholas", retrieved.getFirstName());
    }
    
    @Test
    void testAddContactIdDuplicateThrowsException() {
    	// makes new contact for test
    	Contact contact = new Contact("98765", "Nicholas", "Altemoos", "0123456789", "398 Jericho Ln");
    	
    	// adds addContect to the instance
    	contactService.addContact(contact);
    	
    	// adds add contact and throws a error message w
    	Exception exception = assertThrows(IllegalArgumentException.class, () -> {
    		contactService.addContact(new Contact("98765", "John", "Smith", "0987654321", "945 Geronimo Ave"));
    	});
    	
    	assertEquals("ID already exists.", exception.getMessage());
    }
    
    @Test
    void testDeleteContact() {
    	// makes new contact for test
    	Contact contact = new Contact("98765", "Nicholas", "Altemoos", "0123456789", "398 Jericho Ln");
    	
    	// adds addContact to the instance
    	contactService.addContact(contact);
    	
    	// deletes the contact from the instance by Id
    	contactService.deleteContact("98765");
    	
    	// makes sure the contact is not in the instance after deletion
    	assertNull(contactService.getContact("98765"));
    }
    
    @Test
    void testDeleteContactNotFound() {
    	// tests when a contact is not found when trying to delete
    	assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("48759"));
    }
    
    @Test
    void testUpdateContact() {
    	// makes new contact for test
    	Contact contact = new Contact("98765", "Nicholas", "Altemoos", "0123456789", "398 Jericho Ln");
    	
    	// adds addContact to the instance
    	contactService.addContact(contact);
    	
    	// updates the instance with new information
    	contactService.updateContact("98765", "John", "Smith", "0987654321", "945 Geronimo Ave");
    	
    	// uses getContact to pull the contact in the instance
    	Contact updated = contactService.getContact("98765");
    	
    	// makes sure the updated instance is not null
    	assertNotNull(updated);
    	
    	// makes sure the firstName field is updated to the new information
    	assertEquals("John", updated.getFirstName());
    	
    	// makes sure the lastName field is updated to the new information
    	assertEquals("Smith", updated.getLastName());
    	
    	// makes sure the phoneNumber field is updated to the new information
    	assertEquals("0987654321", updated.getPhoneNumber());
    	
    	// makes sure the address field is updated to the new information
    	assertEquals("945 Geronimo Ave", updated.getAddress());
    }
    
    @Test
    void testContactUpdateNotFound() {
    	// tests when a contact is not found when trying to update
    	assertThrows(IllegalArgumentException.class, () -> contactService.updateContact("99999", "Nicholas", "Altemoos", "0123456789", "398 Jericho Ln"));
    }
    
    @Test
    void testAddContactFullList() {
    	// loop to fill the array with base contacts
    	for (int i = 0; i < ContactService.maxContacts; i++) {
    		contactService.addContact(new Contact(String.valueOf(i), "Nicholas", "Altemoos", "0123456789", "398 Jericho Ln"));
    	}
    	
    	// throws error message after adding one contact past limit
    	Exception exception = assertThrows(IllegalStateException.class, () -> {
    		contactService.addContact(new Contact("51", "John", "Smith", "0987654321", "945 Geronimo Ave"));
    	});
    	
    	// makes sure the error message is correct
    	assertEquals("List is full.", exception.getMessage());
    }

}
