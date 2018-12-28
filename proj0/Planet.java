public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double Grav_const = 6.67e-11;
    
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    /** copy constructor */
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /**
     *  calculate the distance between two Planets
     */ 
    public double calcDistance(Planet p){
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        return Math.sqrt(dx*dx+dy*dy);
    }

    /** 
     *  calculate the force exerted on this palnet by the given planet
     */
    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        return Grav_const*mass*p.mass/(r*r);
    }

    /** 
     *  calculate the force exerted in X direction
     */
    public double calcForceExertedByX(Planet p){
        double r = calcDistance(p);
        double dx = p.xxPos-xxPos;
        return calcForceExertedBy(p)*dx/r;
    }

    /** 
     *  calculate the force exerted in Y direction
     */
    public double calcForceExertedByY(Planet p){
        double r = calcDistance(p);
        double dy = p.yyPos-yyPos;
        return calcForceExertedBy(p)*dy/r;
    }

    /** 
     *  calculate the Net X force exerted by all planets in the array
     *  @param all an array of all the Planets
     *  @return the Net X force by all planets in "all"
     */
    public double calcNetForceExertedByX(Planet[] all){
        double NetforceX = 0;
        for(Planet p : all){
            if(!equals(p))
            NetforceX += calcForceExertedByX(p);
        }
        return NetforceX;
    }

    /** 
     *  calculate the Net Y force exerted by all planets in the array
     *  @param all an array of all the Planets
     *  @return the Net Y force by all planets in "all"
     */
    public double calcNetForceExertedByY(Planet[] all){
        double NetforceY = 0;
        for(Planet p : all){
            if(!equals(p)){
                NetforceY += calcForceExertedByY(p);
            }   
        }
        return NetforceY;
    }

    /** 
     * update planet 
     * @param dt small period of time
     * @param fX X force
     * @param fY Y force
     */
    public void update(double dt, double fX, double fY){
        double aX = fX/mass;
        double aY = fY/mass;
        xxVel += aX * dt;
        yyVel += aY * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    /** darw  */
    public void draw(){
        String pathtofile = "./images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, pathtofile);
    }



}