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

            // Tratando coeficientes nulos
            if (this.coeficientes[i] == 0) continue;

            // Tratando coeficientes iguais a 1
            if (this.coeficientes[i] == 1) {
                System.out.print("x^" + i);
                continue;
            }
            
            // Imprime o termo
            System.out.print(this.coeficientes[i] + "x^" + i);

            // Agrega o sinal de soma aos termos com coeficientes positivos
            if (i > 0 && this.coeficientes[i - 1] >= 0) {
                System.out.print(" +");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public double calcula(int x){
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
        int maior_len;
        boolean implicito_maior;

        // Verifica qual polinomio possui mais termos
        if (this_len >= input_len){
            maior_len = this_len;
            implicito_maior = true;
        } else {
            maior_len = input_len;
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

    }

    public static void main(String[] args){

        double[] entradas = {5, 7, -1, 2, 8};

        Polinomio poli2 = new Polinomio(entradas);
        Polinomio poli1 = new Polinomio(1, -2, 3);
        Polinomio poli3;

        poli1.mostra();
        poli2.mostra();

        poli3 = poli1.soma(poli2);
        poli3.mostra();
    }
}