package ContactList;

import java.util.*;

import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ContactListController {
    private final ContactListRepository repository;

    ContactListController(ContactListRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/contacts")
    List<Contact> all() {
        return repository.findAll();
    }

    @PostMapping("/contacts")
    Contact newContact(@RequestBody Contact newContact) {
        return repository.save(newContact);
    }

    @PutMapping("contacts/{id}")
    Contact replaceContact(@RequestBody Contact newContact, @PathVariable Long id) {
        return repository.findById(id).map(contact -> {
            contact.setFirstName(newContact.getFirstName());
            contact.setMiddleName(newContact.getMiddleName());
            contact.setLastName(newContact.getLastName());
            contact.setStreet(newContact.getStreet());
            contact.setCity(newContact.getCity());
            contact.setState(newContact.getState());
            contact.setZip(newContact.getZip());
            contact.setPhoneNumber(newContact.getPhoneNumber());
            contact.setPhoneType(newContact.getPhoneType());
            contact.setEmail(newContact.getEmail());
            return repository.save(contact);
        }).orElseGet(() -> {
            newContact.setId(id);
            return repository.save(newContact);
        });
    }

    @GetMapping("/contacts/{id}")
    Contact one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Failed"));
    }

    @DeleteMapping("contacts/{id}")
    void deleteContact(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("contacts/call-list")
    List<Contact> callList(){
        List<Contact> homePhones = new ArrayList<Contact>();
        List<Contact> all = repository.findAll();
        for (Contact contact : all) {
            if(contact.getPhoneType() == "home"){
                homePhones.add(contact);
            }
        }
        return homePhones;
    }
}
