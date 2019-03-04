import javafx.scene.shape.Sphere;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mariakovega on 19/11/2018.
 */
public class ReadData {

    private String path;
    private ArrayList<Double> DotA;
    private ArrayList<Double> DotB;
    private ArrayList<Double> Plane;
    private ArrayList<Double> Sphere;
    private ArrayList<Double> Centre;

    private ArrayList<Double> centerB;
    private ArrayList<ArrayList<Double>> allData = new ArrayList<>(4);


    public ReadData(String[] args) {
        this.path = args[0];
        this.DotA = new ArrayList<>(3);
        this.DotB = new ArrayList<>(3);
        this.Plane = new ArrayList<>(4);
        this.Centre = new  ArrayList<>(3);
        this.Sphere = new ArrayList<>(4);

        this.centerB = new ArrayList<>();
    }

    public ArrayList<ArrayList<Double>> readDots() {
        //начинаем читать входной файл
        try {
            Scanner sc = new Scanner(new File(path));

            int i = 0;
            while(sc.hasNext() && i != 3) {
                DotA.add(sc.nextDouble());
                i++;
            }
            sc.nextLine();
            i = 0;

            while(sc.hasNext() && i != 3) {
                DotB.add(sc.nextDouble());
                i++;
            }
            sc.close();
        }
        catch(FileNotFoundException e){e.printStackTrace();
        }

//        System.out.println("dot A:");
//        DotA.forEach(System.out::println);
//        System.out.println("dot B:");
//        DotB.forEach(System.out::println);

        ArrayList<ArrayList<Double>> data = new ArrayList<>(4);
        data.add(DotA);
        data.add(DotB);
        return data;
    }

    public ArrayList<ArrayList<Double>> readModData() { //читаем данные для модифицированного метода (две точки --
        // центры окружностей)
        ArrayList<Double> centerA = new ArrayList<>(3);
        ArrayList<Double> sphereA = new ArrayList<>(4);
        //ArrayList<Double> centerB = new ArrayList<>(3);
        ArrayList<Double> sphereB = new ArrayList<>(4);
        Double radiusA = 0.0;
        Double radiusB = 0.0;
        //начинаем читать входной файл

        try {
            Scanner sc = new Scanner(new File(path));

            int i = 0;

            while(sc.hasNext() && i != 3) {
                centerA.add(sc.nextDouble());
                sphereA.add(centerA.get(i));
                i++;
            }
            radiusA = sc.nextDouble();
            sphereA.add(radiusA);
            sc.nextLine();
            i = 0;

            while(sc.hasNext() && i != 3) {
                centerB.add(sc.nextDouble());
                sphereB.add(centerB.get(i));
                i++;
            }
            radiusB = sc.nextDouble();
            sphereB.add(radiusB);

            sc.close();
        }
        catch(FileNotFoundException e){e.printStackTrace();
        }

        //ArrayList<ArrayList<Double>> data = new ArrayList<>(4);
        allData.add(sphereA);
        allData.add(sphereB);

        //System.out.println(data);
        return allData;
    }


    public  ArrayList<ArrayList<Double>> readElems() {
        //начинаем читать входной файл
        try {
            Scanner sc = new Scanner(new File(path));

            int i = 0;
            while(sc.hasNext() && i != 3) {
                DotB.add(sc.nextDouble());
                i++;
            }
            sc.nextLine();
            i = 0;

            while(sc.hasNext() && i != 4) {
                Plane.add(sc.nextDouble());
                i++;
            }
            sc.nextLine();
            i = 0;

            while(sc.hasNext() && i != 3) {
                Centre.add(sc.nextDouble());
                Sphere.add(Centre.get(i));
                i++;
            }
            sc.nextLine();
            Double radius = sc.nextDouble();
            Sphere.add(radius);

            sc.close();
        }
        catch(FileNotFoundException e){e.printStackTrace();
        }

        ArrayList<ArrayList<Double>> data = new ArrayList<>(4);
        data.add(DotB);
        data.add(Plane);
        data.add(Sphere);

        return data;
    }


    public ArrayList<Double> getCentreB() {
        return centerB;
    }
    public ArrayList<ArrayList<Double>> getAllData() {
        return allData;
    }

}
