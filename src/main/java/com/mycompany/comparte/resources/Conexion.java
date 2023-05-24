/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comparte.resources;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class Conexion {

Connection ccn = null;
Statement st = null;
public static String user,pwd;
public static boolean exito = false;
public static int idUsuario = 0;
public static int idLibro = 0;
    public Conexion() throws ClassNotFoundException{
        try  
            {
                
                Class.forName("com.mysql.jdbc.Driver");
                //En esta parte hace la conexion con la base de datos 
                ccn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/comparte","root", "");
                  st = ccn.createStatement();
                  exito=true;
            } catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null, "CONEXION ERRONEA " + e);  
                }
    }
    
    
    // USER VARIABLES
    
    public class Usuario{
        public String usuario;
        public String pwd; 
        public String nombre;
        public String apellido;
        public String email;
        public String fechaNac;
        public String fechaCrea;
        public String foto;
        public int idUsuario;
    }
    
    
       
    
    
    
    // CRUD USER INFO WITHOUT DELETE
    
    public Usuario leerUsuario(String usuario) throws SQLException{
        
        Usuario user = null;
        
        String query = "SELECT * from usuario WHERE usuario='"+usuario+"';";
        
        System.out.println(query);
        
        //rA=st.executeUpdate(query);
        
        ResultSet rs = st.executeQuery(query);
        
        if (rs.next()) {
            user = new Usuario();
            
            user.nombre = rs.getString("nombre");
            user.apellido = rs.getString("apellido");
            user.email = rs.getString("email");
            user.usuario = rs.getString("usuario");
            
            // Optionally, you can print the retrieved data for debugging
            System.out.println("Usuario: " + user.usuario);
            System.out.println("Nombre: " + user.nombre);
            System.out.println("Apellido: " + user.apellido);
            // Print other attributes

            // Close the result set (optional)
            
        }
        
        rs.close();
        System.out.println("User: "+user);
        return user;
        
    }
  
    public int agregarUsuario(String nombre, String apellido, String fecha, String email, String usuario, String pwd, String foto) throws SQLException{
        int rA=0;
        String query = "insert into usuario(nombre,apellido,email,contrasena,usuario,fechanac,fechacrea,imagen) values('"+nombre+"','"+apellido+"','"+email+"','"+pwd+"','"+usuario+"','"+fecha+"',NOW(),'"+foto+"');";
        System.out.println("Esta es la query de agregarusuario: "+query);
        rA=st.executeUpdate(query);
        return rA;
    }
      
    public int editarUsuario(String nombre, String apellido, String fecha, String email, String pwd,String foto) throws SQLException{
        
        int rA=0;
        
        String query = 
        "update usuario "
        +"set nombre = '"+nombre+"',apellido = '"+apellido+"',email='"+email+"',contrasena='"+pwd+"',fechanac='"+fecha+"',imagen='"+foto+"';";
        
        System.out.println(query);
        
        rA=st.executeUpdate(query);
        
        return rA;
        
    }
    
    public int validarUsuario(String usu) throws SQLException{
        
        int e=0;
        
        Usuario usuario = null;
        
        String query = "select * from usuario where usuario='"+usu+"' ";
         
        ResultSet rs=st.executeQuery(query);
        
        while(rs.next()){
           e=1; 
        }
        
        return e;
    }
    
    public Usuario login(String usu, String pwd) throws SQLException, IOException{
        Usuario usuario = null;
        String query = "select * from usuario where email='"+usu+"' and contrasena='"+pwd+"'";
         
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            usuario =new Usuario();
            usuario.idUsuario= rs.getInt(1);
            usuario.nombre = rs.getString("nombre");
            usuario.apellido = rs.getString("apellido");
            usuario.email = rs.getString("email");
            usuario.usuario = rs.getString("usuario");
            usuario.foto = rs.getString("imagen");
        }
        
        
        
        
        
        
        return usuario;
    }
        
    
    
    // CRUD POST
    
    
    
    /*
    public Post leerPost(String usuario) throws SQLException{
        
        Post post = new Post();
        
        String query = "SELECT * from post WHERE idusuario='"+usuario+"';";
        
        System.out.println(query);
        
        ResultSet rs = st.executeQuery(query);
        
        if (rs.next()) {
            
            
            post.categoria = rs.getString("nombre");
            post.descripcion = rs.getString("apellido");
            post.foto = rs.getString("usuario");
            post.titulo = rs.getString("usuario");
            
            // Optionally, you can print the retrieved data for debugging
            System.out.println("Usuario: " + post.categoria);

            // Print other attributes

            // Close the result set (optional)
            
        }
        
        rs.close();
        System.out.println("User: "+user);
        
        
        return post;
    
    
    
    }
    
    */
    public int agregarPost(String titulo, String foto, String descripcion,String categoria, String idusuario) throws SQLException{
                
        int rA=0;
        String query = 
                "insert into post"
                + "(categoria,descripcion,idusuario,titulo,foto,fechacrea)"
                + "values('"+categoria+"','"+descripcion+"','"+idusuario+"','"+titulo+"','"+foto+"',NOW()');";
        System.out.println(query);
        rA=st.executeUpdate(query);
        return rA;

    }
    
    
    public int actualizarPost(String titulo, String foto, String descripcion,String categoria, String idusuario) throws SQLException{
        
        int rA=0;
        
        String query = 
        "update post "
        +"set categoria = '"+categoria+"',descripcion = '"
        + ""+descripcion+"','idusuario = '"+idusuario+"',titulo = '"
        + ""+titulo+"',imagen='"+foto+"';";
        
        System.out.println(query);
        
        rA=st.executeUpdate(query);
        
        return rA;
        
    }
    
    
    public int eliminarPost(String idpost) throws SQLException{
    
        int rA=0;

        String query = 
        "delete from post where idpost='"+idpost+"';";
        
        System.out.println(query);
        
        rA=st.executeUpdate(query);
        
        return rA;
    }
    
    
    
    
    
    
    
    
    
    /*
        public int agregarUsuario(String nombre, String app, String apm, String tel,String email) throws SQLException{
            int rA=0;
            String query = "insert into usuarios(nombre,app,apm,tel,email) values('"+nombre+"','"+app+"','"+apm+"','"+tel+"','"+email+"');";
            rA=st.executeUpdate(query);
            return rA;
        }
    
    */
    
    
    public int agregarAutor(String nombre,String pais) throws SQLException{
        int rA=0;
        String query = "insert into autores(nombre,pais) values('"+nombre+"','"+pais+"');";
        rA=st.executeUpdate(query);
        return rA;
    }
     
    public int eliminarLibro(int id) throws SQLException{
        int rA=0;
        String query = "delete from libros where id= "+id;
        rA=st.executeUpdate(query);
        return rA;
    }
    
    public int eliminarUsuario(int id) throws SQLException{
        int rA=0;
        String query = "delete from usuarios where id= "+id;
        rA=st.executeUpdate(query);
        return rA;
    }
    
    
    public int eliminarAutor(int id) throws SQLException{
        int rA=0;
        String query = "delete from autores where id= "+id;
        rA=st.executeUpdate(query);
        return rA;
    }
    
    public int modificarLibro(int id,String titulo, String isbn, int cantidad, int anio) throws SQLException{
        int rA=0;
        String query = "update libros set titulo='"+titulo+"',isbn='"+isbn+"', cantidad="+cantidad+", anio_publicacion="+anio+" where id= "+id;
        rA=st.executeUpdate(query);
        return rA;
    }
    
    public int modificarUsuario(int id,String nombre, String app, String apm, String tel,String email) throws SQLException{
        int rA=0;
        String query = "update usuarios set nombre='"+nombre+"',app='"+app+"', apm='"+apm+"', tel='"+tel+"' email='"+email+"' where id= "+id;
        rA=st.executeUpdate(query);
        return rA;
    }
    
    public int modificarAutor(int id,String nombre,String pais) throws SQLException{
        int rA=0;
        String query = "update autores set nombre='"+nombre+"',pais='"+pais+"' where id= "+id;
        rA=st.executeUpdate(query);
        return rA;
    }
