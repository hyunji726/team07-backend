package com.team7.rabbit.repository;

import com.team7.rabbit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 여기에 아무것도 안 적어도 됩니다! 스프링이 알아서 다 만들어 줍니다.
}