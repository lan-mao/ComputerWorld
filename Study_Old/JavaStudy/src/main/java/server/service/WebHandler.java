package server.service;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import server.entity.WebXML;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname WebHandler
 *  解析web.xml配置文件
 * @Date 2020/02/15 14:43
 * @Created by lan-mao.top
 */


public class WebHandler extends DefaultHandler {
    WebXML webXML = new WebXML();
    String name;//保存当前操作的servlet名字
    List<String> urls = new ArrayList<>();//防止servlet-name在url-Pattern后面
    String className;//保存当前操作的servlet类名
    String tag ;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tag = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (content.equals(""))
            return;
        switch (tag){
            case "servlet-name":{
                name = content;
                break;
            }
            case "servlet-class":{
                className = content;
                break;
            }
            case "url-pattern":{
                urls.add(content);
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "servlet":{
                webXML.setServletClass(name, className);
                break;
            }
            case "servlet-mapping":{
                for (String url : urls) {
                    webXML.setServletURL(url, name);
                }
                urls.clear();
                break;
            }
        }
    }

    public WebXML getWebXML() {
        return webXML;
    }

}