package telran.user.model;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        // TODO use setEmail()
        setEmail(email);
        this.password = password;
    }

    public void setEmail(String email) {
        // TODO to use validateEmail
        if (validateEmail(email)) this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // pete@gmail.com
    /* TODO:
        1. @ exists and only one
        2. dot after @
        3. after last dot minimum 2 symbols
        4. alphabetic, digits, _, -, ., @

     */
    private boolean validateEmail(String email) {
        if (email.indexOf('@') == -1) {
            return false;
        }else if (email.indexOf('@', email.indexOf('@') + 1) != -1){
            return false;
        } else if (email.indexOf('.', email.indexOf('@') + 1) == -1) {
            return false;
        } else if (email.indexOf('.', email.indexOf('.') + 1) != -1) {
            return false;
        } else if (!(email.length() - email.indexOf('.', email.indexOf('@') + 1) > 1)){
            return false;
        } else if (!email.matches("[a-zA-Z0-9_.@\\-]+")){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}



