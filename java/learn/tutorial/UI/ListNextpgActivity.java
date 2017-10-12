package learn.tutorial.UI;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import learn.tutorial.R;

public class ListNextpgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nextpg);
        TextView txtprdouct=(TextView)findViewById(R.id.txtViewLabel);
        ImageView image = (ImageView)findViewById(R.id.imageView);

        Intent newIntent=getIntent();
        //getting attached intent data
        String product=newIntent.getStringExtra("teamKey");
        //displaying slected product name


        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("byteArray");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        image.setImageBitmap(bitmap);
        txtprdouct.setText(product);
    }


}
