final class vehical {
    public static void main(String[] args) {
        
    }
    final void run(){
        System.out.println("Running");
    }
}
class car extends vehical{
    @Override
    void run(){
        System.out.println("This is car");
    }

}