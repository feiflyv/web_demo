<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
final String context = request.getContextPath();
final String source = context;
final String webTitle = "DemoWeb";//网站标题

//folder
final String css = source+"/assets/style";
final String img = source+"/assets/image";
final String appJs = source+"/app";
final String ctrlJs = source+"/app/controllers";
final String vendor = source+"/vendors";

pageContext.setAttribute("context",context);
pageContext.setAttribute("webTitle",webTitle);
pageContext.setAttribute("css",css);
pageContext.setAttribute("img",img);
pageContext.setAttribute("appJs",appJs);
pageContext.setAttribute("ctrlJs",ctrlJs);
pageContext.setAttribute("vendor",vendor);
%>