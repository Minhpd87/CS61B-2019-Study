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


}