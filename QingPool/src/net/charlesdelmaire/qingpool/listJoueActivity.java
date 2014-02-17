package net.charlesdelmaire.qingpool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class listJoueActivity extends Activity implements OnClickListener {
	List<Map<String, String>> poolList = new ArrayList<Map<String, String>>();
	SimpleAdapter simpleAdpt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listjoue);

		initList();

		ListView lv = (ListView) findViewById(R.id.listJoue);

		simpleAdpt = new SimpleAdapter(this, poolList,
				android.R.layout.simple_list_item_1,
				new String[] { "nomPool" }, new int[] { android.R.id.text1 });
		lv.setAdapter(simpleAdpt);

		registerForContextMenu(lv);

		View btnClick2 = findViewById(R.id.btnRetPart);
		btnClick2.setOnClickListener(this);

	}

	private void initList() {
		poolList.add(createPool("nomPool", "jouePool"));
		poolList.add(createPool("nomPool", "jouePool1"));
		poolList.add(createPool("nomPool", "jouePool2"));
		poolList.add(createPool("nomPool", "jouePool3"));
		poolList.add(createPool("nomPool", "jouePool4"));
		poolList.add(createPool("nomPool", "jouePool5"));
		poolList.add(createPool("nomPool", "jouePool6"));
	}

	private HashMap<String, String> createPool(String key, String name) {
		HashMap<String, String> Pool = new HashMap<String, String>();
		Pool.put(key, name);
		return Pool;
	}

	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;

		// We know that each row in the adapter is a Map
		HashMap map = (HashMap) simpleAdpt.getItem(aInfo.position);
		menu.setHeaderTitle("Options for " + map.get("nomPool"));
		menu.add(1, 1, 1, "Details");
		menu.add(1, 2, 2, "Delete");
	}

	public boolean onContextItemSelected(MenuItem item) {
		Intent intent = new Intent(this, ProfilJoueActivity.class);
		// start the second Activity
		this.startActivity(intent);
		return true;
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btnRetPart) {
			// define a new Intent for the second Activity
			Intent intent = new Intent(this, ProfilpartActivity.class);
			// start the second Activity
			this.startActivity(intent);
		}

	}

}
