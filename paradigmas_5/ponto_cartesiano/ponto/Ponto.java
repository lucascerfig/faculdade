package ponto;

public class Ponto{
    // Atributos encapsulados
    private int x, y;

    // Construtor
    public Ponto(int x, int y){
        this.x = x;
        this.y = y; 
    }

    public boolean igual(Ponto p){
        if (p.x == this.x && p.y == this.y){
            return true;
        } else {
            return false;
        }
    }

    public double distancia(Ponto p){
        double dist;
        dist = Math.sqrt(Math.pow((p.x - this.x), 2) + Math.pow((p.y - this.y), 2));

        return dist;
    }

    public String toString(){
        return "Ponto{x=" + x + ", y=" + y + "}";
    }
}

