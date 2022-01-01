package top.lanmao.study202110.mybatisstudy3.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import top.lanmao.study202110.mybatisstudy3.pojo.Member;
import top.lanmao.study202110.mybatisstudy3.util.MybatisUtils;

class MemberDAOTest {

    @org.junit.jupiter.api.Test
    void testListMemberByNick() {
        SqlSessionFactory factory = MybatisUtils.getSqlSessionFactory();
        SqlSession sqlSession1 = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();
        MemberDAO memberDao1 = sqlSession1.getMapper(MemberDAO.class);
        Member member1 = memberDao1.getMemberById(1L);
        sqlSession1.close();
        //sqlSession1.commit();
        System.out.println(member1);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        MemberDAO memberDao2 = sqlSession2.getMapper(MemberDAO.class);
        Member member2 = memberDao2.getMemberById(1L);
        sqlSession2.commit();
        System.out.println(member2);

        System.out.println(member1 == member2);
    }
}