package edu.uchicago.cs;

import edu.uchicago.cs.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Third extends Activity implements OnClickListener {

	Button btnRet;
	EditText edtUser;
	EditText edtEmail;

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.third);
		
		edtUser = (EditText) findViewById(R.id.edtUser);
		edtEmail = (EditText) findViewById(R.id.edtEmail);
		btnRet = (Button) findViewById(R.id.btnRet);
		btnRet.setOnClickListener(this);
		
		//is this the same bundle
		Bundle bnd = getIntent().getExtras();
		if (bnd == null) {
			return;
		}
		String strName = bnd.getString("name");
		String strEmail = bnd.getString("email");
		if (strName != null && strEmail != null) {

			edtUser.setText(strName);
			edtEmail.setText(strEmail);
		}



	}

	@Override
	public void onClick(View view) {
		//Intent itn = new Intent();
		Intent itn = getIntent();
		// Return some hard-coded values
		itn.putExtra("ret", edtUser.getText().toString() + ":" + edtEmail.getText().toString());

		setResult(RESULT_OK, itn);
		finish();
	}

}