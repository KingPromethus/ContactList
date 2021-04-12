package ContactList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contact {
    private @Id @GeneratedValue Long id;
//    private Name fullName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String email;
//    private ArrayList<PhoneNumber> phoneNumbers;
    private String phoneNumber;
    private String phoneType;

    Contact() {}

    public Contact(String firstName, String middleName, String lastName, String street, String city, String state,
             String zip, String phoneNumber, String phoneType, String email){
//        this.fullName.setFirstName(firstName);
//        this.fullName.setMiddleName(middleName);
//        this.fullName.setLastname(lastName);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
//        phoneNumbers.add(new PhoneNumber(phoneNumber, phoneType));
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
//        return this.fullName.getFirstName();
        return this.firstName;
    }

    public void setFirstName(String firstName) {
//        this.fullName.setFirstName(firstName);
        this.firstName = firstName;
    }

    public String getMiddleName() {
//        return this.fullName.getMiddleName();
        return middleName;
    }

    public void setMiddleName(String middleName) {
//        this.fullName.setMiddleName(middleName);
        this.middleName = middleName;
    }

    public String getLastName() {
//        return this.fullName.getLastname();
        return lastName;
    }

    public void setLastName(String lastName) {
//        this.fullName.setLastname(lastName);
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

//    public ArrayList<PhoneNumber> getPhoneNumbers(){
//        return this.phoneNumbers;
//    }

//    public void setPhoneNumbers(ArrayList<PhoneNumber> phoneNumbers){
//        this.phoneNumbers = phoneNumbers;
//    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType(){
        return this.phoneType;
    }

    public void setPhoneType(String phoneType){
        this.phoneType = phoneType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
