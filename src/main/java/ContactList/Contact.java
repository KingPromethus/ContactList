package ContactList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

@Entity(name = "Contact")
public class Contact {
    private @Id @GeneratedValue Long id;
    @ElementCollection
    private Map<String, String> name;
    @ElementCollection
    private Map<String, String> address;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<PhoneNumber> phone;
    private String email;

    Contact() {}

    public Contact(Map<String, String> nameMap, Map<String, String> addressMap, List<PhoneNumber> phoneList, String email){
        this.name = nameMap;
        this.address = addressMap;
        this.phone = phoneList;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Map<String, String> getName() {
        return name;
    }

    public void setName(Map<String, String> name) {
        this.name = name;
    }

    public Map<String, String> getAddress() {
        return address;
    }

    public void setAddress(Map<String, String> address) {
        this.address = address;
    }

    public List<PhoneNumber> getPhone() {
        return phone;
    }

    public void setPhone(List<PhoneNumber> phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class ContactListVersion {
    private Map<String, String> name;
    private String number;

    public ContactListVersion() {}

    public ContactListVersion(Contact contact){
        this.name = contact.getName();
        for(PhoneNumber phone : contact.getPhone()){
            if(phone.getType().equals("home"))
                this.number = phone.getNumber();
        }
    }

    public Map<String, String> getName() {
        return name;
    }

    public void setName(Map<String, String> name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
