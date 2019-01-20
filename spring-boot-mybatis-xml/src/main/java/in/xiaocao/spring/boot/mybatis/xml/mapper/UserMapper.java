package in.xiaocao.spring.boot.mybatis.xml.mapper;

import java.util.List;

import in.xiaocao.spring.boot.mybatis.xml.entity.UserEntity;

public interface UserMapper {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}