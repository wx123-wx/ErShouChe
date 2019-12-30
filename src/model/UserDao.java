package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class UserDao {
	
	/**
	 * 杩欐槸鏌ヨ鑾峰緱鎵�鏈夎溅杈嗙殑dao鏂规硶
	 * @return
	 */
	public  List<User>  listAllUsers(){
		  List<User>  users=new ArrayList<>();
		  try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cars?useUnicode=true&characterEncoding=UTF-8","root","root");
			
			QueryRunner run = new QueryRunner();
			ResultSetHandler<List<User>> h = new BeanListHandler<User>(User.class);
			users= run.query(connection, "select * from user", h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  return users;
	}
	/**
	 * 杩欐槸鍒犻櫎杞﹁締淇℃伅鐨刣ao鏂规硶
	 * @param carid
	 * @return
	 */


}
