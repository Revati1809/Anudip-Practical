import java.util.Scanner;

public class hollow_square {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        System.out.print("Enter the size of the square: ");
        int size = Scanner.nextInt();  // Size of the square (e.g., 5)

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // Print * on the borders
                if (row == 0 || row == size - 1 || col == 0 || col == size - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  "); // Inner space
                }
            }
            System.out.println();
        }

        Scanner.close();
    }
}
