package learn.tutorial.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by parth on 8/28/2017.
 */

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData(){
        HashMap<String, List<String>> expandablelist = new HashMap<String, List<String>>();

        List<String> cricket= new ArrayList<String>();
        cricket.add("India");
        cricket.add("Pakistan");
        cricket.add("South Africa");

        List<String> Football= new ArrayList<String>();
        Football.add("Spain");
        Football.add("Argentina");
        Football.add("Brazil");

        List<String> Basketball= new ArrayList<String>();
        Basketball.add("Rams");
        Basketball.add("Clippers");
        Basketball.add("Thunder");

        expandablelist.put("Cricket team", cricket);
        expandablelist.put("Football team", Football);
        expandablelist.put("Baseball team", Basketball);

        return expandablelist;
    }
}
