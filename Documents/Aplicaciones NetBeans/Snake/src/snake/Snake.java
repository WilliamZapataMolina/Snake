/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package snake;

/**
 * Ejercicio De Clase Tema 7
 * 1° de DAW
 * @author WilliamZapataMolina
 */
public class Snake {

    public static void main(String[] args) {
        java.awt.Point playerPosition = new java.awt.Point(10, 9);
        java.awt.Point snakePosition = new java.awt.Point(30, 2);
        java.awt.Point goldPosition = new java.awt.Point(6, 6);
        java.awt.Point doorPosition = new java.awt.Point(0, 5);
        boolean rich = false;

        while (true) {
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 40; x++) {
                    java.awt.Point p = new java.awt.Point(x, y);
                    if (playerPosition.equals(p)) {
                        System.out.print('&');
                    } else if (snakePosition.equals(p)) {
                        System.out.print('S');
                    } else if (goldPosition.equals(p)) {
                        System.out.print('$');
                    } else if (doorPosition.equals(p)) {
                        System.out.print('#');
                    } else {
                        System.out.print('.');
                    }

                }
                System.out.println();
            }

            if (rich && playerPosition.equals(doorPosition)) {
                System.out.println("You won!");
                return;

            }
            if (playerPosition.equals(snakePosition)) {
                System.out.println("Game Over!");
                return;

            }
            if (playerPosition.equals(goldPosition)) {
                rich = true;
                goldPosition.setLocation(-1, -1);

            }/*El error que había era la falta de breaks en el condicional switch,
            es decir, en cada case debe haber un break 
            que nos permita saltar a la siguiente instrucción o línea de código 
             */
            String tecla = new java.util.Scanner(System.in).next();
            switch (tecla) {
                case "w":
                    playerPosition.y = Math.max(0, playerPosition.y - 1);
                    break;
                case "s":
                    playerPosition.y = Math.min(9, playerPosition.y + 1);
                    break;
                case "a":
                    playerPosition.x = Math.max(0, playerPosition.x - 1);
                    break;
                case "d":
                    playerPosition.x = Math.min(39, playerPosition.x + 1);
                    break;
            }

            if (playerPosition.x < snakePosition.x) {
                snakePosition.x--;
            } else if (playerPosition.x > snakePosition.x) {
                snakePosition.x++;
            }

            if (playerPosition.y < snakePosition.y) {
                snakePosition.y--;
            } else if (playerPosition.y > snakePosition.y) {
                snakePosition.y++;
            }
        }
    }
}

