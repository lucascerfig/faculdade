/* Somatório utilizando Threads com omp ... reduction(...) - Computação Paralela
Aluno: Lucas Cerqueira Figueiredo - TIA: 3182482-1 (05N11)
*/



#include <stdio.h>
#include <omp.h>

#define V 1073741824 // Número de elementos no vetor -> 2^30

static int v[V];

int main(){
    
    long long unsigned int soma = 0;

    // Preenchendo o vetor em paralelo
    #pragma omp parallel for 
    for(int i = 0; i < V; i++){
        v[i] = 1;
    }    
    
    // Efetuando o somatório
    #pragma omp parallel for reduction(+: soma)
    for (int i = 0; i < V; i++){
        soma += v[i];
    }
    
    printf("Resultado: %llu\n", soma);

    return 0;
}
