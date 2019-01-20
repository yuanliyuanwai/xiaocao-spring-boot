package in.xiaocao.spring.boot.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.xiaocao.spring.boot.web.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);
    
}