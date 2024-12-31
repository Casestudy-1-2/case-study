package controller;

import dto.CustomerDTO;
import entity.Customer;
import service.ICustomerService;
import service.IGymClassService;
import service.impl.CustomerService;
import service.impl.GymClassService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerController", value = "/customer")
public class CustomerController extends HttpServlet {
    private static ICustomerService customerService = new CustomerService();
    private static IGymClassService gymClassService = new GymClassService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                req.setAttribute("gymClasses", gymClassService.getAll());
                req.getRequestDispatcher("WEB-INF/view/customer/create.jsp").forward(req, resp);
                break;
            case "update":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteCustomer(req, resp);
                break;
            default:
                List<CustomerDTO> customers = customerService.getAllDTO();
                req.setAttribute("customers", customers);
                req.getRequestDispatcher("WEB-INF/view/customer/list.jsp").forward(req, resp);
                break;
        }
    }

    private static void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            Customer customerToUpdate = customerService.getById(Integer.parseInt(id));
            req.setAttribute("customer", customerToUpdate);
            req.getRequestDispatcher("WEB-INF/view/customer/update.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/customer");
        }
    }

    private static void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idToDelete = req.getParameter("id");
        if (idToDelete != null) {
            customerService.delete(Integer.parseInt(idToDelete));
            resp.sendRedirect("/customer?message=deleted");
        } else {
            resp.sendRedirect("/customer");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                insertCustomer(req, resp);
                break;
            case "update":
                updateCustomer(req, resp);
                break;
        }
    }

    private static void insertCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone = req.getParameter("phone");
        Integer idClass = Integer.valueOf(req.getParameter("idClass"));

        Customer customer = new Customer(name, age, phone, email, idClass);
        customerService.add(customer);
        resp.sendRedirect("/customer?message=created");
    }

    private static void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");

        String updatedName = req.getParameter("updatedName");
        String updatedAge = req.getParameter("updatedAge");
        String updatedPhone = req.getParameter("updatedPhone");
        String updatedEmail = req.getParameter("updatedEmail");

        if (id == null || updatedName == null) {
            resp.sendRedirect("/customer");
            return;
        }

        Customer customer = customerService.getById(Integer.parseInt(id));
        if (customer != null) {

            if (updatedName != null && !updatedName.isEmpty()) {
                customer.setName(updatedName);
            }
            if (updatedAge != null && !updatedAge.isEmpty()) {
                customer.setAge(Integer.parseInt(updatedAge));
            }
            if (updatedPhone != null && !updatedPhone.isEmpty()) {
                customer.setPhone(updatedPhone);
            }
            if (updatedEmail != null && !updatedEmail.isEmpty()) {
                customer.setEmail(updatedEmail);
            }

            customerService.update(customer);

            resp.sendRedirect("/customer?message=updated");
        } else {
            resp.sendRedirect("/customer");
        }
    }
}
