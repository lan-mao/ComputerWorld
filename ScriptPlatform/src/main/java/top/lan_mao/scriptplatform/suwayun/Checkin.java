package top.lan_mao.scriptplatform.suwayun;

import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.net.url.UrlPath;
import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.Method;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.LogFactory;
import cn.hutool.setting.Setting;

/**
 * Create Date 2021/09/28 15:25:28 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * TODO:创建定时器，定时签到 <br>
 */
public class Checkin {

    private static final String CHECKIN_HOST ;
    private static final String CHECKIN_PATH;
    private static final String CHECKIN_AUTHORIZATION;
    private static final String CHECKIN_AUTHORIZATION_KEY;
    private static final String CHECKIN_JSON_CODE_KEY;
    private static final Integer CHECKIN_JSON_CODE_SUCCESS;
    private static final Integer CHECKIN_JSON_CODE_REPEAT;
    private static final String EMAIL_RECIPIENT;
    private static final String EMAIL_TITLE;
    private static final Setting SETTING;

    static{
        SETTING = new Setting("suwayun.setting");
        CHECKIN_HOST = SETTING.get("CHECKIN_HOST");
        CHECKIN_AUTHORIZATION = SETTING.get("CHECKIN_AUTHORIZATION");
        CHECKIN_PATH = SETTING.get("CHECKIN_PATH");
        CHECKIN_AUTHORIZATION_KEY = SETTING.get("CHECKIN_AUTHORIZATION_KEY");
        CHECKIN_JSON_CODE_KEY = SETTING.get("CHECKIN_JSON_CODE_KEY");
        CHECKIN_JSON_CODE_REPEAT = SETTING.getInt("CHECKIN_JSON_CODE_REPEAT");
        CHECKIN_JSON_CODE_SUCCESS = SETTING.getInt("CHECKIN_JSON_CODE_SUCCESS");
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
    private static String sendMail(String message) {
        return MailUtil.send(EMAIL_RECIPIENT, EMAIL_TITLE, message, false);
    }

    public static String sendMailAfterCheckin() {
        String body = UnicodeUtil.toString(checkinSuWaYun().body());
        StringBuilder message = new StringBuilder();
        JSONObject jsonObject = JSONUtil.parseObj(body);
        Integer anInt = jsonObject.getInt(CHECKIN_JSON_CODE_KEY);
        if (anInt != null && (anInt.equals(CHECKIN_JSON_CODE_SUCCESS) || anInt.equals(CHECKIN_JSON_CODE_REPEAT)) ) {
            message.append("签到成功\n").append(jsonObject.getStr("message")).append("\n");
        }
        message.append(body).append("\n");
        return sendMail(message.toString());
    }
}