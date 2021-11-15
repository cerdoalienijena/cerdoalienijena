
 /**
* Juego de calculo mental/Calculadora de algoritmo de euclides y resto de division
* @author Grupo 1 Bilingüe
* @version 2.0 , 2021/11/15
*/
package proyecto;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 *
 * @author costa
 */

public class Proyecto {

    
    public static int countdownStarter = 10;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        //dificultad se asigna dependiendo del curso del usuario
        //operacion se utiliza para saber que opcion se elige
        //x e y son utilizados para el algoritmo de euclides
        //exit para poder salir del programa
        
        int dificultad,operacion, x, y, result;
        String Usuario;
        char exit = ' ';
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
                    + "6. Mod \n");
            operacion = sc.nextInt();

            //Este switch nos permite seleccionar que curso somos (dificultad) y llamamos a la funcion determinada por el menu anterior
            //Implemente la dificultad dentro de cada case porque en el case 5 que es el algoritmo de euclides no hay dificultad ya que es una calculadora
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
                    //En el algoritmo de euclides se piden 2 numeros y estos se mandan a la funcion
                    System.out.println("Introduce 2 numeros");
                    x = sc.nextInt();
                    y = sc.nextInt();
                    System.out.println("mcd= "+euclid(x,y));
                case 6:
                    System.out.println("Introduce 2 numeros");
                     x = sc.nextInt();
                    y = sc.nextInt();
                    System.out.println("el modular de "+x+" e "+y+" = "+mod(x,y));
                default:
            }

            System.out.println("\nDo you want to try again? " + Usuario);
            System.out.println("Enter S to exit or another key to continue");
            exit = sc1.next().charAt(0);
            exit = Character.toUpperCase(exit);

        } while (exit != 'S');

    }

    //En cada funcion hay 4 dificultades de 1 de ESO A 4
    //En cada dificultad se añaden digitos a los numeros
    static int Suma(int dificultad) {
        /**Preguntas es un contador de preguntas
        /*count es un contador de preguntas correctas
        /*En suma se almacena el resultado de la suma
        /*azar1 y azar2 almacena el numero aleatorio en cada dificultad se aumentan los digitos que pueden tener los numeros
        /*respuesta almacena la respuesta del usuario
        */
        int preguntas = 0, count = 0, suma, azar1, azar2, respuesta;
        Scanner sc3 = new Scanner(System.in);
        Random rnd = new Random();//Generador de numeros aleatorios
        
        
    /**
    * Frase corta descriptiva
    * Descripción del método.
    * @param dificultad selecciona la dificultad(xD).
    * @return count devuelve el numero de respuestas correctas.
    */
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

                    } else {
                        System.out.println("Es incorrecto");

                    }
                    preguntas++;
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);

                return count;
            case 3:
                do {
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

    static int Resta(int dificultad) {
        /**
        * Frase corta descriptiva
        * Descripción del método.
        * @param dificultad selecciona la dificultad(xD).
        * @return count devuelve el numero de respuestas correctas.
        */
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
                    } if (respuesta != resta && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                     if (respuesta != resta && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                     }
                     else if (countdownStarter <= 1 && respuesta == resta) {
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
                    } if (respuesta != resta && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                     if (respuesta != resta && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                     }
                     else if (countdownStarter <= 1 && respuesta == resta) {
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
                    } if (respuesta != resta && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                     if (respuesta != resta && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                     }
                     else if (countdownStarter <= 1 && respuesta == resta) {
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
                    } if (respuesta != resta && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                     if (respuesta != resta && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                     }
                     else if (countdownStarter <= 1 && respuesta == resta) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                     }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);

        }
        return count;
    }

    static int Multiplicacion(int dificultad) {
        /**
        * Frase corta descriptiva
        * Descripción del método.
        * @param dificultad selecciona la dificultad(xD).
        * @return count devuelve el numero de respuestas correctas.
        */
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
                    } if (respuesta != multiplicacion && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                     if (respuesta != multiplicacion && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                     }
                     else if (countdownStarter <= 1 && respuesta == multiplicacion) {
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
                    } if (respuesta != multiplicacion && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                     if (respuesta != multiplicacion && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                     }
                     else if (countdownStarter <= 1 && respuesta == multiplicacion) {
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
                    } if (respuesta != multiplicacion && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                     if (respuesta != multiplicacion && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                     }
                     else if (countdownStarter <= 1 && respuesta == multiplicacion) {
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
                    } if (respuesta != multiplicacion && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                     if (respuesta != multiplicacion && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                     }
                     else if (countdownStarter <= 1 && respuesta == multiplicacion) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                     }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);

        }
        return count;
    }

    static int Division(int dificultad) {
        /**
        * Frase corta descriptiva
        * Descripción del método.
        * @param dificultad selecciona la dificultad(xD).
        * @return count devuelve el numero de respuestas correctas.
        */
        int preguntas = 0, count = 0, division, azar1, azar2, respuesta;
        Scanner sc3 = new Scanner(System.in);
        Random rnd = new Random();//Generador de numeros aleatorios

        switch (dificultad) {
            case 1:
                countdownStarter=10;
                Time();
                do {
                    countdownStarter=10;
                    //Este do while funciana que hasta que los 2 numeros no sean divisibles no se se mandan las 2 variables
                    do {
                        azar1 = rnd.nextInt(8) + 1;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
                        azar2 = rnd.nextInt(8) + 1;
                    } while (azar1 % azar2 != 0);

                    division = azar1 / azar2;
                    System.out.println(azar1 + " / " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (division % respuesta == 0) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamos 1 en el contador de preguntas correctas
                    } else {
                        System.out.println("Es incorrecto");

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
                    do {
                        azar1 = rnd.nextInt(89) + 10;
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
                    } if (respuesta != division && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                     if (respuesta != division && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                     }
                     else if (countdownStarter <= 1 && respuesta == division) {
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
                    } if (respuesta != division && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                     if (respuesta != division && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                     }
                     else if (countdownStarter <= 1 && respuesta == division) {
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
                    } if (respuesta != division && countdownStarter != 1) {
                        System.out.println("Es incorrecto prueba otra vez");
                        System.out.println("Cual es la respuesta");
                        respuesta = sc3.nextInt();
                    }
                     if (respuesta != division && countdownStarter == 1) {
                        System.out.println("Es incorrecto");
                     }
                     else if (countdownStarter <= 1 && respuesta == division) {
                        System.out.println("La respuesta es correcta pero el tiempo se ha acabado");
                        Time();
                     }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);

        }
        return count;

    }
     static int mod(int a, int b){
        int result = 0;
        if (b>a){
        result = b % a;
        }
 return result;       
}
    static int euclid(int a, int b) {
        //En esta funcion se hace el algoritmo de euclides
        if (b == 0) {
            return a;
        } else {
            System.out.println(a + "%" + b + "=" + a % b);
        }
        return euclid(b, a % b);
    }
    
    
    
    
        public static void Time(){
               
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


  

     

