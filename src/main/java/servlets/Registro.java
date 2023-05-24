/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.mycompany.comparte.resources.Conexion;
import com.mycompany.comparte.resources.Conexion.Usuario;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author USUARIO
 */

@MultipartConfig
public class Registro extends HttpServlet {

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
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String fecha = request.getParameter("fechanacimiento");
        String usuario = request.getParameter("usuario");
        String pwd = request.getParameter("pwd");
        String foto = null;
        
        
        
        ServletContext context = getServletContext();
        String rootPath = context.getRealPath("/");
        
        System.out.println(rootPath);
        String ruta = rootPath.replace("\\", "\\\\");
        
        
        String rutaimagen = rootPath + "/imagenes/";
        
        
        
        String rutaCarpeta = ruta  + "imagenes\\\\";
        System.out.println("RutaCarpeta: "+rutaCarpeta);

        File carpeta = new File(rutaCarpeta);
        boolean creacionExitosa = carpeta.mkdirs();
        if (creacionExitosa) {
            System.out.println("La carpeta se ha creado correctamente.");
        } else {
            System.out.println("No se pudo crear la carpeta.");
        }
        
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();
            
            try (InputStream fileContent = filePart.getInputStream()) {
                foto = rutaimagen+fileName;
                Files.copy(fileContent, Paths.get(rutaimagen + fileName), StandardCopyOption.REPLACE_EXISTING);
                
                System.out.println("Subida completada correctamente.");
            
                Conexion con= new Conexion();

                int resultado = con.agregarUsuario(nombre, apellido, fecha, email, usuario, pwd, foto );

                response.sendRedirect("index.jsp");
                
            } catch (Exception ex) {
                System.out.println("Error en la subida: " + ex.getMessage());
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
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
