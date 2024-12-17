package sn.dev.listtodo.Servlets;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.dev.listtodo.entity.Task;
import sn.dev.listtodo.entity.ToDoList;
import sn.dev.listtodo.entity.User;

import java.io.IOException;
@WebServlet(name = "TodoTaskServlet", urlPatterns = {   "*.todo"})
public class TodoTaskServlet extends HttpServlet {
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = managerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        int idUser = Integer.parseInt(request.getParameter("idU"));
        User user = entityManager.find(User.class, idUser);
        request.setAttribute("user", user);
        System.out.println(user.getUsername());

//        transaction.begin();
//        entityManager.persist(user);
//        entityManager.persist(toDoList);
//        entityManager.persist(task);
//        transaction.commit();
        // Hello
       /* PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");*/

        request.getRequestDispatcher("blank.jsp").forward(request,response);
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public void destroy() {
    }
}
