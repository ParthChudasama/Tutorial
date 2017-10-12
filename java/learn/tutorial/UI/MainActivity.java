package learn.tutorial.UI;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.view.View;

import learn.tutorial.R;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void list(View view) {
        Intent intent = new Intent(MainActivity.this, listactivity.class);
        ;
        startActivity(intent);
        overridePendingTransition(R.transition.slide, R.transition.activity_fade);
    }


    public void Expand(View view) {
        startActivity(new Intent(MainActivity.this,ExpandListView.class));
    }

    public void Grid(View view) {
        startActivity(new Intent(MainActivity.this,MyGridView.class));

    }

    public void Alert(View view) {
        startActivity(new Intent(MainActivity.this,MyAlert.class));

    }

    public void DateTime(View view) {
        startActivity(new Intent(MainActivity.this,DateAndTime.class));

    }

    public void ProgressDialog(View view) {
        startActivity(new Intent(MainActivity.this,ProgressDialogActivity.class));

    }

    public void Anim(View view) {
        startActivity(new Intent(MainActivity.this,Animations.class));

    }

    public void Sharedpref(View view) {
        startActivity(new Intent(MainActivity.this,sharedprefactivity.class));
    }

    public void External(View view) {
        startActivity(new Intent(MainActivity.this,externalAcitivity.class));

    }

    public void Internal(View view) {
        startActivity(new Intent(MainActivity.this,internalActivity.class));

    }

    public void SQL(View view) {
        startActivity(new Intent(MainActivity.this,sql_db.class));
    }

    public void FAB(View view) {
        startActivity(new Intent(MainActivity.this,FAB.class));
    }

    public void CustomActionBAr(View view) {
        startActivity(new Intent(MainActivity.this,customActionBar.class));
    }
}
