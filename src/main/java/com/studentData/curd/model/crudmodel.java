package com.studentData.curd.model;

public class crudmodel {
	private int stud_no;
	private String stud_name;
	private int stud_DOB;
	private int stud_DOJ;

	public crudmodel() {

	}

	public crudmodel(int id, String name, int dob,int doj) {
		super();
		this.stud_no = id;
		this.stud_name = name;
		this.stud_DOB = dob;
		this.stud_DOJ=doj;
		
	}
	public int getId() {
		return stud_no;
	}

	public void setId(int id) {
		this.stud_no = id;
	}

	public String getName() {
		return stud_name;
	}

	public void setName(String name) {
		this.stud_name = name;
	}
	public int getStud_DOB() {
		return stud_DOB;
	}

	public void setStud_DOB(int stud_DOB) {
		this.stud_DOB = stud_DOB;
	}

	public int getStud_DOJ() {
		return stud_DOJ;
	}

	public void setStud_DOJ(int stud_DOJ) {
		this.stud_DOJ = stud_DOJ;
	}
	
	
	
	
	
	
	

}
