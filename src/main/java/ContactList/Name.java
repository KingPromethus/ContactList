package ContactList;

public class Name {
    private String firstName;
    private String middleName;
    private String lastname;

    public Name(String firstName, String middleName, String lastname) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastname = lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
