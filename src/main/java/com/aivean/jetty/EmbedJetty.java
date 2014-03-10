package com.aivean.jetty;

import com.aivean.config.Config;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-01
 */
public class EmbedJetty {

    private static String getJarUrl() {
        URL url = EmbedJetty.class.getProtectionDomain().getCodeSource().getLocation();
        try {
            return URLDecoder.decode(url.getFile(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(Config.PORT);

        URL resource = EmbedJetty.class.getClassLoader().getResource(".");
        String rootPath = resource == null ? getJarUrl() : resource.toString();
        System.out.println(rootPath);
        WebAppContext webapp = new WebAppContext(rootPath, "");
        server.setHandler(webapp);

        server.start();
        server.join();
    }
}