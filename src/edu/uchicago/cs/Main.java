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

public class Main extends Activity implements OnClickListener {

	//################################################
	//this shows call activity for result. 
	//################################################
	
	// declare refs to the views with activity scope
	Button btnSecond, btnThird;
	TextView txt;

	// used for passing data between activities (intra-app communication)
	private static final int REQUEST_CODE = 999;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// inflate the layout
		setContentView(R.layout.main);

		// get references to the views
		btnSecond = (Button) findViewById(R.id.btnSecond);
		btnThird = (Button) findViewById(R.id.btnThird);
		txt = (TextView) findViewById(R.id.txt);

		btnSecond.setOnClickListener(this);
		btnThird.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.btnSecond) {
			//clear out the txt field
			txt.setText("");

			// ********************************
			// This method works great for intra-app calls between activities
			// ********************************

			// Intent itnSecond = new Intent(this, Second.class);
			// startActivity(itnSecond);

			// ********************************
			// You can use this method as well
			// notice that all you need is the component name for explicit calls
			// ********************************
			Intent itnSecond = new Intent();
			itnSecond.setComponent(new ComponentName("edu.uchicago.cs",
					"edu.uchicago.cs.Second"));
			startActivity(itnSecond);

		}

		else {

			Intent itnThird = new Intent();
			itnThird.setComponent(new ComponentName("edu.uchicago.cs",
					"edu.uchicago.cs.Third"));
			// ********************************
			// or you could do this -> Intent itnThird = new Intent(this,
			// Third.class);
			// ********************************
			itnThird.putExtra("name", "Adam Gerber");
			itnThird.putExtra("email", "gerber@cs.uchicago.edu");

			// Set the request code to any code you like, you can identify the
			// callback via this code
			startActivityForResult(itnThird, REQUEST_CODE);

		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {

			StringBuilder stb = new StringBuilder();
			Bundle bnd = data.getExtras();
			Set<String> strKeys = data.getExtras().keySet();
			for (String str : strKeys) {
				stb.append(str + " : " + bnd.get(str).toString() + "\n");
			}
			
			txt.setText(stb.toString());
			
			
		}
	}
}