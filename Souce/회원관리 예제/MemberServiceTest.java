//회원 서비스 
package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class MemberServiceTest {

//    MemberService memberService = new MemberService();
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }//??

    @AfterEach
    public void aftereach() {
        memberRepository.clear();
    }

    @Test
    void 회원가입() { //테스트는 과감하게 한글로 바꿔도 됨
        //given 뭔가 주어 졌을 때
        Member member = new Member();
        member.setName("Hello"); //객체 생성 후 Hello 이름 지정



        //when 이거를 실행 했을 때
        Long saveId = memberService.join(member); //생성한 member객체의 id 반환받음
        //여기서 MemberService 클래스의 join 메소드로 member의 name이 중복되는지 검사
        //검사 후 저장

        //then 결과가 이게 나와야 한다
        Member findMember = memberService.findOne(saveId).get(); //키 값이 saveId인 객체 반환받음
        assertThat(member.getName()).isEqualTo(findMember.getName()); //반환받은 findMember 객체와 선언한 member객체의 name이 같은지 검사
    }

    @Test
    public void 중복_회원_예외() { //중복되는 회원이 있는지 가정.
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring"); //member1과 2의 name이 중복되어 예외가 발생됨

        //when
        memberService.join(member1); //member1을 등록한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //assertThrows(X.class, Executable executable) : 첫 인자로 발생될 예외 클래스의 class 타입을 받은 후 executable에서 발생된 예외와 같은지 비교한다.
        //e에 assertThrows로 반환된 예외를 받는다
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); //e의 예외 메세지가 다음과 같은지 검사한다.

/*        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); //e의 예외 메세지와 예외 메세지가 같은지 확인.
        }*/

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
