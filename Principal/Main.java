package Principal;

import Producto.Libro;
import Bases.Exceptions.*;
import Bases.Verificacion;
import Clientes.*;
import Personal.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author DAPG1
 */
public class Main {

    public static void main(String[] args) {

        boolean sesion = false, usuario = false, salir = false, salir2 = false, salirT = false, cierto = false, cierto2 = false;
        long id=0L;
        int opcion = 0, opcion1 = 0, tUsuario = 0, telefono = 0, edad=0;
        String nombre = "", apellido = "", contrasena = "", correo = "";
        String titulo="", autor="", genero="";
        Scanner sc = new Scanner(System.in);
        Libro libro=null;
        ArrayList <Libro> listaLibros;

        //Declaración del administrador, bibliotecario y user
        Administrador GOD = Administrador.getInstance();
        Administrador.crearRegistro("Registro Usuarios");
        Administrador.crearRegistro("Registro Libros");
        Bibliotecario TECARIO = Bibliotecario.getInstance();
        Usuario user = null;
        Invitado invitado = null;

        System.out.println("Bienvenido a Biblioteca Athos");

        do {
            do {
                sesion = false;
                System.out.println("\nQue desea hacer?");
                System.out.println("(1) Iniciar Sesión");
                System.out.println("(2) Registrarse");
                System.out.println("(3) Ingresar como invitado");
                System.out.println("(4) Salir");
                System.out.print("La opcion es: ");
                try {
                    opcion = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Se esperaba que ingrese un numero");
                    opcion = 20;
                }
                sc.nextLine();

                switch (opcion) {
                    //INICIAR SESION
                    case 1:
                        do {
                            System.out.print("Ingrese el nombre: ");
                            nombre = sc.nextLine();
                            System.out.print("Ingrese el apellido: ");
                            apellido = sc.nextLine();
                            System.out.print("Ingrese la contraseña: ");
                            contrasena = sc.nextLine();
                            //Si es admin
                            if (nombre.toUpperCase().equals("ADMINISTRADOR") && apellido.equals("01")) {
                                if (contrasena.equals("El Admin de los Admins")) {
                                    tUsuario = 1;
                                } else {
                                    System.out.println("Contrasena incorrecta");
                                    break;
                                }
                            } else {
                                //Si es usuario
                                user = GOD.buscarU(nombre, apellido);
                                if (user == null) {
                                    System.out.println("Este usuario no existe");
                                    break;
                                } else {
                                    user = GOD.buscarU(nombre, apellido, contrasena);
                                    if (user == null) {
                                        System.out.println("Contrasena incorrecta");
                                        break;
                                    }
                                }
                                tUsuario = 2;
                            }
                            usuario = true;
                            System.out.print("Accediendo al sistema");
                            sesion = true;
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                            }
                            System.out.print(".");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                            }
                            System.out.print(".");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                            }
                            System.out.print(".");
                            try {
                                Thread.sleep(4000);
                            } catch (InterruptedException e) {
                            }
                        } while (!usuario);
                        break;

                    //REGISTRARSE
                    case 2:
                        System.out.println("¡CREAREMOS UN NUEVO USUARIO!");
                        //Nombre
                        do {
                            cierto = false;
                            System.out.print("Ingrese el nombre: ");
                            nombre = sc.nextLine();
                            try {
                                Verificacion.formatoNombre(nombre);
                            } catch (FormatNombreException e) {
                                System.out.println("Error: " + e.getMessage());
                                System.out.println("Quiere salir?(Y/N)");
                                cierto = sc.nextLine().toUpperCase().equals("Y");
                                if (cierto) {
                                    cierto2 = true;
                                }
                            }
                        } while (!cierto);
                        if (cierto2) {
                            break;
                        }

                        //APELLIDO
                        do {
                            cierto = false;
                            System.out.print("Ingrese el apellido: ");
                            apellido = sc.nextLine();
                            try {
                                Verificacion.formatoNombre(apellido);
                            } catch (FormatNombreException e) {
                                System.out.println("Error: " + e.getMessage());
                                System.out.println("Quiere salir?(Y/N)");
                                cierto = sc.nextLine().toUpperCase().equals("Y");
                                if (cierto) {
                                    cierto2 = true;
                                }
                            }
                        } while (!cierto);
                        if (cierto2) {
                            break;
                        }
                        //Cuenta existente
                        if (GOD.buscarU(nombre, apellido) != null) {
                            System.out.println("\nEl usuario ya existe");
                            break;
                        }
                        //EDAD
                        do{
                            cierto=false;
                            System.out.print("Ingrese la edad:");
                            try{
                               edad=sc.nextInt();
                                Verificacion.validezEdad(edad);
                                cierto= true; 
                            } catch (InputMismatchException e) {
                                System.out.println("Se esperaba que ingrese un numero");
                                System.out.println("Quiere salir?(Y/N)");
                                cierto = sc.nextLine().toUpperCase().equals("Y");
                                if (cierto) {
                                    cierto2 = true;
                                }
                            } catch (RangoNumeroException e) {
                                System.out.println("Error: " + e.getMessage());
                                System.out.println("Quiere salir?(Y/N)");
                                cierto = sc.nextLine().toUpperCase().equals("Y");
                                if (cierto) {
                                    cierto2 = true;
                                }
                            }
                            sc.nextLine();
                            
                        }while(!cierto);
                        if(cierto2){
                                break;
                            }
                        
                        //CONTRASEÑA
                        System.out.print("Ingrese la contraseña: ");
                        contrasena = sc.nextLine();
                        //TELEFONO
                        do {
                            cierto = false;
                            System.out.print("Ingrese el numero de telefono: ");
                            try {
                                telefono = sc.nextInt();
                                Verificacion.validezTelefono(telefono);
                                cierto = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Se esperaba que ingrese un numero");
                                System.out.println("Quiere salir?(Y/N)");
                                cierto = sc.nextLine().toUpperCase().equals("Y");
                                if (cierto) {
                                    cierto2 = true;
                                }
                            } catch (RangoNumeroException e) {
                                System.out.println("Error: " + e.getMessage());
                                System.out.println("Quiere salir?(Y/N)");
                                cierto = sc.nextLine().toUpperCase().equals("Y");
                                if (cierto) {
                                    cierto2 = true;
                                }
                            }
                            sc.nextLine();
                        } while (!cierto);

                        if (cierto2) {
                            break;
                        }
                        //CORREO
                        do{
                            cierto=false;
                            System.out.print("Ingrese el correo electronico: ");
                            correo = sc.nextLine();
                            try {
                                Verificacion.formatoCorreo(correo);
                            } catch (FormatCorreoException e) {
                                System.out.println("Error: " + e.getMessage());
                                System.out.println("Quiere salir?(Y/N)");
                                cierto = sc.nextLine().toUpperCase().equals("Y");
                                if (cierto) {
                                    cierto2 = true;
                                }
                            }
                        }while(!cierto);
                        if(cierto2){
                                break;
                            }
                        //Crear usuario
                        Usuario usuario1 = new Usuario(contrasena, nombre, apellido, edad);
                        usuario1.setCorreo(correo);
                        usuario1.setTelefono(telefono);
                        GOD.registrarU(usuario1);
                        break;

                    //INVITADO
                    case 3:
                        invitado = Invitado.getInstance();
                        tUsuario = 3;
                        sesion = true;
                        break;
                   //Salir
                    case 4:
                        System.out.println("Hasta Luego!");
                        sesion = true;
                        salirT = true;
                        break;
                    default:
                        System.out.println("La opcion no es valida");
                        System.out.println("Por favor ingresa un apcion correcta");
                }

            } while (!sesion);

            if (salirT) {
                break;
            }

            //Bienvendio tal de apellido tal
            
            salir = false;
            //ADMIN
            switch (tUsuario) {
                case 1:
                    salir = false;
                    do {
                        System.out.println("\n\nQue desea hacer?\n");
                        System.out.println("(1) Trabajar con usuarios");
                        System.out.println("(2) Trabajar con Libros");
                        System.out.println("(3) Cerrar sesion");
                        System.out.print("La opcion es: ");
                        try {
                            opcion = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Se esperaba que ingrese un numero");
                            opcion = 20;
                        }
                        sc.nextLine();

                        switch (opcion) {
                            //ADMIN USUARIOS
                            case 1:
                                salir2 = false;
                                System.out.println("¡Trabajaremos con los usuarios!");
                                do {
                                    System.out.println("\nQue desea hacer?");
                                    System.out.println("(1) Registrar Usuario");
                                    System.out.println("(2) Buscar Usuario");
                                    System.out.println("(3) Eliminar Usuario");
                                    System.out.println("(4) Regresar al menú anterior");
                                    System.out.println("(5) Cerrar sesion ");
                                    System.out.print("La opcion es: ");
                                    try {
                                        opcion1 = sc.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Se esperaba que ingrese un numero");
                                        opcion1 = 20;
                                    }
                                    sc.nextLine();

                                    switch (opcion1) {
                                        case 1:
                                            break;
                                        case 2:
                                            break;
                                        case 3:
                                            break;
                                        case 4:
                                            salir2 = true;
                                            break;
                                        case 5:
                                            System.out.println("Seguro que quiere cerrar sesion? (Y/N)");
                                            salir = sc.nextLine().toUpperCase().equals("Y");
                                            if (salir) {
                                                salir2 = true;
                                            }
                                            //Despedir
                                            break;
                                        default:
                                            System.out.println("La opcion no es valida");
                                            System.out.println("Por favor ingresa un apcion correcta");
                                    }

                                } while (!salir2);
                                break;

                            //ADMIN LIBROS 
                            case 2:
                                salir2 = false;
                                System.out.println("¡Trabajaremos con Libros!");
                                do {
                                    System.out.println("\nQue desea hacer?\n");
                                    System.out.println("(1) Registrar Libro");
                                    System.out.println("(2) Buscar libro por Titulo");
                                    System.out.println("(3) Buscar libro por Genero");
                                    System.out.println("(4) Buscar libro por Autor");
                                    System.out.println("(5) Buscar libro por ID");
                                    System.out.println("(6) Buscar libro con todos los datos");
                                    System.out.println("(7) Eliminar libro");
                                    System.out.println("(8) Regresar al menú anterior");
                                    System.out.println("(9) Cerrar sesion");
                                    System.out.print("La opcion es: ");
                                    try {
                                        opcion1 = sc.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Se esperaba que ingrese un numero");
                                        opcion1 = 20;
                                    }
                                    sc.nextLine();

                                    switch (opcion1) {
                                        case 1:
                                            break;
                                        //Titulo
                                        case 2:
                                            System.out.print("Ingrese el Titulo del Libro");
                                            titulo = sc.nextLine();
                                            user.buscar(titulo, 1);
                                            break;
                                        //Genero
                                        case 3:
                                            System.out.print("Ingrese el Genero del Libro");
                                            genero = sc.nextLine();
                                            user.buscar(genero, 3);
                                            break;
                                        //Autor
                                        case 4:
                                            System.out.print("Ingrese el Autor del Libro");
                                            autor = sc.nextLine();
                                            user.buscar(autor, 2);
                                            break;
                                        //ID
                                        case 5:
                                            System.out.print("Ingrese el ID del Libro");
                                            try {
                                                id = sc.nextLong();
                                                libro=user.buscar(id);
                                            } catch (InputMismatchException e) {
                                                System.out.println("Se esperaba que ingrese un numero");
                                            }
                                            sc.nextLine();
                                            System.out.println(libro);
                                            break;
                                        //Todo
                                        case 6:
                                            System.out.print("Ingrese el Titulo del Libro");
                                            titulo = sc.nextLine();
                                            System.out.print("Ingrese el Genero del Libro");
                                            genero = sc.nextLine();
                                            System.out.print("Ingrese el Autor del Libro");
                                            autor = sc.nextLine();
                                            user.buscar(titulo, autor, genero);
                                            break;
                                        //Eliminar libro
                                        case 7:
                                            System.out.print("Ingrese el ID del Libro a eliminar");
                                            try {
                                                id = sc.nextLong();
                                                libro=user.buscar(id);
                                            } catch (InputMismatchException e) {
                                                System.out.println("Se esperaba que ingrese un numero");
                                            }
                                            sc.nextLine();
                                            GOD.eliminarL(libro);
                                            break;
                                        //Menu anterior
                                        case 8:
                                            salir2 = true;
                                            break;
                                        //Cerrar sesion
                                        case 9:
                                            System.out.println("Seguro que quiere cerrar sesion? (Y/N)");
                                            salir = sc.nextLine().toUpperCase().equals("Y");
                                            if (salir) {
                                                salir2 = true;
                                            }
                                            //Despedir
                                            break;
                                        default:
                                            System.out.println("La opcion no es valida");
                                            System.out.println("Por favor ingresa un apcion correcta");
                                    }
                                } while (!salir2);
                                break;
                            //ADMIN SESION
                            case 3:
                                System.out.println("Seguro que quiere cerrar sesion? (Y/N)");
                                salir = sc.nextLine().toUpperCase().equals("Y");
                                //Despedir
                                break;
                            default:
                                System.out.println("La opcion no es valida");
                                System.out.println("Por favor ingresa un apcion correcta");
                        }
                    } while (!salir);
                    break;
                //Usuario
                case 2:
                    do {
                        System.out.println("\n\nQue desea hacer?\n");
                        System.out.println("(1) Buscar libro por Titulo");
                        System.out.println("(2) Buscar libro por Genero");
                        System.out.println("(3) Buscar libro por Autor");
                        System.out.println("(4) Buscar libro por ID");
                        System.out.println("(5) Buscar libro con todos los datos");
                        System.out.println("(6) Pedir prestamo de libro");
                        System.out.println("(7) Renovar prestamo de libro");
                        System.out.println("(8) Devolver/Reponer libro");
                        System.out.println("(9) Cerrar sesion");
                        System.out.print("La opcion es: ");
                        try {
                            opcion = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Se esperaba que ingrese un numero");
                            opcion = 20;
                        }
                        sc.nextLine();

                        switch (opcion) {
                            //Titulo
                            case 1:
                                System.out.print("Ingrese el Titulo del Libro");
                                titulo= sc.nextLine();
                                user.buscar(titulo,1);
                                break;
                                //Genero
                            case 2:
                                System.out.print("Ingrese el Genero del Libro");
                                genero= sc.nextLine();
                                user.buscar(genero,3);
                                break;
                                //Autor
                            case 3:
                                System.out.print("Ingrese el Autor del Libro");
                                autor= sc.nextLine();
                                user.buscar(autor, 2);
                                break;
                            //ID
                            case 4:
                                System.out.print("Ingrese el ID del Libro");
                                try {
                                    id = sc.nextLong();
                                    libro = user.buscar(id);
                                } catch (InputMismatchException e) {
                                    System.out.println("Se esperaba que ingrese un numero");
                                }
                                sc.nextLine();
                                System.out.println(libro);
                                break;
                            //Todo
                            case 5:
                                System.out.print("Ingrese el Titulo del Libro");
                                titulo= sc.nextLine();
                                System.out.print("Ingrese el Genero del Libro");
                                genero= sc.nextLine();
                                System.out.print("Ingrese el Autor del Libro");
                                autor= sc.nextLine();
                                user.buscar(titulo, autor, genero);
                                break;
                            //Prestamo
                            case 6:
                                listaLibros=GOD.listaLibros();
                                TECARIO.realizarPrestamo(user, listaLibros);
                                break;
                           //Renovar
                            case 7:
                                TECARIO.renovarPrestamo(user);
                                break;
                            //Devolver    
                            case 8:
                                listaLibros=GOD.listaLibros();
                                TECARIO.devolverPrestamo(user, listaLibros);
                                break;
                            //Cerrar sesion
                            case 9:
                                System.out.println("Seguro que quiere cerrar sesion? (Y/N)");
                                salir = sc.nextLine().toUpperCase().equals("Y");
                                //Despedir
                                break;
                            default:
                                System.out.println("La opcion no es valida");
                                System.out.println("Por favor ingresa un apcion correcta");
                        }

                    } while (!salir);
                    break;
                //Invitado
                case 3:
                    do {
                        System.out.println("\n\nQue desea hacer?\n");
                        System.out.println("(1) Buscar libro por Titulo");
                        System.out.println("(2) Buscar libro por Genero");
                        System.out.println("(3) Buscar libro por Autor");
                        System.out.println("(4) Regresar al menu anterior");
                        System.out.print("La opcion es: ");
                        try {
                            opcion = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Se esperaba que ingrese un numero");
                            opcion = 20;
                        }
                        sc.nextLine();

                        switch (opcion) {
                            //Titulo
                            case 1:
                                System.out.print("Ingrese el Titulo del Libro");
                                titulo= sc.nextLine();
                                invitado.buscar(titulo,1);
                                break;
                                //Genero
                            case 2:
                                System.out.print("Ingrese el Genero del Libro");
                                genero= sc.nextLine();
                                invitado.buscar(genero,3);
                                break;
                                //Autor
                            case 3:
                                System.out.print("Ingrese el Autor del Libro");
                                autor= sc.nextLine();
                                invitado.buscar(autor, 2);
                                break;
                            case 4:
                                salir = true;
                                break;
                            default:
                                System.out.println("La opcion no es valida");
                                System.out.println("Por favor ingresa un apcion correcta");
                        }
                    } while (!salir);

                    break;
                default:
                    System.out.println("Hubo un problema");
            }

        } while (!salirT);

    }
}
