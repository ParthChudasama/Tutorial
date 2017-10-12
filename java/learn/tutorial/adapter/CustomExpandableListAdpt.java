package learn.tutorial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import learn.tutorial.R;

/**
 * Created by parth on 8/28/2017.
 */

public class CustomExpandableListAdpt extends BaseExpandableListAdapter {
    private Context context;
    private List<String> exptitle;
    private HashMap<String,List<String>> hash;

    public CustomExpandableListAdpt(Context context,List<String> exptitle,HashMap<String,List<String>> hash){
        this.context=context;
        this.exptitle=exptitle;
        this.hash=hash;
    }
    @Override
    public int getGroupCount() {
        return this.exptitle.size();
    }

    @Override
    public int getChildrenCount(int listPostion)
    {
        return this.hash.get(this.exptitle.get(listPostion)).size();
    }

    @Override
    public Object getGroup(int listPosition) {

        return this.exptitle.get(listPosition);
    }

    @Override
    public Object getChild(int listPosition, int childcount )
    {
        return this.hash.get(this.exptitle.get(listPosition)).get(childcount);
    }

    @Override
    public long getGroupId(int listPosition)
    {
        return listPosition;
    }

    @Override
    public long getChildId(int listPosition, int childcount)
    {
        return childcount ;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded, View Titleview, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
              if(Titleview == null){
                  LayoutInflater layoutInflater = (LayoutInflater) this.context.
                          getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                  Titleview = layoutInflater.inflate(R.layout.expand_list_title, null);
              }
        TextView listtitle =(TextView) Titleview.findViewById(R.id.ExpGtitle);
        listtitle.setText(listTitle);
        return Titleview;
    }

    @Override
    public View getChildView(int listPosition, int childcount, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childlist =(String) getChild(listPosition,childcount);
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.expand_list_group_child, null);
        }
        TextView expchild =(TextView) convertView.findViewById(R.id.txtexpchild);
        expchild.setText(childlist);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int childcount) {

        return true;
    }
}
