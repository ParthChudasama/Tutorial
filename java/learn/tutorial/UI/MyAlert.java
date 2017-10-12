package learn.tutorial.UI;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Toast;

import learn.tutorial.R;

public class MyAlert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_alert);
        setupWindowAnimations();
    }

    private void setupWindowAnimations() {
        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.slide);
        getWindow().setExitTransition(slide);
    }

    // In order to make an alert dialog, we need to make an object of AlertDialogBuilder which is an inner class of AlertDialog.

//    Android AlertDialog Components
//
//    * Title: Note that title is optional
//    * Content: This displays the message to the user.
// It can be a string message, a list or custom layout
//    * Action Buttons: These buttons are of three types. They are Positive, Negative and Neutral action buttons.
//      An alert dialog can have maximum three action buttons. In general following are the conventions for the buttons:
//      => If you want the user to accept the action, use Positive action button. It is normally displayed as OK/YES.
//      => If the user wants to cancel the action, then you can use Negative action button (NO).
//      => If the user wants to postpone the decision use Neutral action button (Later).


//    We need to set the methods of these buttons using AlertDialogBuilder class. The syntax is given below.
//
//             alertDialogBuilder.setPositiveButton(CharSequence text, DialogInterface.OnClickListener listener);
//             alertDialogBuilder.setNegativeButton(CharSequence text, DialogInterface.OnClickListener listener);
//             alertDialogBuilder.setNeutralButton(CharSequence text, DialogInterface.OnClickListener listener);
//    The first argument is the text to be displayed. The second argument is the listener to be invoked when the corresponding button is pressed.


    //    Besides this, there are some functions available to customise the alert dialog as given below.
//
//      1.  setIcon(Drawable icon): This method set the icon of the alert dialog box
//      2.  setCancelable(boolean cancelable): This method sets the property that the dialog can be cancelled or not
//      3.  setMessage(CharSequence message): This method sets the message to be displayed in the alert dialog
//      4.  setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems, DialogInterface.OnMultiChoiceClickListener listener):
//          This method sets list of items to be displayed in the dialog as the content.
//          The selected option will be notified by the listener
//      5.  setOnCancelListener(DialogInterface.OnCancelListener onCancelListener):
//       This method Sets the callback that will be called if the dialog is cancelled
//      6.  setTitle(CharSequence title): This method set the title to be appear in the dialog
//      7.  getListView(): This function is used to get the list view used in the dialog
//
//    After creating and setting the dialog builder, we need to create an alert dialog by calling the create()



    public void Button1(View view) {
        AlertDialog.Builder builder =new AlertDialog.Builder(MyAlert.this);
        builder.setTitle("Sample Alert");
        builder.setMessage("One Action Button Alert");
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "OK is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setIcon(R.drawable.india);
        builder.show();

    }

    public void Button2(View view) {
        AlertDialog.Builder builder =new AlertDialog.Builder(MyAlert.this);
        builder.setTitle("Sample Alert");
        builder.setMessage("Two Action Button Alert");
        builder.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "YES is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "No is clicked", Toast.LENGTH_LONG).show();
                    }
                });
        builder.setIcon(R.drawable.rams);
        builder.show();

    }

    public void Button3(View view) {
        AlertDialog.Builder builder =new AlertDialog.Builder(MyAlert.this);
        builder.setTitle("Sample Alert");
        builder.setMessage("Three Action Button Alert");
        builder.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "YES is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "No is clicked", Toast.LENGTH_LONG).show();
                    }
                });
        builder.setNeutralButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Cancel is clicked", Toast.LENGTH_LONG).show();
                    }
                });



        builder.setCancelable(false);
        builder.setIcon(R.drawable.clippers);
        builder.show();
    }
}
