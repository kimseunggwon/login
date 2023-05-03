package hello.login.domain.member;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.*;
import java.util.List;

@Repository
@Slf4j
public class MemberRepository {

    private static Map<Long,Member> store = new HashMap<>();    //static 사용
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
          /* List<Member> all = findAll();
          for (Member member : all) {
              if (member.getLoginId().equals(loginId)) {
                  return member;
              }
          } */

        /**  위에 로직이랑 밑에랑 똑같다 그러나 filter를 이용해 stream으로 루프를 돌리고 하는게 더 간결
         */
        return findAll().stream()
                  .filter(member -> member.getLoginId().equals(loginId))
                  .findFirst(); // 먼저 filter 처리된것을 반환
    }


    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }


}
