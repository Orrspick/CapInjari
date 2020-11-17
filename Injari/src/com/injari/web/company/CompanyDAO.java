package com.injari.web.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.injari.web.DBCPConn;

public class CompanyDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
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
		CompanyDTO company = null;
		ArrayList<CompanyDTO> cslist = new ArrayList<CompanyDTO>();
		
		try {
			// 쿼리
			StringBuffer query = new StringBuffer();
			query.append("SELECT cid,cname,shotinfo from company");
			
			
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

			

		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} 
		close();
		return cslist;
	}//end getCompany
	
	public CompanyDTO getDetail(int cid) {
		CompanyDTO company = null;
		
		try {
			conn = DBCPConn.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from company where cid = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, cid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				company = new CompanyDTO();
				company.setCid(rs.getInt("cid"));
				company.setCname(rs.getString("cname"));
				company.setShotinfo(rs.getString("shotinfo"));
				company.setInfo(rs.getString("info"));
				company.setInteviewinfo(rs.getString("interviewinfo"));
				company.setEtcinfo(rs.getString("etcinfo"));
			}
			
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		close();
		return company;
	}// end getDetail
	
	private void close()
    {
        try {
            if ( pstmt != null ){ pstmt.close(); pstmt=null; }
            if ( conn != null ){ conn.close(); conn=null;    }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    } // end close

}
