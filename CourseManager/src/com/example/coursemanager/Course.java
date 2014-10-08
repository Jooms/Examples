package com.example.coursemanager;

/**
 * TODO: commenting!
 */
public class Course
{
	private String title;
	private String catalogID;
	private int seats;
	
	public Course(String title, String catID, int seats)
	{
		this.title = title;
		this.catalogID = catID;
		this.seats = seats;
	}
	
	public String getTitle()
	{
		return title;
	}
	public String getCatalogID()
	{
		return catalogID;
	}
	public int getSeats()
	{
		return seats;
	}
}