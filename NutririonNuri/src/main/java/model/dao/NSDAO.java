package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.NS;

public class NSDAO {
    private JDBCUtil jdbcUtil = null;

    public NSDAO() {
        jdbcUtil = new JDBCUtil();
    }

    public List<NS> findNSList(String keyword, String option) throws SQLException {
        String sql = "";
        if (option.equals("total")) {
            sql = "SELECT SupId, Name, Manufacturer, Rate " 
                    + "FROM Supplement WHERE Name LIKE ? OR Effect LIKE ? "
                    + "OR Ingredient LIKE ? OR Manufacturer LIKE ? "
                    + "ORDER BY SupId";
            jdbcUtil.setSqlAndParameters(sql, new Object[] {"%"+ keyword +"%", "%"+ keyword +"%", "%"+ keyword +"%", "%"+ keyword +"%"});
        }
        else if (option.equals("name")){
            sql = "SELECT SupId, Name, Manufacturer, Rate " 
                    + "FROM Supplement WHERE Name LIKE ? "
                    + "ORDER BY SupId";
            jdbcUtil.setSqlAndParameters(sql, new Object[] {"%"+ keyword +"%"});
        }
        else if (option.equals("effect")){
            sql = "SELECT SupId, Name, Manufacturer, Rate " 
                    + "FROM Supplement WHERE Effect LIKE ? "
                    + "ORDER BY SupId";
            jdbcUtil.setSqlAndParameters(sql, new Object[] {"%"+ keyword +"%"});
        }
        else if (option.equals("ingredient")){
            sql = "SELECT SupId, Name, Manufacturer, Rate " 
                    + "FROM Supplement WHERE Ingredient LIKE ? "
                    + "ORDER BY SupId";
            jdbcUtil.setSqlAndParameters(sql, new Object[] {"%"+ keyword +"%"});
        }
        else if (option.equals("manufacturer")){
            sql = "SELECT SupId, Name, Manufacturer, Rate " 
                    + "FROM Supplement WHERE Manufacturer LIKE ? "
                    + "ORDER BY SupId";
            jdbcUtil.setSqlAndParameters(sql, new Object[] {"%"+ keyword +"%"});
        }

        try {
            ResultSet rs = jdbcUtil.executeQuery();               
            List<NS> nsList = new ArrayList<NS>(); 
            while (rs.next()) {
                NS ns = new NS(           
                        rs.getInt("SupId"),
                        rs.getString("Name"),
                        null,
                        null,
                        rs.getString("Manufacturer"),
                        null,
                        rs.getFloat("Rate"));
                nsList.add(ns); 
            }       
            return nsList;                    

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       
        }
        return null;
    }

