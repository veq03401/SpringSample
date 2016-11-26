package com.sample.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.business.model.Decade;
import com.sample.business.model.Person;
import com.sample.business.model.SelectSampleForm;
import com.sample.util.DateUtils;


@Controller
@RequestMapping(value="/SelectSample")
public class SelectSampleController {

  //初期表示処理
  @RequestMapping(value="/init", method=RequestMethod.GET)
  public String initSelectSample(Model model) {
	//生まれた年代リストの作成
    List<Decade> DecadeList = findDecadeList();
    model.addAttribute("DecadeList",DecadeList);

    //担当リストの作成
    List<Person> PersonList = new ArrayList<Person>();
    model.addAttribute("PersonList",PersonList);

    //Form初期データの作成
    SelectSampleForm selectSampleForm = new SelectSampleForm();
    //デフォルト値を指定したければ setSelectedYear()で指定する。
    //指定しなかった場合はyearの初期値がnullのため、nullの項目が明示的にSELECTタグのデフォルト値となる
    //selectSampleForm.setSelectedYear(1970);
    model.addAttribute("SelectForm",selectSampleForm);
    
    //初期表示JSPの表示
	return "SelectSample/SelectSample";		
  }
	
	
  @RequestMapping(value="/DecadeList", method=RequestMethod.GET)
  @ResponseBody
  public List<Decade> DecadeList() {
	return findDecadeList();		
  }
	
  @RequestMapping(value="/PersonList", method=RequestMethod.GET)
  @ResponseBody
  public List<Person> jsonList() {
    return findPersonList();		
  }

  //DecadeListのデータ取得
  private List<Decade> findDecadeList() {
	List<Decade> DecadeList = new ArrayList<Decade>();
    DecadeList.add(new Decade());
    DecadeList.add(new Decade(1950,"1950年代"));
    DecadeList.add(new Decade(1960,"1960年代"));
    DecadeList.add(new Decade(1970,"1970年代"));
    DecadeList.add(new Decade(1980,"1980年代"));
    DecadeList.add(new Decade(1990,"1990年代"));
    
	return DecadeList;
  }

  //personListのデータ取得
  private List<Person> findPersonList() {
	    List<Person> personList = new ArrayList<Person>();
	    for (int i = 0; i < 10; i++) {
	      personList.add(new Person("test", i, new Date()));
	    }
	  return personList;
  }
}