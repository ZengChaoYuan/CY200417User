package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserInfo;

/**
 * Servlet implementation class PageServlet
 * 专门用来作为页面跳转使用
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		HttpSession session = request.getSession();
		UserInfo user=(UserInfo)session.getAttribute("userInfo");
		if(page !=null && page.equals("addUser")) {
			request.getRequestDispatcher("WEB-INF/"+page + ".html").forward(request, response);
			return;
		}
		if(page == null || user == null) {
			request.getRequestDispatcher("WEB-INF/index.html").forward(request, response);
			return;
		}
		
		if(page != null && user != null){
			request.getRequestDispatcher("WEB-INF/front/content/"+page + ".html").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
