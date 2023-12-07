package model.dao;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO {
    private JDBCUtil jdbcUtil = null;
    
    public UserDAO() {
        jdbcUtil = new JDBCUtil();
    };
    
    //유저 가입(생성)
    public int addUser(User user) {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO Member ");
        query.append("VALUES (?, ?, ?, ?, ?, ?, ?) ");
        
        jdbcUtil.setSqlAndParameters(query.toString(), 
                new Object[] {"mem_seq.nextval",
                        user.getId(),
                        user.getPw(),
                        user.getName(),
                        user.getPhone(),
                        user.getBirthDay().toString(),
                        user.getEmail()
                        });
        try {
            int result = jdbcUtil.executeUpdate();
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
    
    //유저 정보 갱신
    public int updateUser(User user) throws SQLException{
        StringBuilder query = new StringBuilder();
        query.append("UPDATE Member ");
        query.append("SET pwd=?, name=?, phone=?, birthday=?, email=? ");
        query.append("WHERE MemId = ?");
        
        jdbcUtil.setSqlAndParameters(query.toString(), 
                new Object[] {
                        user.getPw(),
                        user.getName(),
                        user.getPhone(),
                        user.getBirthDay().toString(),
                        user.getEmail(),
                        user.getMemid()});
        try {
            int result = jdbcUtil.executeUpdate();
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
    
    //유저 삭제
    public int deleteUser(String id) throws SQLException{
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM Member ");
        query.append("WHERE MemId = ?");
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {id});
        try {
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex){
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        
        return 0;
    }
    
    //유저 정보 조회
    public User findUser(String id) throws SQLException{
        StringBuilder query = new StringBuilder();
        query.append("SELECT memid, pwd, name, gender, phone, birthday, email ");
        query.append("FROM Member ");
        query.append("WHERE MemId = ?");
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {id});
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if(rs.next()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate birth = LocalDate.parse(rs.getString("birthday"), formatter);
                User user = new User(
                        rs.getInt("memid"),
                        id,
                        rs.getString("pwd"),
                        rs.getString("name"),
                        rs.getString("gender").charAt(0),
                        rs.getString("phone"),
                        birth,
                        rs.getString("email"));
            }
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        
        return null;
    }
    
    //존재하는 유저 id인지 검사
    public boolean existingUser(String userId) throws SQLException{
        StringBuilder query = new StringBuilder();
        
        query.append("SELECT count(*) ");
        query.append("FROM Member ");
        query.append("WHERE memId = ?");
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {userId});
        
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
    
    //모든 유저 list 반환
    public List<User> findUserList() throws SQLException {
        StringBuilder query = new StringBuilder();
        List<User> list = new ArrayList<>();
        
        query.append("SELECT memid, pwd, name, gender, phone, birthday, email ");
        query.append("FROM Member ");
        jdbcUtil.setSqlAndParameters(query.toString(), null);
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            while(rs.next()) {
                int memid = rs.getInt("memid");
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                char gender = rs.getString("gender").charAt(0);
                String phone = rs.getString("phone");
                LocalDate birthday = rs.getDate("birthday").toLocalDate();
                String email = rs.getString("email");
                
                User user = new User(memid, id, pwd, name, gender, phone, birthday, email);
                list.add(user);
            }
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.close();
        }
        
        return list;
    }
}
