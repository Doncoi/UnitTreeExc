package main.java.DAO;

import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;

import main.java.Bean.UnitTreeNode;

public class TreeNodeDAO {
    //增加结点
    public void add(UnitTreeNode node) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            String sql = "insert into unittree(id, name, pid) values(?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, node.getId());
            ps.setString(2, node.getName());
            ps.setString(3, node.getPid());
            ps.execute();

            ps.close();
            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除结点
    public int delete(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from unittree where id = " + id);
            if(! rs.next()) return 0;

            //删除id符合条件的结点
            String sql_1 = " delete from unittree where id = ? ";
            PreparedStatement ps_1 = c.prepareStatement(sql_1);
            ps_1.setString(1, id);
            ps_1.execute();
            ps_1.close();

            //同时删除该目录下的所有结点
            //id_list实现BFS
            Queue<String> id_list = new LinkedList<String>();
            //查询第一层子节点
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from unittree where pid = " + id);
            while (rs.next()) {
//                System.out.println(rs.getString(2));
                id_list.offer(rs.getString(2));
            }
            //层遍历删除子树
            String sql_2 = "delete from unittree where id = ?";
            PreparedStatement ps_2 = c.prepareStatement(sql_2);

            while(! id_list.isEmpty()) {
                String tempid = id_list.remove();
                //删除当前结点
                ps_2.setString(1, tempid);
                ps_2.execute();
                //将当前节点的子结点入队
                rs = stmt.executeQuery("select * from unittree where pid = " + tempid);
                while (rs.next()) {
                    id_list.offer(rs.getString(2));
                }
            }
            //关闭连接
            ps_2.close();
            rs.close();
            stmt.close();
            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    //更改节点名称
    public int updateName(String id, String name) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from unittree where id = " + id);
            if(! rs.next()) return 0;

            String sql = "update unittree set name=? where id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, id);
            ps.execute();

            ps.close();
            stmt.close();
            rs.close();
            c.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 1;
    }

    //更改父节点
    public int updateParent(String id, String pid) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from unittree where id = " + id);
            if(! rs.next()) return 0;

            String sql = "update unittree set pid=? where id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, pid);
            ps.setString(2, id);
            ps.execute();

            ps.close();
            stmt.close();
            rs.close();
            c.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 1;
    }

    //获取总数
    public int getTotal() {
        int total = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            String sql = " select count(*) from unittree ";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }

            ps.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
}
 