package com.aivean.vlc;

import com.aivean.config.Config;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Service that provides integration with VLC
 */
@Component
public class VlcClient {

    public String enqueue(String[] urls) {

        boolean pause = false;
        int added = 0;

        for (String url : urls) {
            String out = sendCommand("enqueue", url);
            while (out.contains("Type 'menu select' or 'pause' to continue.")) {
                sendCommand("pause", "");
                out = sendCommand("enqueue", url);
                pause = true;
            }
            added++;
        }

        if (pause) {
            sendCommand("pause", "");
        }

        return (added + " links added");

    }

    private String sendCommand(String command, String arg) {
        Process p;
        StringBuilder output = new StringBuilder();

        try {
            p = Runtime.getRuntime().exec("nc -U " + Config.SOCKET);
            InputStream inputStream = p.getInputStream();
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));

            if (command != null && !command.trim().isEmpty()) {
                out.write(command + " " + arg.trim() + "\n");
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
