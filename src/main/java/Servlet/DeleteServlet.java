package main.java.Servlet;

import main.java.Bean.UnitTreeNode;
import main.java.Service.TreeNodeService;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    //处理post动作
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        TreeNodeService treeNodeService = new TreeNodeService();
        String id = request.getParameter("id");
        int state = 0;

        //要求所有信息不能为空
        if (!id.trim().isEmpty()){
            state = treeNodeService.delete(id);
            if(state == 1) {
                request.setAttribute("msg", "删除成功");
            } else {
                request.setAttribute("msg", "结点不存在");
            }
        }else {
            request.setAttribute("msg", "信息" + "不完整");
        }

        request.getRequestDispatcher("/msg.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
