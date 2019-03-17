package in.xiaocao.spring.boot.multi.mongodb.dao.second;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "second_mongo")
public class SecondMongoObject {

	@Id
	private String id;

	private String value;
	
	public SecondMongoObject() {
		
	}
	
	public SecondMongoObject(String id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
        return "SecondMongoObject{" + "id='" + id + '\'' + ", value='" + value + '\''
				+ '}';
	}
}
