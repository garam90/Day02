package sds.icto.test;

import java.sql.SQLException;
import java.util.ArrayList;

import sds.icto.dao.AuthorDAO;
import sds.icto.vo.AuthorVO;

public class AuthorDAOTest {

	public static void main(String[] args) {
		
		try{
			insertTest();
			selectTest();
		}catch(Exception e){
			
		}
		
	}

	public static void insertTest() throws ClassNotFoundException, SQLException{
		AuthorDAO dao = new AuthorDAO();

		//1. VO 생성
		AuthorVO vo = new AuthorVO();
		vo.setName("장자");
		vo.setBio("");
		dao.insertAuthor(vo);

		AuthorVO vo2 = new AuthorVO();
		vo2.setName("순자");
		vo2.setBio("");
		dao.insertAuthor(vo2);
		
	}
	
	public static void selectTest() throws ClassNotFoundException, SQLException{
		AuthorDAO dao = new AuthorDAO();
		ArrayList<AuthorVO> list = dao.selectAuthorList();
		for (AuthorVO authorVO : list) {
			System.out.println(authorVO);
		}
	}
	
}
