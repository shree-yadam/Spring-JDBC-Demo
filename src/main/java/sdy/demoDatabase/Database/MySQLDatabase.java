package sdy.demoDatabase.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import sdy.demoDatabase.pojo.User;

@Component
@Lazy(true)
public class MySQLDatabase {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> getUsers() {
		List<Map<String, Object>> userData = jdbcTemplate.queryForList("SELECT * FROM users");
		
		ListIterator<Map<String, Object>> itr = userData.listIterator();
		List<User> users = new ArrayList<User>();
		
		while(itr.hasNext()) {
			User user = new User();
			Map<String,Object> mapObj = itr.next();
			user.setId((Integer) mapObj.get("id"));
			user.setEmail((String) mapObj.get("email"));
			user.setName((String) mapObj.get("name"));
			user.setPassword((String) mapObj.get("password"));
			users.add(user);
		}
		return users;
	}

}
