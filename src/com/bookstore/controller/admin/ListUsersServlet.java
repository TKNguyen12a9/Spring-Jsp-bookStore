package com.bookstore.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.User;
import com.bookstore.service.UserServices;

@WebServlet("/admin/list_users")
public class ListUsersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public ListUsersServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServices userServices = new UserServices();

		List<User> userList = userServices.listUser();
		System.out.println("userList" + userList);
		request.setAttribute("userList", userList);

		String listPage = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
}









