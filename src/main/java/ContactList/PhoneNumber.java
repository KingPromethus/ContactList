package ContactList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "PhoneNumber")
public class PhoneNumber {
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Contact contact;
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    private UUID id;
    private String number;
    private String type;

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

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof PhoneNumber))
            return false;
        PhoneNumber phoneNumber = (PhoneNumber) o;
        return Objects.equals(this.number, phoneNumber.number) && Objects.equals(this.type, phoneNumber.type);
    }
}