    public NS findNS(int nsId) throws SQLException {
        String sql = "SELECT Name, Effect, Ingredient, Manufacturer, Precaution, Rate "
                + "FROM Supplement WHERE SupId=? ";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {nsId});   
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();     
            if (rs.next()) {                        
                NS ns = new NS(       
                        nsId,
                        rs.getString("Name"),
                        rs.getString("Effect"),
                        rs.getString("Ingredient"),
                        rs.getString("Manufacturer"),
                        rs.getString("Precaution"),                    
                        rs.getFloat("Rate")
                        );
                return ns;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       
        }
        return null;
    }

    public int addNS(int MemId, NS ns) throws SQLException {
        String sql = "INSERT INTO TakingSupplement VALUES (IntakeInform_seq.nextval, ?, ?, ?, ?, ?, ?)";
        Object[] param = new Object[] { null, null, ns.getPrecaution(), null, ns.getSupId(), MemId };              
        jdbcUtil.setSqlAndParameters(sql, param);   

        try {               
            int result = jdbcUtil.executeUpdate();  
            calStarRate(ns.getSupId());
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();   
        }       
        return 0;           
    }

    public int deleteNS(int MemId, NS ns) throws SQLException {
        String sql = "DELETE FROM TakingSupplement WHERE SupId = ? AND MemId = ? ";     
        jdbcUtil.setSqlAndParameters(sql, new Object[] {ns.getSupId(), MemId});   

        try {               
            int result = jdbcUtil.executeUpdate();
            calStarRate(ns.getSupId());
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

    public int updateNS(int MemId, NS ns, Date time, int amount, float rate) throws SQLException {
        String sql = "UPDATE TakingSupplement "
                + "SET IntakeTime=?, IntakeAmount=?, Rate=? "
                + "WHERE SupId = ? AND MemId = ? ";     
        jdbcUtil.setSqlAndParameters(sql, new Object[] {time, amount, rate, ns.getSupId(), MemId});   

        try {               
            int result = jdbcUtil.executeUpdate();  
            calStarRate(ns.getSupId());
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

    public List<NS> findMyNSList(int MemId) throws SQLException {

        String sql = "SELECT SupId, Name, Manufacturer, Rate " 
                + "FROM TakingSupplement t JOIN Supplement s ON t.SupId = s.SupId "
                + "WHERE MemId = ? ORDER BY SupId";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {MemId});

        try {
            ResultSet rs = jdbcUtil.executeQuery();               
            List<NS> nsList = new ArrayList<NS>();    
            while (rs.next()) {
                NS ns = new NS(           
                        rs.getInt("SupId"),
                        rs.getString("Name"),
                        null,
                        null,
                        rs.getString("Manufacturer"),
                        null,
                        rs.getFloat("Rate")
                        );
                nsList.add(ns);             
            }       
            return nsList;                    

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       
        }
        return null;
    }

    public List<NS> findStarList() throws SQLException {
        String sql = "SELECT SupId, Name, Manufacturer, Rate " 
                + "FROM Supplement "
                + "ORDER BY Rate DESC, SupId ASC";
        jdbcUtil.setSqlAndParameters(sql, null);

        try {
            ResultSet rs = jdbcUtil.executeQuery();               
            List<NS> nsList = new ArrayList<NS>();    
            while (rs.next()) {
                NS ns = new NS(           
                        rs.getInt("SupId"),
                        rs.getString("Name"),
                        null,
                        null,
                        rs.getString("Manufacturer"),
                        null,
                        rs.getFloat("Rate")
                        );
                nsList.add(ns);             
            }       
            return nsList;                    

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       
        }
        return null;
    }

    public int calStarRate(int nsId) throws SQLException {
        try {
            String sql = "SELECT Rate, count(*) FROM TakingSupplement "
                    + "GROUP BY Rate WHERE SupId=? "; 
            jdbcUtil.setSqlAndParameters(sql, new Object[] {nsId});
            
            ResultSet rs = jdbcUtil.executeQuery();   
            float rate = 0;
            float count = 0;
            while (rs.next()) {
                count = rs.getFloat("count(*)");
                rate += rs.getFloat("Rate");
            }       
            rate /= count;
            
            sql = "UPDATE Supplement SET Rate = ? WHERE SupId = ? ";
            jdbcUtil.setSqlAndParameters(sql, new Object[] {rate, nsId});
            
            int result = jdbcUtil.executeUpdate();  
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       
        }
        return 0;
    }
    
    public List<NS> findSearchList() throws SQLException {
        String sql = "SELECT SupId, Name, Manufacturer, Rate, SearchVolume " 
                + "FROM Supplement "
                + "ORDER BY SearchVolume DESC, SupId ASC";
        jdbcUtil.setSqlAndParameters(sql, null);

        try {
            ResultSet rs = jdbcUtil.executeQuery();               
            List<NS> nsList = new ArrayList<NS>();    
            while (rs.next()) {
                NS ns = new NS(           
                        rs.getInt("SupId"),
                        rs.getString("Name"),
                        null,
                        null,
                        rs.getString("Manufacturer"),
                        null,
                        rs.getFloat("Rate"));
                nsList.add(ns);             
            }       
            return nsList;                    

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       
        }
        return null;
    }
}