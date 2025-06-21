abstract class payment{
    void processpayment(double amount){
       

    }
}
class creditcard extends payment{
    @Override
    void processpayment(double amount){
        System.out.println("Credit card payment called" + "amount" );
    }
}
class UPI extends payment{
    @Override
    void processpayment(double amount){
        System.out.println("UPI payment called"+ "amount" );
    }
}
public class processpayment{
    public static void main(String[] args) {
        creditcard c1 = new creditcard();
        c1.processpayment(1000);

        UPI u1 = new UPI();
        u1.processpayment(5000);

    }
}
