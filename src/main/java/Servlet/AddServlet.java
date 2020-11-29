package main.java.Servlet;

import main.java.Bean.UnitTreeNode;
import main.java.Service.TreeNodeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.tree.TreeNode;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    //处理post动作
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        TreeNodeService treeNodeService = new TreeNodeService();
        UnitTreeNode node = new UnitTreeNode();

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String parentid = request.getParameter("parentid");

        //要求所有信息不能为空
        if (!name.trim().isEmpty() && !id.trim().isEmpty() && !parentid.trim().isEmpty()){
            node.setId(id);
            node.setName(name);
            node.setPid(parentid);
            treeNodeService.add(node);
            request.setAttribute("msg", "恭喜，成功添加结点");
        }else {
            request.setAttribute("msg", "信息不完整");
        }

        request.getRequestDispatcher("/msg.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}