import java.io.*;
import java.util.*;

abstract class Figure {
    double s;
    String name;
    abstract void setS();
    void print() {
        System.out.println(name + " " + Math.floor(10000 * s) / 10000d);
    }
}
class Rectangle extends Figure {
    double a, b;
    Rectangle(double a, double b) {
        this.name = "RECT";
        this.a = a;
        this.b = b;
        setS();
    }
    void setS() {
        this.s = this.a * this.b;
    }
}
class Circle extends Figure {
    double r;
    Circle(double r) {
        this.name = "CIRCLE";
        this.r = r;
        setS();
    }
    void setS() {
        this.s = Math.PI * this.r * this.r;
    }
}
class Triangle extends Figure {
    double p, h;
    Triangle(double p, double h) {
        this.name = "TRIANGLE";
        this.h = h;
        this.p = p;
        setS();
    }
    void setS() {
        this.s = this.h * this.p * 0.5;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList <Figure> list = new ArrayList<Figure>();

        try {
            File file = new File(args[0]);
            FileInputStream fis;
            DataInputStream dis;
            try {
                fis = new FileInputStream(file);
                dis = new DataInputStream(fis);
                int l = Integer.parseInt(dis.readLine());
                for (int i = 0; i < l; i++) {
                    String line = dis.readLine();
                    String[] parsed = line.split(" ");

                    if (parsed[0].equals("CIRCLE")) {
                        double r = Double.parseDouble(parsed[1]);
                        list.add(new Circle(r));
                    } else
                    if (parsed[0].equals("RECT")) {
                        double a = Double.parseDouble(parsed[1]);
                        double b = Double.parseDouble(parsed[2]);
                        list.add(new Rectangle(a, b));
                    }  else
                    if (parsed[0].equals("TRIANGLE")) {
                        double p = Double.parseDouble(parsed[1]);
                        double h = Double.parseDouble(parsed[2]);
                        list.add(new Triangle(p, h));
                    }
                }
                Collections.sort(list, new Comparator<Figure>() {
                    @Override
                    public int compare(Figure o1, Figure o2) {
                        return (int)(o1.s - o2.s);
                    }
                });
                for (Figure f : list) {
                    f.print();
                }
                fis.close();
                dis.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: no such file!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No filename set!");
        }
    }
}
