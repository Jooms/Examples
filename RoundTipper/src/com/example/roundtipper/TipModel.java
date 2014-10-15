package com.example.roundtipper;

import java.util.ArrayList;
import java.util.Observable;

//-------------------------------------------------------------------------
/**
 * The TipModel calculates "round tipping" where, given a subtotal, it finds
 * the closest whole dollar amount that is closest to tipping 20% <TARGET_RATE>
 */
public class TipModel extends Observable
{
    //~ Fields ................................................................

    private double billSubtotal;
    private double tipRate;
    private double tipAmount;
    private double billTotal;
    private ArrayList <Double> rateHistory;
    private ArrayList <Double> amountHistory;
    private ArrayList <Double> totalHistory;
    
    private final static double TARGET_RATE = 0.20;

    //~ Public methods ........................................................
    /**
     * Constructor initializes empty history
     */
    public TipModel()
    {
    		clearHistory();
    }
    
    /**
     * Resets each of the ArrayLists holding tipping history
     */
    public void clearHistory()
    {
    		rateHistory = new ArrayList <Double>();
		amountHistory = new ArrayList <Double>();
		totalHistory = new ArrayList <Double>();
    }
    /**
     * Records the current tip rate, tip amount, and total bill amount
     * at the end of their respective ArrayLists to maintain a history
     * of all tips
     * @throws Exception if there is no data to be stored
     */
    public void recordHistory() throws Exception
    {
    		if( tipRate > 0 && tipAmount > 0 && billTotal > 0 )
    		{
	    		rateHistory.add(tipRate);
	    		amountHistory.add(tipAmount);
	    		totalHistory.add(billTotal);
    		}
    		else
    		{
    			throw new Exception("Tip must be calculated before it is recorded!");
    		}
    }
    /**
     * Finds the average of the rates in the currently recorded history
     * @throws Exception if there is no history recorded yet
     */
    public double averageRate() throws Exception
    {
    		if( rateHistory.isEmpty() )
    		{
    			throw new Exception("No tips in history to average!");
    		}
    		else
    		{
    			double sum = 0;
    			for(double val:rateHistory)
    			{
    				sum+=val;
    			}
    			return sum/rateHistory.size();
    		}
    }
    /**
     * Gets the amount of the bill, before the tip (the subtotal).
     *
     * @return the amount of the bill, before the tip
     */
    public double getBillAmount()
    {
        return billSubtotal;
    }


    // ----------------------------------------------------------
    /**
     * Sets the amount of the bill, before the tip.
     *
     * @param newBillAmount the new amount of the bill before the tip
     */
    public void setSubtotal(double newBillAmount)
    {
        billSubtotal = newBillAmount;
        calcRoundTip();
    }

    /**
     * Calculates the closest tip rate to <TARGET_RATE> that results
     * in a final bill with a round (no change) total
     */
    private void calcRoundTip()
    {
    		double targetTip = billSubtotal * TARGET_RATE;
    		
    		double targetTotal = targetTip + billSubtotal;
    		
    		int cents = ((int) (targetTotal*100)) % 100;
    		System.out.println(cents);
    		if( cents == 0 )
    		{
    			tipRate = TARGET_RATE;
    			tipAmount = targetTip;
    			billTotal = targetTotal;
    		}
    		else if( cents >= 50 )
    		{
    			billTotal = Math.ceil(targetTotal);
    			tipAmount = billTotal - billSubtotal;
    			tipRate = tipAmount/billSubtotal;
    		}
    		else
    		{
    			billTotal = Math.floor(targetTotal);
    			tipAmount = billTotal - billSubtotal;
    			tipRate = tipAmount/billSubtotal;
    		}
    		setChanged();
    		notifyObservers();
    }
    // ----------------------------------------------------------
    /**
     * Gets the tip rate, represented as a decimal (ex. 15% tip would be 0.15).
     *
     * @return the tip rate
     */
    public double getTipRate()
    {
        return tipRate;
    }


    // ----------------------------------------------------------
    /**
     * Gets the absolute amount of the tip by itself
     *
     * @return the absolute amount of the tip by itself
     */
    public double getTipAmount()
    {
        return tipAmount;
    }


    // ----------------------------------------------------------
    /**
     * Gets the total amount of the bill, including the tip.
     *
     * @return the total amount of the bill, including the tip
     */
    public double getBillTotal()
    {
        return billTotal;
    }
    
}
