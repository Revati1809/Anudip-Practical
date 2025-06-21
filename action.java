interface animal{
    public void walk();
    
}
class horse implements animal{
    @Override
    public void walk(){
        System.out.println("horse  is running");
    }
}
class donkey implements animal{
    @Override
    public void walk(){
        System.out.println("donkey is walking");
    }
}
public class action {
    public static void main(String[] args) {
        horse h1 = new horse();
        h1.walk();
        donkey d1 = new donkey();
        d1.walk();
    }
}

