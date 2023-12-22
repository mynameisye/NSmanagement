package model.dao;

import java.sql.*;
import model.MemberInfo;

public class MemberInfoDAO {
	private JDBCUtil jdbcUtil = null;

    public MemberInfoDAO() {
        jdbcUtil = new JDBCUtil();
    }
    
    public int createMemberInfo(int memId) throws SQLException {
        String sql = "INSERT INTO MemberInfo "
                + "VALUES (null, null, 'x', 'x', 'x', null, null, null, ?) ";

        jdbcUtil.setSqlAndParameters(sql, new Object[] {memId}); 

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
    
    //검색
    public MemberInfo findMemberInfo(int memId) throws SQLException {
        String sql = "SELECT Height, Weight, Smoke, Alchol, Pregnant, Medicine, Supplement, PrefIngredient "
                + "FROM MemberInfo WHERE MemId=? ";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {memId});   

        try {
            ResultSet rs = jdbcUtil.executeQuery();     
            if (rs.next()) {                        
            	MemberInfo memberInfo = new MemberInfo(       
            			memId,
                        rs.getFloat("Height"),
                        rs.getFloat("Weight"),
                        rs.getString("Smoke").charAt(0),
                        rs.getString("Alchol").charAt(0),                    
                        rs.getString("Pregnant").charAt(0),
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
    public int updateMemberInfo(MemberInfo memberInfo, String id) throws SQLException {
        
        int memid = findMemId(id);
        
        String sql = "UPDATE MemberInfo "
                + "SET height=?, weight=?, smoke=?, alchol=?, pregnant=?, medicine=?, supplement=?, prefingredient=? "
                + "WHERE MemId = ? ";     
        jdbcUtil.setSqlAndParameters(sql, new Object[] {memberInfo.getHeight(), memberInfo.getWeight(), 
                memberInfo.getSmoke(), memberInfo.getAlchol(), memberInfo.getPregnant(), memberInfo.getMedicine(),
                memberInfo.getSupplement(), memberInfo.getPrefIngredient(), memid});

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
    public boolean existMemberInfo(int MemId) throws SQLException{
        String query = "SELECT count(*) FROM MemberInfo WHERE memId=?";
        jdbcUtil.setSqlAndParameters(query, new Object[] {MemId});
        
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
    
    public int findMemId(String id) throws SQLException {
        String query = "SELECT memid FROM Member WHERE id = ?";
        jdbcUtil.setSqlAndParameters(query, new Object[] {id});

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if(rs.next()) {
                int memid = rs.getInt("memid");
                return memid;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return -1;
    }
}