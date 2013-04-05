package edu.uchicago.cs;



import edu.uchicago.cs.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Second extends Activity implements OnClickListener {

	//though we don't need to define this reference with class scope here, 
	//it's a good habit to do so
	Button btnFinish;


	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.second);

		btnFinish = (Button) findViewById(R.id.btnFinish);
		btnFinish.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
	}
}