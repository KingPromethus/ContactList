package ContactList;

import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
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
//        Map<String, String> testMap = new HashMap<String, String>();
//        testMap.put("number", "7608779542");
//        testMap.put("type", "mobile");
        List<PhoneNumber> testPhone = new ArrayList<PhoneNumber>();
        testPhone.add(new PhoneNumber("7608779542", "mobile"));
//        testPhone.add(new PhoneNumber("700200300", "home"));
        return args -> {
            log.info("Preloading " + repository.save(new Contact(testName, testAddress, testPhone, "mb_charette@hotmail.com")));
        };
    }
}