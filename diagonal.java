import java.util.Scanner;

public class diagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the square: ");
        int size = scanner.nextInt();  // e.g., 7

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // Borders: top, bottom, left, right
                if (row == 0 || row == size - 1 || col == 0 || col == size - 1) {
                    System.out.print("* ");
                }
                // Diagonal: top-left to bottom-right
                else if (row == col) {
                    System.out.print("* ");
                }
                // Inside space
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}

