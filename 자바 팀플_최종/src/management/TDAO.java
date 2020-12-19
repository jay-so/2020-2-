package management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

// 가게 검색 테이블 - sql내용 삽입
	public class TDAO {
	
	    //sql에서 데이터를 불러오는 함수 - 테이블은 2차 배열 String 값
		public static String[][] getstores(){ 
			try {
				Connection con = DBConnManager.getConnection();
				PreparedStatement statement = con.prepareStatement("Select city,mkname,stname,st,lc FROM store");
				ResultSet results = statement.executeQuery(); //반환값
				Vector<String[]> list = new Vector<String[]>();
				while(results.next()) { 
					list.add(new String[] {  
							results.getString("city"),
							results.getString("mkname"),
							results.getString("stname"),
							results.getString("st"),
							results.getString("lc")
					});
				}
				System.out.println("The database linked store data success");
				String[][] arr = new String[list.size()][5]; 
				return list.toArray(arr); //정상시 list에 담아 반환
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return null; //에러가 있을시 null값 반환
			}
		}
	
	
	
}
