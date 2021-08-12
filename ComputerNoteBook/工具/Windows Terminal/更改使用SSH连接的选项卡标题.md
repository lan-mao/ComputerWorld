---
title: 更改使用SSH连接的选项卡标题
date: 2021-07-30 16:47:37
tags:
  - Linux
  - SSH
  - Windows
  - Terminal
alias: 
category: 
stars: 
from: https://docs.microsoft.com/zh-cn/windows/terminal/tutorials/tab-title
url: 
---
# 更改使用SSH连接的选项卡标题

## 问题描述

在使用Widnwos Terminal通过SSH连接远端服务器时，选项卡的标题一直显示为：`Open SSH Client`，无法辨别，即便在选项卡设置中设定了选项卡标题。

## 解决方法

设置中对应的选项卡配置 -- 高级，打开`禁止更改标题`选项。

## 问题原因


> 本文由 [简悦 SimpRead](http://ksria.com/simpread/) 转码， 原文地址 [docs.microsoft.com](https://docs.microsoft.com/zh-cn/windows/terminal/tutorials/tab-title)

> 本教程介绍如何在 Windows 终端中设置选项卡标题。

### 本文内容

1.  [使用 tabTitle 设置](#use-the-tabtitle-setting)
2.  [设置 shell 的标题](#set-the-shells-title)
3.  [使用 suppressApplicationTitle 设置](#use-the-suppressapplicationtitle-setting)
4.  [资源](#resources)

默认情况下，选项卡标题设置为 shell 的标题。 如果选项卡由多个窗格组成，则会将该选项卡的标题设置为当前焦点窗格的标题。 如果要对设置为选项卡标题的内容进行自定义，请按照本教程的说明操作。

在本教程中，你将了解如何执行以下操作：

*   使用 `tabTitle` 设置
*   设置 shell 的标题
*   使用 `suppressApplicationTitle` 设置

### [](#use-the-tabtitle-setting)使用 `tabTitle` 设置


`tabTitle` 设置允许定义 shell 的新实例的起始标题。 如果未设置，则改为使用配置文件 `name`。 每个 shell 以不同的方式响应此设置。

<table><caption>使用 tabTitle 设置</caption><thead><tr><th>Shell</th><th>行为</th></tr></thead><tbody><tr><td>PowerShell</td><td>标题已设置。</td></tr><tr><td>命令提示符</td><td>标题已设置。 如果命令正在运行，它将暂时追加到标题的末尾。</td></tr><tr><td>Ubuntu</td><td>标题会被忽略，但设置为 <code>user@machine:path</code></td></tr><tr><td>Debian</td><td>标题已设置。</td></tr></tbody></table>

备注

尽管 Ubuntu 和 Debian 都运行 bash，但它们具有不同的行为。 这是为了表明不同的分发可能具有不同的行为。

### [](#set-the-shells-title)设置 shell 的标题

Shell 可以完全控制自己的标题。 但是，每个 shell 以不同的方式设置其标题。

<table><caption>设置 shell 的标题</caption><thead><tr><th>Shell</th><th>命令</th></tr></thead><tbody><tr><td>PowerShell</td><td><code>$Host.UI.RawUI.WindowTitle = "New Title"</code></td></tr><tr><td>命令提示符</td><td><code>TITLE "New Title"</code></td></tr><tr><td>bash*</td><td><code>echo -ne "\033]0;New Title\a"</code></td></tr></tbody></table>

请注意，在与 shell 交互时，某些 Linux 分发版（即 Ubuntu）会自动设置其标题。 如果上面的命令不起作用，请运行以下命令：

```
PS1=$
PROMPT_COMMAND=
echo -ne "\033]0;New Title\a"
```

这会将标题更改为 “新标题”，同时将提示符设置为 “$”。

### [](#use-the-suppressapplicationtitle-setting)使用 `suppressApplicationTitle` 设置


由于 shell 可以控制其标题，因此它可以随时选择覆盖选项卡标题。 例如，PowerShell 的 `posh-git` 模块将有关 Git 存储库的信息添加到标题中。

Windows 终端允许在配置文件中将 `suppressApplicationTitle` 设置为 `true` 来禁止对标题进行更改。 这会使配置文件的新实例将可见标题设置为 `tabTitle`。 如果未设置 `tabTitle`，则会将可见标题设置为配置文件的 `name`。

请注意，这会将 shell 的标题与选项卡上显示的可见标题分离开来。如果在设置了标题的位置读取 shell 的变量，则它可能与选项卡的标题不同。

### [](#resources)资源

*   [将控制台标题设置为当前工作目录](https://devblogs.microsoft.com/powershell/setting-the-console-title-to-be-your-current-working-directory/)
*   [更改 Ubuntu 16.04 上终端的标题](https://www.zachpfeffer.com/single-post/Change-the-title-of-a-terminal-on-Ubuntu-1604)