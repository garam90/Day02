package day02_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HRSearchEmployee2 {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이브 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 생성
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 키보드로부터 검색어를 입력받는다.
			System.out.print("검색어 > ");
			String keyword = scan.next();

			// 3. PrepareStatement 준비
			String sql = "select first_name, last_name, email, phone_number, hire_date "
					+ "from employees where first_name like '%'||?||'%' or last_name like '%'||?||'%'";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, keyword);
			stmt.setString(2, keyword);

			// 4. SQL문 날리기
			rs = stmt.executeQuery();

			// 5. 결과출력
			while (rs.next()) {
				String name = rs.getString(1) + " " + rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				Date hire = rs.getDate(5);
				System.out.println(name+"       \t "+email+"      \t "+phone+"   \t "+hire);
			} 
			System.out.println("------검색종료------");

		} catch (ClassNotFoundException e) {
			System.out.println("oracle library 가 없습니다.");
		} catch (SQLException e) {
			System.out.println("DB 연결에 실패했습니다.");
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		
		scan.close();
	}
	
	
}
