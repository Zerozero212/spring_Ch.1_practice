package com.example.firstproject.repository;

import com.example.firstproject.entity.Member;
import org.jspecify.annotations.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member,Long> {
  @Override
  @NonNull
  List<Member> findAll();
}
