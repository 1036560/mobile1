package net.charlesdelmaire.qingpool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class listPartiActivity extends Activity  {
	List<Map<String, String>> partList = new ArrayList<Map<String,String>>();
	SimpleAdapter simpleAdpt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listparti);
		initList();
		
		ListView lv = (ListView) findViewById(R.id.listParticipant);
		
		simpleAdpt = new SimpleAdapter(this, partList, android.R.layout.simple_list_item_1, new String[] {"nomPart"}, new int[] {android.R.id.text1});
		lv.setAdapter(simpleAdpt);
		

		
		registerForContextMenu(lv);

	}
	
	
	private void initList() {
		partList.add(createPart("nomPart","proPool"));
		partList.add(createPart("nomPart","proPool1"));
		partList.add(createPart("nomPart","proPool2"));
		partList.add(createPart("nomPart","proPool3"));
		partList.add(createPart("nomPart","proPool4"));
		partList.add(createPart("nomPart","proPool5"));
		partList.add(createPart("nomPart","proPool6"));
		}
	
	private HashMap<String, String> createPart(String key, String name) {
	    HashMap<String, String> Pool = new HashMap<String, String>();
	    Pool.put(key, name);
	    return Pool;
	}

}
