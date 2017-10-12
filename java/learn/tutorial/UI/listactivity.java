package learn.tutorial.UI;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

import learn.tutorial.R;

public class listactivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //storing strings in array
        String[] teamsArray = getResources().getStringArray(R.array.teams);


        //Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtlistview,teamsArray));
        ListView lv=getListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //selected items
                int[] image={R.drawable.india,R.drawable.west_indies};
                Drawable draw = getResources().getDrawable(image[i]);
                Bitmap bitmap = ((BitmapDrawable)draw).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

                String teamlist=((TextView)view).getText().toString();
                //Launching a new Activity
                Intent intent=new Intent(getApplicationContext(),ListNextpgActivity.class);
                intent.putExtra("byteArray", stream.toByteArray());
                intent.putExtra("teamKey", teamlist);
                startActivity(intent);
            }
        });

    }
}
