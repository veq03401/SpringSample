package com.sample.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.business.model.User;
import com.sample.business.service.UserService;

/**
 * このアノテーションをつけて、component-scanさせるとControllerとして扱われます。
 */
@Controller
@RequestMapping(value="/user/")
public class UserController {
  @Autowired
  private UserService userService;
  
  /**
   * formモデルのバインダーの初期化。リクエストパラメタをモデルに変換するたびに呼ばれる。
  */
  @InitBinder("form")
  public void initBinderForm(WebDataBinder binder) {
    System.out.println("■■■■initBinderForm実行■■■■");

    //バインドするときの日付のフォーマット指定。
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, "user.upDate", new CustomDateEditor(dateFormat, true));

    //Userオブジェクトのうち、user.nameパラメタを受け取りたくない場合
    binder.setAllowedFields("user.age", "user.upDate");
  }
 
  /**
   * モデルオブジェクトの初期化
  */
  @ModelAttribute("form")
  public Form newRequest(
    @RequestParam(required=false, value="user.id") String userId
  ) {
    System.out.println("■■■■new Request実行■■■■");

    Form f = new Form();
    //
    User user = null;
    if(userId == null){
      user = new User();
    }else{
      user = this.userService.getUser(userId);
    }
    //
    f.setUser(user);
    return f;
  }
 
  //リクエスト処理------------------------------------------
  @RequestMapping(value="edit/input", method=RequestMethod.GET)
  public String input(Form form) {
    System.out.println("■■■■input実行■■■■");
    //既にnewRequestでモデルをDBから取り出し、設定しているので何もする必要がない
    return "UserInput/user-Edit-Input";
  }
 
  @RequestMapping(value="edit/confirm", method=RequestMethod.POST)
  public String confirm(@Valid Form form, BindingResult result) {
    System.out.println("■■■■confirm実行■■■■");
    //@Validを指定したモデルは妥当性チェックが実行される。
    if(result.hasErrors()){
      return "UserInput/user-Edit-Input";
    }
    return "UserInput/user-Edit-Confirm";
  }
 
  @RequestMapping(value="edit/finish", method=RequestMethod.POST)
  public String finish(@Valid Form form, BindingResult result) throws Exception {
    System.out.println("■■■■finish実行■■■■");
    if(result.hasErrors()){
      return "/UserInput/user-Edit-Input";
    }
  
    //データ更新
    this.userService.updateUser(form.user);
    return "/UserInput/user-Edit-Finish";
  }
 
 
  //---------------------------------------------
  //フォーム(HTML用のパラメタを受け取れるように作っておいた方がよいと思います)
  public static class Form{
    @Valid
    private User user;
    public User getUser() {
      return user;
    }
    public void setUser(User user) {
      this.user = user;
    }
  }
}