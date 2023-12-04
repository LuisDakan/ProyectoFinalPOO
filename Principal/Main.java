package Principal;

import Clientes.*;
import Personal.*;
import Producto.*;
import java.util.Map;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author DAPG1
 */

public class Main {

    public static void main(String[] args) {

        boolean sesion = false, usuario = false, comprador = false, salir = false, salir2 = false, salirT = false, cierto = false;
        int opcion = 0, opcion1 = 0, numCuenta = 0, edad, tUsuario = 0;
        
        Scanner sc = new Scanner(System.in);

        //
        System.out.println("Bienvenido a Bibliotecas Athos");
        do {
            do {
                sesion = false;
                System.out.println("Que desea hacer?");
                System.out.println("(1) Iniciar Sesión");
                System.out.println("(2) Registrarme");
                System.out.println("(3) Ingresar como invitado");
                System.out.println("(4) Salir");
                System.out.print("La opcion es: ");
                try {
                    opcion = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Se espera que ingrese un numero");
                    opcion = 20;
                }
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
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

            //Ver con que tipo de cliente estamos trabajando
            //regresar tipo de usuario
            //Bienvendio tal de apellido tal
            salir = false;
            //ADMIN
            switch (tUsuario) {
                case 1:
                    salir = false;
                    do {
                        System.out.println("\nQue desea hacer?\n");
                        System.out.println("(1) Trabajar con usuarios");
                        System.out.println("(2) Trabajar con Libros");
                        System.out.println("(3) Cerrar sesion");
                        System.out.print("La opcion es: ");
                        try {
                            opcion = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Se espera que ingrese un numero");
                            opcion = 20;
                        }
                        sc.nextLine();

                        switch (opcion) {
                            //ADMIN USUARIOS
                            case 1:
                                salir2 = false;
                                System.out.println("¡Trabajaremos con los usuarios!");
                                do {
                                    System.out.println("\nQue desea hacer?\n");
                                    System.out.println("(1) Registrar Usuario");
                                    System.out.println("(2) Buscar usuario por cuenta");
                                    System.out.println("(3) Buscar usuario por nombre");
                                    System.out.println("(4) Eliminar Usuario");
                                    System.out.println("(5) Regresar al menú anterior");
                                    System.out.println("(6) Cerrar sesion ");
                                    System.out.print("La opcion es: ");
                                    try {
                                        opcion1 = sc.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Se espera que ingrese un numero");
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
                                            break;
                                        case 5:
                                            break;
                                        case 6:
                                            System.out.println("Seguro que quiere cerrar sesion? (Y/N)");
                                            salir = sc.nextLine().toUpperCase().equals("Y");
                                            if (salir) {
                                                salir2 = true;
                                            }
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
                                        System.out.println("Se espera que ingrese un numero");
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
                                            break;
                                        case 5:
                                            break;
                                        case 6:
                                            break;
                                        case 7:
                                            break;
                                        case 8:
                                            break;
                                        case 9:
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
                        System.out.println("Que desea hacer?");
                        System.out.println("(1) Buscar libro por Titulo");
                        System.out.println("(2) Buscar libro por Genero");
                        System.out.println("(3) Buscar libro por Autor");
                        System.out.println("(4) Buscar libro por ID");
                        System.out.println("(5) Buscar libro con todos los datos");
                        System.out.println("(6) Pedir prestamo de libro");
                        System.out.println("(7) Devolver/Reponer libro");
                        System.out.println("(8) Cerrar sesion");
                        System.out.print("La opcion es: ");
                        try {
                            opcion = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Se espera que ingrese un numero");
                            opcion = 20;
                        }
                        sc.nextLine();

                        switch (opcion) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                salir = true;
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
                        System.out.println("Que desea hacer?");
                        System.out.println("(1) Buscar libro por Titulo");
                        System.out.println("(2) Buscar libro por Genero");
                        System.out.println("(3) Buscar libro por Autor");
                        System.out.println("(4) Buscar libro por ID");
                        System.out.println("(5) Donar dinero a la biblioteca");
                        System.out.println("(6) Regresar al menu anterior");
                        System.out.print("La opcion es: ");
                        try {
                            opcion = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Se espera que ingrese un numero");
                            opcion = 20;
                        }
                        sc.nextLine();

                        switch (opcion) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
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
        }while (!salirT);
    }
}
