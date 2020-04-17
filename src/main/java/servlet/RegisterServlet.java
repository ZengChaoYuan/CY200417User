package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import bean.JsonMessage;
import bean.UserInfo;
import service.UserInfoService;
import util.ServiceFactory;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String userName=request.getParameter("adduserName");
		String userNiName=request.getParameter("adduserNiName");
		String password=request.getParameter("addPwd");
		String userSexs=request.getParameter("adduserSex");
		Long userSex=Long.parseLong(userSexs);
		String userEdu=request.getParameter("adduserEdu");
		String userPro=request.getParameter("adduserPro");
		String userEmail=request.getParameter("adduserEmail");
		String userTel=request.getParameter("adduserTel");
		UserInfo userInfo=new UserInfo();
		userInfo.setUserName(userName);
		userInfo.setUserNiName(userNiName);
		userInfo.setUserPwd(password);
		userInfo.setUserSex(userSex);
		userInfo.setUserEdu(userEdu);
		userInfo.setUserPro(userPro);
		userInfo.setUserEmail(userEmail);
		userInfo.setUserTel(userTel);
		UserInfoService info=(UserInfoService)ServiceFactory.getServiceImpl(UserInfoService.class.getName());
		int result=info.register(userInfo);
		JsonMessage msg=new JsonMessage();
		if(result>0) {
			msg.setId(1);
			msg.setMsg("注册成功！");
		}else{
			msg.setId(2);
			msg.setMsg("注册失败！");
		}
		String json=JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}

}
