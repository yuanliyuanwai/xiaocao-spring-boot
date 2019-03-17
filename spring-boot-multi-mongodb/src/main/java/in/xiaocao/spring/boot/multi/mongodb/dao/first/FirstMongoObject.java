package in.xiaocao.spring.boot.multi.mongodb.dao.first;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "first_mongo")
public class FirstMongoObject {

	@Id
	private String id;

	private String value;
	
	public FirstMongoObject() {
		
	}
	
	public FirstMongoObject(String id, String value) {
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
        return "FirstMongoObject{" + "id='" + id + '\'' + ", value='" + value + '\''
				+ '}';
	}
}
