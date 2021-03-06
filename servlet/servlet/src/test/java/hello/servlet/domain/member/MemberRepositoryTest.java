package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();

    }

    @Test
    void save() {
        //given
        Member member = new Member("park", 20);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Assertions.assertThat(memberRepository.findById(savedMember.getId())).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 25);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> memberList = memberRepository.findAll();

        //then
        Assertions.assertThat(memberList.size()).isEqualTo(2);
        Assertions.assertThat(memberList).contains(member1, member2);
    }
}
