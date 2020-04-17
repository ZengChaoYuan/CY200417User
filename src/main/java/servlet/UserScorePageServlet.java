package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import bean.JsonMessage;
import bean.UserInfo;
import bean.UserScore;
import service.UserScoreServiceImpl;

/**
 * Servlet implementation class UserScorePageServlet
 */
public class UserScorePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserScorePageServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
		Long userId=userInfo.getUserId();
		String start=request.getParameter("start");
		String limit=request.getParameter("limit");
		UserScoreServiceImpl impl=new UserScoreServiceImpl();
		List<UserScore> userScore=impl.selectPage(userId, start, limit);
		Long count=impl.countPage(userId);
		JsonMessage msg=new JsonMessage();
		msg.getDataList().put("userInfo", userInfo);
		msg.getDataList().put("userScore", userScore);
		msg.getDataList().put("count", count);
		response.getWriter().println(JSONObject.toJSONString(msg));	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
