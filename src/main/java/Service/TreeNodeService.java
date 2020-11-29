package main.java.Service;

import main.java.Bean.UnitTreeNode;
import main.java.DAO.TreeNodeDAO;

public class TreeNodeService {
    TreeNodeDAO treeNodeDAO = new TreeNodeDAO();
    public void add(UnitTreeNode node) {
        treeNodeDAO.add(node);
    }

    public int delete(String id) {
        return treeNodeDAO.delete(id);
    }

    public int updateName(String id, String name) {
        return treeNodeDAO.updateName(id, name);
    }

    public int updateParent(String id, String pid) {
        return treeNodeDAO.updateParent(id, pid);
    }

    public int getTotal() {
        return treeNodeDAO.getTotal();
    }
}
