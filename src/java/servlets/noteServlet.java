/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import java.util.*;
import model.Note;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 846582
 */
public class noteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet noteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet noteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Note note = new Note();
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));

            String line = br.readLine();
            List<String> lines = new ArrayList<>();

            while (line != null) {
                lines.add(line);
                line = br.readLine();

            }
            note.setTitle(lines.get(0));
            note.setContents(lines.get(1));
            request.setAttribute("note", note);

        } catch (IOException a) {
            a.printStackTrace();
        }
        String edit = request.getParameter("edit");
        if (edit == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/editNote.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        Note note = new Note(title, contents);
        note.setTitle(title);
        note.setContents(contents);
        request.setAttribute("note", note);

        try {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
            pw.println(title);
            pw.println(contents);

            pw.close();
        } catch (IOException a) {
            a.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);
    }


/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
@Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
