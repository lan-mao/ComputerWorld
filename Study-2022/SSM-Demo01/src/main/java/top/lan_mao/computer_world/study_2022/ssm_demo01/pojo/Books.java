package top.lan_mao.computer_world.study_2022.ssm_demo01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * Copyright (c) 2019-present lan-mao.top
 * ComputerWorld is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 * <p>
 * Create Date 2022/01/22 21:39:57 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0 <br>
 * <br>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Books implements Serializable {
    @Serial
    private static final long serialVersionUID = 9031102280682651352L;
    private Long bookId;
    private String bookName;
    private Integer bookCount;
    private String bookDetail;
}