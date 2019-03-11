package in.xiaocao.spring.boot.mybatis.xml.multi.datasource.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.xiaocao.spring.boot.mybatis.xml.multi.datasource.entity.UserEntity;
import in.xiaocao.spring.boot.mybatis.xml.multi.datasource.mapper.test1.UserMapper1;
import in.xiaocao.spring.boot.mybatis.xml.multi.datasource.mapper.test2.UserMapper2;

@RestController
public class UserController {

	@Autowired
	private UserMapper1 user1Mapper;

	@Autowired
	private UserMapper2 user2Mapper;

	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
		List<UserEntity> users = user1Mapper.getAll();
		return users;
	}

	@RequestMapping("/getUser")
	public UserEntity getUser(Long id) {
		UserEntity user = user2Mapper.getOne(id);
		return user;
	}

	@RequestMapping("/add")
	public void save(UserEntity user) {
		user2Mapper.insert(user);
	}

	@RequestMapping(value = "update")
	public void update(UserEntity user) {
		user2Mapper.update(user);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		user1Mapper.delete(id);
	}

}