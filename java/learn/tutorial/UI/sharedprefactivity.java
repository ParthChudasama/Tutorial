package learn.tutorial.UI;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import learn.tutorial.R;

public class sharedprefactivity extends AppCompatActivity {
      SharedPreferences sharedpref;
      Boolean isSaved=false;
      EditText edtname,edtusername,edtpass;


    public static final String MyPREFERENCES = "MyKHPrefs" ;
    public static final String Name = "nameKey";
     static final String USer = "userKey";
    public static final String Password = "passKey";
    public static final String isDataSaved = "saveKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedprefactivity);
        sharedpref=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        intitcomponent();
    }

    private void intitcomponent() {
        edtname=(EditText)findViewById(R.id.edtname);
        edtusername=(EditText)findViewById(R.id.edtuser);
        edtpass=(EditText)findViewById(R.id.edtpassword);
           isSaved=sharedpref.getBoolean(isDataSaved,false);
           if(isSaved){
               edtname.setText(sharedpref.getString(Name,""));
               edtpass.setText(sharedpref.getString(Password,""));
               edtusername.setText(sharedpref.getString(USer,""));
           }


    }


    public void Save(View view) {
    String name = edtname.getText().toString();
        String user=edtusername.getText().toString();
        String pass=edtpass.getText().toString();

        SharedPreferences.Editor edit= sharedpref.edit();
        edit.putString(Name,name);
        edit.putString(USer,user);
        edit.putString(Password,pass);
        edit.putBoolean(isDataSaved,true);
        edit.commit();

    }

    public void cancel(View view) {
        SharedPreferences.Editor edit =sharedpref.edit();
        edit.clear();
        edit.putBoolean(isDataSaved,false);
        edit.commit();
        edtusername.setText("");
        edtpass.setText("");
        edtname.setText("");
    }
}
