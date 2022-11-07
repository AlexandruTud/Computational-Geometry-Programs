#include <stdio.h>
// v = vector
// l = lungimea vectorului
// e = element
// m = mijlocul vectorului
int cautare (int v[],int s,int d,int e){ //o functie pentru a cauta elementul nostru
    while(s<=d){
        int m=(s+d)/2; //Initializam mijlocul
        if(v[m]==e)
            return m;
        if(v[m]<e)
            s=m+1; //verificam urmatorul element spre dreapta
        else
            d=m-1;
    }
    return -1;
}

int main(){
    int v[]={1,12,18,20,31,32,38,39}; //adaugam valori in vector
    int l=sizeof(v)/sizeof(v[0]); //cautam lungimea vectorului
    printf("Sirul tau este:\n");
    for(int i=0;i<l;i++) {
        printf("%d ", v[i]);
    }
    int e;
    printf("\nIntroduceti elementul pe care doriti sa-l cautati:\n");
    scanf("%d", &e);
    int eGasit = cautare(v,0,l-1,e);
    if(eGasit == -1)
        printf("Elementul nu a fost gasit!\n");
    else
        printf("Elementul a fost gasit pe pozitia: %d", eGasit);
    return 0;
}
