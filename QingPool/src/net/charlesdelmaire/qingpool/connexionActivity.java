package net.charlesdelmaire.qingpool;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class connexionActivity extends Activity 
implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.connexion);
		
		View btnClick = findViewById(R.id.btnConnOk);
	    btnClick.setOnClickListener(this);
	    
	    View btnClick1 = findViewById(R.id.btnConnReset);
	    btnClick1.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.btnConnOk){
			//define a new Intent for the second Activity
			Intent intent = new Intent(this,principaleActivity.class);
			//start the second Activity
			this.startActivity(intent);
		}
		
		if(v.getId() == R.id.btnConnReset){
			
			EditText txtCourriel = (EditText)findViewById(R.id.txBoxCourriel);
			txtCourriel.setText("");
			
			EditText txtMdp = (EditText)findViewById(R.id.txBoxMdp);
			txtMdp.setText("");
			
		}
		
	}

}
