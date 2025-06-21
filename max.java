public class max {
    public static void main(String_palindrome[] args) {
        int a = 59;
        int b = 98;
        int c = 88;
        int max;
        if (a>= b && a>= c){
            max = a;

        }
        else if (b>= a && b>= c){
            max = b;
        }
        else {
            max = c;
        }
        System.out.println("Maximum number is: " + max);
    }
    
}
