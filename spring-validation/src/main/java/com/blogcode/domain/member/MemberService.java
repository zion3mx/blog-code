package com.blogcode.domain.member;

import com.blogcode.domain.member.dto.MemberRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jojoldu@gmail.com on 2017. 2. 20.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long save(MemberRequestDto memberRequestDto){
        Long id;
        if(memberRequestDto.getId() == null){
            id = memberRepository.save(memberRequestDto.toEntity()).getId();
        }else{
            Member origin = memberRepository.findOne(memberRequestDto.getId());
            origin.update(memberRequestDto.getName(), memberRequestDto.getJob());
            id = origin.getId();
        }

        return id;
    }






}
