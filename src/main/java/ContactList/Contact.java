package ContactList;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.*;
import javax.persistence.*;

@Entity(name = "Contact")
public class Contact {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, String> name;
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, String> address;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch (FetchMode.SELECT)
    private List<PhoneNumber> phone;
    private String email;

    Contact() {}

    public Contact(Map<String, String> nameMap, Map<String, String> addressMap, List<PhoneNumber> phoneList, String email){
        this.name = nameMap;
        this.address = addressMap;
        this.phone = phoneList;
        this.email = email;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;
        if(!(o instanceof Contact))
            return false;

        Contact contact = (Contact) o;
        boolean phoneMatch = false;
        Map<String, String> thisPhone;
        Map<String, String> oPhone;

        if(this.phone.size() == contact.getPhone().size()){
            thisPhone = new HashMap<>();
            oPhone = new HashMap<>();

            for(int i = 0; i < this.phone.size(); i++){
                thisPhone.put(this.phone.get(i).getType(), this.phone.get(i).getNumber());
                oPhone.put(contact.getPhone().get(i).getType(), contact.getPhone().get(i).getNumber());
            }
            if((thisPhone.get("home") == oPhone.get("home")) && (thisPhone.get("mobile") == oPhone.get("mobile")) && (thisPhone.get("work") == oPhone.get("work"))){
                phoneMatch = true;
            }
        }
        else{
            return false;
        }

        return Objects.equals(this.id, contact.id) && Objects.equals(this.name, contact.name) && Objects.equals(this.address, contact.address)
                && phoneMatch && Objects.equals(this.email, contact.email);
    }
}

class ContactListVersion implements Comparable<ContactListVersion>{
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

    @Override
    public int compareTo(ContactListVersion clv){
        int returned = this.getName().get("last").compareTo(clv.getName().get("last"));
        if(returned == 0){
            returned = this.getName().get("first").compareTo(clv.getName().get("first"));
        }
        return returned;
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;
        if(!(o instanceof ContactListVersion))
            return false;
        ContactListVersion contact= (ContactListVersion) o;
        return Objects.equals(this.name, contact.name) && Objects.equals(this.number, contact.number);


    }
}
