public class Main {
    public static void main(String[] args) {

        loginAndPasswordVerification("java_skypro_Go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        loginAndPasswordVerification("java_skypro_Go123asdasdasf", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        loginAndPasswordVerification("java_skypro_Go", "D_1hWiKjjP_9", "DiKjjP_9");
        loginAndPasswordVerification("java^^skypro_Go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");

    }

    public static boolean loginAndPasswordVerification(String login, String password, String confirmPassword) {

        try {

            checkLogin(login);
            checkPassword(password, confirmPassword);
            return true;

        } catch (WrongLoginException e) {

            System.out.println("Ошибка логина: " + e.getMessage());
            return false;

        } catch (WrongPasswordException e) {

            System.out.println("Ошибка пароля: " + e.getMessage());
            return false;

        }

    }

    private static void checkPassword(String password, String confirmPassword) {

        if (lengthBigThan(password, 20) || isNonePattern(password) || passwordEquals(password, confirmPassword)) {
            throw new WrongPasswordException("Неверный пароль или пароли не совподают!");
        }

    }

    private static void checkLogin(String login) {

        if (isNonePattern(login) || lengthBigThan(login, 20)) {
            throw new WrongLoginException("Неправильный логин!");
        }

    }

    private static boolean passwordEquals(String password, String confirmPassword) {

        return !password.equals(confirmPassword);

    }

    private static boolean isNonePattern(String string) {

        final String pattern = "abcdefghijklmnopqrstuvwxyz0123456789_";

        for (int i = 0; i < string.length(); i++) {

            if (!pattern.contains(String.valueOf(string.charAt(i)).toLowerCase())) {
                return true;
            }

        }

        return false;

    }

    private static boolean lengthBigThan(String string, int length) {
        return string.length() > length;
    }

}