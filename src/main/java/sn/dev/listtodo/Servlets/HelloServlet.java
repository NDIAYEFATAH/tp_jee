package sn.dev.listtodo.Servlets;

import java.io.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sn.dev.listtodo.entity.Task;
import sn.dev.listtodo.entity.ToDoList;
import sn.dev.listtodo.entity.User;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        // Créer et persister les entités
        User user = new User("abdou", "Passer");
        ToDoList toDoList = new ToDoList();
        Task task = new Task();

        transaction.begin();
        entityManager.persist(user);
        entityManager.persist(toDoList);
        entityManager.persist(task);
        transaction.commit();
        // Hello
       /* PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");*/

        request.getRequestDispatcher("blank.jsp").forward(request,response);
    }

    public void destroy() {
    }
}