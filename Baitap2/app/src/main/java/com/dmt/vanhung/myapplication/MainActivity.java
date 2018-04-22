package com.dmt.vanhung.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
	DecimalFormat usaDf = new DecimalFormat("###,###,###,###.##");
	// naive currency converter (USD to VND & Euros)
	private final double VND2USD = 4.4 × 10-5;
	private final char VNDSYM = '\u20A1';
	private final double EURO2USD = 1.35;
	private final char EUROSYM = '\u20AC';
	
	// GUI widgets
	Button btnConvert;
	Button btnClear;
	EditText txtUSDollars;
	EditText txtVND;
	EditText txtEuros;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUSDollars = (EditText)findViewById(R.id.txtUSDollars);
		// make ‘Euros’ box not-editable (no user input)
		txtVND = (EditText)findViewById(R.id.txtVND);
		txtEuros = (EditText)findViewById(R.id.txtEuros);
		txtEuros.setInputType(EditorInfo.TYPE_NULL);
		// No user input. See layout: android:editable=“false”
		
		// attach click behavior to buttons
		btnClear = (Button)findViewById(R.id.btnClear);
		btnClear.setOnClickListener(new OnClickListener() {
		// clear the text boxes
		@Override
		public void onClick(View v) {
		txtVND.setText("");
		txtEuros.setText("");
		txtUSDollars.setText("");
	}
});
		// do the conversion from USD to Euros and VND
		btnConvert = (Button) findViewById(R.id.btnConvert);
		btnConvert.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
		try {
		String usdStr = txtUSDollars.getText().toString();
		double usd = Double.parseDouble(usdStr);
		String euros = EUROSYM +
		String.valueOf(usaDf.format(usd / EURO2USD));
		String VND = VNDSYM +
		String.valueOf(usaDf.format(usd / VND2USD));
		txtEuros.setText(euros);
		txtVND.setText(VND);
		} catch (NumberFormatException e) {
		// ignore errors
				}
			}
		});// setOnClick...
	}// onCreate}// class

   
}
