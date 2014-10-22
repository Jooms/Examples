package com.example.roundtipper;

import java.util.ArrayList;

public class TipHistoryModel {
	private ArrayList <Double> rateHistory;
    private ArrayList <Double> amountHistory;
    private ArrayList <Double> totalHistory;
    
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
    public void recordHistory(double tipRate, double tipAmount, double billTotal) throws Exception
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
}
