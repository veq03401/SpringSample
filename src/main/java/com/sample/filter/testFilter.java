package com.sample.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class testFilter implements Filter {

  
  @Override
  public void doFilter(ServletRequest req,ServletResponse resp,FilterChain filterChain) 
    throws IOException, ServletException {
    
    try {
      System.out.println("-----------Filter実行！-----------");
      //HTTPヘッダを取得し全表示
      HttpServletRequest request = (HttpServletRequest)req;
      Enumeration headernames = request.getHeaderNames();
      while (headernames.hasMoreElements()){
        String name = (String)headernames.nextElement();
        Enumeration headervals = request.getHeaders(name);
        while (headervals.hasMoreElements()){
          String val = (String)headervals.nextElement();
          System.out.println(name + " : " + val);
        }
      }

      //postパラメータを全て取得し標準出力に表示
      Map map_par=req.getParameterMap();
      Set map_ite1 = map_par.keySet( );
      Iterator i = map_ite1.iterator();
      while(i.hasNext()) {
        String key = (String)i.next();
        String par[] = (String[])map_par.get(key);
        System.out.println(key + " = " + par[0]);
      }
      
      //メッセージボディの内容を標準出力に表示
//      BufferedReader br = new BufferedReader(req.getReader());
//      String param = br.readLine();
//      while(param != null) {
//        System.out.println(param);
//        param = br.readLine();
//      }
      
      System.out.println("-----------ServletにChain！-----------");      
      filterChain.doFilter(req, resp);
      System.out.println("-------------Servletから処理が戻ってきた！-----------");
    } catch(Exception e) {
      System.out.println("Exception発生！");
      e.printStackTrace();
    }
  } 
  
  @Override
  public void init(FilterConfig filterConfig) 
  throws ServletException {
  }

  @Override
  public void destroy() {
  }

}