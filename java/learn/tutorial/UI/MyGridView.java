package learn.tutorial.UI;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import learn.tutorial.R;
import learn.tutorial.adapter.GridAdapter;

public class MyGridView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_grid_view);
        GridView Grid =(GridView )findViewById(R.id.Grid);
        Grid.setAdapter(new GridAdapter(this));
       final int array[]={R.drawable.rams,R.drawable.clippers,R.drawable.thunder,
               R.drawable.spain,R.drawable.argentina,R.drawable.brazil,
               R.drawable.india,R.drawable.pakistan,R.drawable.south_africa};

         Grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Intent intent= new Intent(MyGridView.this,Gridnxtpage.class);
                 int pos = i;
                 Resources res = getResources();
                 Drawable drawable = res.getDrawable(array[pos]);
                 Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
                 ByteArrayOutputStream stream = new ByteArrayOutputStream();
                 bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

                 intent.putExtra("byteArray", stream.toByteArray());
                 startActivity(intent);
             }
         });

    }
}
