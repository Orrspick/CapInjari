package com.injari.web.member;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.injari.web.DBCPConn;

public class MemberDAO {
	
	private static MemberDAO instance;
	
	// 싱글톤 패턴
		private MemberDAO(){}
		public static MemberDAO getInstance(){
			if(instance==null)
				instance=new MemberDAO();
			return instance;
	}
	
	public String Encryption(MemberDTO member) {
		String pw = member.getPassword();
		String sh = "";
		
		try{
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			sha.update(pw.getBytes());
			byte byteData[] = sha.digest();
			for(int i = 0; i <byteData.length; i++){
				String x = Integer.toHexString(byteData[i] & 0xff);
				if(x.length()<2)
					sh += "0";
				sh += x;
			}
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return sh;
	}
	
	public String Description(String password) {
		String pw = password;
		String sh = "";
		
		try{
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			sha.update(pw.getBytes());
			byte byteData[] = sha.digest();
			for(int i = 0; i <byteData.length; i++){
				String x = Integer.toHexString(byteData[i] & 0xff);
				if(x.length()<2)
					sh += "0";
				sh += x;
			}
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return sh;
	}
	
	//db삽입
	public void insertData(MemberDTO dto) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBCPConn.getConnection();
			
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("insert into user(email,password,name,mkdate) values");
			sql.append("(?,?,?,now())");
			Encryption(dto);
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, Encryption(dto));
			pstmt.setString(3, dto.getName());
			
			// 쿼리 실행
			pstmt.executeUpdate();
			// 완료시 커밋
			conn.commit(); 
						
					} catch (ClassNotFoundException | NamingException | SQLException sqle) {
						// 오류시 롤백
						conn.rollback(); 
						throw new RuntimeException(sqle.getMessage());
					} finally {
						// Connection, PreparedStatement를 닫는다.
						try{
							if ( pstmt != null ){ pstmt.close(); pstmt=null; }
							if ( conn != null ){ conn.close(); conn=null;	}
						}catch(Exception e){
							throw new RuntimeException(e.getMessage());
						}
					}
				}
	
	public int loginCheck(String eamil, String pw) 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbPW = ""; // db에서 꺼낸 비밀번호를 담을 변수
		int x = -1;

		try {
			// 쿼리 - 먼저 입력된 아이디로 DB에서 비밀번호를 조회한다.
			StringBuffer query = new StringBuffer();
			query.append("select password from user where email=?");

			conn = DBCPConn.getConnection();
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, eamil);
			rs = pstmt.executeQuery();

			if (rs.next()) // 입려된 아이디에 해당하는 비번 있을경우
			{
				dbPW = rs.getString("password"); // 비번을 변수에 넣는다.
				
				
				if (dbPW.equals(Description(pw))) {
					x = 1; // 넘겨받은 비번과 꺼내온 비번 비교. 같으면 인증성공
				}
				else 				 
					x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
				
			} else {
				x = -1; // 해당 아이디가 없을 경우
			}

			return x;

		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try{
				if ( pstmt != null ){ pstmt.close(); pstmt=null; }
				if ( conn != null ){ conn.close(); conn=null;	}
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
		}
	} // end loginCheck()
	
	public MemberDTO getUserInfo(String email) 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO member = null;

		try {
			// 쿼리
			StringBuffer query = new StringBuffer();
			query.append("select * from user where email=?");

			conn = DBCPConn.getConnection();
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) // 회원정보를 DTO에 담는다.
			{
				member = new MemberDTO();
				member.setUid(rs.getInt("uid"));
				member.setName(rs.getString("name"));
				member.setAuthority(rs.getInt("authority"));
				member.setMkdate(rs.getTimestamp("mkdate"));
			}

			return member;

		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			// Connection, PreparedStatement를 닫는다.
			try{
				if ( pstmt != null ){ pstmt.close(); pstmt=null; }
				if ( conn != null ){ conn.close(); conn=null;	}
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
		}
	}	// end getUserInfo
}
