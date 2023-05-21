package servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */



import com.mycompany.comparte.resources.Conexion;
import com.mycompany.comparte.resources.Conexion.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lalom
 */

@MultipartConfig
public class Perfil extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
    
    }
        
    private void obtaindata(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {

        HttpSession session = request.getSession();
        
        String usuario = (String) session.getAttribute("usuario");
        
        Conexion con= new Conexion();
        
        if(usuario!=null){
            
            System.out.println("usuario isnt empty"); // Logging statement

            Usuario user = con.leerUsuario(usuario);
            
            session.setAttribute("User", user.usuario);
            session.setAttribute("Name", user.nombre);
            session.setAttribute("lastname", user.apellido);
            session.setAttribute("fechanac", user.fechaNac);
            session.setAttribute("email", user.email);
            session.setAttribute("foto", user.foto);
            
            

            
            
            
            
        }else{
            session.setAttribute("error", "El usuario o contraseña son incorrectos");
            response.sendRedirect("index.jsp");
            response.setStatus(500);
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
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
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
        
        System.out.println("Entró a doPost");
        
        try {
                obtaindata(request, response);
            } catch (Exception ex) {
                Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
                response.setStatus(500); // Internal Server Error
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

    