package net.charlesdelmaire.qingpool;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProfilpartActivity extends Activity 
implements OnClickListener {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profilpart);
		
		View btnClick = findViewById(R.id.btnVoirJoueur);
	    btnClick.setOnClickListener(this);
	    
	    View btnClick1 = findViewById(R.id.btnInviter);
	    btnClick1.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void onClick(View arg0) {
		if (arg0.getId() == R.id.btnVoirJoueur) {
			Intent intent = new Intent(this, PopupActivity.class);			
			this.startActivity(intent);
		}
		
		if (arg0.getId() == R.id.btnInviter) {
			Intent intent = new Intent(this, EnvoieCourrielActivity.class);
			this.startActivity(intent);
			
		}

	}
	
	
}	
	


	



