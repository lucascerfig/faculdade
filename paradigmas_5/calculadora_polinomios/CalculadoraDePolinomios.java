/*
Projeto da Calculadora de Polinômios - Disciplina: Paradigmas de Linguagens de Programação (05N - Mackenzie)
Alunos:
    LUCAS CERQUEIRA FIGUEIREDO - TIA: 3182482-1
    LUCAS EID FERNANDES - TIA: 3182355-6

Professor Fabio Lubacheski
Março de 2020
*/


import java.util.Scanner;

class CalculadoraDePolinomios {

    public static void main(String[] args){

        Scanner reader = new Scanner(System.in);

        boolean finaliza = false;
        boolean opc_invalida = true;
        Polinomio[] polinomios = {new Polinomio(0), new Polinomio(0)};
        
        while (finaliza == false){
            System.out.println("*=====================================================*");
            System.out.println("|                                                     |");
            System.out.println("|              CALCULADORA DE POLINÔMIOS              |");
            System.out.println("|                                                     |");
            System.out.println("*=====================================================*");
            System.out.println("| Escolha uma das opções:                             |");
            System.out.println("| (1) Inserir/substituir um polinômio                 |");
            System.out.println("| (2) Listar o par de polinômios inserido             |");
            System.out.println("| (3) Calcular P(x)                                   |");
            System.out.println("| (4) Somar os polinômios                             |");
            System.out.println("| (5) Multiplicar os  polinômios                      |");
            System.out.println("| (0) SAIR                                            |");
            System.out.println("*=====================================================*");
            
            opc_invalida = true;
            while (opc_invalida){

                System.out.print("\nSua opção: ");
                
                switch(reader.nextInt()){

                    // Opção para encerrar
                    case 0:
                        System.out.println("Obrigado!");
                        finaliza = true;

                        opc_invalida = false;
                        break;

                    // Opção para inserir um novo polinomio
                    case 1:
                        System.out.print("Insira o grau do polinomio: ");
                        int grau = reader.nextInt();
                        double[] coefs = new double[grau + 1];

                        // Lê o polinomio de forma decrescente
                        for(int i = grau; i >= 0; i--){
                            System.out.print("\nInsira o coeficiente de grau " + i + ": ");
                            coefs[i] = reader.nextInt();
                        }

                        // Exibe os polinomios disponíveis
                        System.out.println("Polinômios em memória: ");
                        for(int i = 0; i < polinomios.length; i++){
                            System.out.print("(" + (i + 1) + ") P(x) = ");
                            polinomios[i].mostra();
                        }
                        
                        // Substitui um dos polinômios em memória
                        int sub = -1;
                        while (sub != 1 && sub != 2){
                            System.out.print("\n\nEscolha o polinômio a ser substituído: ");
                            sub = reader.nextInt();
                        }

                        // Instancia o novo polinomio
                        polinomios[sub-1] = new Polinomio(coefs);
                        
                        opc_invalida = false;
                        break;

                    // Opção para exibir os polinômios em memória
                    case 2:
                        if (polinomios.length == 0) break;

                        for(int i = 0; i < polinomios.length; i++){
                            System.out.print("(" + (i + 1) + ") P(x) = ");
                            polinomios[i].mostra();
                        }
                        
                        opc_invalida = false;
                        break;

                    // Opção para calcular o valor de P(x) dado um x
                    case 3:
                        System.out.print("\nInsira o x para calcular P(x): ");
                        double x = reader.nextDouble();

                        // Exibe os polinômios em memória
                        System.out.println("Polinômios em memória: ");
                        for(int i = 0; i < polinomios.length; i++){
                            System.out.print("(" + (i + 1) + ") P(x) = ");
                            polinomios[i].mostra();
                        }

                        // Escolha de qual polinômio será calculado
                        int escolha = -1;
                        while (escolha != 1 && escolha != 2){
                            System.out.print("\n\nEscolha o polinômio a ser calculado: ");
                            escolha = reader.nextInt();
                        }
                        
                        // Calcula o valor de P(x)
                        double px = polinomios[escolha-1].calcula(x);
                        
                        System.out.println("P(" + x + ") = " + px);        
                        
                        opc_invalida = false;
                        break;

                    // Opção para somar os polinômios que estão em memória
                    case 4:
                        
                        System.out.print("\nSoma dos polinômios em memória: ");
                        (polinomios[0].soma(polinomios[1])).mostra();
                        
                        opc_invalida = false;
                        break;

                    // Opção para multiplicar os polinômios que estão em memória
                    case 5:

                        System.out.print("\nProduto dos polinômios em memória: ");
                        (polinomios[0].multiplica(polinomios[1])).mostra();
                            
                        opc_invalida = false;
                        break;
                    
                    // Qualquer outra opção é inválida
                    default:
                        System.out.println("OPÇÃO INVÁLIDA!");

                }
            }

        }
        reader.close();
    }
    
}