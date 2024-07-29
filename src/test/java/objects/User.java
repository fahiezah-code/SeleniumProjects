package objects;

public class User {
// can set value to this class by parameter Constructor or Setter method
    String username;
    String email;
    String password;

    public User(){}
    public User(String username, String pw){
        this.username = username;

        this.password = pw;
    }


    public User(String username, String pw, String email){
        this.username = username;
        this.email = email;
        this.password = pw;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }



}
