package cl.example.demoBCI.util;

public class Validation {

    static String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    static String phonePattern = "^\\d{8}$";
    static String passPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

    public static boolean isValidEmail(String email){
        return email.matches(emailPattern);
    }

    public static boolean isValidPhone(String phone){
        return phone.matches(phonePattern);
    }

    public static boolean isValidPassword(String password){
        return password.matches(passPattern);
    }

}
