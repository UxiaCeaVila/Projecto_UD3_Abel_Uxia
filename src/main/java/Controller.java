import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.dao.*;
import model.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private static EntityManagerFactory entitiManagerFactory = Persistence.createEntityManagerFactory("default");
    private static EntityManager entityManager = entitiManagerFactory.createEntityManager();
    private static SessionFactory sessionFactory = new Configuration().buildSessionFactory();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean correcto = false, salir = false;
        int opcion = 9, opcion2 = 5;
        while (!salir) {
            while (!correcto) {
                System.out.println("*******¿QUE QUIERES VER?********\n1 - Sagas\n2 - Libros" +
                        "\n3 - Planetas\n4 - Personajes\n5 - Especies\n6 - Magia");
                System.out.print("\nIntroduce numero de opcion (0 para salir): ");
                if (sc.hasNextInt()) {
                    opcion = sc.nextInt();
                    correcto = true;
                } else {
                    System.out.println("La opcion tiene que ser en numero");
                }

            }
            switch (opcion) {
                case 1:
                    correcto = false;
                    while (!salir) {
                        while (!correcto) {
                            System.out.println("*******¿QUE QUIERES VER?********\n1 - Añadir\n2 - Modificar" +
                                    "\n3 - Borrar\n4 - Listar");
                            System.out.print("\nIntroduce numero de opcion (0 para salir): ");
                            if (sc.hasNextInt()) {
                                opcion = sc.nextInt();
                                correcto = true;
                            } else {
                                System.out.println("La opcion tiene que ser en numero");
                            }

                        }
                        switch (opcion) {
                            case 1:
                                annadirSagas();
                                break;
                            case 2:
                                modificarSagas();
                                break;
                            case 3:
                                deleteSagas();
                                break;
                            case 4:
                                listarSagas();
                                System.out.println();
                            case 0:
                                System.out.println("Saliendo...");
                                salir = true;
                                break;
                            default:
                                System.out.println("La opcion no existe");
                                correcto = false;
                                break;
                        }
                    }
                    salir = false;
                    break;
                case 2:
                    correcto = false;
                    while (!salir) {
                        while (!correcto) {
                            System.out.println("*******¿QUE QUIERES VER?********\n1 - Añadir\n2 - Modificar" +
                                    "\n3 - Borrar\n4 - Listar");
                            System.out.print("\nIntroduce numero de opcion (0 para salir): ");
                            if (sc.hasNextInt()) {
                                opcion = sc.nextInt();
                                correcto = true;
                            } else {
                                System.out.println("La opcion tiene que ser en numero");
                            }

                        }
                        switch (opcion) {
                            case 1:
                                annadirLibros();
                                break;
                            case 2:
                                modificarLibros();
                                break;
                            case 3:
                                deleteLibros();
                                break;
                            case 4:
                                listarLibros();
                                break;
                            case 0:
                                System.out.println("Saliendo...");
                                salir = true;
                                break;
                            default:
                                System.out.println("La opcion no existe");
                                correcto = false;
                                break;
                        }
                    }
                    salir = false;
                    break;
                case 3:
                    correcto = false;
                    while (!salir) {
                        while (!correcto) {
                            System.out.println("*******¿QUE QUIERES VER?********\n1 - Añadir\n2 - Modificar" +
                                    "\n3 - Borrar\n4 - Listar");
                            System.out.print("\nIntroduce numero de opcion (0 para salir): ");
                            if (sc.hasNextInt()) {
                                opcion = sc.nextInt();
                                correcto = true;
                            } else {
                                System.out.println("La opcion tiene que ser en numero");
                            }

                        }
                        switch (opcion) {
                            case 1:
                                annadirPlanetas();
                                break;
                            case 2:
                                modificarPlanetas();
                                break;
                            case 3:
                                deletePlanetas();
                                break;
                            case 4:
                                listarPlanetas();
                                break;
                            case 0:
                                System.out.println("Saliendo...");
                                salir = true;
                                break;
                            default:
                                System.out.println("La opcion no existe");
                                correcto = false;
                                break;
                        }
                    }
                    salir = false;
                    break;
                case 4:
                    correcto = false;
                    while (!salir) {
                        while (!correcto) {
                            System.out.println("*******¿QUE QUIERES VER?********\n1 - Añadir\n2 - Modificar" +
                                    "\n3 - Borrar\n4 - Listar");
                            System.out.print("\nIntroduce numero de opcion (0 para salir): ");
                            if (sc.hasNextInt()) {
                                opcion = sc.nextInt();
                                correcto = true;
                            } else {
                                System.out.println("La opcion tiene que ser en numero");
                            }

                        }
                        switch (opcion) {
                            case 1:
                                annadirPersonajes();
                                break;
                            case 2:
                                modificarPersonajes();
                                break;
                            case 3:
                                deletePersonajes();
                                break;
                            case 4:
                                listarPersonajes();
                                break;
                            case 0:
                                System.out.println("Saliendo...");
                                salir = true;
                                break;
                            default:
                                System.out.println("La opcion no existe");
                                correcto = false;
                                break;
                        }
                    }
                    salir = false;
                    break;
                case 5:
                    correcto = false;
                    while (!salir) {
                        while (!correcto) {
                            System.out.println("*******¿QUE QUIERES VER?********\n1 - Añadir\n2 - Modificar" +
                                    "\n3 - Borrar\n4 - Listar");
                            System.out.print("\nIntroduce numero de opcion (0 para salir): ");
                            if (sc.hasNextInt()) {
                                opcion = sc.nextInt();
                                correcto = true;
                            } else {
                                System.out.println("La opcion tiene que ser en numero");
                            }

                        }
                        switch (opcion) {
                            case 1:
                                annadirEspecies();
                                break;
                            case 2:
                                modificarEspecies();
                                break;
                            case 3:
                                deleteEspecies();
                                break;
                            case 4:
                                listarEspecies();
                                break;
                            case 0:
                                System.out.println("Saliendo...");
                                salir = true;
                                break;
                            default:
                                System.out.println("La opcion no existe");
                                correcto = false;
                                break;
                        }
                    }
                    salir = false;
                    break;
                case 6:
                    correcto = false;
                    while (!salir) {
                        while (!correcto) {
                            System.out.println("*******¿QUE QUIERES VER?********\n1 - Añadir\n2 - Modificar" +
                                    "\n3 - Borrar\n4 - Listar");
                            System.out.print("\nIntroduce numero de opcion (0 para salir): ");
                            if (sc.hasNextInt()) {
                                opcion = sc.nextInt();
                                correcto = true;
                            } else {
                                System.out.println("La opcion tiene que ser en numero");
                            }

                        }
                        switch (opcion) {
                            case 1:
                                annadirMagia();
                                break;
                            case 2:
                                modificarMagia();
                                break;
                            case 3:
                                deleteMagias();
                                break;
                            case 4:
                                listarMagias();
                                break;
                            case 0:
                                System.out.println("Saliendo...");
                                salir = true;
                                break;
                            default:
                                System.out.println("La opcion no existe");
                                correcto = false;
                                break;
                        }
                    }
                    salir = false;
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("La opcion no existe");
                    correcto = false;
                    break;
            }
        }

    }

    private static void annadirSagas() {
        SagasDAO sagasDAO = new SagasDAO();
        PlanetasDAO planetasDAO = new PlanetasDAO();
        Sagas sagas;
        Scanner sc = new Scanner(System.in);
        String nombre, longitud;
        boolean correcto = false;
        Integer idPlaneta = 0;
        System.out.println("Introduce nombre: ");
        nombre = sc.nextLine();
        System.out.println("Introduce longitud de la saga(numero de libros)");
        longitud = sc.nextLine();
        while (!correcto) {
            System.out.println("Introuce ID del Planeta central");
            if (sc.hasNextInt()) {
                idPlaneta = sc.nextInt();
                sc.nextLine();
                correcto = true;
            } else {
                System.out.println("Vuelve a introducir id");
            }
        }
        Planeta planeta = planetasDAO.findById(idPlaneta, entityManager);
        sagas = new Sagas(nombre, longitud, planeta);

        sagasDAO.insert(sagas, sessionFactory);
    }

    private static void annadirEspecies() {
        EspeciesDAO especiesDAO = new EspeciesDAO();
        PlanetasDAO planetasDAO = new PlanetasDAO();
        Especies especies;
        Scanner sc = new Scanner(System.in);
        String nombre;
        boolean correcto = false;
        Integer idPlaneta = 0, fisiologia = 0;
        System.out.println("Introduce nombre: ");
        nombre = sc.nextLine();
        System.out.println("Introduce longitud de la saga(numero de libros)");

        while (!correcto) {
            System.out.println("Introuce la fisiologia de la especie");
            if (sc.hasNextInt()) {
                fisiologia = sc.nextInt();
                sc.nextLine();
                correcto = true;
            } else {
                System.out.println("Vuelve a introducir");
            }
        }
        correcto = false;
        while (!correcto) {
            System.out.println("Introuce ID del Planeta de origen");
            if (sc.hasNextInt()) {
                idPlaneta = sc.nextInt();
                sc.nextLine();
                correcto = true;
            } else {
                System.out.println("Vuelve a introducir id");
            }
        }
        Planeta planeta = planetasDAO.findById(idPlaneta, entityManager);
        especies = new Especies(nombre, planeta, fisiologia);

        especiesDAO.insert(especies, sessionFactory);
    }

    private static void annadirLibros() {
        LibrosDAO librosDAO = new LibrosDAO();
        PlanetasDAO planetasDAO = new PlanetasDAO();
        SagasDAO sagasDAO = new SagasDAO();
        Scanner sc = new Scanner(System.in);
        String nombre;
        Libro libro;
        boolean correcto = false;
        Integer idPlaneta = 0, idSaga = 0;
        System.out.println("Introduce nombre: ");
        nombre = sc.nextLine();
        while (!correcto) {
            System.out.println("Introuce ID del Planeta central");
            if (sc.hasNextInt()) {
                idPlaneta = sc.nextInt();
                sc.nextLine();
                correcto = true;
            } else {
                System.out.println("Vuelve a introducir id");
            }
        }
        while (!correcto) {
            System.out.println("Introuce ID de la Saga central");
            if (sc.hasNextInt()) {
                idSaga = sc.nextInt();
                sc.nextLine();
                correcto = true;
            } else {
                System.out.println("Vuelve a introducir id");
            }
        }
        Planeta planeta = planetasDAO.findById(idPlaneta, entityManager);
        Sagas sagas1 = sagasDAO.findById(idSaga, entityManager);
        libro = new Libro(nombre, planeta, sagas1);

        librosDAO.insert(libro, sessionFactory);
    }

    private static void annadirPersonajes() {
        PersonajesDAO personajesDAO = new PersonajesDAO();
        PlanetasDAO planetasDAO = new PlanetasDAO();
        EspeciesDAO especiesDAO = new EspeciesDAO();
        Personaje personaje;
        Scanner sc = new Scanner(System.in);
        String nombre, edad;
        boolean correcto = false;
        Integer idPlaneta = 0, idEspecie = 0;
        System.out.println("Introduce nombre: ");
        nombre = sc.nextLine();
        System.out.println("Introduce edad del personaje)");
        edad = sc.nextLine();
        while (!correcto) {
            System.out.println("Introuce ID del Planeta de origen");
            if (sc.hasNextInt()) {
                idPlaneta = sc.nextInt();
                sc.nextLine();
                correcto = true;
            } else {
                System.out.println("Vuelve a introducir id");
            }
        }
        correcto = false;
        while (!correcto) {
            System.out.println("Introuce ID del Planeta de origen");
            if (sc.hasNextInt()) {
                idEspecie = sc.nextInt();
                sc.nextLine();
                correcto = true;
            } else {
                System.out.println("Vuelve a introducir id");
            }
        }
        Planeta planeta = planetasDAO.findById(idPlaneta, entityManager);
        Especies especies = especiesDAO.findById(idEspecie, entityManager);

        personaje = new Personaje(nombre, edad, especies, planeta);

        personajesDAO.insert(personaje, sessionFactory);
    }

    private static void annadirMagia() {
        MagiasDAO magiasDAO = new MagiasDAO();
        PlanetasDAO planetasDAO = new PlanetasDAO();
        Magia magia;
        Scanner sc = new Scanner(System.in);
        String nombre, descripcion, esquirla;
        boolean correcto = false;
        System.out.println("Introduce nombre: ");
        nombre = sc.nextLine();
        System.out.println("Introduce descripcion de la magia");
        descripcion = sc.nextLine();
        System.out.println("Introduce esquirla de la magia");
        esquirla = sc.nextLine();
        magia = new Magia(nombre, descripcion, esquirla);

        magiasDAO.insert(magia, sessionFactory);
    }

    private static void annadirPlanetas() {
        PlanetasDAO planetasDAO = new PlanetasDAO();
        Planeta planeta;
        Scanner sc = new Scanner(System.in);
        String nombre, sistema, esquirla;
        boolean correcto = false;
        System.out.println("Introduce nombre: ");
        nombre = sc.nextLine();
        System.out.println("Introduce sistema planetario");
        sistema = sc.nextLine();
        System.out.println("Introduce esquirla del planeta");
        esquirla = sc.nextLine();
        planeta = new Planeta(nombre, sistema, esquirla);

        planetasDAO.insert(planeta, sessionFactory);
    }

    private static void modificarSagas() {
        SagasDAO sagasDAO = new SagasDAO();
        Sagas sagas;
        String actualizar, actualizarPor = "";
        Integer idSaga;
        Scanner sc = new Scanner(System.in);
        boolean correcto = false;
        while (!correcto) {
            System.out.println("Introduce id de la Saga que quieras actualizar:");
            if (sc.hasNextInt()) {
                idSaga = sc.nextInt();
                sc.nextLine();
                System.out.println("Introduce que campo quieres actualizar: \nNombre" +
                        "\nLongitud\nPlaneta");
                actualizar = sc.nextLine();
                if (actualizar.equalsIgnoreCase("Nombre") || actualizar.equalsIgnoreCase("Longitud") || actualizar.equalsIgnoreCase("Planeta")) {
                    if (actualizar.equals("Nombre")) {
                        System.out.println("Introduce nuevo nombre: ");
                        actualizarPor = sc.nextLine();
                    } else if (actualizar.equals("Longitud")) {
                        System.out.println("Introduce nuevo logitud: ");
                        actualizarPor = sc.nextLine();
                    } else if (actualizar.equals("Planeta")) {
                        System.out.println("Introduce nuevo id del planeta: ");
                        actualizarPor = sc.nextLine();
                    }
                    sagas = sagasDAO.findById(idSaga, entityManager);
                    sagasDAO.update(sagas, sessionFactory, actualizar.toLowerCase(), actualizarPor);
                    correcto =true;
                } else {
                    System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
                }
            } else {
                System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
            }

        }
    }

    private static void modificarEspecies() {
        EspeciesDAO especiesDAO = new EspeciesDAO();
        PlanetasDAO planetasDAO = new PlanetasDAO();
        Especies especies;
        Scanner sc = new Scanner(System.in);
        String actualizar, actualizarPor = "";
        boolean correcto = false;
        Integer idEspecie = 0, fisiologia = 0;
        while (!correcto) {
            System.out.println("Introduce id de la Especie que quieras actualizar:");
            if (sc.hasNextInt()) {
                idEspecie = sc.nextInt();
                sc.nextLine();
                System.out.println("Introduce que campo quieres actualizar: \nNombre" +
                        "\nPlaneta\nFisiologia");
                actualizar = sc.nextLine();
                if (actualizar.equalsIgnoreCase("Nombre") || actualizar.equalsIgnoreCase("Planeta") || actualizar.equalsIgnoreCase("Fisiologia")) {
                    if (actualizar.equals("Nombre")) {
                        System.out.println("Introduce nuevo nombre: ");
                        actualizarPor = sc.nextLine();
                    } else if (actualizar.equals("Planeta")) {
                        System.out.println("Introduce nuevo id del Planeta: ");
                        actualizarPor = sc.nextLine();
                    } else if (actualizar.equals("Fisiologia")) {
                        System.out.println("Introduce nueva  Fisiologia: ");
                        actualizarPor = sc.nextLine();
                    }
                    especies = especiesDAO.findById(idEspecie, entityManager);
                    especiesDAO.update(especies, sessionFactory, actualizar.toLowerCase(), actualizarPor);
                    correcto=true;
                } else {
                    System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
                }
            } else {
                System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
            }

        }
    }

    private static void modificarLibros() {
        LibrosDAO librosDAO = new LibrosDAO();
        PlanetasDAO planetasDAO = new PlanetasDAO();
        SagasDAO sagasDAO = new SagasDAO();
        Scanner sc = new Scanner(System.in);
        String actualizar, actualizarPor = "";
        Libro libro;
        boolean correcto = false;
        Integer idLibro = 0;
        while (!correcto) {
            System.out.println("Introduce id del Libro que quieras actualizar:");
            if (sc.hasNextInt()) {
                idLibro = sc.nextInt();
                sc.nextLine();
                System.out.println("Introduce que campo quieres actualizar: \nNombre" +
                        "\nPlaneta\nSaga");
                actualizar = sc.nextLine();
                if (actualizar.equalsIgnoreCase("Nombre") || actualizar.equalsIgnoreCase("Planeta") || actualizar.equalsIgnoreCase("Saga")) {
                    if (actualizar.equals("Nombre")) {
                        System.out.println("Introduce nuevo nombre: ");
                        actualizarPor = sc.nextLine();
                    } else if (actualizar.equals("Planeta")) {
                        System.out.println("Introduce nuevo id del Planeta: ");
                        actualizarPor = sc.nextLine();
                    } else if (actualizar.equals("Saga")) {
                        System.out.println("Introduce nuevo id de Saga: ");
                        actualizarPor = sc.nextLine();
                    }
                    libro = librosDAO.findById(idLibro, entityManager);
                    librosDAO.update(libro, sessionFactory, actualizar.toLowerCase(), actualizarPor);
                    correcto=true;
                } else {
                    System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
                }
            } else {
                System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
            }

        }
    }

    private static void modificarPersonajes() {
        PersonajesDAO personajesDAO = new PersonajesDAO();
        PlanetasDAO planetasDAO = new PlanetasDAO();
        EspeciesDAO especiesDAO = new EspeciesDAO();
        Personaje personaje;
        Scanner sc = new Scanner(System.in);
        String actualizar, actualizarPor = "";
        boolean correcto = false;
        Integer idPersonajes = 0;
        while (!correcto) {
            System.out.println("Introduce id del Personaje que quieras actualizar:");
            if (sc.hasNextInt()) {
                idPersonajes = sc.nextInt();
                sc.nextLine();
                System.out.println("Introduce que campo quieres actualizar: \nNombre" +
                        "\nPlaneta\nEspecie\nEdad");
                actualizar = sc.nextLine();
                if (actualizar.equalsIgnoreCase("Nombre") || actualizar.equalsIgnoreCase("Planeta") || actualizar.equalsIgnoreCase("Especie") || actualizar.equalsIgnoreCase("Edad")) {
                    if (actualizar.equals("Nombre")) {
                        System.out.println("Introduce nuevo nombre: ");
                        actualizarPor = sc.nextLine();
                    } else if (actualizar.equals("Planeta")) {
                        System.out.println("Introduce nuevo id del Planeta: ");
                        actualizarPor = sc.nextLine();
                    } else if (actualizar.equals("Especie")) {
                        System.out.println("Introduce nuevo id de Especie: ");
                        actualizarPor = sc.nextLine();
                    } else if (actualizar.equals("Edad")) {
                        System.out.println("Introduce nuevo id de Edad: ");
                        actualizarPor = sc.nextLine();
                    }
                    personaje = personajesDAO.findById(idPersonajes, entityManager);
                    personajesDAO.update(personaje, sessionFactory, actualizar.toLowerCase(), actualizarPor);
                    correcto=true;
                } else {
                    System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
                }
            } else {
                System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
            }

        }
    }

    private static void modificarMagia() {
        MagiasDAO magiasDAO = new MagiasDAO();
        Magia magia;
        String actualizar, actualizarPor = "";
        Scanner sc = new Scanner(System.in);
        boolean correcto = false;
        Integer idMagia;
        while (!correcto) {
            System.out.println("Introduce id de la Magia que quieras actualizar:");
            if (sc.hasNextInt()) {
                idMagia = sc.nextInt();
                sc.nextLine();
                System.out.println("Introduce que campo quieres actualizar: \nNombre" +
                        "\nDescricion\nEsquirla");
                actualizar = sc.nextLine();
                if (actualizar.equalsIgnoreCase("Nombre") || actualizar.equalsIgnoreCase("Descrpcion") || actualizar.equalsIgnoreCase("Esquirla")) {
                    if (actualizar.equals("Nombre")) {
                        System.out.println("Introduce nuevo nombre: ");
                        actualizarPor = sc.nextLine();
                    } else if (actualizar.equals("Descricion")) {
                        System.out.println("Introduce nuevo id del Descricion: ");
                        actualizarPor = sc.nextLine();
                    } else if (actualizar.equals("Esquirla")) {
                        System.out.println("Introduce nuevo id de Esquirla: ");
                        actualizarPor = sc.nextLine();
                    }
                    magia = magiasDAO.findById(idMagia, entityManager);
                    magiasDAO.update(magia, sessionFactory, actualizar.toLowerCase(), actualizarPor);
                    correcto=true;
                } else {
                    System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
                }
            } else {
                System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
            }
        }
    }
    private static void modificarPlanetas(){
        PlanetasDAO planetasDAO = new PlanetasDAO();
        Planeta planeta;
        Scanner sc = new Scanner(System.in);
        String actualizar, actualizarPor = "";
        boolean correcto = false;
        Integer idPlaneta = 0;
        while (!correcto) {
            System.out.println("Introduce id del Planeta que quieras actualizar:");
            if (sc.hasNextInt()) {
                idPlaneta = sc.nextInt();
                sc.nextLine();
                System.out.println("Introduce que campo quieres actualizar: \nNombre" +
                        "\nSistema\nEsquirla");
                actualizar = sc.nextLine();
                if (actualizar.equalsIgnoreCase("Nombre") || actualizar.equalsIgnoreCase("Sistema") || actualizar.equalsIgnoreCase("Esquirla")) {
                    if (actualizar.equals("Nombre")) {
                        System.out.println("Introduce nuevo nombre: ");
                        actualizarPor = sc.nextLine();
                    } else if (actualizar.equals("Sistema")) {
                        System.out.println("Introduce nuevo  Sistema: ");
                        actualizarPor = sc.nextLine();
                    } else if (actualizar.equals("Esquirla")) {
                        System.out.println("Introduce nuevo id de Esquirla: ");
                        actualizarPor = sc.nextLine();
                    }
                    planeta = planetasDAO.findById(idPlaneta, entityManager);
                    planetasDAO.update(planeta, sessionFactory, actualizar.toLowerCase(), actualizarPor);
                    correcto=true;
                } else {
                    System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
                }
            } else {
                System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
            }
        }

    }
    private static void deleteSagas(){
        SagasDAO sagasDAO = new SagasDAO();
        Sagas sagas;
        Scanner sc = new Scanner(System.in);
        boolean correcto = false;
        Integer idSaga = 0;
        while (!correcto) {
            System.out.println("Introduce id de la Saga que quieras Borrar:");
            if (sc.hasNextInt()) {
                idSaga = sc.nextInt();
                sc.nextLine();
                sagas = sagasDAO.findById(idSaga, entityManager);
                sagasDAO.delete(sagas, sessionFactory);
            } else {
                System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
            }
        }
    }
    private static void deleteEspecies(){
        EspeciesDAO especiesDAO = new EspeciesDAO();
        Especies especies;
        Scanner sc = new Scanner(System.in);
        boolean correcto = false;
        Integer idEspecie = 0;
        while (!correcto) {
            System.out.println("Introduce id de la Especie que quieras borrar:");
            if (sc.hasNextInt()) {
                idEspecie = sc.nextInt();
                sc.nextLine();
                especies = especiesDAO.findById(idEspecie, entityManager);
                especiesDAO.delete(especies, sessionFactory);
            } else {
                System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
            }
        }
    }
    private static void deleteLibros(){
        LibrosDAO librosDAO = new LibrosDAO();
        Libro libro;
        Scanner sc = new Scanner(System.in);
        boolean correcto = false;
        Integer idLibro = 0;
        while (!correcto) {
            System.out.println("Introduce id de la Especie que quieras actualizar:");
            if (sc.hasNextInt()) {
                idLibro = sc.nextInt();
                sc.nextLine();
                libro = librosDAO.findById(idLibro, entityManager);
                librosDAO.delete(libro, sessionFactory);
            } else {
                System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
            }
        }
    }
    private static void deleteMagias(){
        MagiasDAO magiasDAO = new MagiasDAO();
        Magia magia;
        Scanner sc = new Scanner(System.in);
        boolean correcto = false;
        Integer idMagia = 0;
        while (!correcto) {
            System.out.println("Introduce id de la Especie que quieras actualizar:");
            if (sc.hasNextInt()) {
                idMagia = sc.nextInt();
                sc.nextLine();
                magia = magiasDAO.findById(idMagia, entityManager);
                magiasDAO.delete(magia, sessionFactory);
            } else {
                System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
            }
        }
    }
    private static void deletePersonajes(){
        PersonajesDAO personajesDAO = new PersonajesDAO();
        Personaje personaje;
        Scanner sc = new Scanner(System.in);
        boolean correcto = false;
        Integer idPersonaje = 0;
        while (!correcto) {
            System.out.println("Introduce id de la Especie que quieras actualizar:");
            if (sc.hasNextInt()) {
                idPersonaje = sc.nextInt();
                sc.nextLine();
                personaje = personajesDAO.findById(idPersonaje, entityManager);
                personajesDAO.delete(personaje, sessionFactory);
            } else {
                System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
            }
        }
    }
    private static void deletePlanetas(){
        PlanetasDAO planetasDAO = new PlanetasDAO();
        Planeta planeta;
        Scanner sc = new Scanner(System.in);
        boolean correcto = false;
        Integer idPlaneta = 0;
        while (!correcto) {
            System.out.println("Introduce id de la Especie que quieras actualizar:");
            if (sc.hasNextInt()) {
                idPlaneta = sc.nextInt();
                sc.nextLine();
                planeta = planetasDAO.findById(idPlaneta, entityManager);
                planetasDAO.delete(planeta, sessionFactory);
            } else {
                System.out.println("- - - - Error - - - -\nVuelve a introducir id :");
            }
        }
    }

    private static void listarPlanetas(){
        PlanetasDAO planetasDAO = new PlanetasDAO();
        List<Planeta> planetas;
        planetas = planetasDAO.find(entityManager);
        for(Iterator iterator = planetas.iterator(); iterator.hasNext();){
            Planeta planeta = (Planeta) iterator.next();
            System.out.println(planeta.getId()+";"+planeta.getNombre()+";"+planeta.getSistema()+";"+planeta.getEsquirla());
        }
    }
    private static void listarSagas(){
        SagasDAO sagasDAO = new SagasDAO();
        List<Sagas> sagas;
        sagas = sagasDAO.find(entityManager);
        for(Iterator iterator = sagas.iterator(); iterator.hasNext();){
            Sagas sagas1 = (Sagas) iterator.next();
            System.out.println(sagas1.getId()+";"+sagas1.getNombre()+";"+sagas1.getLongitud()+";"+sagas1.getPlaneta().getId());
        }
    }
    private static void listarEspecies(){
        EspeciesDAO especiesDAO = new EspeciesDAO();
        List<Especies> especies;
        especies = especiesDAO.find(entityManager);
        for(Iterator iterator = especies.iterator(); iterator.hasNext();){
            Especies especies1 = (Especies) iterator.next();
            System.out.println(especies1.getId()+";"+especies1.getNombre()+";"+especies1.getFisiologia()+";"+especies1.getPlanetaOrigen().getId());
        }
    }
    private static void listarLibros(){
        LibrosDAO librosDAO = new LibrosDAO();
        List<Libro> libros;
        libros = librosDAO.find(entityManager);
        for(Iterator iterator = libros.iterator(); iterator.hasNext();){
            Libro libro = (Libro) iterator.next();
            System.out.println(libro.getId()+";"+libro.getNombre()+";"+libro.getSaga().getId()+";"+libro.getPlaneta().getId());
        }
    }
    private static void listarMagias(){
        MagiasDAO magiasDAO = new MagiasDAO();
        List<Magia> magias;
        magias = magiasDAO.find(entityManager);
        for(Iterator iterator = magias.iterator(); iterator.hasNext();){
            Magia magia = (Magia) iterator.next();
            System.out.println(magia.getId()+";"+magia.getNombre()+";"+magia.getDescripcion()+";"+magia.getEsquirla());
        }
    }
    private static void listarPersonajes(){
        PersonajesDAO personajesDAO = new PersonajesDAO();
        List<Personaje> personajes;
        personajes = personajesDAO.find(entityManager);
        for(Iterator iterator = personajes.iterator(); iterator.hasNext();){
            Personaje personaje = (Personaje) iterator.next();
            System.out.println(personaje.getId()+";"+personaje.getNombre()+";"+personaje.getEdad()+";"+personaje.getEspecie().getId()+";"+personaje.getPlanetaOrigen().getId());
        }
    }
}
