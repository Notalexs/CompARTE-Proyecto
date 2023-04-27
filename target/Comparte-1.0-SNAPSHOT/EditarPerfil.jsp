<%-- 
    Document   : EditarPerfil
    Created on : 10 mar 2023, 13:10:30
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&family=Satisfy&display=swap" rel="stylesheet">


    <link rel="stylesheet" href="style.css">
    <title>CompARTE/Editar Perfil</title>
  </head>
  <body class="bg-blue">
    
    <section>
        <div class="row g-0">
            <div class="col-lg-7 ">

                <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-indicators">
                      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img src="4.jpg" class="d-block w-100  " alt="...">
                      </div>
                      <div class="carousel-item">
                        <img src="5.jpg" class="d-block w-100" alt="...">
                      </div>
                      <div class="carousel-item">
                        <img src="6.jpg" class="d-block w-100" alt="...">
                      </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                      <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                      <span class="carousel-control-next-icon" aria-hidden="true"></span>
                      <span class="visually-hidden">Next</span>
                    </button>
                  </div>









            </div>
            <div class="col-lg-5 d-flex flex-column align-items-end min-vh-100">
                <div class="px-lg-5 pt-lg-4 pb-lg-3 p-4 w-100 mb-auto ">
                <img src="compARTE.png" class="img-fluid" width="150" height="150">
                </div>
                <div class="px-lg-5 py-lg-4 p-4 w-100 mb-auto ">
                    <h1 style="text-align: center;">¡EMPIEZA A EDITAR!</h1>
                    <form >

                    <div class="form-row mb-3 ">
                        <div class="form-group col-md-6">
                            <label class="font-weight-bold">
                                Nombre<span class="text-danger">*</span>
                            <input type="text" class="form-control bg-bluex border-0" placeholder="Tu nombre">
                        </div>
                        <div class="form-group col-md-6">
                            <label class="font-weight-bold">
                                Apellido<span class="text-danger">*</span>
                            <input type="text" class="form-control bg-bluex border-0" placeholder="Tu apellido">
                        </div>
                        <div class="form-group col-md-6">
                            <label class="font-weight-bold">
                                Fecha de nacimiento<span class="text-danger">*</span>
                            <input type="date" class="form-control bg-bluex border-0">
                        </div>
                        <div class="form-group col-md-6">
                            <label class="font-weight-bold">
                               Correo electrónico<span class="text-danger">*</span>
                            <input type="email" class="form-control bg-bluex border-0" placeholder="Tu correo electrónico">
                        </div>
                       
                        <div class="form-group col-md-6">
                            <label class="font-weight-bold">
                              Contraseña<span class="text-danger">*</span>
                            <input type="password" class="form-control bg-bluex border-0" placeholder="Tu contraseña">
                            <p></p>
                            <button type="submit" class="btn btn-primary  bg-bluey border-0 md-2 py-lg-4">Registrar</button>
                        </div>
                        
                        
                        

                        
                    </div>



                    </form>

                    
                 </div>
                 
             </div>

        </div>
    </section>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
  </body>
</html>