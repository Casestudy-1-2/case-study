
package controller;


import dto.TrainerDTO;
import model.GymClass;
import model.Trainer;
import service.IGymClassService;
import service.ITrainerService;
import service.impl.GymClassService;
import service.impl.TrainerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TrainerController", value = "/trainer")
public class TrainerController extends HttpServlet {
    private static ITrainerService trainerService = new TrainerService();
    private static IGymClassService gymClassService = new GymClassService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.setAttribute("gymClasses", gymClassService.getAll());
                req.getRequestDispatcher("WEB-INF/view/trainer/create.jsp").forward(req, resp);
                break;
            case "update":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteTrainer(req, resp);
                break;
            default:
                String message = req.getParameter("message");
                if(message != null) {
                    if(message.equals("deleted")) {
                        req.setAttribute("message", "Xóa thành công.");
                    }else if(message.equals("created")){
                        req.setAttribute("message", "Thêm mới thành công.");
                    }
                }
                List<TrainerDTO> trainers = trainerService.getAllTrainerDTO();
                req.setAttribute("trainers", trainers);
                req.getRequestDispatcher("WEB-INF/view/trainer/list.jsp").forward(req, resp);
        }
    }

    private static void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            Trainer trainerToUpdate = trainerService.getById(Integer.parseInt(id));
            req.setAttribute("trainer", trainerToUpdate);
            List<GymClass> gymClasses = gymClassService.getAll();
            req.setAttribute("gymClasses", gymClasses);

            req.getRequestDispatcher("WEB-INF/view/trainer/update.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/trainer");
        }
    }

    private static void deleteTrainer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTodelete = req.getParameter("id");
        if(idTodelete != null) {
            trainerService.delete(Integer.parseInt(idTodelete));
            resp.sendRedirect("/trainer?message=deleted");
        }else{
            resp.sendRedirect("/trainer");
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
                String name = req.getParameter("name");
                String specialization = req.getParameter("specialization");
                String phone = req.getParameter("phone");
                Integer idClass = Integer.valueOf(req.getParameter("idClass"));
                Trainer trainer = new Trainer(name, specialization, phone, idClass);
                trainerService.add(trainer);
                resp.sendRedirect("/trainer?message=created");
                break;
            case "update":
                updateTrainer(req, resp);
                break;
        }
    }



    private static void updateTrainer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String updatedName = req.getParameter("updatedName");
        String updatedSpecialization = req.getParameter("updatedSpecialization");
        String updatedPhone = req.getParameter("updatedPhone");
        String updatedClassId = req.getParameter("updatedClassId");
        if (id == null || updatedName == null || updatedSpecialization == null || updatedPhone == null) {
            resp.sendRedirect("/trainer");
            return;
        }
        Trainer trainer = trainerService.getByIdTrainer(Integer.parseInt(id));
        if (trainer != null) {
            trainer.setName(updatedName);
            trainer.setSpecialization(updatedSpecialization);
            trainer.setPhone(updatedPhone);
            if (updatedClassId != null && !updatedClassId.isEmpty()) {
                trainer.setIdClass(Integer.parseInt(updatedClassId));
            }
            trainerService.update(trainer);
            resp.sendRedirect("/trainer?message=updated");
        } else {
            resp.sendRedirect("/trainer");
        }
    }
}
