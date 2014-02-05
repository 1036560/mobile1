package net.charlesdelmaire.qingpool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.AdapterContextMenuInfo;

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
		partList.add(createPart("nomPart","proPart"));
		partList.add(createPart("nomPart","proPart1"));
		partList.add(createPart("nomPart","proPart2"));
		partList.add(createPart("nomPart","proPart3"));
		partList.add(createPart("nomPart","proPart4"));
		partList.add(createPart("nomPart","proPart5"));
		partList.add(createPart("nomPart","proPart6"));
		}
	
	private HashMap<String, String> createPart(String key, String name) {
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
		Intent intent = new Intent(this,ProfilpartActivity.class);
		//start the second Activity
		this.startActivity(intent);
		return true;
	}

}
