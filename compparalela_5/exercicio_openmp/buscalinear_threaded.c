/* Busca em Vetor utilizando Threads - Computação Paralela
Aluno: Lucas Cerqueira Figueiredo - TIA: 3182482-1 (05N11)
*/

#include <stdio.h>
#include <omp.h>
#define SEED 3 // Seed para gerar inteiros únicos
#define N 65536 // Número de elementos no vetor

int main(){

    int x, MAX, t, inicio, fim;

    int v[N];

    // Preenchendo o vetor
    for(int i = 0; i < N; i++){
        v[i] = SEED * i;
    }

    printf("\nPosições: %d", N);

    printf("\nInsira um inteiro para ser buscado: ");
    scanf("%d", &x);

    MAX = omp_get_max_threads();
    #pragma omp parallel private(t, inicio, fim)
    {   
        // Delimitando o bloco buscado pela thread
        t = omp_get_thread_num();
        inicio = t * (N/MAX);
        fim = inicio + (N/MAX);

        for(int j = inicio; j < fim; j++){
            if (v[j] == x){
                printf("O elemento %d foi encontrado na posição %d pela Thread %d\n", x, j+1, t+1);
            } 
        }

        /* DEBUGGING
        printf("\nSegmento da Thread %d: ", t);
        for(int j = inicio; j < fim; j++){
            printf("%d ", v[j]);
        
        }   

        printf("\nIntervalo da Thread %d: %d-%d\n", t, inicio, fim-1);
        */

    }
    return 0;
}