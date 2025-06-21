public class array {
    public static void main(String[] args) {
        int[] number = new int[5];
        number[0]=5;
        number[1]=6;
        number[2]=7;
        number[3]=8;
        number[4]=9;
        System.out.println(number[3]);
        for (int a = 0; a < number.length; a++){
            System.out.println(number[a]);
        }
    }
}
// same data types 
// fixed length
// it follows the 0th based indexing
//data types[]arrayName = new data types[size];