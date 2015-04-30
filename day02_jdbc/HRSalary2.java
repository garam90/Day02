package day02_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HRSalary2 {
public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("월급 [min max] >>");
		int min = scan.nextInt();
		int max = scan.nextInt();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이브 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 생성
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3. PrepareStatement 준비
			String sql = "select * from employees where salary between ? and ? order by salary";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, min);
			stmt.setInt(2, max);
			// 4. SQL문 날리기
			rs = stmt.executeQuery();

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
