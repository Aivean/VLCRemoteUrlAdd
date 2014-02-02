package com.aivean.servlets;

import com.aivean.vlc.VlcClient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-01
 */
public class UrlAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VlcClient c = new VlcClient();
        String res;
        String links = req.getParameter("links");
        if (links != null) {
            String[] urls = links.split("[\\r\\n]+");
            res = c.enqueue(urls);
            System.out.println(res);
        }
        resp.sendRedirect("/");
    }
}
