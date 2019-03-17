package in.xiaocao.spring.boot.multi.mongodb.config.props;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {

	private MongoProperties first = new MongoProperties();
	
	private MongoProperties second = new MongoProperties();

	public MongoProperties getFirst() {
		return first;
	}

	public void setFirst(MongoProperties first) {
		this.first = first;
	}

	public MongoProperties getSecond() {
		return second;
	}

	public void setSecond(MongoProperties second) {
		this.second = second;
	}
	
}
