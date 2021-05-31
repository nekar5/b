package com.mainpackage.dao;

import java.util.HashMap;

public class AdminDAOimpl implements AdminDAO {
        private final HashMap<String,String> db;
    
    public AdminDAOimpl() {
        db = new HashMap<>();
        addAdmin("admin","admin");//default admin
    }
    private void addAdmin(String login,String password) {
        if(!db.containsKey(login))
            db.put(login, password);
    }

    @Override
    public boolean isAdmin(String login, String password) {
        if(!db.containsKey(login)) return false;
        return db.get(login).equals(password);
    }
    
}
