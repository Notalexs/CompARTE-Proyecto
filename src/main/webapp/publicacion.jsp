<%-- 
    Document   : publicacion
    Created on : 10 mar 2023, 13:11:59
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&family=Satisfy&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com//ffec4ec2ed.js" crossorigin="anonymous"></script>
    
<link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">

    <link rel="stylesheet" href="menu.css">
    <link rel="stylesheet" href="perfil.css">
    <link rel="stylesheet" href="tablero.css">
    

    <title>CompARTE/Publicar</title>
  </head>
  <body class="back">
    
    <div class="d-flex">

        <div id="sidebar-container" class="bg-primary">
            <div class="logo menu">
                <div class="px-lg-5 py-lg-7 p-4 w-100 mb-auto">
                <img src="compARTEAmarillo.png" class="img-fluid" width="150" height="150">
            </div>
            </div>
            <div class="menu">
                <div class="px-lg-5 py-lg-4 p-4 w-100 mb-auto">
                <a href="Dashboard.jsp" class="d-block p-3 bg-bluee" ><i class="icon ion-md-apps mr-3 lead"></i>Tablero</a>
                <a href="busqueda.jsp" class="d-block p-3 bg-bluee"><i class="icon ion-md-compass mr-3 lead"></i>Búsqueda</a>
                <div class="d-flex p-3">
                    <input type="text" placeholder="Buscar" class="form-control .col-xs-3  bg-bluex">
                    <div class="btn ">
                        <i class="fa fa-search"></i>
                    </div>
                   
                  
                </div>
                <a href="publicacion.jsp" class="d-block p-3 bg-bluee"><i class="icon ion-md-create mr-3 lead"></i>Publicar</a>
                <a href="perfil.jsp" class="d-block p-3 bg-bluee"><i class="icon ion-md-person mr-3 lead"></i>Perfil</a>
                <a href="index.jsp" class="d-block p-3 bg-bluee"><i class="icon ion-md-power mr-3 lead"></i>Cerrar sesión</a>
               
            </div>
            </div>

            <div class="col-lg-4 px-lg-5 py-lg-4 p-4 w-100 mb-auto">
                <div class="d-flex static">
                <div class="profile-picture3 rounded-circle mr-3 ">
                </div>
                <div>
                    <a href="#" class=" d-block bg-bluee mb-0">Annitas</a>
                    <small class="text-muted">Ana Rodriguez</small>
                </div>
                </div>
          
          </div>
  
        
        </div>



        <div class="w-50">
            <nav class="navbar">
              
            
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  
                </div>
              </nav>
        </div>

        <section class="pay-6 w-100">
            <div class="container my-5">
               <div class="row">
   
                   <div class="col-lg-8">
                       <div class="card">
   
                           <div class="card-body d-flex">
                               <div class="d-flex d-flex-grow-1">
                                   <div class="profile-picture3 rounded-circle mr-3"></div>
                                   <a class=" align-self-center bg-bluee ">ANNITAS</a>
                               </div>

                               
                               
                           </div>

                           <div class="align-self-center ">
                            <i class="icon ion-md-archive"></i>

                           </div>
                           <form  enctype = "multipart/form-data" action="NewPost" method="post">
                            <div class="card-body">

                             <p class="letra">Título</p>
                            <input type="text" name="titulo" />  
                            </div> 
                               
                             <div class="card-body">

                             <p class="letra">Foto</p>
                             <input type="file" value="subir" name="file">  
                            </div> 
                               
                            <div class="card-body">

                             <p class="letra">Descripción</p>
                             <textarea type="text" name="descripcion"></textarea>  
                            </div> 
                         

                           <div class="card-body">
                               <p class="letra">Categoría</p>
                               <select name="Categoria" class="mx-5 mb-4">

                                   <option value="1">Pintura</option>

                                   <option value="2">Escritura</option>

                                   <option value="3">Música</option>

                                   <option value="4">Baile</option>

                                   <option value="5">Cine</option>

                                   <option value="6">Escultura</option>

                               </select>


          
                           </div> 


                             <div class="card-body">
                                
                                <button type="submit" class="btn btn-primary w-100 bg-bluey border-0 md-2">Publicar</button>

                             </div> 
                                 </form>

                       </div>
   
                   </div>
   
                   
                
   
               </div>
            </div>
           </section>
   


   <!-- <section id="inicio" class="inicio ">
        <div class="contenido-banner ">
            <div class="contenedor-img">
                <div class="profile-picture4 rounded-circle center"></div>
            </div>
            <h1 class="my-3">ANNITAS</h1>
            <h2 style="font-size:20px">Estudiante de animación digital y amante de las letras</h2>
           
        </div>
    </section>-->

    <!--<section id="sobremi" class="sobremi py-lg-7 ">
        <div class="contenido-seccion">
      <h2>Sobre mí</h2>
      <p><span>¡Hola, mi nombre es Ana!</span></p>
       </div>
 </section>-->



        <footer class="fixed-bottom">
            <div class="text-center p-1" style="background-color: #fffecdd9;">
                <small>&copy; 2023 <b>CompARTE</b> - Todos los Derechos Reservados.</small>
            </div>
          </footer>

          

          

    </div>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>