package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanBites.urbanBites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  
}
