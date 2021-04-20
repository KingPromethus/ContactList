package ContactList;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ContactListApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(ContactListApplicationTests.class);
	private Map<String, String> testName;
	private Map<String, String> testAddress;
	private List<PhoneNumber> testPhone;
	private String testEmail;
	private Contact testHarold;

	@Autowired
	private ContactListController controller;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void init(){
		log.info("Startup");
		testName = new HashMap<String, String>();
		testName.put("first", "Harold");
		testName.put("middle", "Francis");
		testName.put("last", "Gilkey");
		testAddress = new HashMap<String, String>();
		testAddress.put("street", "8360 High Autumn Row");
		testAddress.put("city", "Cannon");
		testAddress.put("state", "Delaware");
		testAddress.put("zip", "19797");
		testPhone = new ArrayList<PhoneNumber>();
		testPhone.add(new PhoneNumber("302-611-9148", "home"));
		testPhone.add(new PhoneNumber("302-532-9427", "mobile"));
		testEmail = "harold.gilkey@yahoo.com";
		testHarold = new Contact(testName, testAddress, testPhone, testEmail);
	}

	@AfterEach
	public void cleanUp(){
		log.info("Reset");
		testName.clear();
		testAddress.clear();
		testPhone.clear();
		testEmail = "";
		testHarold = null;
	}

	@Test
	public void getTest() throws Exception{
		Map<String, String> testName = new HashMap<String, String>();
		testName.put("first", "Marc");
		testName.put("middle", "Brannon");
		testName.put("last", "Charette");
		Map<String, String> testAddress = new HashMap<String, String>();
		testAddress.put("street", "1 Test Drive");
		testAddress.put("city", "Richmond");
		testAddress.put("state", "Virginia");
		testAddress.put("zip", "23112");
		List<PhoneNumber> testPhone = new ArrayList<>();
		testPhone.add(new PhoneNumber("7608779542", "mobile"));
		Contact marc = new Contact(testName, testAddress, testPhone, "mb_charette@hotmail.com");
		marc.setId(1L);

		List<Contact> returned = controller.all();
		Assert.assertTrue(returned.get(0).equals(marc));

		//Test single ID gets work as well
		Contact contact = controller.one(1L);
		Assert.assertTrue(contact.equals(marc));

	}

	@Test
	public void postTest() throws Exception{
		Map<String, String> testName = new HashMap<String, String>();
		testName.put("first", "Harold");
		testName.put("middle", "Francis");
		testName.put("last", "Gilkey");
		Map<String, String> testAddress = new HashMap<String, String>();
		testAddress.put("street", "8360 High Autumn Row");
		testAddress.put("city", "Cannon");
		testAddress.put("state", "Delaware");
		testAddress.put("zip", "19797");
		List<PhoneNumber> testPhone = new ArrayList<>();
		testPhone.add(new PhoneNumber("302-611-9148", "home"));
        testPhone.add(new PhoneNumber("302-532-9427", "mobile"));
		Contact harold = new Contact(testName, testAddress, testPhone, "harold.gilkey@yahoo.com");

		Contact returned = controller.newContact(testHarold);
		harold.setId(2L);
		returned.equals(harold);
	}

	@Test
	public void putTest() throws Exception{
		Map<String, String> testName = new HashMap<String, String>();
		testName.put("first", "Harold");
		testName.put("middle", "Francis");
		testName.put("last", "Gilkey");
		Map<String, String> testAddress = new HashMap<String, String>();
		testAddress.put("street", "8360 High Autumn Row");
		testAddress.put("city", "Cannon");
		testAddress.put("state", "Delaware");
		testAddress.put("zip", "19797");
		List<PhoneNumber> testPhone = new ArrayList<>();
		testPhone.add(new PhoneNumber("302-611-9148", "home"));
		testPhone.add(new PhoneNumber("302-532-9427", "mobile"));
		Contact harold = new Contact(testName, testAddress, testPhone, "harold.gilkey@yahoo.com");

		//Test if its not there, PUT will place it
		Contact returned = controller.replaceContact(testHarold, 2L);
		harold.setId(2L);
		returned.equals(harold);

		//Then test if it is there, PUT will update it
		testName = new HashMap<String, String>();
		testName.put("first", "Marc");
		testName.put("middle", "Brannon");
		testName.put("last", "Charette");
		testAddress = new HashMap<String, String>();
		testAddress.put("street", "1 Test Road");
		testAddress.put("city", "Place City");
		testAddress.put("state", "Place State");
		testAddress.put("zip", "12345");
		testPhone = new ArrayList<>();
		testPhone.add(new PhoneNumber("111-111-1111", "home"));
		testPhone.add(new PhoneNumber("222-222-2222", "mobile"));
		testEmail = "mb_charette@hotmail.com";
		Contact localHarold = new Contact(testName, testAddress, testPhone, testEmail);
		testHarold.setName(testName);
		testHarold.setAddress(testAddress);
		testHarold.setPhone(testPhone);
		testHarold.setEmail("mb_charette@hotmail.com");

		Contact returnedAgain = controller.replaceContact(testHarold, 2L);
		returnedAgain.equals(localHarold);
	}

	@Test
	public void deleteTest() throws Exception{
		Contact returned = controller.newContact(testHarold);
		List<Contact> all = controller.all();
		Assert.assertTrue(all.contains(testHarold));
		controller.deleteContact(2L);
		all = controller.all();
		Assert.assertTrue(!all.contains(testHarold));
	}

	@Test
	public void callListTest() throws Exception{
		Map<String, String> testName = new HashMap<String, String>();
		testName.put("first", "Harold");
		testName.put("middle", "Francis");
		testName.put("last", "Gilkey");
		Map<String, String> testAddress = new HashMap<String, String>();
		testAddress.put("street", "8360 High Autumn Row");
		testAddress.put("city", "Cannon");
		testAddress.put("state", "Delaware");
		testAddress.put("zip", "19797");
		List<PhoneNumber> testPhone = new ArrayList<>();
		testPhone.add(new PhoneNumber("302-611-9148", "home"));
		testPhone.add(new PhoneNumber("302-532-9427", "mobile"));
		Contact harold = new Contact(testName, testAddress, testPhone, "harold.gilkey@yahoo.com");

		testName = new HashMap<String, String>();
		testName.put("first", "Wanda");
		testName.put("middle", "Vision");
		testName.put("last", "Maximoff");
		testAddress = new HashMap<String, String>();
		testAddress.put("street", "No. 2800");
		testAddress.put("city", "Westview");
		testAddress.put("state", "New York");
		testAddress.put("zip", "21211");
		testPhone = new ArrayList<>();
		testPhone.add(new PhoneNumber("222-222-2222", "home"));
		testPhone.add(new PhoneNumber("111-111-1111", "mobile"));
		Contact wanda = new Contact(testName, testAddress, testPhone, "wanda.maximoff@stark.com");


		ContactListVersion contactListHarold = new ContactListVersion(harold);
		ContactListVersion contactListWanda = new ContactListVersion(wanda);
		Contact returned = controller.newContact(testHarold);
		Contact returned2 = controller.newContact(wanda);
		List<ContactListVersion> callList = controller.callList();

		Assert.assertTrue(callList.get(0).equals(contactListHarold));
		Assert.assertTrue(callList.get(1).equals(contactListWanda));
	}
}
