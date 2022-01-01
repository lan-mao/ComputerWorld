package server.service;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.*;

/**
 * 封装request
 *
 * @Date 2020/02/16 11:33
 * @Created by lan-mao.top
 */

public class Request implements Closeable {
    private Socket socket;
    private String context;
    private String method;
    private String URL;
    private String parameter;
    private Map<String, List<String>> parameters;
    public static final String BLANK = " ";
    public static final String CRLF = "\r\n";
    public Request(Socket socket) {
        this.socket = socket;
        parameters = new HashMap<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            char[] temp = new char[1024 * 1024];
            int length = 0;
            StringBuilder sb = new StringBuilder();
            while (bufferedReader.ready()) {
                if ((length = bufferedReader.read(temp)) != -1)
                    sb.append(temp, 0, length);
            }
            context = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //分析报文中的信息，截取对应的信息
        analysisMessage();
    }

    private void analysisMessage (){
        if (context == null || "".equals(context)) {
            return;
        }
        String[] list = context.split(CRLF);
        String[] list_0 = list[0].split(BLANK);
        method = list_0[0];
        int index = list_0[1].lastIndexOf('?');
        if (index != -1) {
            URL = list_0[1].substring(0,index);
            parameter = list_0[1].substring(index + 1) + "&";
        } else {
            URL = list_0[1];
            parameter = "";
        }
        parameter += context.substring(context.lastIndexOf(CRLF)).trim();
        if (parameter == null ||"".equals(parameter)) {
            return;
        }
        String[] parameterList = parameter.split("&");
        for (String s : parameterList) {
            String[] param = s.split("=");
            if (param.length < 2) {
                param = Arrays.copyOf(param,2);
            }
            if (parameters.containsKey(param[0])) {
                parameters.get(param[0]).add(param[1]);
            } else {
                List<String> value = new ArrayList<>();
                value.add(param[1]);
                parameters.put(param[0], value);
            }
        }
    }

    public String getURL() {
        return URL;
    }

    public String getMethod() {
        return method;
    }

    public Map<String, List<String>> getParameters() {
        return parameters;
    }

    @Override
    public void close() throws IOException {
        socket.shutdownInput();
    }
}
