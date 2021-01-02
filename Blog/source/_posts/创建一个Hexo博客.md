---
title: 创建一个Hexo博客
date: 2020-01-08 11:47:17
tags:
 - HEXO
 - 博客
categories:
 - 1/0世界
 - HEXO
---

## 如何创建一个Hexo博客

这个问题其实没有太大价值，因为网络上已经有很多关于此的文章，官网里的文档也写的非常清晰，本着不重复发明轮子的原则，在此不再赘述。

## 使用自定义主题

我使用的是[Obsidian](https://github.com/TriDiamond/hexo-theme-obsidian)主题，至少在我现在看来主题还是挺好看的，配色、样式挺有科技感。移动端适配的也不错，并且作者看起来也还在更新。问题就是Bug挺多，我修改了一些问题，并且将它放在了我的[Github仓库](https://github.com/lan-mao/hexo-theme-obsidian)中，并且在作者更新了版本后尽量也更新。

## 加速你的博客

### 加速不经常改动的资源

如何加速，为了解决这个问题，我尝试了很多的解决方案，比如将博客放到到Coding上，但是发现Coding的IP在香港，在我这里访问更慢；另一个设置CDN加速，我尝试了七牛云和腾讯云两个平台，但不知道因为什么，并没有改善很多。

后来我发现如果部署到码云平台，它的page页面访问速度很快，但是码云的普通用户不能自定义域名，而且不会自动部署，上传之后必须手动部署才行。但另一方面，Github Pages可以自定义域名，并且还是很多个，支持自动部署。并且我发现，码云仓库的资源是可以直接访问的，而一些静态资源也不需要频繁更改，可以使用手工代替。更重要的是：放在码云上的文件不需要花钱。

![](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200121105239_5d40b446b228b3950995bb6660d4f9c6.gif)

### 把图片放在云上

图片就不能放在码云了，否则每次新写文章的时候就要手动部署一次，麻烦得很。不过使用VSCode的插件功能就可以自动上传图片到云端的资源库中。并且可以自动生成链接。用过Typora来写MD文章，虽然他的实时渲染功能十分炫酷，但是在Windows平台上不能用插件，使得我还是选择了VSCode。

腾讯云图片自动上传插件：[tencent-cloud-cos-upload-image - Visual Studio Marketplace](https://marketplace.visualstudio.com/items?itemName=galenye.tencent-cloud-cos-upload-image)，可以使用快捷键上传剪贴板上的图片和本地文件。

阿里云图床的插件：[aliyun oss upload image - Visual Studio Marketplace](https://marketplace.visualstudio.com/items?itemName=vvkee.aliyun-oss-upload-image)

七牛云图床的自动上传插件：[qiniu-upload-image - Visual Studio Marketplace](https://marketplace.visualstudio.com/items?itemName=imys.qiniu-upload-image)

> 附一个插件：自动将剪贴板中的链接生成链接标签，并且标题是连接的标题，省好多事情：[Paste URL - Visual Studio Marketplace](https://marketplace.visualstudio.com/items?itemName=kukushi.pasteurl)