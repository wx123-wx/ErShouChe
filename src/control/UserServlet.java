package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.User;
import model.UserDao;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private UserDao  dao=new UserDao();
	/**
	 * Servlet澶嶇敤
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//鍙璋冪敤CarServlet 閮戒細杩涘叆杩欎釜鏂规硶锛� 鐒跺悗鍐嶆牴鎹敤鎴蜂紶杩囨潵鐨刴ethod鍙傛暟鍋氬垎娴�
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		switch (method) {
			case "listAll":
			{
				System.out.println("查看所有");
				List<User> users=dao.listAllUsers();
				System.out.println(users.get(0).getXingming());
				System.out.println(users.size());
				
				//璁叉煡璇㈢殑鏁版嵁瀛樺偍鍒皉equest鑼冨洿鍐�
				request.setAttribute("users", users);
				
				//鏁版嵁瀛樺偍瀹屾瘯锛岃烦杞埌椤甸潰涓婂噯澶囧湪椤甸潰涓婃樉绀烘墍鏈変簩鎵嬭溅淇℃伅
				request.getRequestDispatcher("userList.jsp").forward(request, response);
				
				
				break;
			}
			case "add":
			{
				System.out.println("添加");
				break;
			}
			case "update":
			{
				System.out.println("修改");
				break;
			}
			case "delete":
			{
				System.out.println("删除");
				
				break;
			}
	
		}
	}
}
