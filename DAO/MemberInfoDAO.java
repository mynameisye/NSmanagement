package model.dao;

import java.util.*;
import java.sql.*;
import model.MemberInfo;

public class MemberInfoDAO {
	private JDBCUtil jdbcUtil = null;

    public MemberInfoDAO() {
        jdbcUtil = new JDBCUtil();
    }
    
    //검색
    public MemberInfo findMemberInfo(int memId) throws SQLException {
        String sql = "SELECT Height, Weight, Disease, Smoke, Alchol, Pregnant, Medicine, Supplement, PrefIngredient "
                + "FROM MemberInfo WHERE MemId=? ";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {memId});   

        try {
            ResultSet rs = jdbcUtil.executeQuery();     
            if (rs.next()) {                        
            	MemberInfo memberInfo = new MemberInfo(       
            			memId,
                        rs.getFloat("Height"),
                        rs.getFloat("Weight"),
                        rs.getString("Disease"),
                        rs.getInt("Smoke"),
                        rs.getInt("Alchol"),                    
                        rs.getDate("Pregnant"),
                        rs.getString("Medicine"),
                        rs.getString("Supplement"),
                        rs.getString("PrefIngredient"));
                return memberInfo;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       
        }
        return null;
    }
    //삭제
    public int deleteMemberInfo(MemberInfo memberInfo) throws SQLException {
        String sql = "DELETE FROM MemberInfo WHERE MemId = ? ";     
        jdbcUtil.setSqlAndParameters(sql, new Object[] {memberInfo.getMemId()});   

        try {               
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   
        }       
        return 0;
    }
    //갱신
    public int updateMemberInfo(MemberInfo memberInfo) throws SQLException {
        String sql = "UPDATE MemberInfo "
                + "SET /*채워 넣기*/ "
                + "MemId = ? ";     
        jdbcUtil.setSqlAndParameters(sql, new Object[] {memberInfo.getMemId()});   

        try {               
            int result = jdbcUtil.executeUpdate();  
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   
        }       
        return 0;
    }
    //MemId 있는지 확인
    public boolean existMemberInfo(String MemId) throws SQLException{
        StringBuilder query = new StringBuilder();
        
        query.append("SELECT count(*) ");
        query.append("FROM MemberInfo ");
        query.append("WHERE memId = ?");
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {MemId});
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if(rs.next()) {
                int count = rs.getInt(1);
                return (count == 1 ? true: false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return false;
    }
}
