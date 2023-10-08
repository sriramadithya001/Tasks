abstract class Percentage {
    public abstract double getPercentage(double m1,double m2,double m3);
    public abstract double getPercentage(double m1,double m2,double m3, double m4);
}

class StudentA extends Percentage {
    double m1,m2,m3,m4;
    
    StudentA(double m1,double m2,double m3) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = 0;
    }
    
    public double getPercentage(double m1,double m2,double m3) {
        return (m1+m2+m3)/3;
    }
    
    public double getPercentage(double m1,double m2,double m3,double m4) {
        return (m1+m2+m3+m4)/4;
    }
}

class StudentB extends Percentage {
    double m1,m2,m3,m4;
    
    StudentB(double m1,double m2,double m3, double m4) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
    }
    
    public double getPercentage(double m1,double m2,double m3) {
        return (m1+m2+m3)/3;
    }
    
    public double getPercentage(double m1,double m2,double m3,double m4) {
        return (m1+m2+m3+m4)/4;
    }
}