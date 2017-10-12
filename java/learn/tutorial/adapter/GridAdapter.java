package learn.tutorial.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import learn.tutorial.R;
import learn.tutorial.UI.MyGridView;

/**
 * Created by parth on 9/3/2017.
 */

public class GridAdapter extends BaseAdapter {
  private Context mcontext;
 public GridAdapter(Context c){
        mcontext = c;
 }
 public  GridAdapter(int b[]){
        this.a[9]=b[9];
 }

    @Override
    public int getCount() {
        return a.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView image;
        if(view==null){
            image = new ImageView(mcontext);
            image.setLayoutParams(new GridView.LayoutParams(300,300));
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            image.setPadding(8,8,8,8);
        }
        else{
            image =(ImageView) view;
        }
        image.setImageResource(a[i]);
        return image;
    }

   private int[] a={R.drawable.rams,R.drawable.clippers,R.drawable.thunder,
           R.drawable.spain,R.drawable.argentina,R.drawable.brazil,
           R.drawable.india,R.drawable.pakistan,R.drawable.south_africa};
}
