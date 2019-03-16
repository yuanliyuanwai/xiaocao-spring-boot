package in.xiaocao.spring.boot.mongodb.dao;

import in.xiaocao.spring.boot.mongodb.entity.UserEntity;

public interface UserDao  {

    public void saveUser(UserEntity user);

    public UserEntity findUserByUserName(String userName);

    public int updateUser(UserEntity user);

    public void deleteUserById(Long id);

}
