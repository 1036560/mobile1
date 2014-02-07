package net.charlesdelmaire.qingpool;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class EnvoieCourrielActivity extends Activity implements OnClickListener {
	
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.envoiecourriel);
		
		View btnClick = findViewById(R.id.btnEnvoieCou);
	    btnClick.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClick(View v){
	Intent i = new Intent(Intent.ACTION_SEND);
	i.setType("message/rfc822");
	i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"Contacts@Invités.com"});
	i.putExtra(Intent.EXTRA_SUBJECT, "Venez nous rejoindre sur Qing Pool");
	i.putExtra(Intent.EXTRA_TEXT   , "Nous avons un Pool de créer et nous aimerions vous avoir avec nous!");
	try {
	    startActivity(Intent.createChooser(i, "Send mail..."));
	} catch (android.content.ActivityNotFoundException ex) {
	    Toast.makeText(this, "Vous n'avez pas de client courriel d'installé.", Toast.LENGTH_SHORT).show();
	}
}
}

