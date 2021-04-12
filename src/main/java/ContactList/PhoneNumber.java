package ContactList;

public class PhoneNumber {
    public String phoneNumber;
    public String phoneType;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.phoneType = "home";
    }

    public PhoneNumber(String phoneNumber, String phoneType) {
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;

    }
}
