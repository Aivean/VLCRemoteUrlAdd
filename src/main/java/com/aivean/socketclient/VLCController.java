package com.aivean.socketclient;

import com.aivean.config.Config;

import java.io.*;

/**
 * Created by squirrel on 2/1/14.
 */
public class VLCController {


    public String enqueue(String[] urls) {

        Process p;
        StringBuffer output = new StringBuffer();

        try {
            p = Runtime.getRuntime().exec("nc -U " + Config.SOCKET);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            for (String url : urls) {
                out.write("enqueue " + url + "\n");
            }

            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return output.toString();
    }


}
