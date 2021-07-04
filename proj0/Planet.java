
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double g = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;

    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double xDistance = Math.pow((this.xxPos - p.xxPos), 2);
        double yDistance = Math.pow((this.yyPos - p.yyPos), 2);
        return Math.pow(xDistance + yDistance, 0.5);
    }

    public double calcForceExertedBy(Planet p) {
        return this.mass * p.mass * g / Math.pow(calcDistance(p), 2);
    }

    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double totalNetForceX = 0;
        for (Planet p: planets) {
            if(this.equals(p) == true) continue;
            totalNetForceX += calcForceExertedByX(p);
        }
        return totalNetForceX;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double totalNetForceY = 0;
        for (Planet p: planets) {
            if(this.equals(p) == true) continue;
            totalNetForceY += calcForceExertedByY(p);
        }
        return totalNetForceY;
    }

    public void update(double dt, double fX, double fY) {
        double accerlerationX = fX / this.mass;
        double accerlerationY = fY / this.mass;
        this.xxVel += dt * accerlerationX;
        this.yyVel += dt * accerlerationY;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }
    public void draw(){
		StdDraw.picture(xxPos, yyPos, "./images/"+imgFileName);
	}
}
