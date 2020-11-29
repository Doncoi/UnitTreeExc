package main.java.DAO;

import java.sql.*;

public class TreeListDAO {
    //获取name属性
    public String getName(String id) {
        String result = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            String sql = " select name from unittree where id =" + id;
            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString(1);
            }

            ps.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    //获取pid属性
    public String getPid(String id) {
        String result = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            String sql = " select pid from unittree where id = " + id;
            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString(1);
            }

            ps.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    //获取根节点
    public String getRootID() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");
            //pid等于自身id的是根节点，没有父节点的游离节点的pid为NULL
            String sql = " select id from unittree where id = pid";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }

            ps.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return "NULL";
    }

    //获取规定格式单行
    public String getRow(String id, int depth) {
        String result = "";
        for(int i = 1; i < depth; ++ i) result += "    ";
        result += ("-- id: " + id + "    name: " + getName(id) + "    parent: " + getPid(id) + "\n");
        return result;
    }

    //递归获取子树树形列表
    public String getSubTreeList(String id, int depth) {
//        System.out.println("getsubat " + id + " depth : " + depth);
        String result = getRow(id, depth);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select id from unittree where pid = " + id);

            while (rs.next()) {
//                System.out.println("rs state : " + rs.getString(1) + " id: "  + id);
                if(rs.getString(1).equals(id)) continue;
                //谨记，判断值相等不要写==，麻了
//                if(rs.getString(1) == (id)) continue;
                result += getSubTreeList(rs.getString(1), depth + 1);
            }

            c.close();
            stmt.close();
            rs.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    //获取树形列表
    public String getTreeList() {
        String root_id = getRootID();
        String result = "";

        result += getSubTreeList(root_id, 1);

        return result;
    }
}
