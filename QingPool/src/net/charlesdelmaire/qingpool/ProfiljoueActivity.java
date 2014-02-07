package net.charlesdelmaire.qingpool;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class ProfiljoueActivity extends Activity 
implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profiljoue);
		
		View btnClick = findViewById(R.id.btnRetPart);
	    btnClick.setOnClickListener(this);
	    
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void onClick(View v) {
		if(v.getId() == R.id.btnRetPart){
			//define a new Intent for the second Activity
			Intent intent = new Intent(this,ProfilpartActivity.class);
			//start the second Activity
			this.startActivity(intent);
		}

	}
	
	

}

