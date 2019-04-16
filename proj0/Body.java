public class Body {
    double xxPos; //current x pos
    double yyPos; //current y pos
    double xxVel; //current velocity in x direction
    double yyVel; //current velocity in y direction
    double mas; //the mass
    String imgFileName; //file name of the image the depicts the body such as jupiter.jpg

    //create Constructors for the body class
    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.m = m;
        this.img = img;
    }

    public Body(Body b) {

    }
}