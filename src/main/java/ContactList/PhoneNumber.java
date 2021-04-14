package ContactList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class PhoneNumber {
    public @Id @GeneratedValue @JsonIgnore long id;
    public String number;
    public String type;

    public PhoneNumber() {}

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
}
