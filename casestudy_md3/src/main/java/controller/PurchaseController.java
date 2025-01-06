package controller;

import dto.CustomerDTO;
import dto.PurchaseDTO;
import model.Customer;
import model.GymCard;
import model.GymClass;
import model.Purchase;
import service.ICustomerService;
import service.IGymCardService;
import service.IPurchaseService;
import service.impl.CustomerService;
import service.impl.GymCardService;
import service.impl.PurchaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "PurchaseController", value = "/purchase")
public class PurchaseController extends HttpServlet {
    private static IPurchaseService purchaseService = new PurchaseService();
    private static ICustomerService customerService = new CustomerService();
    private static IGymCardService gymCardService = new GymCardService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        String search = req.getParameter("search");
        switch (action) {
            case "create":
                List<CustomerDTO> customers = customerService.getAllDTO();
                req.setAttribute("customers", customers);
                List<GymCard> gymCards = gymCardService.getAll();
                req.setAttribute("gymCards", gymCards);
                req.getRequestDispatcher("WEB-INF/view/purchase/create.jsp").forward(req, resp);
                break;
            case "update":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteController(req, resp);
                break;
            default:
                String message = req.getParameter("message");
                if (message != null) {
                    if (message.equals("deleted")) {
                        req.setAttribute("message", "Xóa thành công.");
                    } else if (message.equals("created")) {
                        req.setAttribute("message", "Têm mới thành công.");
                    }
                }
                List<PurchaseDTO> purchases;
                if (search != null && !search.isEmpty()) {
                    purchases = purchaseService.searchByCustomerName(search);
                } else {
                    purchases = purchaseService.getAllDTO();
                }
                req.setAttribute("purchases", purchases);
                req.getRequestDispatcher("WEB-INF/view/purchase/list.jsp").forward(req, resp);
                break;


        }
    }

    private void deleteController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idToDelete = req.getParameter("id");
        if (idToDelete != null) {
            purchaseService.delete(Integer.parseInt(idToDelete));
            resp.sendRedirect("/purchase?message=deleted");
        } else {
            resp.sendRedirect("/purchase");
        }
    }

    private static void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            Purchase purchaseToUpdate = purchaseService.getById(Integer.parseInt(id));
            req.setAttribute("purchase", purchaseToUpdate);
            List<CustomerDTO> customers = customerService.getAllDTO();
            req.setAttribute("customers", customers);
            List<GymCard> gymCards = gymCardService.getAll();
            req.setAttribute("gymCards", gymCards);
            req.getRequestDispatcher("WEB-INF/view/purchase/update.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/purchase");
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
                String customerIdStr = req.getParameter("customerId");
                String cardIdStr = req.getParameter("cardId");
                String purchaseDate = req.getParameter("purchaseDate");
                String totalPriceStr = req.getParameter("totalPrice");
                String validUntil = req.getParameter("validUntil");
                if (customerIdStr == null || cardIdStr == null || purchaseDate == null || totalPriceStr == null || validUntil == null) {
                    req.setAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin.");
                    req.getRequestDispatcher("WEB-INF/view/purchase/create.jsp").forward(req, resp);
                    return;
                }
                int customerId = Integer.parseInt(customerIdStr);
                int cardId = Integer.parseInt(cardIdStr);
                double totalPrice = Double.parseDouble(totalPriceStr);
                Purchase purchase = new Purchase(customerId, cardId, purchaseDate, totalPrice, validUntil);
                purchaseService.add(purchase);
                resp.sendRedirect("/purchase");
                break;
            case "update":
                updatePurchase(req, resp);
                break;

            default:
                break;

        }
    }

    private static void updatePurchase(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String purchaseIdStr = req.getParameter("purchaseId");
        String updatedCustomerIdStr = req.getParameter("customerId");
        String updatedCardIdStr = req.getParameter("cardId");
        String updatedPurchaseDate = req.getParameter("purchaseDate");
        String updatedTotalPriceStr = req.getParameter("totalPrice");
        String updatedValidUntil = req.getParameter("validUntil");
        if (purchaseIdStr == null || updatedCustomerIdStr == null || updatedCardIdStr == null || updatedPurchaseDate == null || updatedTotalPriceStr == null || updatedValidUntil == null) {
            resp.sendRedirect("/purchase");
            return;
        }
        try {
            int purchaseId = Integer.parseInt(purchaseIdStr);
            double updatedTotalPrice = Double.parseDouble(updatedTotalPriceStr);
            Purchase purchase = purchaseService.getById(purchaseId);
            if (purchase != null) {
                int updatedCustomerId = Integer.parseInt(updatedCustomerIdStr);
                int updatedCardId = Integer.parseInt(updatedCardIdStr);
                Date purchaseDate = Date.valueOf(updatedPurchaseDate);
                Date validUntil = Date.valueOf(updatedValidUntil);
                purchase.setCustomerId(updatedCustomerId);
                purchase.setCardId(updatedCardId);
                purchase.setPurchaseDate(purchaseDate);
                purchase.setTotalPrice(updatedTotalPrice);
                purchase.setValidUntil(validUntil);
                purchaseService.update(purchase);
                resp.sendRedirect("/purchase?message=updated");
            } else {
                resp.sendRedirect("/purchase");
            }
        } catch (IllegalArgumentException e) {
            resp.sendRedirect("/purchase?message=error");
        }
    }
}
