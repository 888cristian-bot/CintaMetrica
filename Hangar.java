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
        Hangar copiaHangar = (Hangar) super.clone();
        copiaHangar.primerUso = (java.util.Date) primerUso.clone();
        return copiaHangar;
    }

    @Override
    public Hangar clone() {
        try {
            Hangar copiaHangar = (Hangar) super.clone();
            copiaHangar.primerUso = (java.util.Date) primerUso.clone();
            return copiaHangar;
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    @Override
    public int compareTo(Hangar objeto) {
        return Double.compare(area, objeto.area);
    }

    public static void main(String[] args) {
        Hangar hangar1 = new Hangar(101, 23902.46);

        // Copia superficial (comentada)
        // Hangar copia = hangar1;

        // Copia profunda activada
        Hangar copia = hangar1.clone();

        System.out.println("ID original: " + hangar1.obtenerID());
        System.out.println("ID copia: " + copia.obtenerID());
        System.out.println("Misma referencia de fecha: " + (hangar1.obtenerFecha() == copia.obtenerFecha()));
    }
}
