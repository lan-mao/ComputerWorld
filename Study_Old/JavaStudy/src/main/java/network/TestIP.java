package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Classname TestIP
 *  测试IP
 * @Date 2020/02/10 10:13
 * @Created by lan-mao.top
 */

public class TestIP {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
    }
}
