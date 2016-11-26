package com.sample.business.model;

public class SelectSampleForm {
	
  //フィールド
  private int selectedYear;

  private String selectedPerson;

  //Setter Getter  
  public int getSelectedYear() {
      return selectedYear;
  }
  
  public void setSelectedYear(int selectedYear) {
      this.selectedYear = selectedYear;
  }
  
  public String getSelectedPerson() {
      return selectedPerson;
  }
  
  public void setSelectedPerson(String selectedPerson) {
      this.selectedPerson = selectedPerson;
  }

  
  
}
