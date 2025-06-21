public class student {
    String name = "Revati";
    int age = 20 ;
    static String college = "viit";
    student(String name, int age ){
        this.name = name;
        this.age = age;
        this.college = college;
    }

}
class main{
    public static void main(String[] args) {
        student s1 = new student("Revati",20);
        System.out.println("name="+s1.name);
        System.out.println("age ="+s1.age);
        System.err.println("college ="+s1.college);
    }
}
