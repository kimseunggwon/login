package hello.login.domain.login;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password) {

        /**  코드 1
         */
        /*Optional<Member> findMemberOptional = memberRepository.findByLoginId(loginId);
        Member member = findMemberOptional.get();  //optional member에서 get
        if (member.getPassword().equals(password)){
            return member;
        }else {
            return null;
        }*/

        /**  코드 2
         */
       /* Optional<Member> byLoginId = memberRepository.findByLoginId(loginId);
        byLoginId.filter(m->m.getPassword().equals(password))
                .orElse(null);*/

        /**  코드 3
         * (로그인 비즈니스 로직은 회원을 조회한 다음에 파라미터로 넘어온 password와 비교해서 같으면 회원을 반환하고, 다르면 null
         */
        return memberRepository.findByLoginId(loginId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }


}
