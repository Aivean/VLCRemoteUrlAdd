package com.aivean.vlc;

import com.aivean.config.Config;

import java.io.*;

/**
 *  Service that provides integration with VLC
 */
public class VlcClient {

    public String enqueue(String[] urls) {

        Process p;
        StringBuilder output = new StringBuilder();

        try {
            p = Runtime.getRuntime().exec("nc -U " + Config.SOCKET);
            InputStream inputStream = p.getInputStream();
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            for (String url : urls) {
                if (url == null || url.trim().isEmpty()) {
                    continue;
                }
                out.write("enqueue " + url.trim() + "\n");
                out.flush();
            }
            out.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return output.toString();
    }
}
