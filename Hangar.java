public class Hangar implements Cloneable, Comparable<Hangar> {
    private int id;
    protected java.util.Date primerUso;
    private double area;

    public Hangar(int id, double area) {
        this.id = id;
        this.area = area;
        this.primerUso = new java.util.Date();
    }

    public int obtenerID() { return id; }
    public double obtenerArea() { return area; }
    public java.util.Date obtenerFecha() { return primerUso; }

    // Alternativa copia profunda
    public Hangar copiaProfunda() throws CloneNotSupportedException {
        Hangar copiaHangar = (Hangar)super.clone();
        copiaHangar.primerUso = (java.util.Date)primerUso.clone();
        return copiaHangar;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Hangar copiaHangar = new Hangar(id, area);
        copiaHangar.primerUso = new java.util.Date();
        copiaHangar.primerUso.setTime(primerUso.getTime());
        return copiaHangar;
    }

    @Override
    public Object clone() {
        Hangar copiaHangar = (Hangar)super.clone();
        copiaHangar.primerUso = (java.util.Date)primerUso.clone();
        try {
            return copiaHangar;
        } catch (CloneNotSupportedException ex) { return null; }
    }

    @Override
    public int compareTo(Hangar objeto) {
        if (area > objeto.area)
            return 1;
        else if (area < objeto.area)
            return -1;
        return 0;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Hangar hangar1 = new Hangar(101, 23902.46);
    }
}
