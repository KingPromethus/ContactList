package ContactList;

import javax.persistence.*;

@Entity
public class PhoneNumber {
    public @Id @GeneratedValue long id;
    public String number;
    public String type;
    @ManyToOne
    private Contact contact;

    public PhoneNumber(String phoneNumber, String phoneType) {
        this.number = phoneNumber;
        this.type = phoneType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
