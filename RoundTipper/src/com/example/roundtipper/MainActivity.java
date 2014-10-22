package com.example.roundtipper;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements Observer
{
	private Button calc;
	private EditText subtotal;
	private TextView rate;
	private TextView tip;
	private TextView total;
	private TipModel tipCalc;
	private TipHistoryModel history;
	
	/**
	 * Initiates widget bindings when activity is created
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc = (Button) findViewById(R.id.buttonCalc);
        subtotal = (EditText) findViewById(R.id.subtotalField);
        rate = (TextView) findViewById(R.id.textRate);
        tip = (TextView) findViewById(R.id.textTip);
        total = (TextView) findViewById(R.id.textTotal);
        
        tipCalc = new TipModel();
        tipCalc.addObserver(this); // observes for calculation to be complete
        
        history = new TipHistoryModel();
    }
    
    /**
     * Uses the subtotal entered to calculate the tip within the model
     * 
     * @param view - the button that called the method
     */
    public void calculateTip(View view)
    {
    		if( !subtotal.getText().toString().isEmpty() )
    		{
    			tipCalc.setSubtotal(
    					  Double.parseDouble( subtotal.getText().toString() )
    					);  
    			
    		}
    }

    /**
     * Formats a double to have only two decimal places and 
     * adds a dollar sign before it
     * @param unformatted double
     * @return $x.yz
     */
    private String doubleToCurrency(double amount)
    {
    		DecimalFormat formatting = new DecimalFormat("#.##");
    		formatting.setRoundingMode(RoundingMode.FLOOR);
    		return "$ " + formatting.format(amount);
    }

	@Override
	public void update(Observable observable, Object data) {
		tip.setText( doubleToCurrency(tipCalc.getTipAmount()) );
		rate.setText( (int) Math.floor(tipCalc.getTipRate()*100) + "%" );
		total.setText( doubleToCurrency(tipCalc.getBillTotal()) );
		
		try {
			history.recordHistory(tipCalc.getTipRate(), tipCalc.getTipAmount(), tipCalc.getBillTotal());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
