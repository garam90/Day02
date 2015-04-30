package sds.icto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sds.icto.vo.AuthorVO;

public class AuthorDAO {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		conn = DriverManager.getConnection(url, "icto55", "icto55");
		return conn;
	}

	public void insertAuthor(AuthorVO author) throws ClassNotFoundException,
			SQLException {

		Connection conn = getConnection();
		String sql = "insert into author values (seq_author.nextval, ?,?)";
		PreparedStatement stmt  = conn.prepareStatement(sql);
		stmt.setString(1, author.getName());
		stmt.setString(2, author.getBio());
		stmt.executeUpdate();

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

	public ArrayList<AuthorVO> selectAuthorList()
			throws ClassNotFoundException, SQLException {
		ArrayList<AuthorVO> list = new ArrayList<AuthorVO>();

		Connection conn = getConnection();
		String sql = "select * from author";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			AuthorVO vo = new AuthorVO(rs.getInt(1), rs.getString(2), rs.getString(3));
			list.add(vo);
		}

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

		return list;
	}

	public void delete(int seq_author) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		String sql = "delete from author where seq_author = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, seq_author);
		stmt.executeUpdate();
		
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
	
}
