package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import bean.JsonMessage;
import bean.UserInfo;
import bean.FileCheckInfo;

import service.MyFileInfoServiceImpl;

/**
 * Servlet implementation class MyFileInfoServlet
 */
@WebServlet("/MyFileInfoServlet")
public class MyFileInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFileInfoServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
		Long userId=userInfo.getUserId();
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String ftIds=request.getParameter("ftId");
		Long ftId=Long.parseLong(ftIds);
		String checkStates=request.getParameter("checkState");
		Long checkState=Long.parseLong(checkStates);
		String start=request.getParameter("start");
		String limit=request.getParameter("limit");
		MyFileInfoServiceImpl impl=new MyFileInfoServiceImpl();
		List<FileCheckInfo> myFileInfo=impl.selectPage(userId, startTime, endTime, ftId, checkState, start, limit);
		Long count=impl.countPage(userId, startTime, endTime, ftId, checkState);
		JsonMessage msg=new JsonMessage();
		msg.getDataList().put("myFileInfo", myFileInfo);
		msg.getDataList().put("count", count);
		response.getWriter().println(JSONObject.toJSONString(msg));	
	}

}
