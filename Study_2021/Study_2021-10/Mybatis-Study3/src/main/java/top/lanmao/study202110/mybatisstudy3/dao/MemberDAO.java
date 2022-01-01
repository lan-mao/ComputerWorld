package top.lanmao.study202110.mybatisstudy3.dao;

import top.lanmao.study202110.mybatisstudy3.pojo.Member;

import java.util.List;

/**
 * Create Date 2021/11/09 10:43:51 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public interface MemberDAO {

    List<Member> listMemberByNick(String keyWord);

    Member getMemberById(Long id);

}