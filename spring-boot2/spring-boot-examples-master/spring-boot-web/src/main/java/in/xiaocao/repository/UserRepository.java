package in.xiaocao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.xiaocao.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);
    
}