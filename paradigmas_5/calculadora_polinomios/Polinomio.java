class Polinomio {

    private double[] coeficientes;

    public Polinomio(double... coef){
        this.coeficientes = coef;
    }

    public void mostra(){
        for(int i = this.coeficientes.length - 1; i >= 0; i--){
            // Tratando termos independentes de x
            if (i == 0){
                System.out.print(this.coeficientes[i]);
                continue;
            }
            
            if (this.coeficientes[i] == 0){ // Tratando coeficientes nulos
                // Não imprime nada
            } else if (this.coeficientes[i] == 1) { // Tratando coeficientes iguais a 1
                System.out.print("x^" + i);
            } else { // Imprime o termo                
                System.out.print(this.coeficientes[i] + "x^" + i);
            }            
            
            // Agrega o sinal de soma aos termos com coeficientes positivos
            if (i > 0 && this.coeficientes[i - 1] > 0) {
                System.out.print(" +");
            } else if (i > 0 && this.coeficientes[i - 1] == 0) {
                System.out.print("");
            } else {
                System.out.print(" ");
            }
        }

        System.out.println();
    }

    public double calcula(double x){

        double valor = 0; 

        // Dado x, calcula o valor de cada termo e soma-os
        for(int i = this.coeficientes.length - 1; i >= 0; i--){
            valor += Math.pow(x, i) * this.coeficientes[i];
        }

        return valor;
    }

    public Polinomio soma(Polinomio poli){
        double[] valores;

        int this_len = this.coeficientes.length;
        int input_len = poli.coeficientes.length;
        boolean implicito_maior;

        // Verifica qual polinomio possui mais termos
        if (this_len >= input_len){
            implicito_maior = true;
        } else {
            implicito_maior = false;
        }

        // Cria o vetor de termos resultantes a partir do maior polinomio
        if (implicito_maior){
            valores = this.coeficientes;

            // Soma apenas os valores do menor polinomio ao vetor resultante
            for(int i = input_len - 1; i >= 0; i--){
                valores[i] += poli.coeficientes[i];
            }

        } else {
            valores = poli.coeficientes;
            for(int i = this_len - 1; i >= 0; i--){
                valores[i] += this.coeficientes[i];
            }
        }

        Polinomio resPoli = new Polinomio(valores);
        return resPoli;
    }
    
    public Polinomio multiplica(Polinomio poli){

        // Definindo o tamanho (grau) do polinomio final e inicializando o vetor de coeficientes
        int tamanho_res = poli.coeficientes.length + this.coeficientes.length;
        double[] valores = new double[tamanho_res - 1];

        // Para cada termo do polinomio implicito...
        for(int i = 0; i < this.coeficientes.length; i++){

            // ...multiplica-o por cada termo do polinomio explicito...
            for(int j = 0; j < poli.coeficientes.length; j++){

                // ..somando o resultado ao termo do polinomio resultante
                valores[i+j] += this.coeficientes[i] * poli.coeficientes[j];
            }
        }
        
        Polinomio resPoli = new Polinomio(valores); 
        return resPoli;
    }

    public static void main(String[] args){

        double[] entradas = {5, 7, -1, 2, 8};

        Polinomio poli1 = new Polinomio(12, 0, 2, 3);
        Polinomio poli2 = new Polinomio(-5, 3, -4, 0, -4);
        Polinomio poli3;

        poli1.mostra();
        poli2.mostra();

        poli3 = poli1.multiplica(poli2);
        poli3.mostra();
    }
}