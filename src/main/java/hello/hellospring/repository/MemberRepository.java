package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // 없으면 null로 반환할때 optional로 감싸서 반환(자바8 기능)
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
