package main.java.TestClass;

import main.java.DAO.TreeListDAO;

public class TreeListDAOTest {
    TreeListDAO testDAO = new TreeListDAO();

    public static void main(String[] args) {
        TreeListDAOTest maintest = new TreeListDAOTest();
        maintest.showTreeList();
    }

    private void showTreeList() {
        System.out.println(testDAO.getTreeList());
    }
}
