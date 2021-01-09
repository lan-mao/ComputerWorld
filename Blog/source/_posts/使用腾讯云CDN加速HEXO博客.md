---
title: 使用腾讯云CDN加速HEXO博客

date: 2021-01-08 22:35:27

tags:
    - HEXO
    - 博客
    - CDN

categories:
    - 1/0世界
    - HEXO

---

其实就像如何把大象装进冰箱里一样——（把冰箱门打开，把大象装进去，把冰箱门关上），使用CDN加速博客也简单的分为：部署博客，打开CDN，用CDN加速博客。（逃~~）

咳咳，扯远了。这里讲了如何使用腾讯云CDN加速我的HEXO博客，其他的CDN服务也大同小异，基本都可以参考。

## 配置Github Pages服务

首先我们需要有一个HEXO博客，并且已经将它上传到了Github的仓库中，然后在仓库的Settings选项卡中，找到Github Pages选项。这里由于我的仓库名是：`lan-mao.github.io`这种格式的，所以可以直接使用这个三级域名访问。并且默认开启了HTTPS服务，这里需要注意，如果使用的是七牛云的免费CDN服务是无法加速HTTPS协议的。当然如果有自己域名的也可以直接使用自定义，或者在CNAME文件中修改，不过要注意的是，一个仓库只支持一个域名。使用自定义的域名可以不使用HTTPS协议。

重点需要注意的是，如果自定义域名，自定义的域名需要在域名的DNS解析服务上添加到Github Pages的解析。并且这个域名不能与你要加速的域名相同，否则会出现循环重定向的问题。

![Github Pages选项](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/26816496654600.png)

## 配置CDN服务
首先需要拥有一个经过备案的域名，这里我使用的是我自己的域名：[blog.lan-mao.top](https://blog.lan-mao.top)

然后开通腾讯云的CDN服务，由于我开通的CDN服务比较早，当时有每月免费的10GB流量数据的优惠，现在已经没了。虽然只有10GB，但是由于我另外的腾讯云对象存储COS也开通的比较早，所以有50GB的免费存储容量。这样我就可以将文章中的图片放到COS中，并且不通过CDN加速。同时我还将大部分的静态资源放到了码云的仓库中，尽管码云的仓库不支持Push后自动更新Page页面，但是使用静态页面来提供一些静态资源还是可以的。（我可真是个小机灵鬼ヽ(ﾟ∀ﾟ*)ﾉ━━━ｩ♪ ）

在CDN服务中添加域名。如图所示。

![腾讯云CDN添加域名](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/26849150159900.png)

- 业务类型：是博客所以选择静态加速
- 源站配置：
- 源站类型：我们使用的是Github的服务器，所以选`自有源`
- 回源协议：看你有没有开通Github Pages的HTTPS协议了
- 源站地址：源站地址代表的是你可以通过这个地址访问到资源，要注意源站地址不是上面填写的加速域名
- 回源域名：访问源站时用哪个域名，由于我们配置的是Github Pages，仅仅支持一个域名访问。所以只能用对应的那个域名才能不报`404`

配置好以后大部分的东西默认就行了，其他的选项可以看文档自己鼓捣了。CDN会给一个CDN的域名，是需要将你加速的域名映射到这个CDN域名上的。

## 在域名的DNS解析服务中添加到CDN的解析

我用的域名是阿里云的，具体配置如图：

![阿里云添加DNS解析](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/27632539945900.png)

需要添加的是一个CNAME记录，值为刚刚给的CDN域名。

### 配置HTTPS服务

如果上面的步骤都做完了，同时也能访问，但是浏览器提示连接不安全。这是因为没有配置域名对应的HTTPS证书，默认的是一个腾讯云的通用证书。我们需要将HTTPS证书部署到CDN中去。

1. 首先需要购买一个SSL证书，我这里使用的是阿里云提供的一个一年免费的SSL证书：  
    ![阿里云证书申请](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/28000177737400.png)
   
2. 申请过程按照提示的步骤进行即可，申请成功后，下载其中的Nginx版本的证书：  
    ![证书下载](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/28063441854200.png)
   
3. 添加证书的公钥和私钥到CDN的HTTPS配置中：  
    ![证书添加](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/28207841305500.png)

4. 保存后等待一会就好了。  