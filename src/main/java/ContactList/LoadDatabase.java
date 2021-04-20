package ContactList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ContactListRepository repository) {
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
        return args -> {
            log.info("Preloading " + repository.save(new Contact(testName, testAddress, testPhone, "mb_charette@hotmail.com")));
        };
    }
}