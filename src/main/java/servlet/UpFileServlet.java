package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import bean.FileCheck;
import bean.FileInfo;
import bean.JsonMessage;
import bean.UserInfo;
import service.UpFileServiceImpl;

/**
 * Servlet implementation class UpFileServlet
 */
@WebServlet("/UpFileServlet")
public class UpFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpFileServlet() {
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
		//上传文件
		//1.插入文件信息表
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
		Long userId=userInfo.getUserId();
		String fileName=request.getParameter("fileName");
		String fileIntro=request.getParameter("fileIntro");
		String ftIds=request.getParameter("ftId");
		Long ftId=Long.parseLong(ftIds);
		String fileScores=request.getParameter("fileScore");
		String savePath=request.getParameter("savePath");
		Long fileScore=Long.parseLong(fileScores);
		FileInfo fileInfo=new FileInfo();
		fileInfo.setFileName(fileName);
		fileInfo.setFileIntro(fileIntro);
		fileInfo.setTypeId(ftId);
		fileInfo.setUserId(userId);
		fileInfo.setSavePath(savePath);
		fileInfo.setFileScore(fileScore);
		UpFileServiceImpl impl=new UpFileServiceImpl();
		Integer fileInfoIndex=impl.insertByFileInfo(fileInfo);
		Long fileId=fileInfo.getFileId();
		System.out.println(fileId);
		//2.插入文件审核表
		FileCheck fileCheck=new FileCheck();
		fileCheck.setFileId(fileId);
		Integer fileCheckIndex=impl.insertByFileCheck(fileCheck);
		JsonMessage msg=new JsonMessage();
		if(fileInfoIndex>0&&fileCheckIndex>0) {
			msg.setId(1);
			msg.setMsg("上传文件成功!");
		}else {
			msg.setId(2);
			msg.setMsg("上传文件失败!");
		}
		response.getWriter().println(JSONObject.toJSONString(msg));
		
	}

}
