package eecs1022.lab1;

/**
     The Person class is a template for person entities.
 */
public class Person
{
    /*
        Attributes are data that we store to represent the
        STATE(i.e. combination of attribute values) of each entity.
    */

    /*
        Each declaration of an attribute consists of:
        1. the type (the set/collection of allowed values) of the attribute
            Common data types in Java:
                int for integers (e.g. 1 4, 56, -3)
                double for real numberS (e.g. -0.5, 63.7, 4.6)
                character for single key (e.g. 'h' , ' ', 'e')
                String for sequences of characters (e.g. " ", "abcde", "a")
        2. The name of the attribute.
     */
    /*
        Once we have declared the types of attributes, it is considered a
        type error if we try to change an attribute's value into one that
        is no compatible with its declared type.
        e.g. changing a persons name to 3.4 is not correct
                changing a persons weight to "90" is not correct
    */
    String name;
    double weight;
    double height;

    // Define a constructor for creating instances of a Person
    // This constructor has three parameters (i.e. inputs) in order to create instances.
    public Person (String n, double w, double h)
    {
        // When we write v = e, we intend to assign a value e (on the RHS) to the
        // variable v (on the LHS).
        this.name = n;
        this.weight = w;
        this.height = h;
    }

    // Define ACCESSOR methods, which ask questions about the context object (e.g. p1, p2) and get RETURNED
    // with some answers to the questions.
    /*
        Given the current context object weight and height, apply the BMI calculation formula.
    */
    // 1st accessor
    double getBMI()
    {
        // Make use of the attribute values of the current context object,
        // do some computation, then return the computation result.

        // Declare a local variable to store the intermediate computation result.
        double bmi = this.weight / (this.height * this.height);
        return bmi; // accessor types must always have a return type (double) and return statement (return bmi).

    }

    public String getInterpret()
    {
        String s = "";
        double bmi = this.getBMI();

        if (bmi <= 18.5)
        {
            s += this.name + " is Underweight.";
        }
        else if(bmi >= 18.5 && bmi < 25.0)
        {
            s += this.name + " is Normal.";

        }
        else if (bmi >= 25.0 && bmi <30.0)
        {
            s += this.name + " is Overweight.";
        }
        else
        {
            s += this.name + " is Obese.";
        }

        return s;

    }
    // 2nd accessor

    @Override
    public String toString()
    {
        String s = "";

        s = s + "";
        s += this.name;
        s = s + "'s has BMI: ";
        // This line below is a repetition of what getBMI() accessor would do
        // so it adds "smell" to your code. To improve, simply replace this line
        // by a call to the getBMI().
        // double bmi = this.weight/ (this.height * this.height);
        double bmi = this.getBMI();

        String f = String.format("%.2f", bmi);

        s = s + f + ".\n";
        s+= getInterpret();

        return s;

    }

    /*
       Define MUTATOR methods which modify the state (i.e attribute values) of the current context object.
       It will not return anything and we say this with the keyword "void". Using void means
       you are dealing with a mutator method.
   */
    void setWeight(double w)
    {
        this.weight = w;
    }


    void setHeight(double h)
    {
        this.height = h;
    }

}
