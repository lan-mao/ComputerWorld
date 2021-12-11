package top.lanmao.scriptplatform.suwayun;

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
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Create Date 2021/09/28 15:25:28 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 创建定时器，定时签到 <br>
 */

@Data
public class Checkin {

    private String checkinHost ;
    private String checkinPath;
    private String checkinAuthorization;
    private String checkinAuthorizationKey;
    private String emailRecipient;
    private String emailTitle;

    private Setting setting;


    private Checkin() {}

    public static Checkin init(String url){
        LogFactory.get().debug("URL：" + url);
        Checkin checkin = new Checkin();
        checkin.setting = new Setting(Objects.requireNonNullElse(url, "suwayun.setting"));
        LogFactory.get().debug("setting信息：" + checkin.setting.toString());
        checkin.checkinHost = checkin.setting.get("CHECKIN_HOST");
        checkin.checkinAuthorization = checkin.setting.get("CHECKIN_AUTHORIZATION");
        checkin.checkinPath = checkin.setting.get("CHECKIN_PATH");
        checkin.checkinAuthorizationKey = checkin.setting.get("CHECKIN_AUTHORIZATION_KEY");
        checkin.emailTitle = checkin.setting.get("EMAIL_TITLE");
        checkin.emailRecipient = checkin.setting.get("EMAIL_RECIPIENT");
        return checkin;
    }

    /**
     * 签到并返回响应信息
     * @return 响应信息
     */
    public HttpResponse checkinSuWaYun () {
        String url = UrlBuilder.create()
                .setScheme("HTTPS")
                .setHost(checkinHost)
                .setPath(new UrlPath().parse(checkinPath, null))
                .toString();
        LogFactory.get().info(url);
        return new HttpRequest(url)
                .setMethod(Method.PUT)
                .header(checkinAuthorizationKey, checkinAuthorization)
                .timeout(1000*20)
                .execute();
    }

    /**
     * 发送邮件
     * @param message 邮件内容
     * @return 邮件id
     */
    public String sendMail(String message) {
        return MailUtil.send(emailRecipient, emailTitle, message, false);
    }

    /**
     * 签到并且发送邮件
     * @return 返回邮件id
     */
    public String sendMailAfterCheckin() {
        String mailId;
        StringBuilder message = new StringBuilder();
        try {
            String body = UnicodeUtil.toString(checkinSuWaYun().body());
            message.append(body).append("\n");
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
            message.append("运行时间：").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date())).append("\n");
        }catch (Exception e) {
            message.append(e.getMessage());
        }finally {
            mailId = sendMail(message.toString());
        }
        return mailId;
    }

    private MessageBO parseJSON(String json) {
        return JSONUtil.toBean(json, MessageBO.class);
    }
}