import java.util.Arrays;
import java.util.regex.*;

public class NBody {

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);
        
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-(radius+0.5*Math.pow(10,11)), radius+0.5*Math.pow(10,11));
		StdDraw.picture(0, 0, "./images/starfield.jpg");
        StdDraw.show();
		for(int i=0;i<planets.length;i++){
			planets[i].draw();
		}
		double[] xForces = new double[planets.length];
		double[] yForces = new double[planets.length];
		for (double time=0; time <= T; time = time + dt){
			for(int i=0; i<planets.length; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for(int j=0; j<planets.length; j++){
				planets[j].update(dt,xForces[j],yForces[j]);
			}
			StdDraw.setScale(-(radius+0.5*Math.pow(10,11)), radius+0.5*Math.pow(10,11));
			StdDraw.picture(0, 0, "./images/starfield.jpg");
			for(int i=0; i<planets.length;i++){
				planets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    	    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                planets[i].yyVel, planets[i].mass, planets[i].imgFileName);  
        } 
    }
    
    public static double readRadius(String filename) {
        if (filename == null) return 0.0;
        In in = new In(filename);
        int numberOfPlanets = in.readInt();
        double radius = in.readDouble();
        in.close();

        return radius;
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        String[] planetsInfos;
        planetsInfos = Arrays.copyOfRange(in.readAllLines(), 2, 7);
        Planet[] planets = new Planet[planetsInfos.length];
        for (int i=0; i < planetsInfos.length ; i++) {
            String[] parameters = planetsInfos[i].split("\\s{2,}");
            planets[i] = new Planet( Double.parseDouble(parameters[0]), Double.parseDouble(parameters[1]), Double.parseDouble(parameters[2]), Double.parseDouble(parameters[3]), Double.parseDouble(parameters[4]), parameters[5]);
        }
        return planets;
    }
}
