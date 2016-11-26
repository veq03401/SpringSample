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
  { "name":"",
    "age":"",
    "info":""
  },

  { "name":"takayuki",
	"age":41,
	"info":"札幌市北区"
  },
  { "name":"chiaki",
	"age":40,
	"info":"札幌市南区"
  },
  { "name":"shougo",
	"age":8,
	"info":"札幌市東区"
  },
  { "name":"ryosuke",
	"age":1,
	"info":"札幌市北区"
  }
];

$(function() {
  $('#selectedYear').change(function(){
	//confirm('いえーい');
    $('#selectedPerson').empty();
    for(var i in data) {
      $('#selectedPerson').append("<option value="     + data [i].age +">" +data[i].name  + "</option>");
    }
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