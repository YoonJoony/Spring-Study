package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.PrepareTestInstance;

import java.util.List;
import java.util.Optional;

class MemoryMemberRepositoryTest { //다른 곳에서 갖다 쓸게 아니니 public으로 지정 안해도 된다.
    MemberRepository repository = new MemoryMemberRepository(); //왜 MemberRepository?

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get(); //member에 설정된 id(키) 값인 객체를 store에 찾아서 반환됨
                                                                   //따라서 result = member가 됨
        //System.out.println("result = " + (result == member)); //result와 member가 같다면 true
        //Assertions.assertEquals(member, result); //assertEquals : (x, y) 두 객체의 값이 같은 지 여부
                                                 //다르면 오류가 실행 됨

        Ass
    }
}
