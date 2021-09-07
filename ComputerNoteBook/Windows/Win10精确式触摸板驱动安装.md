---
title: Win10精确式触摸板驱动安装
date: 2021-09-07 08:26
tags:
  - null
aliases: null
category: null
description: null
from: null
modified: 2021-09-07 08:29

---

# Win10精确式触摸板驱动安装（失败）

## 硬件需求

ELAN或Synaptics品牌

## 驱动下载

Microsoft的驱动程序库链接： <https://www.catalog.update.microsoft.com/Search.aspx?q=elan%20wdf>

选择 Elan - Other hardware - ELAN Input Device For WDF 或 ELAN - Mouse 都可以，尽量选最新的版本，下载完成后解压

## 驱动安装

设备管理器 -> 鼠标和其他指针设备 -> ELAN Input Device for WDF -> 右键更新驱动程序 -> 浏览我的计算机以查找驱动程序软件 -> 让我从计算机上的可用驱动程序列表中选取 -> 从磁盘安装 -> 选择驱动解压后的文件夹 -> 选择 ETD.inf -> 确定 -> 若弹出警告继续确定 -> 安装完成后重启 -> 打开设置中触摸板，已支持精确式触摸板

## 参考资料

- <https://blog.csdn.net/ccgcccccc/article/details/89044621>
