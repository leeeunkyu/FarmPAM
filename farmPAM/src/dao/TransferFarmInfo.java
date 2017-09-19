package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import Util.UtilExcel;

public class TransferFarmInfo {
	private static TransferFarmInfo instance = new TransferFarmInfo();
	private FactoryUser factory = FactoryUser.getInstance();
	private UtilExcel util=UtilExcel.getInstance();
	
	public static TransferFarmInfo getInstance() {
		return instance;
	}
	
	private TransferFarmInfo() {	}
	/**
	 * a열 조사 구분코드 examinCd api
	 * b열 조사 지역명 areaName 검색
	 * c열 조사 품목코드 prdlstCd	api
	 * d열 조사 품목명 prdlstName 검색
	 * @return 성공적으로 값을 넣을경우 true 그렇지않을경우 false
	 */
	public boolean addFarmInfo() {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashMap<String, String> farmlist = new HashMap<>();
		farmlist=util.loadFarmInfo();
		String sql ="INSERT INTO farmlist VALUES (?,?,?,?,?)";
		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			/*
			 * key 리스트
			 * 조사 구분코드 examinCd+[index]
			 * 조사 지역명 areaName+[index]
			 * 조사 품목코드 prdlstCd+[index]
			 * 조사 품목명 prdlstName+[index]
			 */
			for (int i = 0; i < farmlist.size()/4; i++) {				
				pstmt.setInt(1,i);
				pstmt.setString(2, farmlist.get("examinCd["+i+"]"));
				pstmt.setString(3, farmlist.get("areaName["+i+"]"));
				pstmt.setString(4, farmlist.get("prdlstCd["+i+"]"));
				pstmt.setString(5, farmlist.get("prdlstName["+i+"]"));
				pstmt.executeUpdate();
			}
			System.out.println(farmlist.size());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			factory.close(conn,pstmt,rs);
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(TransferFarmInfo.getInstance().addFarmInfo());
	}
}
