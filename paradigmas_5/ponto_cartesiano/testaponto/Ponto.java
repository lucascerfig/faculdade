/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaponto;

/**
 *
 * @author fabio
 */
public class Ponto{
    // ocultamento dos atributas da classes
    private int x, y;
    public Ponto( int x, int y){
        this.x = x;
        this.y = y;
    }
    // sobrescrever o metodo toString da classe pai da classe Ponto
    // para saber mais:https://www.devmedia.com.br/java-object-class-entendendo-a-classe-object/30513

    @Override
    public String toString() {
        return "Ponto{" + "x=" + x + ", y=" + y + '}';
    }
    
}
