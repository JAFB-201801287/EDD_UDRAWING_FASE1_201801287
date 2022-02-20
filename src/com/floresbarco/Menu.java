package com.floresbarco;

import com.floresbarco.DataStructure.LinkedList;
import com.floresbarco.DataStructure.Node;
import com.floresbarco.DataStructure.Stack;
import com.floresbarco.controller.ClientController;
import com.floresbarco.controller.DocumentController;
import com.floresbarco.controller.ImageController;
import com.floresbarco.controller.WindowController;
import com.floresbarco.model.Client;
import com.floresbarco.model.Image;
import com.floresbarco.model.Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Random;

public class Menu {
    // PASOS
    private LinkedList<String> steps;
    private String step;
    // NOMBRE 0-14
    private String NAMES[] = new String[]{"Jose", "Susana", "Kevin", "Alex", "Carla", "Carlos", "Luis", "Luisa", "Daniel", "Daniela", "Fernando", "Fernanada", "Lucrecia", "Hugo", "Jorge"};
    // APELLIDOS 0-14
    private String SECONDNAME[] = new String[]{"Hernández", "García", "Martínez", "López", "González", "Pérez", "Rodríguez", "Sánchez", "Ramírez", "Cruz", "de Leon", "Rodríguez", "Diaz", "Castillo", "Herrera"};
    private Integer idClient;
    private Integer numberSteps;
    private Integer idImage;

    // CONSTRUCTOR
    public Menu() {
        idClient = 0;
        numberSteps = 0;
        idImage = 0;
        steps = new LinkedList<String>();
        step = "";
    }

    // DATOS
    private void info() throws IOException {
        System.out.println("");
        System.out.println("**************************************************************************************************************************");
        System.out.println("  JOSE ANDRES FLORES BARCO");
        System.out.println("  201801287");
        System.out.println("  ESTRUCTURAS DE DATOS Sección A");
        System.out.println("**************************************************************************************************************************");
        System.out.println("");
        System.out.println("  PRESIONE ENTER PARA CONTINUAR.");
        reader();
    }

