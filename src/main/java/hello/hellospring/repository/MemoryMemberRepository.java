package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
       member.setId(++sequence);
       store.put(member.getId(), member);
       return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null이어도 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // 람다표현식
                .filter(member -> member.getName().equals(name))
                .findAny(); // 하나라도 찾으면 반환, 없으면 optional로 null 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // member 반환
    }

    public void clearStore(){
        store.clear();
    }
}
