package com.aivean.servlets;

import com.aivean.vlc.VlcClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by squirrel on 2/16/14.
 */
@Controller
public class UrlAddServletController {
    protected static Logger logger = Logger.getLogger("UrlAddServletController");

    @Autowired
    private AddURLResult results;

    @Autowired
    private VlcClient vlc;


    @RequestMapping("/")
    public ModelAndView showMainPage() {
        logger.info("Return View");
        ModelAndView model = new ModelAndView("WEB-INF/views/index.jsp");
        if (results.getResult() != null) {
            model.addObject("result", results.getResult());
            results.setResult(null);
        }
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam(value = "links", required = false) String links) {
        logger.info("add request");
        //VlcClient c = new VlcClient();
        String res;
        if (links != null) {
            String[] urls = links.split("[\\r\\n]+");
            res = vlc.enqueue(urls);
            results.setResult(res);
            System.out.println(res);
        }
        return "redirect:/";
    }

    @Component
    @Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
    public static class AddURLResultImpl implements AddURLResult {

        private String result;

        @Override
        public String getResult() {
            return result;
        }

        @Override
        public void setResult(String r) {
            this.result = r;
        }
    }

    /**
     * Created by squirrel on 2/16/14.
     */
    public static interface AddURLResult {
        String getResult();

        void setResult(String r);
    }
}
