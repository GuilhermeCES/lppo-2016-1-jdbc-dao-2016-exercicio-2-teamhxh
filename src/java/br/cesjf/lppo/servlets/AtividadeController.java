package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Atividade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AtividadeController", urlPatterns = {"/atividade/listar.html", "/atividade/cadastrar.html"})
public class AtividadeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().contains("listar.html")) {
            List<Atividade> lista = new ArrayList<>();

            try {
                AtividadeDAOPrep dao = new AtividadeDAOPrep();
                lista = dao.listaTodos();
            } catch (Exception ex) {
                Logger.getLogger(AtividadeController.class.getName()).log(Level.SEVERE, null, ex);
                lista = new ArrayList<Atividade>();
                request.setAttribute("erro", "Problema ao listar as atividades");
            }
            request.setAttribute("atividades", lista);
            request.getRequestDispatcher("/WEB-INF/listar.jsp").forward(request, response);
        } else if (request.getRequestURI().contains("cadastrar.html")) {
            request.getRequestDispatcher("/WEB-INF/novo.jsp").forward(request, response);
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
        if (request.getRequestURI().contains("cadastrar.html")) {
            Atividade novaAti = new Atividade();
            novaAti.setFuncionario(request.getParameter("funcionario"));
            novaAti.setDescricao(request.getParameter("descricao"));
            novaAti.setTipo(request.getParameter("tipo"));
            novaAti.setHoras(Integer.parseInt(request.getParameter("horas")));

            try {
                AtividadeDAOPrep dao = new AtividadeDAOPrep();
                dao.criar(novaAti);
            } catch (Exception ex) {
                Logger.getLogger(AtividadeController.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("listar.html?erro=Erro ao criar atividade");
                return;
            }
            response.sendRedirect("listar.html");
        } 
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
