package com.mycompany.blog.action;

import com.mycompany.blog.dao.ArticleDAO;
import com.mycompany.blog.entity.Article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ArticlesAction implements Action {
    ActionResult index = new ActionResult("index");
    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {

        ArticleDAO dao = new ArticleDAO();
        List<Article> articles = dao.getAll();
        req.setAttribute("articles", articles);

        return index;
    }
}
