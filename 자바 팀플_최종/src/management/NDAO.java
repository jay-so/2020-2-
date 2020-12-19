package management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//가게 공지사항 테이블 - sql내용 삽입
public class NDAO {
			
			
		//sql에서 데이터를 불러오는 함수 - 테이블은 2차 배열 String 값
			public static String[][] getcontents(){ 
				try {
					Connection con = DBConnManager.getConnection();
					PreparedStatement statement = con.prepareStatement("Select * FROM notice");
					ResultSet results = statement.executeQuery(); //반환값
					Vector<String[]> list = new Vector<String[]>();
					while(results.next()) { 
						list.add(new String[] {  
								results.getString("number"),  //번호
								results.getString("date"),    //날짜
								results.getString("contents") //내용
						});
					}
					System.out.println("The database linked notice data success");
					String[][] arr = new String[list.size()][3]; 
					return list.toArray(arr); //정상시 list에 담아 반환
					
				}catch(Exception e) {
					System.out.println(e.getMessage());
					return null; //에러가 있을시 null값 반환
				}
			}
	
}
