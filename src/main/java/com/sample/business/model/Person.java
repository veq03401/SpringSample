package com.sample.business.model;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

public class Person {
	
	//フィールドの定義
    @NotNull
    private String id;

    @NotNull
    private String name;
    private int age;
    private String birthDate;  //"yyyy/mm/dd"想定

    //コンストラクタ
    public Person(String id, String name, int age, String birthDate) {
    	this.id = id;
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    //ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    //Name
    @Size(max = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //BirthDate
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
	
}
