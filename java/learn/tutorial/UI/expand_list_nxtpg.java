package learn.tutorial.UI;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import learn.tutorial.R;

public class expand_list_nxtpg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_list_nxtpg);

        TextView txtchild=(TextView)findViewById(R.id.tchild);
        ImageView image=(ImageView)findViewById(R.id.Cimage);
        //TextView detail = (TextView)findViewById(R.id.txtdetail);


        Intent newIntent=getIntent();
        //getting attached intent data
        String child=newIntent.getStringExtra("key");
       // String det=newIntent.getStringExtra("detail");
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("byteArray");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        image.setImageBitmap(bitmap);
        //displaying slected product name
        txtchild.setText(child);
        //detail.setText(det);
    }
}
