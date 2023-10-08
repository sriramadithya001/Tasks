package BMIPackage;public 

class BMI {
    double weight;
    double height;
    
    public BMI(double height,double weight) {
        this.height = height;
        this.weight = weight;
    }
    
    public double calculate() {
        return weight / (height * height);
    }
}