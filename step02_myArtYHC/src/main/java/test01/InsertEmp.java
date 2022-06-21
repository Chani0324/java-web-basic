package test01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertEmp")
public class InsertEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertEmp() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String command = request.getParameter("command");
		if (command != null && command.length() != 0) {

			if (command.equals("sign-up")) {
				String email = request.getParameter("email");
				String psw = request.getParameter("psw");
				String pswRepeat = request.getParameter("psw-repeat");

				if (!psw.equals(pswRepeat)) {
					out.println("비밀번호와 재입력 비밀번호가 일치하지 않습니다.");
				} else {
					out.println("회원가입 축하드립니다.");
					out.println("귀하의 id는 " + email + "입니다.");
					out.println("지금부터 다양한 서비스 이용 가능합니다.");
				}
			}else { 
				out.println("잘못된 선택입니다.");
			}
		} else {
			out.println("비정상 접근");
		}

	}
}
