package student.dao;

import student.entity.Member;

import java.util.List;

public interface MemberDao {
    Member loginMember(String name,String pwd);
    List<Member> selectMember(String keyword);
    void registerMember(Member member);
}
