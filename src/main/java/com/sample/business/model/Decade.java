package com.sample.business.model;

public class Decade {

	//フィールドの定義
    private int year;
    private String nendai;

    //コンストラクタ
    public Decade() {
    }

    public Decade(int argYear,String argNendai) {
    	this.setYear(argYear);
    	this.setNendai(argNendai);
    }

    //Year
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }

    //Nendai
    public String getNendai() {
        return nendai;
    }

    public void setNendai(String nendai) {
        this.nendai = nendai;
    }

}
