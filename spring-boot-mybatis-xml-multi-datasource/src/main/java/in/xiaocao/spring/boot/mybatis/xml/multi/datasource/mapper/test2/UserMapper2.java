package in.xiaocao.spring.boot.mybatis.xml.multi.datasource.mapper.test2;

import java.util.List;

import in.xiaocao.spring.boot.mybatis.xml.multi.datasource.entity.UserEntity;

public interface UserMapper2 {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}