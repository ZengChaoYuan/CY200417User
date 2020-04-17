package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserInfo;
import util.DBUtil;

public class UserInfoDaoImpl implements UserInfoDao {

	@Override
	public UserInfo selectUser(Connection conn, String userName, String password) {
		String sql="SELECT * FROM USER_INFO WHERE USER_NAME= ? AND USER_PWD= ?"; 
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				Long userId=rs.getLong("USER_ID");
				String username=rs.getString("USER_NAME");
				String userNiName=rs.getString("USER_NINAME");
				String userPwd=rs.getString("USER_PWD");
				Date userCtime=rs.getDate("USER_CTIME");
				Long userState=rs.getLong("USER_STATE");
				Long userSex=rs.getLong("USER_SEX");
				String userEdu=rs.getString("USER_EDU");
				String userPro=rs.getString("USER_PRO");
				String userEmail=rs.getString("USER_EMAIL");
				String userTel=rs.getString("USER_TEL");
				Long userScore=rs.getLong("USER_SCORE");
				UserInfo userInfo=new UserInfo(userId,username,
						userNiName,userPwd,userCtime,userState,
						userSex,userEdu,userPro,userEmail,userTel,
						userScore);
				return userInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return null;
	}

	@Override
	public int insertUser(Connection conn, UserInfo userInfo) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="INSERT INTO USER_INFO VALUES(SEQ_USER_INFO.NEXTVAL,?,?,?,SYSDATE,1,?,?,?,?,?,0)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, userInfo.getUserName());
			ps.setString(2, userInfo.getUserNiName());
			ps.setString(3, userInfo.getUserPwd());
			ps.setLong(4, userInfo.getUserSex());
			ps.setString(5, userInfo.getUserEdu());
			ps.setString(6, userInfo.getUserPro());
			ps.setString(7, userInfo.getUserEmail());
			ps.setString(8, userInfo.getUserTel());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConn(conn, ps, rs);
		}	
		return 0;
	}

}
