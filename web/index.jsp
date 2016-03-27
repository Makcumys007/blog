<%@ page import="com.mycompany.blog.dao.ArticleDAO" %>
<%@ page import="com.mycompany.blog.entity.Article" %>
<%@ page import="java.util.List" %><%--@elvariable id="articles" type="java.util.List"--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <% ArticleDAO dao = new ArticleDAO();
      List<Article> all = dao.getAll();
    %>

  <%=all.get(0)%>
  </body>
</html>
