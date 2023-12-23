import java.util.Scanner;

public class KekuatanPassword {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan panjang kata sandi: ");
        int length = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Kata sandi yang dibuat: ");
        String password = scanner.nextLine();

        int score = calculatePasswordStrength(password);
        String strength = determineStrength(score, password, length);

        System.out.println(strength);
    }

    public static int calculatePasswordStrength(String password) {
        int score = 0;

        
        if (password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=\\-\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$")) {
            score = 8; 
        } else {
            score = 0; 
        }

        return score;
    }

    public static String determineStrength(int score, String password, int length) {
        if (score >= 8) {
            return "Kekuatan kata sandi: Kuat";
        } else {
            StringBuilder reason = new StringBuilder("Kekuatan kata sandi: Lemah\nAlasan: ");

            if (password.length() < length) {
                reason.append("Kata sandi memiliki panjang kurang dari ").append(length).append(" karakter. ");
            }

            if (!password.matches(".*[A-Z].*")) {
                reason.append("Kata sandi tidak memiliki huruf besar. ");
            }

            if (!password.matches(".*[!@#$%^&*()_+=\\-\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
                reason.append("Kata sandi tidak memiliki karakter khusus. ");
            }

            if (!password.matches(".*\\d.*")) {
                reason.append("Kata sandi tidak memiliki angka. ");
            }

            return reason.toString();
        }
    }
}
