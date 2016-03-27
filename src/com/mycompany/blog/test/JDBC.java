package com.mycompany.blog.test;

import com.mycompany.blog.entity.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "user", "pass");
        List<Article> articles = new ArrayList<>();

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM articles")) {
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setDescription(rs.getString("description"));
                article.setText(rs.getString("text"));
                article.setAuthor(rs.getString("author"));

                System.out.println(article);

                articles.add(article);
            }

        } catch (SQLException e) {
            throw new RuntimeException("SQL Statement Error: " + e);
        }
    }
}
