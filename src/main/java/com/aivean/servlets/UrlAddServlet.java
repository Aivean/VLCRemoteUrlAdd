package com.aivean.servlets;

import com.aivean.socketclient.VLCController;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-01
 */
public class UrlAddServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VLCController  c = new VLCController();
        String res;
        String[] urls = req.getParameter("links").split("[\\r\\n]+");

        res = c.enqueue(urls);

        System.out.println(res);
        resp.sendRedirect("/");
    }
}
