package Advent.Day13;

import Advent.Day;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Day13 extends Day {

    ArrayList<Cart> carts = new ArrayList<>();
    char[][] tracks = new char[150][];
    String crashPos;

    public Day13() {
        read();
        question();
    }

    public void read() {
        for (int y = 0; y < 150; y++) {
            tracks[y] = input.nextLine().toCharArray();
            for (int x = 0; x < 150; x++) {
                switch (tracks[y][x]) {
                    case '>':
                    case '<':
                        carts.add(new Cart(x, y, arrowToInt(tracks[y][x])));
                        tracks[y][x] = '-';
                        break;
                    case '^':
                    case 'v':
                        carts.add(new Cart(x, y, arrowToInt(tracks[y][x])));
                        tracks[y][x] = '|';
                        break;
                }
            }
        }
    }

    public int arrowToInt(char c) {
        switch (c) {
            case '>':
                return 0;
            case '^':
                return 1;
            case '<':
                return 2;
            case 'v':
                return 3;
        }
        return -1;
    }

    public void question() {
        boolean crash = false;
        while (carts.size() > 1) {
            List<Cart> cartsSorted = carts.stream().sorted((c1, c2) -> c1.compare() - c2.compare()).collect(Collectors.toList());
            for (Cart cart : cartsSorted) {
                {
                    if (carts.contains(cart)) {
                        for (Cart cart2 : cartsSorted) {
                            if (cart2.compare() == cart.compare() + cart.getDirX() + cart.getDirY() * 1000) {
                                carts.remove(cart);
                                carts.remove(cart2);
                                if (!crash) {
                                    crashPos = (cart.getPosX() + cart.getDirX()) + "," + (cart.getPosY() + +cart.getDirY());
                                    crash = true;
                                }
                                break;
                            }
                        }
                        cart.setPos(cart.getPosX() + cart.getDirX(), cart.getPosY() + cart.getDirY());
                        if (tracks[cart.getPosY()][cart.getPosX()] == '/') {
                            if (cart.getDirX()!= 0) {
                                cart.setDir(cart.getDirY(), -cart.getDirX());
                            } else {//1
                                cart.setDir(-cart.getDirY(), cart.getDirX());
                            }
                        }
                        if (tracks[cart.getPosY()][cart.getPosX()] == '\\') {
                            cart.setDir(cart.getDirY(), cart.getDirX());
                        }
                        if (tracks[cart.getPosY()][cart.getPosX()] == '+') {
                            cart.turn();
                        }
                    }
                }
            }
        }
        System.out.println(crashPos);
        System.out.println(carts.get(0).getPosX() + "," + carts.get(0).getPosY());
    }

    public static void main(String[] args) {
        Day13 d = new Day13();
    }
}
//109,23
//137,101
