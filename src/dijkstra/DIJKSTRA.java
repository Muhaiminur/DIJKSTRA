package dijkstra;

import java.io.File;
import java.util.PriorityQueue;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ITCLANBD
 */
public class DIJKSTRA {

    int INFINITE = 999;
    int[][] a;
    int[] dis;
    boolean[] visit;

    public DIJKSTRA() {
        try {
            Scanner abir = new Scanner(new File("Input"));
            int ver = abir.nextInt();
            a = new int[ver][ver];
            dis = new int[ver];
            visit = new boolean[ver];
            abir.nextInt();
            while (abir.hasNext()) {
                int m = abir.nextInt();
                int n = abir.nextInt();
                int w = abir.nextInt();
                add(m, n, w);
            }

        } catch (Exception e) {
        }

    }

    public void DIJKSTRA(int s) {
        for (int c = 0; c < a.length; c++) {
            dis[c] = INFINITE;
            visit[c] = false;
        }

        dis[s] = 0;
        visit[s] = true;
        for (int c = 0; c < a.length - 1; c++) {
            int u = EXTRACTMIN(dis, visit);
            //System.out.println("("+u+")");

            visit[u] = true;
            for (int d = 0; d < a.length; d++) {
                if (visit[d] == false && dis[d] > dis[u] + a[u][d] && dis[u] != INFINITE) {
                    dis[d] = dis[u] + a[u][d];
                    System.out.println(dis[d]);
                }

            }

        }
    }

    public int EXTRACTMIN(int[] d, boolean[] v) {
        int min = INFINITE;
        int min_index = INFINITE;
        for (int c = 0; c < a.length; c++) {
            if (v[c] == false && d[c] <= min) {
                min = d[c];
                min_index = c;
            }

        }
        return min_index;
    }

    public void RESULT() {
        for (int c = 0; c < dis.length; c++) {
            System.out.println(c + " ----->" + dis[c]);

        }
    }

    public void add(int c, int d, int w) {
        if (c >= 0 && d >= 0) {
            a[c][d] = w;
        }
    }

    public void exchange(int[] a, int c, int d) {
        int temp = a[c];
        a[c] = a[d];
        a[d] = temp;
    }

    public void PRINT(int[] a) {
        System.out.println("==============================================");
        for (int c = 0; c < a.length; c++) {
            System.out.print(a[c] + " ");

        }
        System.out.println("");
        System.out.println("==============================================");
    }

    public void printMatrix() {
        for (int c = 0; c < a.length; c++) {
            System.out.print("[");
            System.out.print(" | ");
            for (int d = 0; d < a[c].length; d++) {
                System.out.print(a[c][d] + " | ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

}
