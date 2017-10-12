package learn.tutorial.UI;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import learn.tutorial.R;

public class customActionBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_action_bar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_sublay);
        View view = getSupportActionBar().getCustomView();

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Back Button is clicked", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.action_bar_forward);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Forward Button is clicked", Toast.LENGTH_LONG).show();
            }
        });
    }

//    To add a custom layout to the ActionBar we’ve called the following two methods on the getSupportActionBar() :
//
//    getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//    getSupportActionBar().setDisplayShowCustomEnabled(true);
//    setCustomView() is invoked to inflate the ActionBar with a customView as shown above.
//    To set the onClickListeners for the ActionBar buttons we need to get the CustomView first using getCustomView().
}
