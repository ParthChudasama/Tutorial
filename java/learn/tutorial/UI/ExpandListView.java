package learn.tutorial.UI;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import learn.tutorial.Data.ExpandableListDataPump;
import learn.tutorial.R;
import learn.tutorial.adapter.CustomExpandableListAdpt;

import static android.R.attr.bitmap;

public class ExpandListView extends AppCompatActivity {
      ExpandableListView exp;
      HashMap<String,List<String>> hash;
      List<String> exptitle;
      ExpandableListAdapter expandableListAdapter;
      ImageView image;

   // String[] detail = getResources().getStringArray(R.array.cricket);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_list_view);
        exp = (ExpandableListView)findViewById(R.id.Expandlistv);
        hash = ExpandableListDataPump.getData();

        exptitle= new ArrayList<String>(hash.keySet());
        expandableListAdapter=new CustomExpandableListAdpt(this,exptitle,hash);
        exp.setAdapter(expandableListAdapter);


        exp.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),exptitle.get(groupPosition)+"List Expanded.",Toast.LENGTH_SHORT).show();
            }
        });

        exp.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),exptitle.get(groupPosition)+"List Collapsed.",Toast.LENGTH_SHORT).show();
            }
        });

        exp.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long id)
            {
                String child = hash.get(exptitle.get(groupPosition)).get(childPosition).toString();
             //   String teamlist=((TextView)view).getText().toString();

                int group,pos;
                group=groupPosition;
                pos=childPosition;
                int[][] draw=new int[][]{{R.drawable.rams,R.drawable.clippers,R.drawable.thunder},
                                           {R.drawable.spain,R.drawable.argentina,R.drawable.brazil},
                                          {R.drawable.india,R.drawable.pakistan,R.drawable.south_africa}};



                Intent intent= new Intent(ExpandListView.this,expand_list_nxtpg.class);
             //Converting image to bitmap byte

                Resources res = getResources();
                Drawable drawable = res.getDrawable(draw[group][pos]);
                Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

                intent.putExtra("byteArray", stream.toByteArray());
                intent.putExtra("key",child);
             //   if(group==0){
                    //intent.putExtra("detail",detail[pos]);
//            //    }
                startActivity(intent);
                return false;
            }
        });

    }

}
