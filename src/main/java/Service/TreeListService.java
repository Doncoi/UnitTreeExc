package main.java.Service;

import main.java.DAO.TreeListDAO;

public class TreeListService {
    TreeListDAO listDAO = new TreeListDAO();

    public String getTreeList() {return listDAO.getTreeList();}
}