//    
//    public ArrayList<Libros> listarTodosLibros() throws SQLException{
//        Libros libro = null;
//        String query = "select * from libros";
//        ArrayList<Libros> lst=new ArrayList<Libros>();
//        ResultSet rs=st.executeQuery(query);
//        while(rs.next()){
//            libro =new Libros();
//            libro.id = rs.getInt(1);
//            libro.setTitulo(rs.getString("titulo"));
//            libro.setCantidad(rs.getInt("cantidad"));
//            libro.setAnio(rs.getInt("anio_publicacion"));
//            libro.setIsbn(rs.getString("isbn"));
//            lst.add(libro);
//        }
//        return lst;
//    }
//           
    
//    public ArrayList<Usuario> listarTodosUsuarios() throws SQLException{
//        Libros libro = null;
//        String query = "select * from libros";
//        ArrayList<Usuario> lst=new ArrayList<Usuario>();
//        ResultSet rs=st.executeQuery(query);
//        while(rs.next()){
//            Usuario usuario=new Usuario();
//            usuario.setId(rs.getInt(1));
//            usuario.setNombre(rs.getString("nombre"));
//            usuario.setApp(rs.getString("app"));
//            usuario.setApm(rs.getString("apm"));
//            lst.add(usuario);
//        }
//        return lst;
//    }
//    
//    public Usuario listarPosicionUsuario(String pos) throws SQLException{
//        Usuario usuario = null;
//        String query = "select * from usuarios order by id "+pos+ " limit 1";
//         
//        ResultSet rs=st.executeQuery(query);
//        while(rs.next()){
//            usuario=new Usuario();
//            usuario.setId(rs.getInt(1));
//            usuario.setNombre(rs.getString("nombre"));
//            usuario.setApp(rs.getString("app"));
//            usuario.setApm(rs.getString("apm"));
//            usuario.setTel(rs.getString("tel"));
//            usuario.setEmail(rs.getString("email"));
//          
//        }
//        return usuario;
//    }
//    
//     public Libros listarPosicionLibro(String pos) throws SQLException{
//        Libros libro = null;
//        String query = "select * from libros order by id "+pos+ " limit 1";
//         
//        ResultSet rs=st.executeQuery(query);
//        while(rs.next()){
//            libro =new Libros();
//            libro.id = rs.getInt(1);
//            libro.setTitulo(rs.getString("titulo"));
//            libro.setCantidad(rs.getInt("cantidad"));
//            libro.setAnio(rs.getInt("anio_publicacion"));
//            libro.setIsbn(rs.getString("isbn"));
//          
//        }
//        return libro;
//    }
//        
//    public Usuario listarPosicionNumUsuario( int i) throws SQLException{
//        Usuario usuario = null;
//        String query = "select * from usuarios where id = "+i;
//         
//        ResultSet rs=st.executeQuery(query);
//        while(rs.next()){
//            usuario=new Usuario();
//            usuario.setId(rs.getInt(1));
//            usuario.setNombre(rs.getString("nombre"));
//            usuario.setApp(rs.getString("app"));
//            usuario.setApm(rs.getString("apm"));
//            usuario.setTel(rs.getString("tel"));
//            usuario.setEmail(rs.getString("email"));
//          
//        }
//        return usuario;
//    }
//    
//    
//      public Libros listarPosicionNumLibro( int i) throws SQLException{
//        Libros libro = null;
//        String query = "select * from libros where id = "+i;
//         
//        ResultSet rs=st.executeQuery(query);
//        while(rs.next()){
//            libro =new Libros();
//            libro.id = rs.getInt(1);
//            libro.setTitulo(rs.getString("titulo"));
//            libro.setCantidad(rs.getInt("cantidad"));
//            libro.setAnio(rs.getInt("anio_publicacion"));
//            libro.setIsbn(rs.getString("isbn"));
//          
//        }
//        return libro;
//    }
//        
//     public ArrayList<Autores> listarTodosAutores() throws SQLException{
//        Libros libro = null;
//        String query = "select * from autores";
//        ArrayList<Autores> lst=new ArrayList<Autores>();
//        ResultSet rs=st.executeQuery(query);
//        while(rs.next()){
//            Autores autor=new Autores();
//            autor.setId(rs.getInt(1));
//            autor.setNombre(rs.getString("nombre"));
//            autor.setPais(rs.getString("pais"));
//            lst.add(autor);
//        }
//        return lst;
//    } 
//     
//    
    public Connection getConnection(){
        return ccn;
    }
    
    public void Desconexion(){
        try {
            ccn.close();            
            System.exit(0);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}