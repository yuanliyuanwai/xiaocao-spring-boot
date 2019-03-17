package in.xiaocao.spring.boot.multi.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "in.xiaocao.spring.boot.multi.mongodb.dao.first",
		mongoTemplateRef = FirstMongoConfig.MONGO_TEMPLATE)
public class FirstMongoConfig {

	protected static final String MONGO_TEMPLATE = "firstMongoTemplate";
}
