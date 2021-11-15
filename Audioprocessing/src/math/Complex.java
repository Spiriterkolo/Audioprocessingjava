package math;

public class Complex {
    private double Re;
    private double Im;

    public Complex(double re, double im) {
        this.Re = re;
        this.Im = im;
    }

    public void setRe(double re) {
        this.Re = re;
    }

    public void setIm(double im) {
        this.Im = im;
    }

    public double getRe() {
        return (Re);
    }

    public double getIm() {
        return (Im);
    }

    public Complex() {
        this.Re = 0;
        this.Im = 0;
    }

    public Complex add(Complex z) {
        return (new Complex(this.Re + z.Re, this.Im + z.Im));
    }
    public Complex minus(Complex z){
        return((new Complex(this.Re-z.Re,this.Im-z.Im)));
    }
    public double module() {
        return(Math.sqrt(Re*Re+Im*Im));
    }
    public double argument(){
        return Math.atan2(Im, Re);
    }
}
