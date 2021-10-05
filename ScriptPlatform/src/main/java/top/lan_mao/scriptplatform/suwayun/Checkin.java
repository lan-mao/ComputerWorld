package top.lan_mao.scriptplatform.suwayun;

import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.net.url.UrlPath;
import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.Method;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.LogFactory;
import cn.hutool.setting.Setting;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create Date 2021/09/28 15:25:28 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 创建定时器，定时签到 <br>
 */
public class Checkin {

    private static final String CHECKIN_HOST ;
    private static final String CHECKIN_PATH;
    private static final String CHECKIN_AUTHORIZATION;
    private static final String CHECKIN_AUTHORIZATION_KEY;
    private static final String EMAIL_RECIPIENT;
    private static final String EMAIL_TITLE;

    private static final Setting SETTING;

    static{
        SETTING = new Setting("suwayun.setting");
        CHECKIN_HOST = SETTING.get("CHECKIN_HOST");
        CHECKIN_AUTHORIZATION = SETTING.get("CHECKIN_AUTHORIZATION");
        CHECKIN_PATH = SETTING.get("CHECKIN_PATH");
        CHECKIN_AUTHORIZATION_KEY = SETTING.get("CHECKIN_AUTHORIZATION_KEY");
        EMAIL_TITLE = SETTING.get("EMAIL_TITLE");
        EMAIL_RECIPIENT = SETTING.get("EMAIL_RECIPIENT");
    }

    /**
     * 签到并返回响应信息
     * @return 响应信息
     */
    public static HttpResponse checkinSuWaYun () {
        String url = UrlBuilder.create()
                .setScheme("HTTPS")
                .setHost(CHECKIN_HOST)
                .setPath(new UrlPath().parse(CHECKIN_PATH, null))
                .toString();
        LogFactory.get().info(url);
        return new HttpRequest(url)
                .setMethod(Method.PUT)
                .header(CHECKIN_AUTHORIZATION_KEY, CHECKIN_AUTHORIZATION)
                .execute();
    }

    /**
     * 发送邮件
     * @param message 邮件内容
     * @return 邮件id
     */
    public static String sendMail(String message) {
        return MailUtil.send(EMAIL_RECIPIENT, EMAIL_TITLE, message, false);
    }

    /**
     * 签到并且发送邮件
     * @return 返回邮件id
     */
    public static String sendMailAfterCheckin() {
        String body = UnicodeUtil.toString(checkinSuWaYun().body());
        StringBuilder message = new StringBuilder();
        MessageBO response = parseJSON(body);
        switch (response.getCode()) {
            case 10:
                message.append(response.getMessage());
                break;
            case 100:
                message.append(response.getData().getMessage());
                break;
            default:
                message.append("签到失败");
                break;
        }
        message.append("\n");
        message.append(body).append("\n");
        message.append("运行时间：").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
        return sendMail(message.toString());
    }

    private static MessageBO parseJSON(String json) {
        return JSONUtil.toBean(json, MessageBO.class);
    }
}