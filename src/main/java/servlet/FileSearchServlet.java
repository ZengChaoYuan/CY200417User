package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import bean.FileSearch;
import bean.JsonMessage;
import service.FileSearchServiceImpl;

/**
 * Servlet implementation class FileSearchServlet
 */
public class FileSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileSearchServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String fileName=request.getParameter("fileName");
		//初始化好的参数
		String start=request.getParameter("start");
		String limit=request.getParameter("limit");
		FileSearchServiceImpl iml=new FileSearchServiceImpl();
		List<FileSearch> fileSearch=iml.selectPage(fileName, start, limit);
		Long count=iml.countPage(fileName);
		JsonMessage msg=new JsonMessage();
		msg.getDataList().put("fileSearch", fileSearch);
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
