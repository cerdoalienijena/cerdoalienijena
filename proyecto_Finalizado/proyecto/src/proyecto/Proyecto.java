/**
 * Juego de calculo mental/Calculadora de algoritmo de euclides y resto de division
 *
 * @author Grupo 1 Bilingüe
 * @version 2.0 , 2021/11/15
 */
package proyecto;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Proyecto {

    public static int countdownStarter = 10;

    /**
     * Genera un menu en el que el usuario puede elegir que opcion quiere
     * utilizar dificultad se asigna dependiendo del curso del usuario operacion
     * se utiliza para saber que opcion se elige x e y son utilizados para el
     * algoritmo de euclides exit para poder salir del programa
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Random rnd = new Random();

        int dificultad, operacion, result, respuesta;
        int x, y;
        String Usuario;
        char exit;
        System.out.println("Nombre de usuario: ");
        Usuario = sc.nextLine();

        //Menu de el programa
        do {
            System.out.print("Choose your option:\n"
                    + "1. Sum \n"
                    + "2. Substract \n"
                    + "3. Multiplication \n"
                    + "4. Division \n"
                    + "5. Euclidean algorithm \n"
                    + "6. Mod \n"
                    + "7. Exit \n");
            operacion = sc.nextInt();

            /**
             * En cada funcion hay 4 dificultades de 1 de ESO A 4 En cada
             * dificultad se añaden digitos a los numeros
             */
            switch (operacion) {
                case 1:
                    System.out.print("Nivel de dificultad por curso(1-4): ");
                    dificultad = sc.nextInt();
                    Suma(dificultad);

                    break;
                case 2:
                    System.out.print("Nivel de dificultad por curso(1-4): ");
                    dificultad = sc.nextInt();
                    Resta(dificultad);

                    break;
                case 3:
                    System.out.print("Nivel de dificultad por curso(1-4): ");
                    dificultad = sc.nextInt();
                    Multiplicacion(dificultad);

                    break;
                case 4:
                    System.out.print("Nivel de dificultad por curso(1-4): ");
                    dificultad = sc.nextInt();
                    Division(dificultad);

                    break;
                case 5:
                    int z = 1;

                    do {
                        x = rnd.nextInt(998) + 1;
                        y = rnd.nextInt(89) + 10;
                        z = euclid(x, y);
                    } while (z == 1);

                    System.out.println("El MCD de " + x + " y " + y + " = ");
                    respuesta = sc.nextInt();
                    if (respuesta == euclid(x, y)) {
                        System.out.println("Es correcto");
                    } else {
                        System.out.println("Es incorrecto " + euclid(x, y));
                    }
                    break;
                case 6:
                    System.out.print("Nivel de dificultad por curso(1-4): ");
                    dificultad = sc.nextInt();
                    Mod(dificultad);
                    break;
                case 7:
                    System.exit(0);
                default:

            }

            System.out.println("\nDo you want to try again? " + Usuario);
            System.out.println("Enter S to exit or another key to continue");
            exit = sc1.next().charAt(0);
            exit = Character.toUpperCase(exit);

        } while (exit != 'S');

    }

    /**
     *
     * Metodo de calculo mental de la suma genera dos numeros aleatorios segun
     * la dificultad y el usuario tiene que responder en el tiempo estipulado
     *
     * @param dificultad selecciona la dificultad.
     * @return devuelve el numero de respuestas correctas.
     *
     * Preguntas es un contador de preguntas count es un contador de preguntas
     * correctas En suma se almacena el resultado de la suma azar1 y azar2
     * almacena el numero aleatorio en cada dificultad se aumentan los digitos
     * que pueden tener los numeros respuesta almacena la respuesta del usuario
     */
    public static int Suma(int dificultad) {

        int preguntas = 0, count = 0, suma, azar1, azar2, respuesta;
        Scanner sc3 = new Scanner(System.in);
        Random rnd = new Random();//Generador de numeros aleatorios

        switch (dificultad) {// EN ESTE SWITCH DEPENDIENDO EN QUE CURSO ESTE EL USUARIO ASIGNAMOS LA DIFICULTAD
            case 1:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;

                    azar1 = rnd.nextInt(8) + 1;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
                    azar2 = rnd.nextInt(8) + 1;
                    suma = azar1 + azar2;
                    System.out.println(azar1 + " + " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");

                    respuesta = sc3.nextInt();

                    if (respuesta == suma && countdownStarter > 0) {
                        System.out.println("Es correcto");
                        count++;

                    } //Si es correcta la respuesta sumamos 1 en el contador de preguntas correctas
                    if (respuesta != suma && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != suma && countdownStarter == 1) {
                        System.out.println("Es incorrecto");

                    } else if (countdownStarter <= 1 && respuesta == suma) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado

                } while (preguntas != 10);//Este ciclo no acaba hasta que no haya preguntado 10 veces
                countdownStarter = 0;
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                return count;

            case 2:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    azar1 = rnd.nextInt(89) + 10;//la dificultad aumenta
                    azar2 = rnd.nextInt(8) + 1;
                    suma = azar1 + azar2;
                    System.out.println(azar1 + " + " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == suma && countdownStarter > 0) {
                        System.out.println("Es correcto");
                        count++;

                    } //Si es correcta la respuesta sumamos 1 en el contador de preguntas correctas
                    if (respuesta != suma && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != suma && countdownStarter == 1) {
                        System.out.println("Es incorrecto");

                    } else if (countdownStarter <= 1 && respuesta == suma) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++;
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);

                return count;
            case 3:
                do {
                    countdownStarter = 10;
                    Time();
                    azar1 = rnd.nextInt(89) + 10;
                    azar2 = rnd.nextInt(89) + 10;
                    suma = azar1 + azar2;
                    System.out.println(azar1 + " + " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == suma) {
                        System.out.println("Es correcto");
                        count++;
                    }
                    if (respuesta != suma && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != suma && countdownStarter == 1) {
                        System.out.println("Es incorrecto");

                    } else if (countdownStarter <= 1 && respuesta == suma) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++;
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);

                return count;
            case 4:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    azar1 = rnd.nextInt(899) + 100;
                    azar2 = rnd.nextInt(89) + 10;
                    suma = azar1 + azar2;
                    System.out.println(azar1 + " + " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == suma) {
                        System.out.println("Es correcto");
                        count++;
                    }
                    if (respuesta != suma && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != suma && countdownStarter == 1) {
                        System.out.println("Es incorrecto");

                    } else if (countdownStarter <= 1 && respuesta == suma) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++;
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
        }
        return count;

    }

    /**
     *
     * Metodo de calculo mental de la Resta genera dos numeros aleatorios segun
     * la dificultad y el usuario tiene que responder en el tiempo estipulado
     *
     * @param dificultad selecciona la dificultad.
     * @return devuelve el numero de respuestas correctas.
     */
    public static int Resta(int dificultad) {

        int preguntas = 0, count = 0, resta, azar1, azar2, respuesta;
        Scanner sc3 = new Scanner(System.in);
        Random rnd = new Random();
        switch (dificultad) {// EN ESTE SWITCH DEPENDIENDO EN QUE CURSO ESTE EL USUARIO ASIGNAMOS LA DIFICULTAD
            case 1:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    azar1 = rnd.nextInt(8) + 1;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
                    azar2 = rnd.nextInt(8) + 1;
                    //Este if sirve para que nunca el resultado sea negativo
                    if (azar1 < azar2) {
                        resta = azar2 - azar1;
                        System.out.println(azar2 + " - " + azar1 + " = ");
                    } else {
                        resta = azar1 - azar2;
                        System.out.println(azar1 + " - " + azar2 + " = ");
                    }

                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == resta) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != resta && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != resta && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == resta) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                return count;
            case 2:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    azar1 = rnd.nextInt(97) + 2;
                    azar2 = rnd.nextInt(8) + 1;
                    if (azar1 < azar2) {
                        resta = azar2 - azar1;
                        System.out.println(azar2 + " - " + azar1 + " = ");
                    } else {
                        resta = azar1 - azar2;
                        System.out.println(azar1 + " - " + azar2 + " = ");
                    }

                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == resta) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != resta && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != resta && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == resta) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                return count;
            case 3:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    azar1 = rnd.nextInt(97) + 2;
                    azar2 = rnd.nextInt(97) + 2;
                    if (azar1 < azar2) {
                        resta = azar2 - azar1;
                        System.out.println(azar2 + " - " + azar1 + " = ");
                    } else {
                        resta = azar1 - azar2;
                        System.out.println(azar1 + " - " + azar2 + " = ");
                    }

                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == resta) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != resta && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != resta && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == resta) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                return count;
            case 4:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    azar1 = rnd.nextInt(899) + 100;
                    azar2 = rnd.nextInt(89) + 10;
                    if (azar1 < azar2) {
                        resta = azar2 - azar1;
                        System.out.println(azar2 + " - " + azar1 + " = ");
                    } else {
                        resta = azar1 - azar2;
                        System.out.println(azar1 + " - " + azar2 + " = ");
                    }

                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == resta) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != resta && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != resta && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == resta) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);

        }
        return count;
    }

    /**
     * Metodo de calculo mental de la Multiplicacion genera dos numeros
     * aleatorios segun la dificultad y el usuario tiene que responder en el
     * tiempo estipulado
     *
     * @param dificultad selecciona la dificultad.
     * @return devuelve el numero de respuestas correctas.
     */
    public static int Multiplicacion(int dificultad) {
        int preguntas = 0, count = 0, multiplicacion, azar1, azar2, respuesta;
        Scanner sc3 = new Scanner(System.in);
        Random rnd = new Random();//Generador de numeros aleatorios

        switch (dificultad) {// EN ESTE SWITCH DEPENDIENDO EN QUE CURSO ESTE EL USUARIO ASIGNAMOS LA DIFICULTAD
            case 1:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    azar1 = rnd.nextInt(8) + 1;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
                    azar2 = rnd.nextInt(8) + 1;
                    multiplicacion = azar1 * azar2;
                    System.out.println(azar1 + " * " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == multiplicacion) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != multiplicacion && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != multiplicacion && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == multiplicacion) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                return count;
            case 2:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    azar1 = rnd.nextInt(89) + 10;
                    azar2 = rnd.nextInt(8) + 1;
                    multiplicacion = azar1 * azar2;
                    System.out.println(azar1 + " * " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == multiplicacion) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != multiplicacion && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != multiplicacion && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == multiplicacion) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                return count;
            case 3:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    azar1 = rnd.nextInt(899) + 100;
                    azar2 = rnd.nextInt(8) + 1;
                    multiplicacion = azar1 * azar2;
                    System.out.println(azar1 + " * " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == multiplicacion) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != multiplicacion && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != multiplicacion && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == multiplicacion) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                return count;

            case 4:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    azar1 = rnd.nextInt(89) + 10;
                    azar2 = rnd.nextInt(89) + 10;
                    multiplicacion = azar1 * azar2;
                    System.out.println(azar1 + " * " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == multiplicacion) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != multiplicacion && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != multiplicacion && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == multiplicacion) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);

        }
        return count;
    }

    /**
     *
     * Metodo de calculo mental de la Division genera dos numeros aleatorios
     * segun la dificultad y el usuario tiene que responder en el tiempo
     * estipulado
     *
     * @param dificultad selecciona la dificultad.
     * @return devuelve el numero de respuestas correctas.
     */
    public static int Division(int dificultad) {
        int preguntas = 0, count = 0, division, azar1, azar2, respuesta;
        Scanner sc3 = new Scanner(System.in);
        Random rnd = new Random();//Generador de numeros aleatorios

        switch (dificultad) {
            case 1:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    //Este do while funciana que hasta que los 2 numeros no sean divisibles no se se mandan las 2 variables
                    do {
                        azar1 = rnd.nextInt(8) + 1;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
                        azar2 = rnd.nextInt(8) + 1;
                    } while (azar1 % azar2 != 0);

                    division = azar1 / azar2;
                    System.out.println(azar1 + " / " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == division) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != division && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != division && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == division) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                return count;
            case 2:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;

                    azar1 = rnd.nextInt(89) + 10;
                    azar2 = rnd.nextInt(8) + 1;

                    division = azar1 % azar2;
                    System.out.println(azar1 + " % " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == division) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != division && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != division && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == division) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                return count;

            case 3:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    do {
                        azar1 = rnd.nextInt(899) + 100;
                        azar2 = rnd.nextInt(8) + 1;
                    } while (azar1 % azar2 != 0);

                    division = azar1 / azar2;
                    System.out.println(azar1 + " / " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == division) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != division && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != division && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == division) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                return count;

            case 4:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    do {
                        azar1 = rnd.nextInt(899) + 100;
                        azar2 = rnd.nextInt(89) + 10;
                    } while (azar1 % azar2 != 0);

                    division = azar1 / azar2;
                    System.out.println(azar1 + " / " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == division) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != division && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != division && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == division) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);

        }
        return count;

    }

    /**
     *
     * Hace la division de los 2 numeros insertados y devuelve el resto
     *
     * @param dificultad
     * @return Devuelve el resultado para mostrarlo en pantalla
     */
    public static int Mod(int dificultad) {
        int preguntas = 0, count = 0, result = 0, azar1, azar2, respuesta;
        Scanner sc3 = new Scanner(System.in);
        Random rnd = new Random();//Generador de numeros aleatorios

        switch (dificultad) {
            case 1:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;

                    azar1 = rnd.nextInt(8) + 1;
                    azar2 = rnd.nextInt(8) + 1;

                    result = azar1 % azar2;
                    System.out.println(azar1 + " / " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == result) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != result && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != result && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 0 && respuesta == result) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                break;
            case 2:
                countdownStarter = 10;
                Time();

                do {
                    countdownStarter = 10;
                    do {
                        azar1 = rnd.nextInt(89) + 10;
                        azar2 = rnd.nextInt(8) + 1;
                    } while (azar1 % azar2 != 0);

                    result = azar1 % azar2;
                    System.out.println(azar1 + " / " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == result) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != result && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != result && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == result) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                break;
            case 3:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    do {
                        azar1 = rnd.nextInt(89) + 10;
                        azar2 = rnd.nextInt(89) + 10;
                    } while (azar1 % azar2 != 0);

                    result = azar1 % azar2;
                    System.out.println(azar1 + " / " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == result) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != result && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != result && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == result) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);

            case 4:
                countdownStarter = 10;
                Time();
                do {
                    countdownStarter = 10;
                    do {
                        azar1 = rnd.nextInt(899) + 100;
                        azar2 = rnd.nextInt(89) + 10;
                    } while (azar1 % azar2 != 0);

                    result = azar1 % azar2;
                    System.out.println(azar1 + " / " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == result) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamso 1 en el contador de preguntas correctas
                    }
                    if (respuesta != result && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                    if (respuesta != result && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                    } else if (countdownStarter <= 1 && respuesta == result) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
        }
        return result;

    }

    /**
     * En esta funcion se hace el algoritmo de euclides
     *
     * @param a numero aleatorio 1
     * @param b numero aleatorio 2
     * @return Devuelve el mcd de los 2 numero inseratados
     */
    public static int euclid(int a, int b) {

        if (b == 0) {
            return a;
        }
        return euclid(b, a % b);
    }

    /**
     * Temporizador usado en los metodos de calculo mental
     */
    public static void Time() {

        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Runnable runnable = new Runnable() {

            public void run() {

                System.out.println(countdownStarter);
                countdownStarter--;

                if (countdownStarter <= 0) {
                    scheduler.shutdown();

                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
    }
}
