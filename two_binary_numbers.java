public class two_binary_numbers {
    static String_palindrome add_Binary(String_palindrome x, String_palindrome y)
    {

        int num1 = Integer.parseInt(x, 2);
        int num2 = Integer.parseInt(y, 2);
        int sum = num1 + num2;
        String_palindrome result = Integer.toBinaryString(sum);
        

        return result;
    }
    public static void main(String_palindrome args[])
    {
        String_palindrome x = "01101", y = "10101";

        System.out.print(add_Binary(x, y));
    }
}