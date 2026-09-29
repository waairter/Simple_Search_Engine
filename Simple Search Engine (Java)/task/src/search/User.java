package search;

public class User {

    private String firstName;
    private String secondName;
    private String email;

    public User(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public User(String firstName, String secondName, String email) {
        this(firstName, secondName);
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        String firstName = this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1);
        String secondName = this.secondName.substring(0, 1).toUpperCase() + this.secondName.substring(1);
        String email = this.email != null ? this.email : "";
        String userString = firstName + " " + secondName + " " + email;
        return userString.trim();
    }
}
