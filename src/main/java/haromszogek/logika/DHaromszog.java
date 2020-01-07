package haromszogek.logika;

public class DHaromszog {
    private double aOldal;
    private double bOldal;
    private double cOldal;
    private int sorSzama;
    
    public DHaromszog(String sor, int sorSzama) throws Exception{
        this.setSorSzama(sorSzama);
        
        String[] adatok = sor.replace(',', '.').split(" ");
        
        this.setaOldal(Double.parseDouble(adatok[0]));
        this.setbOldal(Double.parseDouble(adatok[1]));
        this.setcOldal(Double.parseDouble(adatok[2]));
    
        this.EllNovekvoSorrend();
        this.EllMegszerkesztheto();
        this.EllDerekszogu();
    }

    public int getSorSzama() {
        return sorSzama;
    }

    public void setSorSzama(int sorSzama) {
        this.sorSzama = sorSzama;
    }

    public double getaOldal() {
        return this.aOldal;
    }

    public void setaOldal(double aOldal) throws Exception{
        if(aOldal > 0){
            this.aOldal = aOldal;
        }else{
            throw new Exception("Az a oldal nem lehet 0 vagy negatív");        
        }
    }

    public double getbOldal() {
        return this.bOldal;
    }

    public void setbOldal(double bOldal) throws Exception{
        if(bOldal > 0){
            this.bOldal = bOldal;
        }else{
                throw new Exception("A b oldal nem lehet 0 vagy negatív");
        }
    }
    public double getcOldal() {
        return this.cOldal;
    }

    public void setcOldal(double cOldal) throws Exception{
        if(cOldal > 0){
            this.cOldal = cOldal;
        }else{
                    throw new Exception("A c oldal nem lehet 0 vagy negatív");
        }
    }    
    
    private boolean EllDerekszogu() throws Exception{
    boolean derekszogu = Math.pow(aOldal,2) + Math.pow(bOldal,2) == Math.pow(cOldal,2);
        if (!derekszogu) {
            throw new Exception("A háromszöget nem derékszögű");
        }
        return derekszogu;
        
    }
    private boolean EllMegszerkesztheto() throws Exception{
        boolean szerkesztheto = aOldal + bOldal >= cOldal;
        if (!szerkesztheto) {
            throw new Exception("A háromszöget nem lehet megszerkeszteni");
        }
        return szerkesztheto;
    }
    private boolean EllNovekvoSorrend() throws Exception{
        boolean novekvosorrend = aOldal <= bOldal && bOldal <= cOldal;
        if (!novekvosorrend) {
            throw new Exception("Az adatok nincsenek növekvő sorrendben");
        }
        return novekvosorrend;
    }
    
    public double Kerulet(){
        return  this.aOldal + this.bOldal + this.cOldal; 
    }
    public double Terulet(){
        return this.aOldal * this.bOldal / 2;
    }

    @Override
    public String toString() {
        return String.format("%d. sor: a=%.2f b=%.2f c=%.2f", this.sorSzama, this.aOldal, this.bOldal, this.cOldal);
    }
    
}
