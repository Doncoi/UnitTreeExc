package main.java.TestClass;

import main.java.Bean.UnitTreeNode;
import main.java.DAO.TreeNodeDAO;

import java.sql.*;

public class TreeNodeDAOTest {
    TreeNodeDAO testdao = new TreeNodeDAO();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TreeNodeDAOTest maintest = new TreeNodeDAOTest();
        maintest.addTest("0001", "test1", "0001");
        maintest.addTest("0002", "test2", "0001");
        maintest.addTest("0003", "test3", "0001");
        maintest.addTest("0004", "test4", "0002");
        maintest.addTest("0005", "test5", "0002");
        maintest.addTest("0006", "test6", "0003");
        maintest.addTest("0007", "test7", "0004");
//        maintest.show();
//        maintest.deleteTest("0001");
//        maintest.updateNameTest("0001", "test1_1");
//        maintest.updateParentTest("0001", "NULL");
//        maintest.getRootIDTest();
        maintest.show();
    }

    protected void addTest(String id, String name, String pid) {
        UnitTreeNode tempNode = new UnitTreeNode(id, name, pid);
        tempNode.show();
        testdao.add(tempNode);
    }

    protected void deleteTest(String id) {
        testdao.delete(id);
    }

    protected void updateNameTest(String id, String name) {
        testdao.updateName(id, name);
    }

    protected void updateParentTest(String id, String pid) {
        testdao.updateParent(id, pid);
    }

    protected void show() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //创建连接
        Connection conn= DriverManager.getConnection
                ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC","root","1021");
        //得到执行sql语句的Statement对象
        Statement stmt = conn.createStatement();

        System.out.println("***Connection Success");
        //执行sql语句，并返回结果
        ResultSet rs = stmt.executeQuery("select * from unittree");
        //处理结果
        while (rs.next()) {
            for (int i = 1; i <= 4; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        //关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }
}

