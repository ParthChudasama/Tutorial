package learn.tutorial.UI;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import learn.tutorial.R;

public class externalAcitivity extends AppCompatActivity {
    EditText external;
    Button Save, get;
    TextView txtresponse;

    private String filename = "ExternalFile.txt";
    private String filepath = "MyExKHFolder";
    File myExternalFile;
    String myData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_acitivity);
        external = (EditText) findViewById(R.id.edtxternal);
        Save = (Button) findViewById(R.id.btnsave);
        get = (Button) findViewById(R.id.btnget);
        txtresponse = (TextView) findViewById(R.id.txtmsg);

        if (!isExternalStorageWritable()) {
            Save.setEnabled(false);
        } else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
            String s = myExternalFile.getAbsolutePath();
        }
        myExternalFile.delete();
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public void save(View view) {
        try {
            FileOutputStream fos = new FileOutputStream(myExternalFile);
            fos.write(external.getText().toString().getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        external.setText("");
        txtresponse.setText(filename +" saved to External Storage...");
    }
    public void Read(View view){
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        external.setText(myData);
        txtresponse.setText(filename +" data retrieved from External Storage...");
    }

    public void delete(View view) {
//        try {
//            FileOutputStream fos = new FileOutputStream(myExternalFile);
//            fos.write("h");
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
