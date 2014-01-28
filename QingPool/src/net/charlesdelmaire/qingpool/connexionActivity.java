package net.charlesdelmaire.qingpool;

import com.google.android.gms.common.*;
import com.google.android.gms.common.GooglePlayServicesClient.*;
import com.google.android.gms.plus.PlusClient;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class connexionActivity extends Activity 
implements View.OnClickListener, ConnectionCallbacks, OnConnectionFailedListener {
	
	 private static final String TAG = "connexionActivity";
	 private static final int REQUEST_CODE_RESOLVE_ERR = 9000;

	 private ProgressDialog mConnectionProgressDialog;
	 private PlusClient mPlusClient;
	 private ConnectionResult mConnectionResult;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.connexion);

		
		View btnClick = findViewById(R.id.btnConnOk);
	    btnClick.setOnClickListener(this);
	    
	    View btnClick1 = findViewById(R.id.btnConnReset);
	    btnClick1.setOnClickListener(this);
	    
	    mPlusClient = new PlusClient.Builder(this, this, this)
        .setActions("http://schemas.google.com/AddActivity", "http://schemas.google.com/BuyActivity")
        .setScopes(Scopes.PLUS_LOGIN)  // recommended login scope for social features
        //.setScopes("profile")       // alternative basic login scope
        .build();
	    findViewById(R.id.sign_in_button).setOnClickListener(this);
	    mConnectionProgressDialog = new ProgressDialog(this);
        mConnectionProgressDialog.setMessage("Signing in...");
		
	    
	 
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
		
		
		if (v.getId() == R.id.sign_in_button && !mPlusClient.isConnected()) {
	        if (mConnectionResult == null) {
	            mConnectionProgressDialog.show();
	        } else {
	            try {
	                mConnectionResult.startResolutionForResult(this, REQUEST_CODE_RESOLVE_ERR);
	            } catch (SendIntentException e) {
	                // Try connecting again.
	                mConnectionResult = null;
	                mPlusClient.connect();
	            }
	        }
	    }
		
	}

	 @Override
	    public void onConnectionFailed(ConnectionResult result) {
	      if (mConnectionProgressDialog.isShowing()) {
	        // The user clicked the sign-in button already. Start to resolve
	        // connection errors. Wait until onConnected() to dismiss the
	        // connection dialog.
	        if (result.hasResolution()) {
	          try {
	                   result.startResolutionForResult(this, REQUEST_CODE_RESOLVE_ERR);
	           } catch (SendIntentException e) {
	                   mPlusClient.connect();
	           }
	        }
	      }
	      // Save the result and resolve the connection failure upon a user click.
	      mConnectionResult = result;
	    }

	  @Override
	    public void onConnected(Bundle connectionHint) {
	        String accountName = mPlusClient.getAccountName();
	        Toast.makeText(this, accountName + " is connected.", Toast.LENGTH_LONG).show();
	    }

	  @Override
	    public void onDisconnected() {
	        Log.d(TAG, "disconnected");
	    }
	
	@Override
    protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
        if (requestCode == REQUEST_CODE_RESOLVE_ERR && responseCode == RESULT_OK) {
            mConnectionResult = null;
            mPlusClient.connect();
        }
    }
	
	

	

}
