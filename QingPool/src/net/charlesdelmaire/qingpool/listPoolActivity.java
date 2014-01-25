package net.charlesdelmaire.qingpool;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listPoolActivity extends Activity{
	List<Map<String, String>> poolList = new ArrayList<Map<String,String>>();
	SimpleAdapter simpleAdpt;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listpool);
		
		initList();
		
		ListView lv = (ListView) findViewById(R.id.listPool);
		
		simpleAdpt = new SimpleAdapter(this, poolList, android.R.layout.simple_list_item_1, new String[] {"nomPool"}, new int[] {android.R.id.text1});
		lv.setAdapter(simpleAdpt);
		

		
		registerForContextMenu(lv);

	}
	
	
	private void initList() {
		poolList.add(createPool("nomPool","proPool"));
		poolList.add(createPool("nomPool","proPool1"));
		poolList.add(createPool("nomPool","proPool2"));
		poolList.add(createPool("nomPool","proPool3"));
		poolList.add(createPool("nomPool","proPool4"));
		poolList.add(createPool("nomPool","proPool5"));
		poolList.add(createPool("nomPool","proPool6"));
		}
	
	
	
	private HashMap<String, String> createPool(String key, String name) {
		    HashMap<String, String> Pool = new HashMap<String, String>();
		    Pool.put(key, name);
		    return Pool;
		}
	
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
			      super.onCreateContextMenu(menu, v, menuInfo);
			      AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;
			     
				// We know that each row in the adapter is a Map
			      HashMap map =  (HashMap) simpleAdpt.getItem(aInfo.position);
			      menu.setHeaderTitle("Options for " + map.get("nomPool"));
			      menu.add(1, 1, 1, "Details");
			      menu.add(1, 2, 2, "Delete");
			  }
	
	public boolean onContextItemSelected(MenuItem item) {
		Intent intent = new Intent(this,listPartiActivity.class);
		//start the second Activity
		this.startActivity(intent);
	    return true;
	}

	
	




}
