package top.lan_mao.computer_world.snake;

import javax.swing.*;
import java.net.URL;
import java.util.Objects;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/01/14 11:23:41 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * 存储图片的数据<br>
 */
public class Data {

    /**
     * 头部图片的地址和图片
     */
    public static URL headerURL = Data.class.getResource("/static/header.png");
    public static ImageIcon header = new ImageIcon(Objects.requireNonNull(headerURL));

    /**
     * 头部
     */
    public static URL upURL = Data.class.getResource("/static/up.png");
    public static URL downURL = Data.class.getResource("/static/down.png");
    public static URL leftURL = Data.class.getResource("/static/left.png");
    public static URL rightURL = Data.class.getResource("/static/right.png");
    public static ImageIcon up = new ImageIcon(Objects.requireNonNull(upURL));
    public static ImageIcon down = new ImageIcon(Objects.requireNonNull(downURL));
    public static ImageIcon left = new ImageIcon(Objects.requireNonNull(leftURL));
    public static ImageIcon right = new ImageIcon(Objects.requireNonNull(rightURL));
    public static int headHeight = up.getIconHeight();
    public static int headWidth = right.getIconWidth();
    /**
     * 身体
     */
    public static URL bodyURL = Data.class.getResource("/static/body.png");
    public static ImageIcon body = new ImageIcon(Objects.requireNonNull(bodyURL));
    /**
     * 食物
     */
    public static URL foodURL = Data.class.getResource("/static/food.png");
    public static ImageIcon food = new ImageIcon(Objects.requireNonNull(foodURL));

}