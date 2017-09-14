package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * dao 구조를 정규화 하기위한 Factory 클래스
 * db에 대한 정보값을 conf/dbserver.properties로 부터 불러온다
 * @author kosta
 *
 */
public class FactoryUser  {
	/**FactoryUser 객체를 얻기위한 instance변수 */
	private static FactoryUser instance = new FactoryUser();
	/**DB 드라이버 정보*/
	private String driverinfo;
	/**DB URL 경로*/
	private String url;
	/**DB 유저 ID*/
	private String driver_user;
	/**DB 유저 PWD*/
	private String driver_pwd;
	/**번들객체를 이용하기위한 번들 참조변수 */
	private ResourceBundle bundle;
	
	
	/**
	 * 초기 생성시 DB값 셋팅
	 */
	private FactoryUser() {
		bundle = ResourceBundle.getBundle("conf/dbserver");
		driverinfo = bundle.getString("oracle.driver");
		url = bundle.getString("oracle.url");
		driver_user = bundle.getString("oracle.username");
		driver_pwd = bundle.getString("oracle.password");
		try {
			Class.forName(driverinfo);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static FactoryUser getInstance() {
		return instance;
	}
	
	/**
	 * 
	 * @param url
	 * @param user
	 * @param password
	 * @return Connection
	 * DB와 연결
	 */
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(this.url, this.driver_user, this.driver_pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * CUD 자원해제 메소드
	 * @param conn
	 * @param stmt
	 */
	public void close(Connection conn,Statement stmt) {
		close(conn,stmt,null);
	}
	
	/**
	 * R 자원해제 메소드
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public void close(Connection conn,Statement stmt,ResultSet rs) {
		try {
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}
			if(rs!=null) {rs.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}