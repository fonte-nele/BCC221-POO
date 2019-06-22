#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
int tempo = 500;
int usu[6];
int cont = 0;
int fase = 0;
int vel = 0;
int lin, col;
int seq[6][6];
int num;
int contador=0;
int i,j;
//Protótipo das funções
void inicia();
void liga();
void muda(int, int, int);
int verifica();
void mostraganhou();
void mostraerrou();
void geranum();
void menu1();
void liga()
{
 for(j = 0; j <= contador; j++ )
 {
 muda(seq[fase][j], tempo, 0);
 menu1();
 }
}
void mostraganhou()
{
 printf("\n::::::::::::::::::::");
 printf("\n:::Voce Acertou!!:::");
 printf("\n::::::::::::::::::::\n");
 printf(":: VELOCIDADE %d - FASE %d \n", vel+1 , fase+1);
 system("color 5F");
 _beep(400,1000);
 system("cls");
 menu1();
}
void mostraerrou()
{
 printf("\n::::::::::::::::::::");
 printf("\n:::Voce ERROU!!::::");
 printf("\n::::::::::::::::::::\n");
 printf(":: VELOCIDADE %d - FASE %d \n", vel+1 , fase+1);
 system("color 4F");
 _beep(900,2000);
 system("cls");
 menu1();
}
main()
{
 inicia();
 system("cls");
 geranum();
 menu1();
 sleep(1000); // aguarda 1s
 liga();
 while(1)
 {
 for(i = 0; i <= contador; i++ )
 {
 printf("\nDigite a sequencia: \n");
 printf(" Numero %d: ", i+1) ;
 scanf("%d", &usu[i]);
 muda(usu[i],100,1);
 }
 if (verifica())
 {
 contador++;
 if (contador % 6 == 0) //a cada nova fase(6 acertos)
 {
 printf("Preparando-se para a nova fase...");
 sleep(1000); // aguarda 1s

 fase++;
 vel++;
 tempo-=100;
 {
 if (tempo < 100)
{
 tempo = 500;
fase = 0;
 }
 }
 contador = 0;
 }

 mostraganhou();
 liga();
 cont = 0;
 }
 else
 {
 mostraerrou();
 liga();
 cont = 0;
 }
 }
}
void menu1()
{
 printf("::::::::::::::::::: \n");
 printf(": JOGO GENIUS : \n");
 printf("::::::::::::::::::: \n");
 printf(": VELOCIDADE %d - FASE %d \n", vel+1 , fase+1);
 printf("iniciando....\n");
}
void muda(int i, int t, int habilita)
{
 switch(i)
 {
 //Cor azul
 case 0:
 system("color 1F");
 printf("\n::: 0 ::::") ;
 _beep(1000,t);
 break;

 //Cor vermelha
 case 1:
 system("color 4F");
 printf("\n::: 1 ::::") ;
 _beep(800,t);
 break;
 //Cor verde
 case 2:
 system("color 2F");
 printf("\n::: 2 ::::") ;
 _beep(600,t);
 break;
 //Cor amarela(fundo) e letra preta
 case 3 :
 system("color E0");
 printf("\n::: 3 ::::") ;
 _beep(500,t);
 break;
 }
 if (habilita == 0){
 system("cls");
 }
 system("color 0F");
}
int verifica()
{
 int c, l;
 l = fase;
 {
 for (c = 0; c <= contador; c++)
 {
 if (seq[l][c] != usu[c])
 {
 return 0;
 break;
 }
 }
 }
 return 1;
}
void geranum()
{
 srand(time(NULL));
 for (lin = 0; lin <= 4; lin++)
 {
 for (col=0; col<=4; col++)
 {
 // para gerar números aleatórios de 0 a 5
 num = (rand() % 4);
 while(num == seq[lin][col-1])
 {
 num = (rand() % 4);
 }
 seq[lin][col] = num;
 }
 }
}
void inicia()
{
 int y = 400, c=0;
 char cmd_MSDOS[50];
 char barra[50];

 strcpy(barra,"");

 for(c= 0;c<=15;c++)
 {
 system("cls");
 if(c<=15)
 {
 sprintf(cmd_MSDOS,"color %xF",c) ;
 strcat(barra,":") ;
 printf("%s\n", barra);
 printf(": JOGO GENIUS : \n");
 printf("%s\n", barra);
 _beep(y,200);

 if(c == 15)
 {
 system("color F0");
 }else
 system(cmd_MSDOS); //executa comando msdos
 }
 y+=100;
 }

}