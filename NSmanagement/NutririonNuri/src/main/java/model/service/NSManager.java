package model.service;

import java.sql.SQLException;
import java.util.List;

import model.NS;
import model.dao.NSDAO;

public class NSManager {
    private static NSManager nsMan = new NSManager();
    private NSDAO nsDAO;
    
    private NSManager() {
        try {
            nsDAO = new NSDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static NSManager getInstance() {
        return nsMan;
    }
    
    //findNS
    public NS findNS(int nsId) throws SQLException {
        return nsDAO.findNS(nsId);
    }
    
    //findNSList
    public List<NS> findNSList(String key, String option) throws SQLException{
        return nsDAO.findNSList(key, option);
    }
    
    //addNS
    //deleteNS
    //updateNS
    //findMyNSList
    //findMyNS
    
    //calStarRate
    //findSearchList
    //findStarList
}
