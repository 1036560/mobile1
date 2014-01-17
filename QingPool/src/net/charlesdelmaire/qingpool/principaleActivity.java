package net.charlesdelmaire.qingpool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;


public class principaleActivity extends Activity 
implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pageprincipale);
		
		View btnClick = findViewById(R.id.btnStartPool);
	    btnClick.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btnStartPool){
			//define a new Intent for the second Activity
			Intent intent = new Intent(this,nouveauPoolActivity.class);
			//start the second Activity
			this.startActivity(intent);
		}
	}

	
}

