package ContactList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ContactListRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Contact("Marc", "Brannon", "Charette", "1 Test Street", "Midlothian", "VA",
                    "23112", "7608779542", "home", "mb_charette@hotmail.com")));
        };
    }
}