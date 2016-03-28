package com.mycompany.blog.dao;

import com.mycompany.blog.entity.Article;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO implements AbstractDAO<Article> {
    private final String SELECT_ALL_ARTICLES = "SELECT * FROM articles";

    private Connection connection = BlogConnection.getConnection();

    public List<Article> getAll() {
        List<Article> articles = new ArrayList<>();

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(SELECT_ALL_ARTICLES)) {
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
        return articles;
    }
}
