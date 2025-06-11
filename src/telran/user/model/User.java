package telran.user.model;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        // TODO use setEmail()
        setEmail(email);
        setPassword(password);
        // this.password = password;
    }

    public void setEmail(String email) {
        // TODO to use validateEmail
        if (validateEmail(email)) this.email = email;
    }

    public void setPassword(String password) {
        if (validatePassword(password)) {
            this.password = password;
        } else {
            System.out.println("Password not valid");
        }

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
        } else if (!(email.length() - email.indexOf('.', email.indexOf('@')) >= 3)){
            return false;
        } else if (!email.matches("[a-zA-Z0-9_.@\\-]+")){
            return false;
        }
        return true;
    }


    /*
        1. minimum 8 symbols
        2. min one digit
        3. min one special symbol (!%@*&)
        4. min one symbol of uppercase
        5. min one symbol of lowercase
     */
    private boolean validatePassword(String password){
        boolean[] res = new boolean[5];
        int len = password.length();
        if (len >= 8) {
            res[0] = true;
        }
        for (int i=0; i < len; i++){
            char c = password.charAt(i);
            if (Character.isDigit(c)){
                res[1] = true;
            }
            if (isSpecSymbol(c)){
                res[2] = true;
            }
            if (Character.isUpperCase(c)){
                res[3] = true;
            }
            if (Character.isLowerCase(c)){
                res[4] = true;
            }
            if(res[0] && res[1] && res[2] && res[3] && res[4]){
                return true;
            }
        }
        return false;
    }

    private boolean isSpecSymbol(char c) {
        return "!%@*&".indexOf(c) >= 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}



