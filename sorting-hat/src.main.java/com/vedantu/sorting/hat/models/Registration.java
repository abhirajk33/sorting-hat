package com.vedantu.sorting.hat.models;

public class Registration {
	
	public static enum RegistrationCommand{
		reg
	}
	
	public static enum StudentClass{
		A,B
	}
	
	public static enum StudentFoodPreference{
		V,NV
	}
	
	
	private RegistrationCommand registrationCommand;
	private int studentRollNumber;
	private StudentClass studentClass;
	private StudentFoodPreference studentFoodPreference;
	


	public Registration(RegistrationCommand registrationCommand, int studentRollNumber, StudentClass studentClass,
			StudentFoodPreference studentFoodPreference) {
		this.registrationCommand = registrationCommand;
		this.studentRollNumber = studentRollNumber;
		this.studentClass = studentClass;
		this.studentFoodPreference = studentFoodPreference;
	}


	public RegistrationCommand getRegistrationCommand() {
		return registrationCommand;
	}


	public void setRegistrationCommand(RegistrationCommand registrationCommand) {
		this.registrationCommand = registrationCommand;
	}


	public int getStudentRollNumber() {
		return studentRollNumber;
	}


	public void setStudentRollNumber(int studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}


	public StudentClass getStudentClass() {
		return studentClass;
	}


	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}


	public StudentFoodPreference getStudentFoodPreference() {
		return studentFoodPreference;
	}


	public void setStudentFoodPreference(StudentFoodPreference studentFoodPreference) {
		this.studentFoodPreference = studentFoodPreference;
	}


	@Override
	public String toString() {
		return "Registration [studentRollNumber=" + studentRollNumber + ", "
				+ "studentClass=" + studentClass
				+ ", studentFoodPreference=" + studentFoodPreference + "]";
	}
	
	

}
