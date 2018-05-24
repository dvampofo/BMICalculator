package eecs1022.lab1;

/**
   This is a tester program for testing the correctness of the Persons class.
 */
public class PersonTester
{
    public static void main(String[] args)
    {
        Person p1 = new Person("jim", 80, 1.5);
        Person p2 = new  Person("john", 78, 1.90);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        System.out.println("After Jim has gained 2kg.");
        p1.setWeight(p1.weight + 2);
        System.out.println("After John has lost 2kg.");
        p2.setWeight(p2.weight - 2);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        System.out.println(" ");
        System.out.println("This is kg to lb conversion");
        System.out.println("Jims BMI with kg to lb conversion is " + p1.weight *0.45359237);
        System.out.println(p1.toString());
    }
}
