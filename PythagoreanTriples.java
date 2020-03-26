import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PythagoreanTriples {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigDecimal two = new BigDecimal("2");
        String aString = "";
        BigDecimal a;
        BigDecimal b;
        BigDecimal c;
        int counter;
        String answer = "";
        boolean flag;

        System.out.print("\n");
        while (!answer.toUpperCase().equals("N") && !answer.toUpperCase().equals("NO")) {
            flag = true;
            do {
                try {
                    System.out.print("Please enter a positive integer value for 'a' or enter 0 to exit the program: ");
                    aString = scan.nextLine();
                    a = new BigDecimal(aString);
                    if (a.equals(BigDecimal.ZERO)) System.exit(0);
                    if (a.compareTo(BigDecimal.ZERO) < 0) System.out.println("\nYou must enter a positive number!");
                    else if (a.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) > 0) System.out.println("\nYou must enter a whole number!");
                    else flag = false;
                } catch (java.lang.NumberFormatException error) {
                    System.out.println("\nYou must enter a number!");
                }
            } while (flag);

            a = new BigDecimal(aString);
            BigDecimal aSquaredOverI;
            System.out.println("\nAll possible pythagorean triples where a = " + a.toString() + " are:");
            counter = 1;
            for (BigDecimal i = BigDecimal.ONE; i.compareTo(a) < 0; i = i.add(BigDecimal.ONE)) {
                aSquaredOverI = a.multiply(a).divide(i, 0, RoundingMode.CEILING);
                if ((a.multiply(a)).remainder(i).equals(BigDecimal.ZERO) &&
                        (aSquaredOverI.remainder(two).equals(i.remainder(two)))) {
                    b = aSquaredOverI.subtract(i).divide(two, 0, RoundingMode.CEILING);
                    c = b.add(i);
                    System.out.println(counter + ". a = " + a + ", b = " + b + ", c = " + c);
                    counter++;
                }
            }

            if (counter == 1) {
                System.out.println("none");
            }
            answer = "";
            System.out.println("\nWould you like to try another value for 'a'? (Y/N)");
            while(!answer.toUpperCase().equals("YES") && !answer.toUpperCase().equals("Y")
                    && !answer.toUpperCase().equals("NO") && !answer.toUpperCase().equals("N")) {
                answer = scan.nextLine();
                if (!answer.toUpperCase().equals("YES") && !answer.toUpperCase().equals("Y")
                        && !answer.toUpperCase().equals("NO") && !answer.toUpperCase().equals("N")) {
                    System.out.println("\nYou must answer with either 'Y' or 'N'!");
                    System.out.println("Would you like to try another value for 'a'? (Y/N)");
                }
            }
            System.out.print("\n");
        }
    }
}