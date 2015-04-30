package day02_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HRSalary {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("월급 [min max] >>");
		int min = scan.nextInt();
		int max = scan.nextInt();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이브 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 생성
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3. PrepareStatement 준비
			stmt = conn.createStatement();

			// 4. SQL문 날리기
			String sql = "select * from employees where salary between "+ min +" and "+max+" order by salary";
			rs = stmt.executeQuery(sql);

			// 5. 결과출력
			while (rs.next()) {
				String name = rs.getString("first_name") + " " + rs.getString("last_name");
				int salary = rs.getInt("salary");
				System.out.println(name+"    \t>> salary : "+salary);
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
