package hello.login.web.member;


import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Member member) {
        return "members/addMemberForm.html";
    }

    /**
     *  BindingResult = 검증 오류를 보관하는 객체
     *  @Valid = 유효성검  // errors.properties에 설정을 통해 @NotEmpty 같은 어노테이션에 메시지를 지정할 수 있다.
     */
    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult) { // BindingResult = 검증 오류를 보관하는 객체
        if (bindingResult.hasErrors()) {
            return "members/addMemberForm.html";
        }

        memberRepository.save(member);
        return "redirect:/";    // 홈 화면으로 리다이렉트
    }
}
