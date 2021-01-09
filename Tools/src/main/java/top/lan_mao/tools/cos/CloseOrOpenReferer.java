package top.lan_mao.tools.cos;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.demo.GeneratePresignedUrlDemo;
import com.qcloud.cos.endpoint.EndpointBuilder;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.utils.DateUtils;
import org.apache.commons.codec.digest.HmacUtils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;
import java.util.List;


/**
 * Create Date 2021/01/07 9:27:38 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 打开或者关闭防盗链设置 <br>
 */
public class CloseOrOpenReferer {
    public static void main(String[] args) {

        //language=JSON
        String demo = "{\n" +
                "  \"q-sign-algorithm\": \"sha1\",\n" +
                "  \"q-ak\": \"AKIDZfbOAo7cllgPvF9cXFrJD0a1ICvR****\",\n" +
                "  \"q-sign-time\": \"1547105134;32526689134\",\n" +
                "  \"q-key-time\": \"1547105134;32620001134\",\n" +
                "  \"q-header-list\": \"content-md5;content-type;host\",\n" +
                "  \"q-url-param-list\": \"referer\",\n" +
                "  \"q-signature\": \"0f7fef5b1d2180deaf6f92fa2ee0cf87ae83f****\"\n" +
                "}";
        String secretId = "AKIDwf8uVr9B2e2BWNtNXQ6f1A8tTnrrmkQq";
        String secretKey = "JTbtfBSg3A9tNehdMtACyTmstjQs7Hjy";
        String bucketName = "blog-1258302212";
        String putContent = "<RefererConfiguration>\n" +
                "    <Status>Enabled</Status>\n" +
                "    <RefererType>White-List</RefererType>\n" +
                "    <DomainList>\n" +
                "        <Domain>blog.lan-mao.top</Domain>\n" +
                "    </DomainList>\n" +
                "    <EmptyReferConfiguration>Deny</EmptyReferConfiguration>\n" +
                "</RefererConfiguration>";
        String contentMD5 = "7402303607e12c676342d5e5e50c46fd";
        String authorization = "";

        String keyTime = System.currentTimeMillis() + ";" +
                (System.currentTimeMillis() + 24 * 3600 * 1000);

        String signKey = HmacUtils.hmacSha1Hex(secretKey, keyTime);

        String urlParamList = "content-md5;content-type;host";


        HttpRequest.put("blog-1258302212.cos.ap-nanjing.myqcloud.com")
                .header("Host", "blog-1258302212.cos.ap-nanjing.myqcloud.com")
                .header("Content-Type", "application/xml")
                .header("Content-MD5", contentMD5)
                .header("Content-Length", putContent.getBytes().length + "")
                .header("Authorization", authorization)
                .body(putContent);




    }


    public static String generateAuthorization (String secretKey, String secretId) {
        String keyTime = System.currentTimeMillis() + ";" + (System.currentTimeMillis() + 24 * 3600 * 1000);

        String signKey = HmacUtils.hmacSha1Hex(secretKey, keyTime);

        String UrlParamList = "referer";

        String hearderList = "content-md5;content-type;host";
        String Signature;
        return null;
    }
}

