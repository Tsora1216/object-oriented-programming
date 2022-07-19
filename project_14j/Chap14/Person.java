// Listing 14-2 Person

public class Person {

    private final String firstName;
    private final String lastName;
    private final String email;

    public Person(String fName, String lName, String email) {
        this.firstName = fName;
        this.lastName = lName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}