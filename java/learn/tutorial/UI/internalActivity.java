package learn.tutorial.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import learn.tutorial.R;

public class internalActivity extends AppCompatActivity {
    EditText  edtfile;
    String file_name = "myinternalfile.txt";
    File f;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);
         edtfile=(EditText)findViewById(R.id.edtfile);

    }

    public void write(View view) {
        try{

            FileOutputStream file1 = openFileOutput(file_name, MODE_APPEND);
            OutputStreamWriter outputWriter=new OutputStreamWriter(file1);
            outputWriter.write(edtfile.getText().toString());
            outputWriter.close();
            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            e.printStackTrace();
        }
        edtfile.setText("");

    }


    public void read(View view) {
        try {
//            openFileInput(): This method is used to open a file and read it. It returns an instance of FileInputStream. Its syntax is given below:
//            FileInputStream fin = openFileInput(file);

            FileInputStream fileIn=openFileInput(file_name);
            InputStreamReader InputRead= new InputStreamReader(fileIn);

//            we call read method to read one character at a time from the file and then print it. Its syntax is given below:
            char[] inputBuffer= new char[100];
            int charRead;
            String temp="";
            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                temp +=readstring;
            }
            InputRead.close();
            edtfile.setText(temp);
//            string temp contains all the data of the file.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear(View view) {
        FileOutputStream writer = null;
        try {
            FileOutputStream file1 = openFileOutput(file_name, MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(file1);
            outputWriter.write((""));
            outputWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        edtfile.setText("");
    }
}
