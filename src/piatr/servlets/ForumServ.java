/**
 * Created by piatr on 27.03.17.
 */
package piatr.servlets;

import piatr.logic.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ForumServ extends HttpServlet {
    private ArrayList <Message> messages = new ArrayList<>();
    private static final String MESSAGE = "message";
    private static final String NICK = "nick";
    private static final String GET_MESSAGE = "getMessage";
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    String nick = request.getParameter(NICK);
    String message = request.getParameter(MESSAGE);
    String getMessages = request.getParameter(GET_MESSAGE);
    if ((nick==null||message==null)&(getMessages==null)){
        doGet(request,response);
    }else if (getMessages==null) {
        messages.add(new Message(message, nick));
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<title>Forum</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='forum'>");
        for (Message mes : messages) {
            out.println("<p><strong>" + mes.getNick() + ": </strong>" + mes.getFormattedDate() + "</p>");
            out.println("<p>" + mes.getMessage() + "</p>");
            out.println("<hr>");
        }
        out.println("<hr><br><hr>");
        out.println("<form id=\"form\" action=\"http://localhost:8080/fs.do\" method=\"post\">");
        out.println("<label for=\"nick\">Nickname: </label><br>");
        out.println(" <input name=\"nick\" id=\"nick\" type=\"text\"><br>");
        out.println("<label for=\"message\">Your comment: </label><br>");
        out.println("<textarea name=\"message\" id=\"message\"></textarea><br>");
        out.println("<input type=\"submit\">");
        out.println("</form>");
        out.println("<hr>");
        out.println("<form action=\"/fs.do\" method=\"post\">");
        out.println(" <label for=\"getMessage\">Посмотреть комментарии от: </label>");
        out.println("<input name=\"getMessage\" id=\"getMessage\" type=\"text\">");
        out.println("<input type=\"submit\">");
        out.println("</form>");
        out.println("</body>");
        }else {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<title>Forum</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='forum'>");
        for (Message mes : messages){
            if (mes.getNick().equals(getMessages)){
                out.println("<p><strong>" + mes.getNick() + ": </strong>" + mes.getFormattedDate() + "</p>");
                out.println("<p>" + mes.getMessage() + "</p>");
                out.println("<hr>");
            }
            out.println("<hr>");
            out.println("</body>");
        }
    }
    }
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<title>Forum</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='forum'>");
        for (Message ms: messages){
            out.println("<p><strong>"+ms.getNick()+": </strong>"+ms.getFormattedDate()+"</p>");
            out.println("<p>"+ms.getMessage()+"</p>");
            out.println("<hr>");
        }
        out.println("<hr><br><hr>");
        out.println("<form id=\"form\" action=\"http://localhost:8080/fs.do\" method=\"post\">");
        out.println("<label for=\"nick\">Nickname: </label><br>");
        out.println(" <input name=\"nick\" id=\"nick\" type=\"text\"><br>");
        out.println("<label for=\"message\">Your comment: </label><br>");
        out.println("<textarea name=\"message\" id=\"message\"></textarea><br>");
        out.println("<input type=\"submit\">");
        out.println("</form>");
        out.println("<hr>");
        out.println("<form action=\"/fs.do\" method=\"post\">");
        out.println(" <label for=\"getMessage\">Посмотреть комментарии от: </label>");
        out.println("<input name=\"getMessage\" id=\"getMessage\" type=\"text\">");
        out.println("<input type=\"submit\">");
        out.println("</form>");
        out.println("</body>");
    }
}
