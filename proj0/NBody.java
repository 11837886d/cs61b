public class NBody {
    public static double readRadius(String input){
        In in = new In (input);
        int number = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String input){
        In in = new In(input);
        int number = in.readInt();
        in.readDouble();
        Planet[] all =  new Planet[number];
        for (int i = 0; i<number; i++){
            Planet temp = new Planet(in.readDouble(), in.readDouble(), in.readDouble(),
            in.readDouble(), in.readDouble(), in.readString());
            all[i] = temp;
        }
        return all;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        In in = new In(filename);
        int number = in.readInt();
        Planet[] all =  new Planet[number];
        all = readPlanets(filename);
        StdDraw.enableDoubleBuffering();
        double t = 0;
        double[] xForces  = new double[number];
        double[] yForces  = new double[number];
        while (t < T){
            for (int i =0; i<number; i++){
                xForces[i] = all[i].calcNetForceExertedByX(all);
                yForces[i] = all[i].calcNetForceExertedByY(all);
            }
            for (int i =0; i<number; i++){
                all[i].update(dt,xForces[i], yForces[i]);
            }
            StdDraw.setScale(-radius, radius);
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i =  0; i<number; i++){
                all[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t+=dt;
        }
        StdOut.printf("%d\n", all.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < all.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    all[i].xxPos, all[i].yyPos, all[i].xxVel,
                    all[i].yyVel, all[i].mass, all[i].imgFileName);
        }
    }
}
