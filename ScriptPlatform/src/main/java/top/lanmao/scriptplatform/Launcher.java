package top.lanmao.scriptplatform;

import top.lanmao.scriptplatform.localip.LauncherLocalIpImpl;
import top.lanmao.scriptplatform.suwayun.LauncherSuwayunImpl;

/**
 * Create Date 2021/10/03 17:10:35 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 */
public class Launcher {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("请输入参数");
            return;
        }
        switch (args[0]) {
            default:
                System.out.println("输出参数错误，目前支持参数：suwayun,localIP");
                break;
            case "suwayun":
                new LauncherSuwayunImpl().launch(args);
                break;
            case "localIP":
                new LauncherLocalIpImpl().launch(args);
        }


    }
}