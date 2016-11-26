<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SelectSample</title>
<script src="<c:url value="/resource/js/jquery-3.1.1.min.js" />" ></script>
<script>
var data = [
  { "id":"001",
	"name":"takayuki",
	"age":41,
	"info":"札幌市北区"
  },
  
  { "id":"002",
    "name":"chiaki",
	"age":40,
	"info":"札幌市南区"
  },
  
  { "id":"003",
	"name":"shougo",
	"age":8,
	"info":"札幌市東区"
  },
  { "id":"004",
	"name":"ryosuke",
	"age":1,
	"info":"札幌市北区"
  }
];

$(function() {
  //selectedYearの先頭行に空のデータとデフォルト値を設定
  $('#selectedYear').prepend($("<option>").val(""));
  $('#selectedYear').val("");
  
  //selectedYear変更時の処理
  $('#selectedYear').change(function(){
	$('#selectedPerson').children().remove();

    var year = $('#selectedYear').val();
    if (year == "") {
      return;
    } 

    //data定数の値を設定する場合はこちら
//    $('#selectedPerson').append($("<option>").val(""));
//    for(var i in data) {
//      $('#selectedPerson').append($("<option>").val(data[i].id).text(data[i].name));
//    } 

    $.getJSON(
      "./PersonList",
      {"year":year},
      function(personList){
        var optionItems = new Array();
        optionItems.push(new Option("",""));
        for (key in personList) {
          optionItems.push(new Option(personList[key].name,personList[key].id ));
        }
        $('#selectedPerson').append(optionItems);
      }
    );
    
  })	    
});
</script>
</head>
<body>

<form:form action="/SelectSample/post" method="POST" modelAttribute="SelectForm" >
 生まれた年代　 <form:select path="selectedYear" items="${DecadeList}" itemLabel="nendai" itemValue="year" delimiter=" " /><br>
 担当         <form:select path="selectedPerson" items="${PersonList}" itemLabel="name" itemValue="name" delimiter=" " /><br>　　　　　　

</form:form>

</body>
</html>