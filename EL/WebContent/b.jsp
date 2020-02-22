<%@page import="pojo.Person"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			Person person = new Person();
			person.setId(100);
			person.setPhones(new String[]{"123456","7890","21234"});
			List<String> cities = Arrays.asList("北京","上海","广州","深圳");
			person.setCities(cities);
			Map<String, Object> map = new HashMap<>();
			map.put("key1","values1");
			map.put("key2","values2");
			map.put("key3","values3");
			person.setMap(map);
			request.setAttribute("p", person);
		%>
		输出Person对象：${ p }<br/>
		输出Person的id属性：${ p.id }<br/>
		输出Person的数组元素值：${ p.phones }<br/>
		输出Person的List元素值：${ p.cities[0] }<br/>
		输出Person的Map元素值：${ p.map.key1 }<br/>
		
	</body>
</html>