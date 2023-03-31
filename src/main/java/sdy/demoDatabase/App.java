package sdy.demoDatabase;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sdy.demoDatabase.Database.MySQLDatabase;
import sdy.demoDatabase.pojo.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        MySQLDatabase db = ctx.getBean(MySQLDatabase.class); 
        
        List<User> users = db.getUsers();
        
        for(User user: users) {
        	System.out.println(user);
        }
        
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
