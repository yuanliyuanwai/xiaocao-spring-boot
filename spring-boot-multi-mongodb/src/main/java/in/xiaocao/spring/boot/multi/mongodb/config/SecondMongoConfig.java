package in.xiaocao.spring.boot.multi.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "in.xiaocao.spring.boot.multi.mongodb.dao.second",
		mongoTemplateRef = SecondMongoConfig.MONGO_TEMPLATE)
public class SecondMongoConfig {

	protected static final String MONGO_TEMPLATE = "secondMongoTemplate";
}
