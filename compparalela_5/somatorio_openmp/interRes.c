/* Somatório utilizando Threads com Vetores Intermediários - Computação Paralela
Aluno: Lucas Cerqueira Figueiredo - TIA: 3182482-1 (05N11)
*/

#include <stdio.h>
#include <omp.h>

#define V 1073741824 // Número de elementos no vetor -> 2^30

static int v[V];

int main(){

    int MAX, t, inicio, fim;
    long long unsigned int finalRes;

    MAX = omp_get_max_threads();

    printf("Número de threads: %d\n", MAX);

    // Vetor de valores intermediários
    long long unsigned int interRes[MAX];

    // Inicializando o vetor intermediário
    for (int i = 0; i < MAX; i++){
        interRes[i] = 0;
    }

    // Preenchendo o vetor apenas com o número 1
    #pragma omp for
    for(int i = 0; i <= V; i++){
        v[i] = 1;
    }    
    
    // Efetuando o somatório em cada bloco de thread
    #pragma omp parallel private(t, inicio, fim)
    {
        // Delimitando o bloco operado pela thread
        t = omp_get_thread_num();
        inicio = t * (V/MAX);
        fim = inicio + (V/MAX);

        for(int j = inicio; j < fim; j++){
            interRes[t] += v[j];
        }

        printf("Valor intermediario da Thread %d: %llu\n", t, interRes[t]);

    }

    // Somando os valores intermediários
    finalRes = 0;
    for (int i = 0; i < MAX; i++){
        finalRes += interRes[i];
    }

    // Espera-se que o valor final seja igual ao tamanho do vetor operado
    printf("Valor final: %llu\n", finalRes);

    return 0;
}
