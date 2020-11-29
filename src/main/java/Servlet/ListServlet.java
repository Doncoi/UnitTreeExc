package main.java.Servlet;

import main.java.Service.TreeListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TreeListService listService = new TreeListService();
        String tree_list = listService.getTreeList();

        System.out.println(tree_list);

        request.setAttribute("treelist",tree_list);
        request.getRequestDispatcher("/list.jsp").forward(request,response);

//        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
