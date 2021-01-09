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

我使用的是[Obsidian](https://github.com/TriDiamond/hexo-theme-obsidian) 主题

## 加速你的博客

### 加速不经常改动的资源

如何加速，为了解决这个问题，我尝试了很多的解决方案，比如将博客放到到Coding上，但是发现Coding的IP在香港，在我这里访问更慢；另一个设置CDN加速，我尝试了七牛云和腾讯云两个平台，但不知道因为什么，并没有改善很多。

后来我发现如果部署到码云平台，它的page页面访问速度很快，但是码云的普通用户不能自定义域名，而且不会自动部署，上传之后必须手动部署才行。但另一方面，Github Pages可以自定义域名，并且还是很多个，支持自动部署。并且我发现，码云仓库的资源是可以直接访问的，而一些静态资源也不需要频繁更改，可以使用手工代替。更重要的是：放在码云上的文件不需要花钱。

### 把图片放在云上

图片就不能放在码云了，否则每次新写文章的时候就要手动部署一次，麻烦得很。不过使用VSCode的插件功能就可以自动上传图片到云端的资源库中。并且可以自动生成链接。用过Typora来写MD文章，虽然他的实时渲染功能十分炫酷，但是在Windows平台上不能用插件，使得我还是选择了VSCode。

腾讯云图片自动上传插件：[tencent-cloud-cos-upload-image - Visual Studio Marketplace](https://marketplace.visualstudio.com/items?itemName=galenye.tencent-cloud-cos-upload-image)，可以使用快捷键上传剪贴板上的图片和本地文件。

阿里云图床的插件：[aliyun oss upload image - Visual Studio Marketplace](https://marketplace.visualstudio.com/items?itemName=vvkee.aliyun-oss-upload-image)

七牛云图床的自动上传插件：[qiniu-upload-image - Visual Studio Marketplace](https://marketplace.visualstudio.com/items?itemName=imys.qiniu-upload-image)

> 附一个插件：自动将剪贴板中的链接生成链接标签，并且标题是连接的标题，省好多事情：[Paste URL - Visual Studio Marketplace](https://marketplace.visualstudio.com/items?itemName=kukushi.pasteurl)
 
--- 

## 2021-01-08更新

2020年真的是极其魔幻的一年，我自己在这一年里面可以说是一事无成。不过都过去了，都过去了。

2021年开年的这几天，我将自己的博客合并到了我的一个算是记录我学习编程的全过程的项目 [ComputerWorld](https://github.com/lan-mao/ComputerWorld/) 中，并且将全部的源代码都放在了这个项目的Github仓库和Gitee仓库中，写作的工具也转移到了IDEA中。

在转移的时候遇到的比较大的难题有两个：Git更新并发布博客源代码和将博客使用CDN加速 

### 更新主题并将源代码保存至新仓库

一开始的想法是将主题的代码与作者的代码进行本地的比较，然后将主题文件夹中的文件全部上传至Github中，但是上传之后发现上传的并不是真正的代码，而是一个仓库地址和对应的版本号，代码本身并不在这个仓库中。后来经过查询发现原来这是Git的功能：`子模块`，是专门用来加载其他远程仓库的代码的。但是这个功能并不能解决我的问题：我想将代码发布到同一个仓库中，但同时也能保留主题本身在原仓库中的分支进度，这需要我将.git文件夹一并添加到git仓库中，但这样仓库就会变得比较大，也不符合精简的原则。因此在摸索了一段时间的子模块功能后，我放弃了这种方式。

我最终采取的方式是：
1. 将主题文件夹删除git仓库
   
2. 将原作者的主题仓库作为[ComputerWorld](https://github.com/lan-mao/ComputerWorld/) 项目的子模块，加载到博客的themes文件夹下面，并保持与最新的主题文件同步
   
3. 通过IDEA的文件对比功能比较两个文件夹中的差异，并且修改需要修改的内容（偷偷插一句：IDEA的对比功能是真的很强大）

通过这样折中的方式，我保持了主题代码可以与作者的代码同步更新，同时也将主题的源代码保存到了仓库中，而仓库也并没有变得太大。算是完美؏؏☝ᖗ乛◡乛ᖘ☝؏؏

### 使用CDN加速博客

由于以前并没有什么加速的实际操作，所以一开始算是一窍不通的。中间走了很多岔路，并且网上有关CDN+Hexo的博文写的很多都含糊不清，所以这个事情我专门写了新的博客，来记录我遇到的坑。

博客的传送门在这里 :point_right: [使用腾讯云CDN加速HEXO博客](https://blog.lan-mao.top/2021/01/08/%E4%BD%BF%E7%94%A8%E8%85%BE%E8%AE%AF%E4%BA%91CDN%E5%8A%A0%E9%80%9FHEXO%E5%8D%9A%E5%AE%A2/)