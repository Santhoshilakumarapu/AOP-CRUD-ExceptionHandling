package net.java.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import net.java.entity.User;
public interface UserRepository  extends JpaRepository<User,Integer> {
    User findByUserId(int id);
}
