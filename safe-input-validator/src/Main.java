import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Yas gir (0-120), cikis icin q: ");
                String input = sc.nextLine().trim();

                if (input.equalsIgnoreCase("q"))
                    break;

                int age = parseAge(input);
                System.out.println("Gecerli yas: " + age);
            }
            catch (NumberFormatException e) {
                System.out.println("Hata: Sayi girilmedi.");
            }
            catch (InvalidAgeException e) {
                System.out.println("Hata: " + e.getMessage());
            }
            finally {
                System.out.println("Deneme tamamlandi.\n");
            }
        }

        sc.close();
    }

    static int parseAge(String input) throws InvalidAgeException {
        int age = Integer.parseInt(input);

        if (age < 0 || age > 120)
            throw new InvalidAgeException("Yas 0 ile 120 arasinda olmali.");

        return age;
    }
}
