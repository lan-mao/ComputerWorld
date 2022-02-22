package top.lanmao.scriptplatform.localip;

import com.aliyun.alidns20150109.Client;
import com.aliyun.alidns20150109.models.DescribeDomainRecordsRequest;
import com.aliyun.alidns20150109.models.DescribeDomainRecordsResponse;
import com.aliyun.teaopenapi.models.Config;
import top.lanmao.scriptplatform.LauncherService;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Create Date 2022/01/17 11:5:0 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * <br>
 */
public class LauncherLocalIpImpl implements LauncherService {

    private String accessKeyId, accessKeySecret;
    private String domainName, RRKeyWord;

    @Override
    public void launch(String... param) throws Exception {
        accessKeyId = param[1];
        accessKeySecret = param[2];
        domainName = param[3];
        RRKeyWord = param[4];
        Client client = createClient();
        DescribeDomainRecordsRequest describeDomainRecordsRequest = new DescribeDomainRecordsRequest()
                .setDomainName(domainName)
                .setRRKeyWord(RRKeyWord);
        // 复制代码运行请自行打印 API 的返回值
        DescribeDomainRecordsResponse describeDomainRecordsResponse = client.describeDomainRecords(describeDomainRecordsRequest);
        String recordId = describeDomainRecordsResponse.body.domainRecords.record.get(0).recordId;

    }

    /**
     * 使用AK&SK初始化账号Client
     *
     * @return Client
     */
    public Client createClient() throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "alidns.cn-hangzhou.aliyuncs.com";
        return new Client(config);
    }

    public String getLocalAddress() {
        return null;
    }

    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress:" + addr.getHostAddress());
        String hostname = addr.getHostName();
        System.out.println("Local host name: " + hostname);
    }

}

//class Sample {
//
//    /**
//     * Initialization  初始化公共请求参数
//     */
//    public static com.aliyun.alidns20150109.Client Initialization(String regionId) throws Exception {
//        Config config = new Config();
//        // 您的AccessKey ID
//        config.accessKeyId = com.aliyun.darabonba.env.EnvClient.getEnv("ACCESS_KEY_ID");
//        // 您的AccessKey Secret
//        config.accessKeySecret = com.aliyun.darabonba.env.EnvClient.getEnv("ACCESS_KEY_SECRET");
//        // 您的可用区ID
//        config.regionId = regionId;
//        return new com.aliyun.alidns20150109.Client(config);
//    }
//
//    /**
//     * 获取主域名的所有解析记录列表
//     */
//    public static DescribeDomainRecordsResponse DescribeDomainRecords(com.aliyun.alidns20150109.Client client, String domainName, String RR, String recordType) throws Exception {
//        DescribeDomainRecordsRequest req = new DescribeDomainRecordsRequest();
//        // 主域名
//        req.domainName = domainName;
//        // 主机记录
//        req.RRKeyWord = RR;
//        // 解析记录类型
//        req.type = recordType;
//        try {
//            DescribeDomainRecordsResponse resp = client.describeDomainRecords(req);
//            com.aliyun.teaconsole.Client.log("-------------------获取主域名的所有解析记录列表--------------------");
//            com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(TeaModel.buildMap(resp)));
//            return resp;
//        } catch (TeaException error) {
//            com.aliyun.teaconsole.Client.log(error.message);
//        } catch (Exception _error) {
//            TeaException error = new TeaException(_error.getMessage(), _error);
//            com.aliyun.teaconsole.Client.log(error.message);
//        }
//        return null;
//    }
//
//    /**
//     * 修改解析记录
//     */
//    public static void UpdateDomainRecord(com.aliyun.alidns20150109.Client client, UpdateDomainRecordRequest req) throws Exception {
//        try {
//            UpdateDomainRecordResponse resp = client.updateDomainRecord(req);
//            com.aliyun.teaconsole.Client.log("-------------------修改解析记录--------------------");
//            com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(TeaModel.buildMap(resp)));
//        } catch (TeaException error) {
//            com.aliyun.teaconsole.Client.log(error.message);
//        } catch (Exception _error) {
//            TeaException error = new TeaException(_error.getMessage(), _error);
//            com.aliyun.teaconsole.Client.log(error.message);
//        }
//    }
//
//    public static void main(String[] args_) throws Exception {
//        java.util.List<String> args = java.util.Arrays.asList(args_);
//        String regionid = args.get(0);
//        String currentHostIP = args.get(1);
//        String domainName = args.get(2);
//        String RR = args.get(3);
//        String recordType = args.get(4);
//        com.aliyun.alidns20150109.Client client = Sample.Initialization(regionid);
//        DescribeDomainRecordsResponse resp = Sample.DescribeDomainRecords(client, domainName, RR, recordType);
//        if (com.aliyun.teautil.Common.isUnset(TeaModel.buildMap(resp)) || com.aliyun.teautil.Common.isUnset(TeaModel.buildMap(resp.body.domainRecords.record.get(0)))) {
//            com.aliyun.teaconsole.Client.log("错误参数！");
//            return ;
//        }
//
//        DescribeDomainRecordsResponseBody.DescribeDomainRecordsResponseBodyDomainRecordsRecord record = resp.body.domainRecords.record.get(0);
//        // 记录ID
//        String recordId = record.recordId;
//        // 记录值
//        String recordsValue = record.value;
//        com.aliyun.teaconsole.Client.log("-------------------当前主机公网IP为：" + currentHostIP + "--------------------");
//        if (!com.aliyun.teautil.Common.equalString(currentHostIP, recordsValue)) {
//            // 修改解析记录
//            UpdateDomainRecordRequest req = new UpdateDomainRecordRequest();
//            // 主机记录
//            req.RR = RR;
//            // 记录ID
//            req.recordId = recordId;
//            // 将主机记录值改为当前主机IP
//            req.value = currentHostIP;
//            // 解析记录类型
//            req.type = recordType;
//            Sample.UpdateDomainRecord(client, req);
//        }
//
//    }
//}