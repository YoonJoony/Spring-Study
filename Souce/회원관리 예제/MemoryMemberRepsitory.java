//회원 리포지토리 메모리 구현체

package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

//구현체
public class MemoryMemberRepository implements MemberRepository{

    //save할 때 메모리를 저장을 할 때
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    //회원이 Long, 값은 Member

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //member id값 셋팅
        store.put(member.getId(), member); //
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) { //id 찾기
        return Optional.ofNullable(store.get(id));
        //store에서 save에 입력받은 id를 꺼낸다.
        //그냥 store.get(id)로 반환해도 되지만 Optional로 반환 타입이 명시되어 있고
        //꺼낸 id가 널 값일 수 있으므로 요즘에는 널 값을 꺼낼 시 Optional로 감싸서 꺼낸다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //String으로 넘어온 name이 member에 저장된 name과 같은지 확인
                .findAny(); //map에서 하나 찾으면 바로 반환
                            //없으면 Optional에 널이 감싸져서 반환
    }

    @Override
    public List<Member> findAll() {  //자바 실무할 떄는 List 많이 쓴다
        return new ArrayList<>(store.values()); //store의 member 전부 반환
    }
}
