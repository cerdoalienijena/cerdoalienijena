
        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author costa
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        //dificultad se asigna dependiendo del curso del usuario
        //count es un contador de preguntas correctas
        //operacion se utiliza para saber que opcion se elige
        //x e y son utilizados para el algoritmo de euclides
        //exit para poder salir del programa
        int dificultad, count, operacion, x, y;
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
                    + "5. Euclidean algorithm \n");
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
        //Preguntas es un contador de preguntas
        //count es un contador de preguntas correctas
        //En suma se almacena el resultado de la suma
        //azar1 y azar2 almacena el numero aleatorio en cada dificultad se aumentan los digitos que pueden tener los numeros
        //respuesta almacena la respuesta del usuario
        int preguntas = 0, count = 0, suma, azar1, azar2, respuesta;
        Scanner sc3 = new Scanner(System.in);
        Random rnd = new Random();//Generador de numeros aleatorios

        switch (dificultad) {// EN ESTE SWITCH DEPENDIENDO EN QUE CURSO ESTE EL USUARIO ASIGNAMOS LA DIFICULTAD
            case 1:
                do {
                    azar1 = rnd.nextInt(8) + 1;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
                    azar2 = rnd.nextInt(8) + 1;
                    suma = azar1 + azar2;
                    System.out.println(azar1 + " + " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == suma) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamos 1 en el contador de preguntas correctas
                    } else {
                        System.out.println("Es incorrecto");

                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);//Este ciclo no acaba hasta que no haya preguntado 10 veces
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                return count;
            case 2:
                do {
                    azar1 = rnd.nextInt(89) + 10;//la dificultad aumenta
                    azar2 = rnd.nextInt(8) + 1;
                    suma = azar1 + azar2;
                    System.out.println(azar1 + " + " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == suma) {
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

                    } else {
                        System.out.println("Es incorrecto");

                    }
                    preguntas++;
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);

                return count;
            case 4:
                do {
                    azar1 = rnd.nextInt(899) + 100;
                    azar2 = rnd.nextInt(8) + 1;
                    suma = azar1 + azar2;
                    System.out.println(azar1 + " + " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == suma) {
                        System.out.println("Es correcto");
                        count++;

                    } else {
                        System.out.println("Es incorrecto");

                    }
                    preguntas++;
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
        }
        return count;
    }

    static int Resta(int dificultad) {
        //Preguntas es un contador de preguntas
        //count es un contador de preguntas correctas
        //En resta se almacena el resultado de la suma
        //azar1 y azar2 almacena el numero aleatorio en cada dificultad se aumentan los digitos que pueden tener los numeros
        //respuesta almacena la respuesta del usuario
        int preguntas = 0, count = 0, resta, azar1, azar2, respuesta;
        Scanner sc3 = new Scanner(System.in);
        Random rnd = new Random();
        switch (dificultad) {// EN ESTE SWITCH DEPENDIENDO EN QUE CURSO ESTE EL USUARIO ASIGNAMOS LA DIFICULTAD
            case 1:
                do {
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
                    } else {
                        System.out.println("Es incorrecto");
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                return count;
            case 2:
                do {
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
                    } else {
                        System.out.println("Es incorrecto");
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                return count;
            case 3:
                do {
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
                    } else {
                        System.out.println("Es incorrecto");
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);
                return count;
            case 4:
                do {
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
                    } else {
                        System.out.println("Es incorrecto");
                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);

        }
        return count;
    }

    static int Multiplicacion(int dificultad) {
        //Preguntas es un contador de preguntas
        //count es un contador de preguntas correctas
        //En multiplicacion se almacena el resultado de la suma
        //azar1 y azar2 almacena el numero aleatorio en cada dificultad se aumentan los digitos que pueden tener los numeros
        //respuesta almacena la respuesta del usuario
        int preguntas = 0, count = 0, multiplicacion, azar1, azar2, respuesta;
        Scanner sc3 = new Scanner(System.in);
        Random rnd = new Random();//Generador de numeros aleatorios

        switch (dificultad) {// EN ESTE SWITCH DEPENDIENDO EN QUE CURSO ESTE EL USUARIO ASIGNAMOS LA DIFICULTAD
            case 1:
                do {
                    azar1 = rnd.nextInt(8) + 1;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
                    azar2 = rnd.nextInt(8) + 1;
                    multiplicacion = azar1 * azar2;
                    System.out.println(azar1 + " * " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == multiplicacion) {
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
                do {
                    azar1 = rnd.nextInt(89) + 10;
                    azar2 = rnd.nextInt(8) + 1;
                    multiplicacion = azar1 * azar2;
                    System.out.println(azar1 + " * " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == multiplicacion) {
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
            case 3:
                do {
                    azar1 = rnd.nextInt(899) + 100;
                    azar2 = rnd.nextInt(8) + 1;
                    multiplicacion = azar1 * azar2;
                    System.out.println(azar1 + " * " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == multiplicacion) {
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

            case 4:
                do {
                    azar1 = rnd.nextInt(89) + 10;
                    azar2 = rnd.nextInt(89) + 10;
                    multiplicacion = azar1 * azar2;
                    System.out.println(azar1 + " * " + azar2 + " = ");
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (respuesta == multiplicacion) {
                        System.out.println("Es correcto");
                        count++;
//Si es correcta la respuesta sumamos 1 en el contador de preguntas correctas
                    } else {
                        System.out.println("Es incorrecto");

                    }
                    preguntas++; //cada vez que hay un ciclo del programa contamos 1 para saber cuantas preguntas hemos preguntado
                } while (preguntas != 10);
                System.out.println("Tu puntuacion es " + count + " sobre " + preguntas);

        }
        return count;
    }

    static int Division(int dificultad) {
        //Preguntas es un contador de preguntas
        //count es un contador de preguntas correctas
        //En division se almacena el resultado de la suma
        //azar1 y azar2 almacena el numero aleatorio en cada dificultad se aumentan los digitos que pueden tener los numeros
        //respuesta almacena la respuesta del usuario
        int preguntas = 0, count = 0, division, azar1, azar2, respuesta;
        Scanner sc3 = new Scanner(System.in);
        Random rnd = new Random();//Generador de numeros aleatorios

        switch (dificultad) {
            case 1:
                do {
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
                do {
                    do {
                        azar1 = rnd.nextInt(89) + 10;
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

            case 3:
                do {
                    do {
                        azar1 = rnd.nextInt(899) + 100;
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

            case 4:
                do {
                    do {
                        azar1 = rnd.nextInt(899) + 100;
                        azar2 = rnd.nextInt(89) + 10;
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

        }
        return count;

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
}  

     

