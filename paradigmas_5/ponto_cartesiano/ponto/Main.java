package ponto;

public class Main{
    public static void main(String[] args) {

        Ponto p1, p2, p3, p4;
        double dist1, dist2;

        p1 = new Ponto(3, -1);
        p2 = new Ponto(0, 5);
        p3 = new Ponto(8, 2);
        p4 = new Ponto(3, -1);        

        // Testa p1 com p2
        if (p1.igual(p2)){
            System.out.println("p1 é igual a p2");
        } else {
            System.out.println("p1 é diferente de p2");
        }

        // Testa p1 com p4
        if (p1.igual(p4)){
            System.out.println("p1 é igual a p4");
        } else {
            System.out.println("p1 é diferente de p4");
        }

        // Calcula a distancia entre p2 e p3
        dist1 = p2.distancia(p3);
        System.out.printf("A distância entre p2 e p3 é %f\n", dist1);

        // Calcula a distancia entre p1 e p3
        dist2 = p1.distancia(p3);
        System.out.printf("A distância entre p1 e p3 é %f\n", dist2);

    }

}