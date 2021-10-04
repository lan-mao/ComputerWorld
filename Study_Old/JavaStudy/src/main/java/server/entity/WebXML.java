package server.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname WebXML
 * 存储web.xml的配置信息
 * @Date 2020/02/15 15:41
 * @Created by lan-mao.top
 */

public class WebXML {
    Map<String, String> servletClass = new HashMap<>();
    Map<String, String> servletURL = new HashMap<>();

    public WebXML() {
    }
    public String getClassName(String url){
        String servletName = servletURL.get(url);
        if (servletName!= null) {
            return servletClass.get(servletName);
        }
        return null;
    }
    public void setServletClass(String name, String className) {
        servletClass.put(name, className);
    }
    public void setServletURL(String url, String name) {
        servletURL.put(url, name);
    }

    public Map<String, String> getServletClass() {
        return servletClass;
    }

    public void setServletClass(Map<String, String> servletClass) {
        this.servletClass = servletClass;
    }

    public Map<String, String> getServletURL() {
        return servletURL;
    }

    public void setServletURL(Map<String, String> servletURL) {
        this.servletURL = servletURL;
    }
}