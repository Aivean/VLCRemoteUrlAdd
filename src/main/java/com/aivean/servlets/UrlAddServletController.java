package com.aivean.servlets;

import com.aivean.vlc.VlcClient;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by squirrel on 2/16/14.
 */
@Controller
public class UrlAddServletController{
    protected static Logger logger = Logger.getLogger("UrlAddServletController");

    @RequestMapping("/")
    public ModelAndView showMainPage(){
        logger.info("Return View");
        return new ModelAndView("index.jsp");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam(value = "links", required = false) String links)  {
        logger.info("add request");
        VlcClient c = new VlcClient();
        String res;
        if (links != null) {
            String[] urls = links.split("[\\r\\n]+");
            res = c.enqueue(urls);
            System.out.println(res);
        }
        return "redirect:/";
    }

}
