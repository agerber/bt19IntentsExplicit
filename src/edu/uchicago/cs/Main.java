package edu.uchicago.cs;

import java.util.Set;

import edu.uchicago.cs.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity  {

	//################################################
	//this shows call activity for result. 
	//################################################

	// used for passing data between activities (intra-app communication)
	private static final int REQUEST_CODE = 999;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// inflate the layout
		setContentView(R.layout.main);



	
	}
}