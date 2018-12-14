package Advent.Day13;

import Advent.Day;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public final class Day13 extends Day {

    int size = 150;
    ArrayList<Cart> carts = new ArrayList<>();
    char[][] trainMap = new char[size][];
    char[][] trackMap = new char[size][size];
    boolean crash = false;
    String crashPos;

    public Day13() {
        read();
        question();
    }

    public void read() {
        for (int y = 0; y < size; y++) {

            trainMap[y] = input.nextLine().toCharArray();
            System.arraycopy(trainMap[y], 0, trackMap[y], 0, size);
        }
        Cart cart;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                switch (trackMap[y][x]) {
                    case '>':
                        cart = new Cart(x, y, '>');
                        carts.add(cart);

                        trackMap[y][x] = '-';
                        break;
                    case '^':
                        cart = new Cart(x, y, '^');
                        carts.add(cart);

                        trackMap[y][x] = '|';
                        break;
                    case '<':
                        cart = new Cart(x, y, '<');
                        carts.add(cart);

                        trackMap[y][x] = '-';
                        break;
                    case 'v':
                        cart = new Cart(x, y, 'v');
                        carts.add(cart);

                        trackMap[y][x] = '|';
                        break;
                    default:
                        break;
                }
                System.out.print(trainMap[y][x]);
            }
            System.out.println("");
        }
    }

    public void question() {
        
        while (carts.size() > 1) {
            Cart cart3 = null;
            List<Cart> cartsSorted = carts.stream().sorted((i1, i2) -> i1.order() - i2.order()).collect(Collectors.toList());
            for (Cart cart1 : cartsSorted) {
                {
                    if (carts.contains(cart1)) {

                        switch (cart1.getDirection()) {
                            case '>':
                                switch (trainMap[cart1.getY()][cart1.getX() + 1]) {
                                    case '-':
                                        cart1.setDirection('>');
                                        trainMap[cart1.getY()][cart1.getX() + 1] = '>';
                                        break;
                                    case '/':
                                        cart1.setDirection('^');
                                        trainMap[cart1.getY()][cart1.getX() + 1] = '^';
                                        break;
                                    case '\\':
                                        cart1.setDirection('v');
                                        trainMap[cart1.getY()][cart1.getX() + 1] = 'v';
                                        break;
                                    case '+':
                                        switch (cart1.getTurnDirection()) {
                                            case 0:
                                                cart1.setDirection('^');
                                                trainMap[cart1.getY()][cart1.getX() + 1] = '^';
                                                break;
                                            case 1:
                                                cart1.setDirection('>');
                                                trainMap[cart1.getY()][cart1.getX() + 1] = '>';
                                                break;
                                            case 2:
                                                cart1.setDirection('v');
                                                trainMap[cart1.getY()][cart1.getX() + 1] = 'v';
                                                break;
                                            default:
                                                break;
                                        }
                                        cart1.setTurnDirection();
                                        break;
                                    case 'v':
                                    case '^':
                                    case '<':
                                    case '>':
                                        trainMap[cart1.getY()][cart1.getX() + 1] = trackMap[cart1.getY()][cart1.getX() + 1];
                                        carts.remove(cart1);
                                       
                                        for (Cart cart2 : carts) {
                                            if (cart2.getX() == cart1.getX() + 1 && cart2.getY() == cart1.getY()) {
                                                cart3 = cart2;
                                            }
                                        }
                                        carts.remove(cart3);
                                        System.out.println("_" + carts.size());
                                        if (!crash) {
                                            crashPos = (cart1.getX() + 1) + "," + cart1.getY();
                                            crash = true;
                                        }

                                        break;
                                    default:
                                        break;
                                }
                                trainMap[cart1.getY()][cart1.getX()] = trackMap[cart1.getY()][cart1.getX()];
                                cart1.setX(cart1.getX() + 1);
                                break;
                            case '^':
                                switch (trainMap[cart1.getY() - 1][cart1.getX()]) {
                                    case '|':
                                        cart1.setDirection('^');
                                        trainMap[cart1.getY() - 1][cart1.getX()] = '>';
                                        break;
                                    case '/':
                                        cart1.setDirection('>');
                                        trainMap[cart1.getY() - 1][cart1.getX()] = '^';
                                        break;
                                    case '\\':
                                        cart1.setDirection('<');
                                        trainMap[cart1.getY() - 1][cart1.getX()] = 'v';
                                        break;
                                    case '+':
                                        switch (cart1.getTurnDirection()) {
                                            case 0:
                                                cart1.setDirection('<');
                                                trainMap[cart1.getY() - 1][cart1.getX()] = '<';
                                                break;
                                            case 1:
                                                cart1.setDirection('^');
                                                trainMap[cart1.getY() - 1][cart1.getX()] = '^';
                                                break;
                                            case 2:
                                                cart1.setDirection('>');
                                                trainMap[cart1.getY() - 1][cart1.getX()] = '>';
                                                break;
                                            default:
                                                break;
                                        }
                                        cart1.setTurnDirection();
                                        break;
                                    case 'v':
                                    case '^':
                                    case '<':
                                    case '>':
                                        trainMap[cart1.getY() - 1][cart1.getX()] = trackMap[cart1.getY() - 1][cart1.getX()];
                                        carts.remove(cart1);
                                        for (Cart cart2 : carts) {
                                            if (cart2.getX() == cart1.getX() && cart2.getY() == cart1.getY()-1) {
                                                cart3 = cart2;
                                            }
                                        }
                                        carts.remove(cart3);
                                        System.out.println("_" + carts.size());
                                        if (!crash) {
                                            crashPos = (cart1.getX() + 1) + "," + cart1.getY();
                                            crash = true;
                                        }
                                        break;
                                    default:
                                        break;
                                }
                                trainMap[cart1.getY()][cart1.getX()] = trackMap[cart1.getY()][cart1.getX()];
                                cart1.setY(cart1.getY() - 1);
                                break;

                            case '<':
                                switch (trainMap[cart1.getY()][cart1.getX() - 1]) {
                                    case '-':
                                        cart1.setDirection('<');
                                        trainMap[cart1.getY()][cart1.getX() - 1] = '<';
                                        break;
                                    case '/':
                                        cart1.setDirection('v');
                                        trainMap[cart1.getY()][cart1.getX() - 1] = 'v';
                                        break;
                                    case '\\':
                                        cart1.setDirection('^');
                                        trainMap[cart1.getY()][cart1.getX() - 1] = '^';
                                        break;
                                    case '+':
                                        switch (cart1.getTurnDirection()) {
                                            case 0:
                                                cart1.setDirection('v');
                                                trainMap[cart1.getY()][cart1.getX() - 1] = 'v';
                                                break;
                                            case 1:
                                                cart1.setDirection('<');
                                                trainMap[cart1.getY()][cart1.getX() - 1] = '<';
                                                break;
                                            case 2:
                                                cart1.setDirection('^');
                                                trainMap[cart1.getY()][cart1.getX() - 1] = '^';
                                                break;
                                            default:
                                                break;
                                        }
                                        cart1.setTurnDirection();
                                        break;
                                    case 'v':
                                    case '^':
                                    case '<':
                                    case '>':
                                        trainMap[cart1.getY()][cart1.getX() - 1] = trackMap[cart1.getY()][cart1.getX() - 1];
                                        carts.remove(cart1);
                                        for (Cart cart2 : carts) {
                                            if (cart2.getX() == cart1.getX()-1 && cart2.getY() == cart1.getY()) {
                                            cart3 = cart2;
                                            }
                                        }
                                        carts.remove(cart3);
                                        System.out.println("_" + carts.size());
                                        if (!crash) {
                                            crashPos = (cart1.getX() + 1) + "," + cart1.getY();
                                            crash = true;
                                        }
                                        break;
                                    default:
                                        break;
                                }
                                trainMap[cart1.getY()][cart1.getX()] = trackMap[cart1.getY()][cart1.getX()];
                                cart1.setX(cart1.getX() - 1);

                                break;
                            case 'v':
                                switch (trainMap[cart1.getY() + 1][cart1.getX()]) {
                                    case '|':
                                        cart1.setDirection('v');
                                        trainMap[cart1.getY() + 1][cart1.getX()] = 'v';
                                        break;
                                    case '/':
                                        cart1.setDirection('<');
                                        trainMap[cart1.getY() + 1][cart1.getX()] = '<';
                                        break;
                                    case '\\':
                                        cart1.setDirection('>');
                                        trainMap[cart1.getY() + 1][cart1.getX()] = '>';
                                        break;
                                    case '+':
                                        switch (cart1.getTurnDirection()) {
                                            case 0:
                                                cart1.setDirection('>');
                                                trainMap[cart1.getY() + 1][cart1.getX()] = '>';
                                                break;
                                            case 1:
                                                cart1.setDirection('v');
                                                trainMap[cart1.getY() + 1][cart1.getX()] = 'v';
                                                break;
                                            case 2:
                                                cart1.setDirection('<');
                                                trainMap[cart1.getY() + 1][cart1.getX()] = '<';
                                                break;
                                            default:
                                                break;
                                        }
                                        cart1.setTurnDirection();
                                        break;
                                    case 'v':
                                    case '^':
                                    case '<':
                                    case '>':
                                        trainMap[cart1.getY() + 1][cart1.getX()] = trackMap[cart1.getY() + 1][cart1.getX()];
                                        carts.remove(cart1);
                                        for (Cart cart2 : carts) {
                                            if (cart2.getX() == cart1.getX() && cart2.getY() == cart1.getY()+1) {
                                            cart3 = cart2;
                                            }
                                        }
                                        carts.remove(cart3);
                                        System.out.println("_" + carts.size());
                                        if (!crash) {
                                            crashPos = (cart1.getX() + 1) + "," + cart1.getY();
                                            crash = true;
                                        }
                                        break;
                                    default:
                                        break;
                                }
                                trainMap[cart1.getY()][cart1.getX()] = trackMap[cart1.getY()][cart1.getX()];
                                cart1.setY(cart1.getY() + 1);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            //   System.out.println(carts.size());
        }
        System.out.println(crashPos);
        System.out.println(carts.get(0).getX() + "," + carts.get(0).getY());
    }

    public static void main(String[] args) {
        Day13 d = new Day13();
    }

}
