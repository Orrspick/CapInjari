package com.injari.web.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.injari.web.DBCPConn;

public class CompanyDAO {
	
	private static CompanyDAO instance;
	
	// 싱글톤 패턴
		private CompanyDAO(){}
		public static CompanyDAO getInstance(){
			if(instance==null)
				instance=new CompanyDAO();
			return instance;
	}
	
	public ArrayList<CompanyDTO> getCompany() {
		int i = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CompanyDTO company = null;
		
		try {
			// 쿼리
			StringBuffer query = new StringBuffer();
			query.append("SELECT cid,cname,shotinfo from company");
			
			ArrayList<CompanyDTO> cslist = new ArrayList<CompanyDTO>();
			conn = DBCPConn.getConnection();
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) // 회원정보를 DTO에 담는다.
			{
				company = new CompanyDTO(); 
				company.setCid(rs.getInt("cid"));
				company.setCname(rs.getString("cname"));
				company.setShotinfo(rs.getString("shotinfo"));
				
				cslist.add(company);
				i++;
				if(i == 6) {
					break;
				}
			}

			return cslist;

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
	}
	
}
