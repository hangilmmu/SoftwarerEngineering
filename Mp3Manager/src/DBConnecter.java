import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBConnecter {
	Connection conn;
	Statement stmt;
	public DBConnecter(){
		conn = null;
		stmt = null;
		/*
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
			("jdbd:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			stmt = conn.createStatement();
			
			System.out.println("DB 연결 완료");
		}catch(ClassNotFoundException e){
			System.out.println("JDBC 드라이버 로드 에러");
		}catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
		*/
	}
	public ArrayList<Mp3Header> insertMp3List(ArrayList<Mp3Header> findList){
		ArrayList<Mp3Header> Mp3List = new ArrayList<Mp3Header>();
		ResultSet rs;
		for(int i=0; i<findList.size(); i++){
			//rs = stmt.executeQuery("SELECT ID FROM MP3LIST WHERE ID = " +findList.get(i).FName);
			//if(!rs.next()){
				try{
					/*
					stmt.executeUpdate( "INSERT INTO MP3LIST VALUES('"
						+Mp3List.get(i).FName +"', '" +Mp3List.get(i).Name +"', '" +Mp3List.get(i).Artist +"', '"
					 	+Mp3List.get(i).Album +"', '" +Mp3List.get(i).Year +"', '" +Mp3List.get(i).Comment +"')");
					*/
					System.out.println( "INSERT INTO MP3LIST VALUES('"
						+findList.get(i).FName +"', '" +findList.get(i).Name +"', '" +findList.get(i).Artist +"', '"
						+findList.get(i).Album +"', '" +findList.get(i).Year +"', '" +findList.get(i).Comment +"')");
				} catch(Exception e) {
					e.printStackTrace();
				}
			//}
		}
		/*
		try {
			rs = stmt.executeQuery("SELECT * FROM MP3LIST");
			while(rs.next()){
				Mp3Header mp3h = new Mp3Header();
				mp3h.FName = rs.getNString("FName");
				mp3h.Name = rs.getNString("Name");
				mp3h.Artist = rs.getNString("Artist");
				mp3h.Album = rs.getNString("Album");
				mp3h.Year = rs.getNString("Year");
				mp3h.Comment = rs.getNString("Comment");
				Mp3List.add(mp3h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		return Mp3List;
	}
}
