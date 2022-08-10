package hello.hellospring.controller;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
  private final MemberService memberService;
  
  @Autowired //스프링에 연관된 객체를 찾아준다. @Service, @Repository가 붙어있는 객체? 
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }
}
