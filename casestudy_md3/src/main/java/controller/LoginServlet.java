package controller;

import service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/view/login/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        // Kiểm tra thông tin đăng nhập thông qua UserService
        if (userService.login(username, password)) {
            // Lưu session nếu đăng nhập thành công
            HttpSession session = req.getSession();
            session.setAttribute("username", username);

            // Lưu cookie nếu "Ghi nhớ đăng nhập" được chọn
            if ("on".equals(remember)) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(60 * 60 * 24 * 7); // 7 ngày
                resp.addCookie(cookie);
            } else {
                // Xóa cookie nếu không chọn "Ghi nhớ đăng nhập"
                Cookie cookie = new Cookie("username", "");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }

            resp.sendRedirect("/home");
        } else {
            // Trả về login.jsp với thông báo lỗi nếu đăng nhập thất bại
            req.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng!");
            req.getRequestDispatcher("WEB-INF/view/login/login.jsp").forward(req, resp);
        }
    }
}
