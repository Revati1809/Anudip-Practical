public class zero_onepattern {
    public static void main(String[] args) {
        int rows = 4; // total number of rows
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                // Print 1 if sum of row and column index is even, else 0
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println(); // Move to next line
        }
    }
}

