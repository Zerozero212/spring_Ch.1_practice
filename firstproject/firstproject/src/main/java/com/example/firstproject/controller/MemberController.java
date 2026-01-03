package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class MemberController {
  @Autowired
  private MemberRepository memberRepository;

  @GetMapping("/members")
  public String memberHomePage() {return "members/members";}

  @GetMapping("/signup")
  public String signUpPage() {return "members/signup";}

  @PostMapping("/join")
  public String memberJoin(MemberForm form) {
    log.info(form.toString());

    // DTO -> Entity
    Member member = form.toEntity();
    log.info(member.toString());

    // Entity -> Repository
    Member saved = memberRepository.save(member);
    log.info(saved.toString());

    return "redirect:/members/" + saved.getId();
  }

  @GetMapping("/members/{id}")
  public String show(@PathVariable Long id, Model model) {
    log.info("id : " + id);
    Member memberEntity = memberRepository.findById(id).orElse(null);
    model.addAttribute("member",memberEntity);
    return "members/show";
  }

  @GetMapping("/membersList")
  public String index(Model model) {
    List<Member> memberEntityList = memberRepository.findAll();
    model.addAttribute("memberList",memberEntityList);
    return "members/index";
  }

  @GetMapping("/members/{id}/edit")
  public String edit(@PathVariable Long id, Model model) {
    Member memberEntity = memberRepository.findById(id).orElse(null);
    model.addAttribute("member",memberEntity);
    return "members/edit";
  }

  @PostMapping("/members/update")
  public String update(MemberForm form) {
    log.info(form.toString());
    Member memberEntity = form.toEntity();
    Member target = memberRepository.findById(memberEntity.getId()).orElse(null);
    if (target != null) {
      memberRepository.save(memberEntity);
    }
    return "redirect:/members/" + memberEntity.getId();
  }
}
