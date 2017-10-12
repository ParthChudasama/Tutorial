package learn.tutorial.UI;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import learn.tutorial.R;

public class FAB extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    private Button one, two, three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.tbSnack);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabSnack);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "FloatingActionButton is clicked", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

//                In the above snippet make() method accepts three parameters:
//
//        1. coordinatorLayout : It is the root layout of the activity
//        2. Message : This is the message to be appear on snackbar, and we can customise it with our own message
//        3. Snackbar.LENGH_LONG : This is last parameter which is the time limit how long snackbar to be displayed
//
//      show() method is used to display the SnackBar on the screen.
            }
        });

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cordinator);

        View layout= findViewById(R.id.layoutSnackBar);
        one=(Button)layout.findViewById(R.id.btnSB1);
        two=(Button)layout.findViewById(R.id.btnSB2);
        three=(Button)layout.findViewById(R.id.btnSB3);



        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Hello Message !!!", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Message is deleted", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Message is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });

                snackbar.show();
            }

        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Try again!", Snackbar.LENGTH_LONG)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Trying Again !!! ", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });
                snackbar.setActionTextColor(Color.RED);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        });

    }
}
