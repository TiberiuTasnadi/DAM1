//Tibi
package exercicis;
import java.util.Scanner;
public class bici {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int avui,ahir=0,suma=0,contador_casos=0,casos;
		System.out.println("Indica el numero de casos");
		casos=sc.nextInt();
		System.out.println("Indica els primers kilometres i finalitza la sequencia amb un 0");
		avui=sc.nextInt();
		while(contador_casos<casos && avui<30 && casos<1000 && avui>0){
			while (avui!=0){
			avui=(avui*2)+ahir;
			ahir=avui;
			suma=suma+avui;
			avui=sc.nextInt();
			}
			while(avui==0){
				if(contador_casos<casos){
					System.out.println(suma);
					contador_casos++;
					if (contador_casos!=casos){
						suma=0;
						ahir=0;
						avui=sc.nextInt();
					
					}else{
						contador_casos=casos;
						avui=1;
					}
				}
				
		}

	}
	}
}
