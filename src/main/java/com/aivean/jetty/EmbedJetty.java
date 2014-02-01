package com.aivean.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-01
 */
public class EmbedJetty {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        String rootPath = EmbedJetty.class.getClassLoader().getResource("webapp").toString();
        WebAppContext webapp = new WebAppContext(rootPath, "");
        server.setHandler(webapp);

        server.start();
        server.join();
    }
}