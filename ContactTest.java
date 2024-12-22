import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testContact() {
    	// makes new contact for test
        Contact contact = new Contact("98765", "Nicholas", "Altemoos", "0123456789", "398 Jericho Ln");
        
        // tests that the contact is not null
        assertNotNull(contact);
        
        // tests that the contact is created correctly
        assertEquals("98765", contact.getContactId());
        assertEquals("Nicholas", contact.getFirstName());
        assertEquals("Altemoos", contact.getLastName());
        assertEquals("0123456789", contact.getPhoneNumber());
        assertEquals("398 Jericho Ln", contact.getAddress());
    }

    @Test
    public void testContactIdTooLong() {
    	// tests when contactId is too long
        assertThrows(IllegalArgumentException.class, () -> new Contact("19876543210", "Nicholas", "Altemoos", "0123456789", "398 Jericho Ln"));
    }
    
    @Test
    public void testContactIdNUll() {
    	// tests when contactId is null
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Nicholas", "Altemoos", "0123456789", "398 Jericho Ln"));
    }

    @Test
    public void testFirstNameTooLong() {
    	// tests when firstName is too long
        assertThrows(IllegalArgumentException.class, () -> new Contact("98765", "NicholasNicholas", "Altemoos", "0123456789", "398 Jericho Ln"));
    }
    
    @Test
    public void testFirstNameNull() {
    	// tests when firstName is null
    	assertThrows(IllegalArgumentException.class, () -> new Contact("98765", null, "Altemoos", "0123456789", "398 Jericho Ln"));
    }
    
    @Test
    public void testLastNameTooLong() {
    	// tests when lastName is too long
        assertThrows(IllegalArgumentException.class, () -> new Contact("98765", "Nicholas", "AltemoosAltemoos", "0123456789", "398 Jericho Ln"));
    }
    
    @Test
    public void testLastNameNull() {
    	// tests when lastName is null
    	assertThrows(IllegalArgumentException.class, () -> new Contact("98765", "Nicholas", null, "0123456789", "398 Jericho Ln"));
    }
    
    @Test
    public void testAddressToolong() {
    	// tests when address is too long
    	assertThrows(IllegalArgumentException.class, () -> new Contact("98765", "NicholasNicholas", "Altemoos", "0123456789", "0123456789012345678901234567891"));
    }
    
    @Test
    public void testAddressNull() {
    	// tests when address is null
    	assertThrows(IllegalArgumentException.class, () -> new Contact("98765", "NicholasNicholas", "Altemoos", "0123456789", null));
    }

    @Test
    public void testPhoneNumberInvalid() {
    	// tests when phoneNumber is invalid with characters
        assertThrows(IllegalArgumentException.class, () -> new Contact("98765", "Nicholas", "Altemoos", "a123456789", "398 Jericho Ln"));
    }
    
    @Test
    public void testPhoneNumberTooLong() {
    	// tests when phoneNumber is too long
        assertThrows(IllegalArgumentException.class, () -> new Contact("98765", "Nicholas", "Altemoos", "10123456789", "398 Jericho Ln"));
    }
    
    @Test
    public void testPhoneNumberNull() {
    	// tests when phoneNumber is null
        assertThrows(IllegalArgumentException.class, () -> new Contact("98765", "Nicholas", "Altemoos", null, "398 Jericho Ln"));
    }

}