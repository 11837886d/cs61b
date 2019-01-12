public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos) + (yyPos - p.yyPos) * (yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p) {
        return G * this.mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
    }

    public double calcForceExertedByX(Planet p) {
        return -this.calcForceExertedBy(p) * (xxPos - p.xxPos) / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return -this.calcForceExertedBy(p) * (yyPos - p.yyPos) / this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] all) {
        double force = 0;
        for (Planet p : all) {
            if (!this.equals(p)) {
                force += this.calcForceExertedByX(p);
            }
        }
        return force;
    }

    public double calcNetForceExertedByY(Planet[] all) {
        double force = 0;
        for (Planet p : all) {
            if (!this.equals(p)) {
                force += this.calcForceExertedByY(p);
            }
        }
        return force;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX /mass;
        double aY = fY/mass;
        xxVel = aX*dt + xxVel;
        yyVel = aY*dt + yyVel;
        xxPos+= xxVel*dt;
        yyPos+= yyVel*dt;
    }
     public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
     }
}
