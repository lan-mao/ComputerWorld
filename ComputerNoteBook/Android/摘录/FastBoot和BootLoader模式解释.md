---
title: FastBoot和BootLoader模式解释
date: 2021-07-10 18:29:41
tags:
  - 
alias: 
category: 
stars: 
from: https://www.cnanzhi.com/artdetail/universal_1575_17/
url: 
---
理论上，所有的Android设备都存在着Fastboot/Bootloader模式，不过，由于Android操作系统的开源特性，各厂商的对 自家的相关Android设备都有着各自不同的Fastboot/Bootlader模式。当然，并非所有的厂商的都会对旗下设备的Fastboot /Bootloader模式进行锁定。然而，大多数情况下，它们的Fastboot/Bootloader模式是锁定的。但是，值得称道的是，现在越来越多的厂商已渐渐向开发的Fastboot/Bootloader模式过渡，如HTC（HTC官方旗舰店）、Sony Ericsson（索尼爱立信官方旗舰店）等。因为它们虽然仍对新发布的设备锁了Fastboot/Bootloader模式，但它们已于官方发布了解锁旗下设备的Fastboot/Bootloader模式的教程与相关应用或工具。  
  
**那么，Fastboot/Bootloader模式是什么呢？**  
  
从字面上来说，Fastboot/Bootloader是代码，其为引导程序的含义。它在任何的操作系统开始运行之前执行。Fastboot /Bootloader的概念是普遍性的，实际上，它适用于包括PC（Personal Computer）即个人电脑、轻便性电脑、智能手机、平板电脑或其他相关设备的所有的操作系统。Fastboot/Bootloader基本的作用为加 载操作系统的内核与大多数的调试或修改环境模式。在你的设备中，Bootloader引导程序在任何的应用程序启动之前启动。它是一个特别的单元，每一个 主板上都有着各自的Bootloader。对于众多的Android设备而言，它们的处理硬件有着很大的不同，由于Android的开源，各厂商都开发着 各自的Bootloader引导程序，因此它们各自有着不同的第三方自定义的系统Rom固件。这一点，在Apple的iOS设备上不曾见到，因为统一的硬件与软件  
  
**接着，我们来看看的Bootloader**  
  
每一个Android设备有着一个Fastboot/Bootloader模式，它们引导着操作系统的核心的正常启动。但是，我们需要知道的 是，Android操作系统是一个开源的平台，它们的硬件平台有很大的不同，对于硬件运行环境上，每一个制造厂商有着它们自己的 Fastboot/Bootloader模式。 比如，Motorola（摩托罗拉官方旗舰店）在旗下Android设备中加载着“eFuse”的指令，当你并没有进行过任何的解锁Fastboot/Bootloader模式而试图升级或安装或更新一个自定义的系统Rom固件时，它可能会损坏你的Motorola Android设备  
  
**然而，为什么Bootloader有锁呢？**  
  
关于这个问题，其实是很好理解的，尽管Android操作系统是一个开源的平台，但每一个制造厂商都想有着绝对的控制权，为了与其他厂商有着区别， 它们各自都会定制自家的用户界面、应用、引导程序等等。基于Bootloader引导程序有锁的原因，我们很大部分不可能可以直接的升级或安装或更新一个 自定义的系统Rom固件，因为设备不能引导。这是需要相当注意的，否则极易损坏设备。  
  
想必，为什么要解锁Fastboot/Bootloader模式？这个疑问，已很简单了吧。你想ROOT你的设备，你想要一个自定义的系统Rom固件，你想要一个更加好用的第三方ROM固件等等。这些首先要有一个可以随意引导的程序，即自由的或称之为无锁的Fastboot/Bootloader模式  
  
**我们需要注意的一些问题：**  
  
1、解锁Fastboot/Bootloader模式时，可能会使保修相关服务失效  
  
2、在解锁Bootloader的过程中，可能会使设备恢复到出厂设备，即会移除包括设备内置存储中的应用程序、联系人、信息等等重要资料，请先作好备份  
  
3、在解锁Bootloader的过程中，可能会损坏设备