package in.xiaocao.spring.boot.multi.mongodb.dao.second;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecondMongodbDao extends MongoRepository<SecondMongoObject, String> {
}
