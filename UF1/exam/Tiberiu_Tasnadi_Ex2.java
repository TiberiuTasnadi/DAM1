package exercicis;
import java.util.Scanner;
public class Tiberiu_Tasnadi_Ex2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		int numero, digit_ant=0,suma=0,cub,numero_ant=0,contador=1,digit=2;
		System.out.println("Indica el numero");
		numero=sc.nextInt();
		
		while (numero!=0){
			
			if (contador==1){
				System.out.print(numero+" ");
			}
			
			digit=numero%10;
			cub=(int) (digit*digit*digit);
			suma=suma+cub;
			numero=((numero-(numero%10))/10);
			contador++;
			
			while(numero>10000){
				System.out.println("\n Torna a escirure, no pot ser major que 10^4");
				numero=sc.nextInt();
			}
					
			if (numero<1){
				digit=numero%10;
				cub=(int) (digit*digit*digit);
				suma=suma+cub;
				System.out.print("- "+suma);
				numero_ant=numero;
				numero=suma;
				digit=2;
				
			}
			if (suma==1){
				System.out.print(" -> Es cubifinit \n");
				
				numero=sc.nextInt();
				contador=1;
				suma=0;
				digit=2;
				numero_ant=0;
			}
			if (numero==numero_ant){
				System.out.print(" -> No es cubifinito \n");
				numero_ant=0;
				numero=sc.nextInt();
				contador=1;
				suma=0;
				digit=2;
			}
		
			
		
			
					
					
				}
			}
		}
		
	


