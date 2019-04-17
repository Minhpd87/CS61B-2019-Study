public class Body {
    double xxPos; //current x pos
    double yyPos; //current y pos
    double xxVel; //current velocity in x direction
    double yyVel; //current velocity in y direction
    double mass; //the mass
    String imgFileName; //file name of the image the depicts the body such as jupiter.jpg

    //create Constructors for the body class
    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Body(Body b) { //construct new body with value of Body b
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    //add calcDistance method
    public double calcDistance(Body target) {
        //this one calculate the r aka distance between this body and the target
        double dx = this.xxPos - target.xxPos;
        double dy = this.yyPos - target.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    //add calForceExerted by
    public double calcForceExertedBy(Body from) {
        double g = 6.67e-11;
        double r = this.calcDistance(from);
        return (g * this.mass * from.mass) / (r * r);
    }

    //add calcForceExertedByX and calcForceExertedByY
    public double calcForceExertedByX(Body from) {
        double dx = from.xxPos - this.xxPos; //meaning from is causing the force to this
        double r = this.calcDistance(from);
        return this.calcForceExertedBy(from) * dx / r;
    }

    public double calcForceExertedByY(Body from) {
        double dy = from.yyPos - this.yyPos; //meaning from is causing the force to this
        double r = this.calcDistance(from);
        return this.calcForceExertedBy(from) * dy / r;
    }

    //add calcNetForceExertedByX and calcNetForceExertedByY
    public double calcNetForceExertedByX(Body[] bodyArray) {
        double forceNet = 0;
        for (Body b : bodyArray) {
            if (!b.equals(this)) {
                forceNet += this.calcForceExertedByX(b);
            }
        }
        return forceNet;
    }

    public double calcNetForceExertedByY(Body[] bodyArray) {
        double forceNet = 0;
        for (Body b : bodyArray) {
            if (!b.equals(this)) {
                forceNet += this.calcForceExertedByY(b);
            }
        }
        return forceNet;
    }

    //add method that determines how much forces exerted on the body will cause that body to accelerate
    //and the resulting change in the body's velocity and position in a small period of time dt.
    //for eg: sammh.update(0.005, 10, 3) would adjust the velocity and position if a x force of 10 newtons and a y force
    // of 3 newtons were applied for 0.005 seconds

    public void update(double dt, double fX, double fY) {
        //calculate the acceleration
        double aX = fX / this.mass;
        double aY = fY / this.mass;

        //calculate / update the new velocity
        this.xxVel = this.xxVel + dt * aX;
        this.yyVel = this.yyVel + dt * aY;

        //calculate / update new position
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw() { //draw at this's position
        StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
    }
}