    // OPCIONES
    private void options() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                           MENU                                                           ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("  1) PARÁMETROS INICIALES");
        System.out.println("  2) EJECUTAR PASO");
        System.out.println("  3) ESTADO EN MEMORIA DE LAS ESTRUCTURAS");
        System.out.println("  4) REPORTES");
        System.out.println("  5) ACERCA DE ← DATOS DEL ESTUDIANTE");
        System.out.println("  6) SALIR");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    }

    private void initialParameterOptions() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                            MENU DE PARÁMETROS INICIALES                                                  ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("  1) CARGA MASIVA DE CLIENTES");
        System.out.println("  2) CANTIDAD DE VENTANILLAS");
        System.out.println("  3) REGRESAR");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    }

    private void reportrOptions() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                  MENU DE REPORTES                                                        ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("  1) VISUALIZACIÓN DE ESTRUCTURAS");
        System.out.println("  2) TOP 5 DE CLIENTES CON MAYOR CANTIDAD DE IMÁGENES A COLO");
        System.out.println("  3) TOP 5 DE CLIENTES CON MENOR CANTIDAD DE IMÁGENES EN BLANCO Y NEGRO");
        System.out.println("  4) INFORMACIÓN DEL CLIENTE QUE MÁS PASOS ESTUVO EN EL SISTEMA");
        System.out.println("  5) DATOS DE CLIENTE");
        System.out.println("  6) REGRESAR");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    }

    // LIMPIAR CONSOLA
    private static void clear(){
        try{
            String operatingSystem = System.getProperty("os.name");

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // LECTOR DE CONSOLA
    private String reader() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    // MENU
    public void menu() throws IOException {
        boolean flag = true;

        do {
            String option = "";
            clear();
            options();

            System.out.print("  ESCRIBA EL NUMERO DE LA OPCIÓN QUE DECEA EJECUTAR >> ");
            option = reader();
            if (isNumeric(option)) {
                switch (Integer.parseInt(option)) {
                    case 1:
                        initialParameterMenu();
                        break;
                    case 2:
                        execStep();
                        break;
                    case 3:
                        stateMemory();
                        break;
                    case 4:
                        reportMenu();
                        break;
                    case 5:
                        info();
                        break;
                    case 6:
                        flag = false;
                        break;
                    default:
                        System.out.println("  EL NUMERO DE LA OPCIÓN ESCOGIDA NO EXISTE. PRESIONE ENTER PARA CONTINUAR.");
                        reader();
                        break;
                }
            } else {
                System.out.println("  SOLO SE ACEPTAN RESPUESTAS CON NÚMEROS ENTEROS. PRESIONE ENTER PARA CONTINUAR.");
                reader();
            }
        } while (flag);
        clear();
    }

    // MENU DE PARAMETROS INICIALES
    private void initialParameterMenu() throws IOException {
        boolean flag = true;

        do {
            String option = "";
            clear();
            initialParameterOptions();

            System.out.print("  ESCRIBA EL NUMERO DE LA OPCIÓN QUE DECEA EJECUTAR >> ");
            option = reader();
            if (isNumeric(option)) {
                switch (Integer.parseInt(option)) {
                    case 1:
                        bulkLoadClients();
                        break;
                    case 2:
                        numberWindows();
                        break;
                    case 3:
                        flag = false;
                        break;
                    default:
                        System.out.println("  EL NUMERO DE LA OPCIÓN ESCOGIDA NO EXISTE. PRESIONE ENTER PARA CONTINUAR.");
                        reader();
                        break;
                }
            } else {
                System.out.println("  SOLO SE ACEPTAN RESPUESTAS CON NÚMEROS ENTEROS. PRESIONE ENTER PARA CONTINUAR.");
                reader();
            }
        } while (flag);
        clear();
    }

    // MENU DE REPORTES
    private void reportMenu() throws IOException {
        boolean flag = true;

        do {
            String option = "";
            clear();
            reportrOptions();

            System.out.print("  ESCRIBA EL NUMERO DE LA OPCIÓN QUE DECEA EJECUTAR >> ");
            option = reader();
            if (isNumeric(option)) {
                switch (Integer.parseInt(option)) {
                    case 1:
                        report();
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
                        flag = false;
                        break;
                    default:
                        System.out.println("  EL NUMERO DE LA OPCIÓN ESCOGIDA NO EXISTE. PRESIONE ENTER PARA CONTINUAR.");
                        reader();
                        break;
                }
            } else {
                System.out.println("  SOLO SE ACEPTAN RESPUESTAS CON NÚMEROS ENTEROS. PRESIONE ENTER PARA CONTINUAR.");
                reader();
            }
        } while (flag);
        clear();
    }


    // VALIDAR SI LA ENTRADA EN NUMERO ENTERO
    private static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer number = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /* METODOS PARA PARAMETROS INICIALES ------------------------------------------------------- */
    private void bulkLoadClients() throws IOException {
        clear();
        initialParameterOptions();
        System.out.print("  INGRESE LA DIRECCIÓN DEL ARCHIVO >> ");
        String addres = reader();

        Map clients = DocumentController.getInstance().documentReding(addres);

        for (Object key : clients.keySet()) {
            System.out.println("  " + key + ": " + clients.get(key));
            Map info = (Map) clients.get(key);
            Client client = new Client();
            client.setId(Integer.parseInt((String) info.get("id_cliente")));
            client.setName((String) info.get("nombre_cliente"));
            client.setColorImage(Integer.parseInt((String) info.get("img_color")));
            client.setColorlessImage(Integer.parseInt((String) info.get("img_bw")));
            ClientController.getInstance().addReceptionQueue(client);
            ClientController.getInstance().add(client);
            if (idClient < Integer.parseInt((String) info.get("id_cliente"))) {
                idClient = Integer.parseInt((String) info.get("id_cliente")) + 1;
            }
        }

        System.out.println("  PRESIONE ENTER PARA CONTINUAR.");
        reader();

        clear();
    }

    private void numberWindows() throws IOException {
        clear();
        initialParameterOptions();
        System.out.print("  INGRESE LA CANTIDAD DE VENTANILLAS >> ");
        String n = reader();
        if (isNumeric(n)) {
            WindowController.getInstance().add(Integer.parseInt(n));
            System.out.println("  SE A INGRESADO LA CANTIDAD DE VENTANILLAS: " + n + ". PRESIONE ENTER PARA CONTINUAR.");
            reader();
        } else {
            System.out.println("  SOLO SE ACEPTAN RESPUESTAS CON NÚMEROS ENTEROS. PRESIONE ENTER PARA CONTINUAR.");
            reader();
        }
        clear();
    }

    /* PASOS ------------------------------------------------------- */
    private void infoSteps() {
        System.out.println("");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("  PASO " + numberSteps);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("");

        Node<Client> current = ClientController.getInstance().getReceptionQueue().get();
        System.out.println("**************************************************************************************************************************");
        System.out.println("  FILA DE RECEPCION");
        System.out.println("**************************************************************************************************************************");
        while (current != null) {
            System.out.println("  NOMBRE: " + current.getElement().getName() + " >> IMAGENES A COLOR: " + current.getElement().getColorImage() + " >> IMAGENES A BLANCO Y NEGRO: " + current.getElement().getColorlessImage());
            current = current.getAfter();
        }
        System.out.println("");

        Node<Window> current1 = WindowController.getInstance().getWindowList().get();
        System.out.println("**************************************************************************************************************************");
        System.out.println("  VENTANILLAS");
        System.out.println("**************************************************************************************************************************");
        while (current1 != null) {
            if(current1.getElement().getClient() != null) {
                System.out.println("  VENTANILLA: " + current1.getElement().getId() + " >> CLIENTE: " + current1.getElement().getClient().getName() + " >> IMAGENES A COLOR: " + current1.getElement().getColorImage() + " >> IMAGENES A BLANCO Y NEGRO: " + current1.getElement().getColorlessImage());
            } else {
                System.out.println("  VENTANILLA: " + current1.getElement().getId() + " >> CLIENTE: VACIO" + " >> IMAGENES A COLOR: " + current1.getElement().getColorImage() + " >> IMAGENES A BLANCO Y NEGRO: " + current1.getElement().getColorlessImage());
            }
            current1 = current1.getAfter();
        }
        System.out.println("");

        Node<Client> current2 = ClientController.getInstance().getClientWaiting().get();
        System.out.println("**************************************************************************************************************************");
        System.out.println("  CLIENTE EN ESPERA QUE SE IMPRIMA SUS IMAGENES");
        System.out.println("**************************************************************************************************************************");
        if(current2 != null) {
            do {
                System.out.println("  NOMBRE: " + current2.getElement().getName() + " >> ID: " + current2.getElement().getId() + " >> IMAGENES A COLOR: " + current2.getElement().getColorImage() + " >> IMAGENES A BLANCO Y NEGRO: " + current2.getElement().getColorlessImage());
                current2 = current2.getAfter();
            } while (current2 != ClientController.getInstance().getClientWaiting().get());
        }
        System.out.println("");

        Node<Image> imagecCurrent = ImageController.getInstance().getImageColorList().get();
        System.out.println("**************************************************************************************************************************");
        System.out.println("  IMPRESORA A COLOR");
        System.out.println("**************************************************************************************************************************");
        System.out.println("  CANTIDAD: " + ImageController.getInstance().getImageColorList().getCount());
        System.out.println("");
        while (imagecCurrent != null) {
            System.out.println("  IMAGEN A COLOR >> CLIENTE: " + imagecCurrent.getElement().getClient().getName() + ", ID CLIENTE: " + imagecCurrent.getElement().getClient().getId());
            imagecCurrent = imagecCurrent.getAfter();
        }
        System.out.println("");

        Node<Image> imagebCurrent = ImageController.getInstance().getImageColorList().get();
        System.out.println("**************************************************************************************************************************");
        System.out.println("  IMPRESORA EN BLANCO Y NEGRO");
        System.out.println("**************************************************************************************************************************");
        System.out.println("  CANTIDAD: " + ImageController.getInstance().getImageColorLessList().getCount());
        System.out.println("");
        while (imagebCurrent != null) {
            System.out.println("  IMAGEN EN BLANCO Y NEGRO >> CLIENTE: " + imagebCurrent.getElement().getClient().getName() + ", ID CLIENTE: " + imagebCurrent.getElement().getClient().getId());
            imagebCurrent = imagebCurrent.getAfter();
        }
        System.out.println("");
    }

    private void stepWindow() {
        boolean flag = true;
        Node<Window> windows = WindowController.getInstance().getWindowList().get();

        while (windows != null && flag) {
            Client client = ClientController.getInstance().getReceptionQueue().dequeue();
            if (windows.getElement().getClient() == null && client != null) {
                windows.getElement().setClient(client);
                flag = false;
                step += "\n  EL CLIENTE " + client.getName() + " INGRESA A LA VENTANILLA " + windows.getElement().getId() + "\n";
            }
            windows = windows.getAfter();
        }
    }

    private void stepImageWindow() {
        boolean flag = true;
        Node<Window> windows = WindowController.getInstance().getWindowList().get();
        while (windows != null) {
            Window window = windows.getElement();
            Client client = null;
            client = window.getClient();
            if (client != null) {
                    if (window.getColorImage() == client.getColorImage() && window.getColorlessImage() == client.getColorlessImage()) {
                        step += "\n  EL CLIENTE " + client.getName() + " INGRESA A LA LISTA DE ESPERA\n";
                        ClientController.getInstance().addClientWaiting(client);
                        window.setClient(null);
                        window.setColorImage(0);
                        window.setColorlessImage(0);
                        window.setImages(new Stack<Image>());

                        step += "\n  LA IMPRESORA A BLANCO Y NEGRO RECIBIO " + client.getColorlessImage() + " IMAGENES/IMAGEN\n";
                        for(int x=0; x<client.getColorlessImage(); x++) {
                            ImageController.getInstance().addColorLess(new Image(0, "BLANCO Y NEGRO", client));
                        }

                        step += "\n  LA IMPRESORA A COLOR RECIBIO " + client.getColorImage() + " IMAGENES/IMAGEN\n";
                        for(int x=0; x<client.getColorImage(); x++) {
                            ImageController.getInstance().addColor(new Image(0, "COLOR", client));
                        }


                    } else if (window.getColorlessImage() < client.getColorlessImage()) {
                        window.getImages().add(new Image(idImage, "BLANCO Y NEGRO", client));
                        window.setColorlessImage(window.getColorlessImage()+1);
                        idImage++;
                        step += "\n  VENTANILLA " + window.getId() + " RECIBIÓ UNA IMAGEN A BLANCO Y NEGRO\n";
                    }else if (window.getColorImage() < client.getColorImage()) {
                        window.getImages().add(new Image(idImage, "COLOR", client));
                        window.setColorImage(window.getColorImage()+1);
                        idImage++;
                        step += "\n  VENTANILLA " + window.getId() + " RECIBIÓ UNA IMAGEN A COLOR\n";
                    }
            }
            windows = windows.getAfter();
        }
    }

    private void stepWaiting() {
        for(int x = 0; x < ClientController.getInstance().getClientWaiting().getCount(); x++) {
            Node<Client> current = ClientController.getInstance().getClientWaiting().get();
            Integer idNodeClient = 0;
            boolean flag = true;

            if (current != null) {
                do {
                    if(current.getElement().getImages().getCount() >= (current.getElement().getColorImage() + current.getElement().getColorlessImage())) {
                        idNodeClient = current.getId();
                        flag = false;
                    }
                    current = current.getAfter();
                } while (current != ClientController.getInstance().getClientWaiting().get() && flag);
            }
            if(!flag) {
                Client client = ClientController.getInstance().deleteClientWaiting(idNodeClient);
                if (client != null) {
                    step += "\n  EL CLIENTE " + client.getName() + " INGRESA A LA LISTA DE CLIENTES ATENDIDOS\n";
                    ClientController.getInstance().addClientsServed(client);
                }
            }
        }
    }

    private void stepPrinters() {
        Image imageColorless = ImageController.getInstance().dequeueColorLess();

        if(imageColorless != null) {
            //System.out.println("SIN COLOR >> NAME:" + imageColorless.getNameClient());
            Client client2 = ClientController.getInstance().findClientWaiting(imageColorless.getClient().getId());
            if(client2 != null) {
                client2.getImages().add(imageColorless);
                step += "\n  EL CLIENTE " + client2.getName() + " RECIBIO UNA IMAGEN EN BLANCO Y NEGRO\n";
            }
        }

        Image imageColor = ImageController.getInstance().dequeueColor();
        if(imageColor != null) {
            //System.out.println("SIN COLOR >> NAME:" + imageColor.getNameClient());
            Client client1 = ClientController.getInstance().findClientWaiting(imageColor.getClient().getId());
            if (client1 != null) {
                client1.getImages().add(imageColor);
                step += "\n  EL CLIENTE " + client1.getName() + " RECIBIO UNA IMAGEN A COLOR\n";
            }
        }
    }

    private void generateClient() {
        Random rand = new Random();
        // GENERA DE 0 A 3 CLIENTES
        Integer numberClient = rand.nextInt(4);

        step += "\n  INGRESARON " + numberClient + " A LA COLA DE RECEPCION\n";

        for (int x=0; x<numberClient; x++) {
            Client client = new Client(
                    idClient,
                    NAMES[rand.nextInt(15)] + " " + SECONDNAME[rand.nextInt(15)],
                    rand.nextInt((4-1)+1)+1,
                    rand.nextInt((4-1)+1)+1);
            ClientController.getInstance().addReceptionQueue(client);
            ClientController.getInstance().add(client);
            idClient++;
        }
    }

    /* METODOS DE LAS OPCIONES ------------------------------------------------------- */
    private void execStep() throws IOException {
        clear();
        options();

        numberSteps++;
        step += "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                "  PASO " + numberSteps + "\n" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";

        generateClient();

        stepPrinters(); // 4
        stepWaiting(); // 3
        stepImageWindow(); // 2
        stepWindow(); // 1

        infoSteps();

        steps.add(step);
        step = "";
        System.out.println("  PRESIONE ENTER PARA CONTINUAR.");
        reader();
        clear();
    }

    // INFO DE PASOS
    private void stateMemory() throws IOException {
        Node<String> current = steps.get();

        while (current != null) {
            System.out.println(current.getElement());
            current = current.getAfter();
        }

        System.out.println("  PRESIONE ENTER PARA CONTINUAR.");
        reader();
        clear();
    }

    /* REPORTES ------------------------------------------------------- */
    private String receptionReport() {
        Node<Client> current = ClientController.getInstance().getReceptionQueue().get();
        String info = "";
        String conecction = "";
        String node = "";

        while (current != null) {
            node += "\t\"client" + current.getElement().getId() +"\" [\n" +
                    "\t\tlabel = \"ID: " + current.getElement().getId() + "|NOMBRE: " + current.getElement().getName() + "|IMG_C: " + current.getElement().getColorImage() + "|IMG_BN: " + current.getElement().getColorlessImage() + "\"\n" +
                    "\t\tshape = \"record\"\n" +
                    "\t];";
            if(current.getAfter() != null) {
                conecction += ("client" + current.getElement().getId() + " -> ");
            } else {
                conecction += ("client" + current.getElement().getId() + ";");
            }
            current = current.getAfter();
        }

        info += "\tsubgraph cluster_0 {\n" +
                "\t\tstyle=filled;\n" +
                "\t\tcolor=lightgrey;\n" +
                "\t\tnode [style=filled,color=white];\n" +
                "\t\t" + conecction + "\n" +
                "\t\tlabel = \"COLA DE RECEPCIÓN\";\n" +
                "\t}\n" +
                node;

        return info;
    }

    private String windowReport() {
        Node<Window> current = WindowController.getInstance().getWindowList().get();
        String info = "";
        String conecction = "";
        String conecction1 = "";
        String conecction2 = "";
        String node = "";

        while (current != null) {
            node += "\t\"window" + current.getElement().getId() +"\" [\n" +
                    "\t\tlabel = \"VENTANILLA " + current.getElement().getId() + "\"\n" +
                    "\t\tshape = \"record\"\n" +
                    "\t\tcolor = \"lightyellow\"\n" +
                    "\t];\n";
            if(current.getAfter() != null) {
                conecction += ("window" + current.getElement().getId() + " -> ");
            } else {
                conecction += ("window" + current.getElement().getId() + ";");
            }

            if(current.getElement().getClient() != null) {
                node += "\t\"client" + current.getElement().getClient().getId() +"\" [\n" +
                        "\t\tlabel = \"CLIENTE " + current.getElement().getClient().getName() + "\"\n" +
                        "\t\tshape = \"record\"\n" +
                        "\t];\n";

                conecction1 += "\t\tclient" + current.getElement().getClient().getId() + " -> window" + current.getElement().getId() + ";\n";
            }

            Integer numberColor = current.getElement().getColorImage();
            Integer numberColorless = current.getElement().getColorlessImage();

            if (numberColorless > 0) {
                if (numberColorless == 1) {
                    node += "\t\"" + "imgWindow" + current.getElement().getId() + "_0" + "\" [\n" +
                            "\t\tlabel = \"IMG_BN" + "\"\n" +
                            "\t\tshape = \"record\"\n" +
                            "\t];\n";
                    conecction2 += "window" + current.getElement().getId() + " -> " + "imgWindow" + current.getElement().getId() + "_0";
                } else {
                    for (int x = 0; x < numberColorless; x++) {
                        node += "\n\t\"imgWindow" + current.getElement().getId() + "_" + x + "\" [\n" +
                                "\t\tlabel = \"IMG_BN" + "\"\n" +
                                "\t\tshape = \"record\"\n" +
                                "\t];\n";

                        if(x == 0) {
                            conecction2 += "window" + current.getElement().getId() + " -> imgWindow" + current.getElement().getId() + "_" + x;
                        } else {
                            conecction2 += " -> imgWindow" + current.getElement().getId() + "_" + x;
                        }
                    }
                }
            }

            if (numberColor > 0) {
                for (int x = 0; x < numberColor; x++) {
                    node += "\t\"imgCWindow" + current.getElement().getId() + "_" + x +"\" [\n" +
                            "\t\tlabel = \"IMG_C" + "\"\n" +
                            "\t\tshape = \"record\"\n" +
                            "\t];";
                    conecction2 += " -> imgCWindow" + current.getElement().getId() + "_" + x;
                }
            }
            if ((numberColorless > 0)) {
                conecction2 += ";\n";
            }

            current = current.getAfter();
        }

        info += "\tsubgraph cluster_1 {\n" +
                "\t\tstyle=filled;\n" +
                "\t\tcolor=lightgrey;\n" +
                "\t\tnode [style=filled,color=white];\n" +
                "\t\t" + conecction + "\n" +
                "\t\t" + conecction1 + "\n" +
                "\t\t" + conecction2 + "\n" +
                "\t\tlabel = \"VENTANILLAS\";\n" +
                "\t}\n" +
                node;

        return info;
    }

    private String waitingReport() {
        Node<Client> current = ClientController.getInstance().getClientWaiting().get();
        String info = "";
        String conecction = "";
        String conecction1 = "";
        String node = "";

        if(current != null) {
            do {
                node += "\t\"client" + current.getElement().getId() +"\" [\n" +
                        "\t\tlabel = \"ID: " + current.getElement().getId() + "|NOMBRE: " + current.getElement().getName() + "|IMG_C: " + current.getElement().getColorImage() + "|IMG_BN: " + current.getElement().getColorlessImage() + "\"\n" +
                        "\t\tshape = \"record\"\n" +
                        "\t];";
                conecction += ("client" + current.getElement().getId() + " -> client" + current.getAfter().getElement().getId() + ";");
                conecction += ("client" + current.getElement().getId() + " -> client" + current.getBefore().getElement().getId() + ";");

                Node<Image> imageCurrent = current.getElement().getImages().get();
                while (imageCurrent != null) {
                    if (imageCurrent.getElement().getType().equals("BLANCO Y NEGRO")) {
                        node += "\t\"img" + current.getElement().getId() + "_" + imageCurrent.getId() +"\" [\n" +
                                "\t\tlabel = \"IMG_BN\"\n" +
                                "\t\tshape = \"record\"\n" +
                                "\t];";
                    } else if (imageCurrent.getElement().getType().equals("COLOR")) {
                        node += "\t\"img" + current.getElement().getId() + "_" + imageCurrent.getId() +"\" [\n" +
                                "\t\tlabel = \"IMG_C\"\n" +
                                "\t\tshape = \"record\"\n" +
                                "\t];";
                    }
                    conecction1 += " -> img" + current.getElement().getId() + "_" + imageCurrent.getId();
                    imageCurrent = imageCurrent.getAfter();
                }

                if(current.getElement().getImages().getCount() > 0) {
                    conecction1 = "client" + current.getElement().getId() + conecction1 + ";\n";
                }

                current = current.getAfter();
            } while (current != ClientController.getInstance().getClientWaiting().get());

            info += "\tsubgraph cluster_2 {\n" +
                    "\t\tstyle=filled;\n" +
                    "\t\tcolor=lightgrey;\n" +
                    "\t\tnode [style=filled,color=white];\n" +
                    "\t\t" + conecction + "\n" +
                    "\t\t" + conecction1 + "\n" +
                    "\t\tlabel = \"LISTA DE ESPERA PARA IMPRESION\";\n" +
                    "\t}\n" +
                    node;
        }
        return info;
    }

    private String printerReport() {
        Node<Image> currentColorLess = ImageController.getInstance().getImageColorLessList().get();
        Node<Image> currentColor = ImageController.getInstance().getImageColorList().get();
        String info = "";
        String conecction = "";
        String conecction1 = "";
        String node = "";

        while (currentColorLess != null) {
            node += "\t\"PRINTBN_IMG" + currentColorLess.getElement().getId() +"\" [\n" +
                    "\t\tlabel = \"IMG_BN\"\n" +
                    "\t\tshape = \"record\"\n" +
                    "\t];\n";

            conecction += " -> PRINTBN_IMG" + currentColorLess.getElement().getId();
            currentColorLess = currentColorLess.getAfter();
        }

        node += "\t\"PRINT_BN\" [\n" +
                "\t\tlabel = \"IMPRESORA EN BLANCO Y NEGRO\"\n" +
                "\t\tshape = \"record\"\n" +
                "\t\tcolor = \"lightyellow\"\n" +
                "\t];\n";

        conecction = "PRINT_BN" + conecction + ";\n";

        while (currentColor != null) {
            node += "\t\"PRINTC_IMG" + currentColor.getElement().getId() +"\" [\n" +
                    "\t\tlabel = \"IMG_C \"\n" +
                    "\t\tshape = \"record\"\n" +
                    "\t];\n";

            conecction1 += " -> PRINTC_IMG" + currentColor.getElement().getId();
            currentColor = currentColor.getAfter();
        }

        node += "\t\"PRINT_C\" [\n" +
                "\t\tlabel = \"IMPRESORA A COLOR\"\n" +
                "\t\tshape = \"record\"\n" +
                "\t\tcolor = \"lightyellow\"\n" +
                "\t];\n";

        conecction1 = "PRINT_C" + conecction1 + ";\n";

        info += "\tsubgraph cluster_3 {\n" +
                "\t\tstyle=filled;\n" +
                "\t\tcolor=lightgrey;\n" +
                "\t\tnode [style=filled,color=white];\n" +
                "\t\t" + conecction + "\n" +
                "\t\t" + conecction1 + "\n" +
                "\t\tlabel = \"IMPRESORAS\";\n" +
                "\t}\n" +
                node;

        return info;
    }

    private String serverdReport() {
        Node<Client> current = ClientController.getInstance().getClientsServed().get();
        String info = "";
        String conecction = "";
        String node = "";

        while (current != null) {
            node += "\t\"client" + current.getElement().getId() +"\" [\n" +
                    "\t\tlabel = \"ID: " + current.getElement().getId() + "|NOMBRE: " + current.getElement().getName() + "|IMG_C: " + current.getElement().getColorImage() + "|IMG_BN: " + current.getElement().getColorlessImage() + "\"\n" +
                    "\t\tshape = \"record\"\n" +
                    "\t];";
            if(current.getAfter() != null) {
                conecction += ("client" + current.getElement().getId() + " -> ");
            } else {
                conecction += ("client" + current.getElement().getId() + ";");
            }
            current = current.getAfter();
        }

        info += "\tsubgraph cluster_4 {\n" +
                "\t\tstyle=filled;\n" +
                "\t\tcolor=lightgrey;\n" +
                "\t\tnode [style=filled,color=white];\n" +
                "\t\t" + conecction + "\n" +
                "\t\tlabel = \"CLIENTES ATENDIDOS\";\n" +
                "\t}\n" +
                node;

        return info;
    }

    private void report() {
        String head = "digraph g {\n" +
                "\tgraph [\n" +
                "\t\trankdir = \"LR\"\n" +
                "\t];\n" +
                "\t\n" +
                "\tnode [\n" +
                "\t\tfontsize = \"16\"\n" +
                "\t\tshape = \"ellipse\"\n" +
                "\t];\n" +
                "\t\n" +
                "\tedge [\n" +
                "\t];\n\n" +
                receptionReport() + "\n" +
                windowReport() + "\n" +
                waitingReport() + "\n" +
                printerReport() + "\n" +
                serverdReport() + "\n" +
                "}";

        DocumentController.getInstance().documentWriting("Report.dot", head);
        DocumentController.getInstance().execGraphviz("Report.dot", "Report", "png");
        DocumentController.getInstance().execGraphviz("Report.dot", "Report", "pdf");
        DocumentController.getInstance().execGraphviz("Report.dot", "Report", "svg");
        DocumentController.getInstance().openDocument("Report.png");
    }
}
