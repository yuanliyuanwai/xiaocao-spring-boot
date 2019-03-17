package in.xiaocao.spring.boot.multi.mongodb.dao.first;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FirstMongodbDao extends MongoRepository<FirstMongoObject, String> {
}
