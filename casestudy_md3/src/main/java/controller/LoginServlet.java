package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        // Giả sử thông tin người dùng tĩnh
        if ("admin".equals(username) && "1234".equals(password)) {
            // Lưu session
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

            // Chuyển hướng đến home.jsp
            resp.sendRedirect("home.jsp");
        } else {
            // Trả về login.jsp với thông báo lỗi
            req.setAttribute("errorMessage", "Invalid username or password!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
