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
        int dificultad, count;
        String Usuario, operacion;
        Scanner sc = new Scanner(System.in);
        System.out.println("Como te llamas");//preguntamos por el usuario
        Usuario = sc.nextLine();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("En que curso estas");//preguntamos el curso para saber la dificultad
        dificultad = sc2.nextInt();
        System.out.println("Que modo de juego quieres jugar");//preguntamos que operacion va ha hacer el usuario
        operacion = sc.nextLine();
        switch (operacion) {//EN ESTE SWITCH MIRAMOS LO QUE HA PUESTO EL USUARIO Y DEPENDIENDO QUE OPERACION ELIJA LLAMAMOS A LA FUNCION
            case "suma":
                count = Suma(dificultad);
                break;
            case "resta":
                count = Resta(dificultad);
                break;
            case "multiplicar":
    count = Multiplicacion(dificultad);
    break;
    case "division":
    count = Division(dificultad);
    break;
            default:
        }

    }

    static int Suma(int dificultad) {
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
                    azar1 = rnd.nextInt(97) + 2;//la dificultad aumenta
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
                    azar1 = rnd.nextInt(97) + 2;
                    azar2 = rnd.nextInt(97) + 2;
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
                    azar1 = rnd.nextInt(197) + 2;
                    azar2 = rnd.nextInt(97) + 2;
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
        int preguntas = 0, count = 0, resta, azar1, azar2, respuesta;
        Scanner sc3 = new Scanner(System.in);
        Random rnd = new Random();
        switch (dificultad) {// EN ESTE SWITCH DEPENDIENDO EN QUE CURSO ESTE EL USUARIO ASIGNAMOS LA DIFICULTAD
            case 1:
                do {
                    azar1 = rnd.nextInt(8) + 1;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
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
            case 2:
                do {
                    azar1 = rnd.nextInt(97) + 2;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
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
                    azar1 = rnd.nextInt(97) + 2;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
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
                    azar1 = rnd.nextInt(197) + 2;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
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

        }
        return count;
    }
    static int Multiplicacion(int dificultad){
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
                    azar1 = rnd.nextInt(97) + 2;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
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
                    azar1 = rnd.nextInt(197) + 2;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
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
                    azar1 = rnd.nextInt(97) + 2;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
                    azar2 = rnd.nextInt(97) + 2;
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
        static int Division(int dificultad){
             int preguntas = 0, count = 0, division, azar1, azar2, respuesta;
        Scanner sc3 = new Scanner(System.in);
        Random rnd = new Random();//Generador de numeros aleatorios

        switch (dificultad) {
        case 1:
                do {
                    do{
                    azar1 = rnd.nextInt(8) + 1;//generamos un numero del 0 al 8 y le sumamos 1 para que nunca salga 0
                    azar2 = rnd.nextInt(8) + 1;
                    }while(azar1%azar2!=0);
                   
                    division=azar1/azar2;
                    System.out.println(azar1 + " / " + azar2 + " = ");        
                    System.out.println("Cual es la respuesta");
                    respuesta = sc3.nextInt();
                    if (division%respuesta==0) {
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
        
}
