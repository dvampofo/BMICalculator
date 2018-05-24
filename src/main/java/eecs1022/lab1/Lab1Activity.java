package eecs1022.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab1Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
    }


    //                                SELECTING SPINNER OPTIONS
        /*
            We want to know which object is chosen such as if object 1 is chosen
            or object 2.
         */

        /*
            First helper method. Changes the content of the output TextView
            Will display what the BMI is in the GUI.

            Given the id (set in the View xml file) of a TextView
            we change its contents to 'newContents'
        */
    private void setContentsOfTextView(int id, String newContents)
    {
        View view = findViewById(id);
        TextView textView= (TextView) view;
        textView.setText(newContents);
    }

        /*
            This helper method will allow you to select the option in the
            the spinner.
        */
    private String getItemSelected(int id)
    {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String string = spinner.getSelectedItem().toString();
        return string;
    }



    //                      C O N T R O L L E R

        /*
            Helper method for retrieving contents from GUI.

            Given the id(set in the View xml file) of a TextView,
            we change its contents to "newContents".
        */
    private String getInputOfTextField(int id)
    {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    public void computeBMIButtonClicked(View view)
    {
        /*
            Implementation body of method computeBMIButtonClicked.
            This block of code can be attached to some GUI component in the View xml file
            by setting the "onClick".
        */
        /*
            Phase 1: Retrieve values from EditText fields.
            To do this, we call helper methods
         */
        String textName = getInputOfTextField(R.id.inputName);
        String textWeight = getInputOfTextField(R.id.inputWeight);
        String textHeight = getInputOfTextField(R.id.inputHeight);

        /*
            Phase 2: Based on the information retrieved, display them.
        */
        // String contents = textName + "'s BMI is " + textWeight + "."; // BMI calculation to add!
        // String bmiCategory = textName + " is " + ".";    // normal, obese etc

        // setContentsOfTextView(R.id.labelAnswer, contents);
        // setContentsOfTextView(R.id.labelAnswer2, bmiCategory);


        /*
           Alternative Phase 2: Based on the information retrieved,
           convert them into numbers if necessary.
           Caution: Every input value that user inputs is retrieved as a string.
           e.g. when the user inputs the name 'john', it is retrieved by the controller as "john"
                                     the weight '100', it is retrieved by the controller as "100"
                                       (ie a string of 3 characters).
                                     the height 1.75, it's retrieved as "1.75" (ie a string of 4
                                         characters).
        */
        // No conversion needed for name
        // Conversion needed for weight and height.
        double weight = Double.parseDouble(textWeight);
        double height = Double.parseDouble(textHeight);

        // Computation should not be done in context of controller,
        // because of the separation of concern principle.
        // In general, the computation required for a specific app can be complicated
        // in which case, it is bad to have controller for both input retrievals and computation
        // This is, in general, we want to have separate components  responsible for
        // computation related to the specific app.
        // double bmi = weight / (height * height);

        // String contents = textName + "'s BMI is " + bmi + "."; // BMI calculation to add!
        // String bmiCategory = textName + " is " + ".";    // normal, obese etc.

        //              S P I N N E R    W E I G H T
        String selectedItem = getItemSelected(R.id.spinner);
        if(selectedItem.equals("kilograms"))
        {
            setContentsOfTextView(R.id.labelAnswer, "Option 1");
            // Default option. Do nothing.

        }
        else if(selectedItem.equals("pounds"))
        {
            // If pounds are chosen, convert pounds to kilograms.
            setContentsOfTextView(R.id.labelAnswer, "Option 2");
            double poundsKilogram = 0.45359237;
            weight = weight * poundsKilogram;
        }

        //             S P I N N E R    H E I G H T
        String selectedItem2 = getItemSelected(R.id.spinnerHeight);
        if(selectedItem2.equals("centimeters"))
        {
            // If in centimeters convert to meters.
            setContentsOfTextView(R.id.labelAnswer, "Option 1");
            double centimetersMeters = 100;
            height = height / 100;
        }
        else if(selectedItem2.equals("inches"))
        {
            // If inches is chosen, convert inches to centimeters and then convert
            // to meters.
            setContentsOfTextView(R.id.labelAnswer, "Option 2");
            double inchesCentimeters = 2.54;
            height = height * inchesCentimeters; // Convert cm
            height = height / 100;               // Convert to meters

        }

        /*
           Proper phase 2: Based on the information retrieved (ie textName, weight, height)
           create a model and let it compute the BMI and return the computation result to be displayed.
        */
        Person user = new Person(textName, weight, height);
        setContentsOfTextView(R.id.labelAnswer, user.toString());

    }
}
