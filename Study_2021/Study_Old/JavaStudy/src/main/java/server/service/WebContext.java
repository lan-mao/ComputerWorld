package server.service;

import org.xml.sax.SAXException;
import server.entity.WebXML;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @Classname WebContext
 *  对url进行解析，并找到创建对应的servlet对象
 * @Date 2020/02/15 16:34
 * @Created by lan-mao.top
 */

public class WebContext {
    private WebXML webXML ;
    private static volatile WebContext context;

    private WebContext() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            WebHandler handler = new WebHandler();
            parser.parse(WebContext.class.getResourceAsStream("/webTest.xml"), handler);
            webXML = handler.getWebXML();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebContext getContext() {
        if (context == null){
            return context = new WebContext();
        }
        return context;
    }

    public Servlet getServlet(String url) throws ClassNotFoundException {
        String className = webXML.getClassName(url);
        Servlet servlet = null;
        if (className == null) {
            throw new ClassNotFoundException("未找到url对应的servlet------" + url);
        }
        try {
            Class clz = Class.forName(className);
            servlet = (Servlet) clz.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return servlet;
    }

}
