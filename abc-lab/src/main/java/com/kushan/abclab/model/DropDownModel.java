package com.kushan.abclab.model;

public class DropDownModel {
	
	private int id;
	private String label;
	private String dropID;
	
	private String date;
    private String price;

    public void AppointmentInfo(String date, String price) {
        this.date = date;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }
	
	public DropDownModel(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
	
	public DropDownModel() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	public String getDropID() {
		return dropID;
	}


	public void setDropID(String dropID) {
		this.dropID = dropID;
	}
	
	
	

}
