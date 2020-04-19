/* Somatório utilizando Threads com Área Crítica - Computação Paralela
Aluno: Lucas Cerqueira Figueiredo - TIA: 3182482-1 (05N11)
*/


#include <stdio.h>
#include <omp.h>

#define V 1073741824 // Número de elementos no vetor -> 2^30

int v[V];

int main(){
    
    long long unsigned int soma = 0;

    // Preenchendo o vetor em paralelo
    #pragma omp parallel for 
    for(int i = 0; i < V; i++){
        v[i] = 1;
    }    
    
    #pragma omp parallel for 
    for (int i = 0; i < V; i++){
        #pragma omp critical
        {
        soma += v[i];
        }
    }

    printf("%llu\n", soma);

    /*

    #pragma omp parallel private(t, inicio, fim, inter_res)
    
    t = omp_get_thread_num();
    inicio = t * (N/MAX);
    fim = inicio + (N/MAX);

    for (int i = inicio; i < fim; i++)

    }
    
    */

    return 0;
}
