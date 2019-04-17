public class NBody {

    //add readRadius method

    //file format
    //first line = number of planet
    //second line = radius of the universe
    //        ID          0         1       2       3       4       5
    //third line onward = x-pos     y-pos   x-vel   y-vel   mass    planetFile

    public static double readRadius(String fileName) {
        In reader = new In(fileName);
        double radius = 0;
        reader.readInt(); //this line is needed because it initiates the read and let the stream move on to the next
        radius = reader.readDouble();

        reader.close();
        return radius;
    }

    //add readBodies method
    //return an array of Body corresponding to bodies in the file
    public static Body[] readBodies(String fileName) {
        In reader = new In(fileName);
        Body[] bodyArray = new Body[reader.readInt()]; //create an array with the size of total planets in the file
        reader.readDouble(); //ignore this

        //add the body to the array by reading parameters needed for creating a Body object
        for (int i = 0; i < bodyArray.length; i++) {
            double xpos = reader.readDouble();
            double ypos = reader.readDouble();
            double xvel = reader.readDouble();
            double yvel = reader.readDouble();
            double mass = reader.readDouble();
            String imgName = reader.readString();

            bodyArray[i] = new Body(xpos, ypos, xvel, yvel, mass, imgName);
        }

        reader.close();
        return bodyArray;
    }

    //create the main method
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];

        double radius = readRadius(fileName);
        Body[] bodyArray = readBodies(fileName);

        //Drawing the background
        //Set the scale that matches the radius
        StdDraw.setScale(radius * -1, radius);

        //Draw the image starfield.jpg
        StdDraw.picture(0, 0, "./images/starfield.jpg");
        for (Body b : bodyArray) {
            b.draw();
        }

        //Creating animation
        StdDraw.enableDoubleBuffering();
        double t = 0;
        while (t < T) {
            //create XForces and YForces array
            double[] xForces = new double[bodyArray.length]; //size of the array equals the number of body
            double[] yForces = new double[bodyArray.length]; //size of the array equals the number of body

            //calculate net force of each body in the body array
            for (int i = 0; i < bodyArray.length; i++) {
                xForces[i] = bodyArray[i].calcNetForceExertedByX(bodyArray);
                yForces[i] = bodyArray[i].calcNetForceExertedByY(bodyArray);
            }
            //after all forces are calculated and put into the array
            for (int i = 0; i < bodyArray.length; i++) {
                bodyArray[i].update(dt, xForces[i], yForces[i]);
            }

            //draw background
            StdDraw.picture(0, 0, "./images/starfield.jpg");

            //draw body
            for (Body b : bodyArray) {
                b.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);

            t += dt; //increase time variable by dt


            //to Do Extra for Experts
        }

        //printing the universe
        StdOut.printf("%d\n", bodyArray.length);
        StdOut.printf("%2e\n", radius);
        for (Body b : bodyArray) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", b.xxPos, b.yyPos, b.xxVel, b.yyVel, b.mass, b.imgFileName);
        }
    }

}