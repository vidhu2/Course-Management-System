package courseapp;

public class Validation {

    public static boolean isValidName(String name) {

        return name != null &&
                !name.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {

        return email != null &&
                email.matches(
                        "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
                );
    }

    public static boolean isValidPhone(String phone) {

        return phone != null &&
                phone.matches("[0-9]{10}");
    }

    public static boolean isValidFee(float fee) {

        return Float.isFinite(fee) && fee >= 0;
    }
}

