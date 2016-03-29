package com.mycompany.blog.action;

import com.mycompany.blog.dao.ArticleDAO;
import com.mycompany.blog.entity.Article;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ArticlesAction implements Action {
    ActionResult home;

    public ArticlesAction(String page) {
        home = new ActionResult(page);
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        ArticleDAO articleDAO = new ArticleDAO();
        List<Article> articles = articleDAO.getAll();
        req.setAttribute("articles", articles);

        return home;
    }
}
