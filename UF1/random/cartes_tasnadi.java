//Tibi
package exercicis;
import java.util.Scanner;
import java.util.Random;
public class cartes {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		Random rnd=new Random();
		int [] cartes=new int[48];
		int llegir_cartes, llegidor=0,decisio=0,random,vic_cpu=0,vic_usu=0,entrada=0;
		//entrada serveix per entrar al while que, en cas de que no ha acavat la partida, torni a fer el bucle del usuari
		//decisio indica, segons el valor que te (0=usuari, 1=maquina) a qui li toca "jugar"
		double actual_usu=0,suma_usu=0,actual_cpu=0,suma_cpu=0;
		//les variables del double seran les que farem servir al joc per mirar qui guanya la ronda
		//Aqui incertarem les cartes dins de l'array
		for (llegir_cartes=0;llegir_cartes<48;llegir_cartes++){
			if (llegidor>11){
				llegidor=0;
			}
			llegidor++;
			cartes[llegir_cartes]=llegidor;
			
		}
		//Aqui ja comença el joc, on dependent de la decisio, jugara la cpu o el user. Quan la decisio es 2, s'acabara el joc denifitavament i hi haura un guanyador
		while (decisio!=2){
			
		//Aqui juga el usuari
		while (decisio==0){
			llegir_cartes=0;
			random=rnd.nextInt(48);
			actual_usu=cartes[random];
			//En cas de que li haigui tocat una carta que abans ja ha tocat, se li asignara el valor de 0 i haura de tornar a triar una altra
			while (actual_usu==0){
				random=rnd.nextInt(48);
				actual_usu=cartes[random];
			}
			//Aqui surten els resultat de la ronda, on depenent de quina carta ha tocat, seran de ESPASES, BASTONS, OROS o COPES
			if (random<=12){
				System.out.print("ESPASES: "+actual_usu );
				if (actual_usu==11 || actual_usu==12 || actual_usu==10){
					actual_usu=0.5;
				}
				suma_usu=(actual_usu+suma_usu);
				System.out.println("\nsi vols una altra carta apreta 0, sino, apreta 1\ntotal: "+suma_usu);
				cartes[random]=0;
				decisio=sc.nextInt();
				while (decisio>1){
					System.out.println("sol pots escriure un 0 o un 1");
					decisio=sc.nextInt();
				}
				
			}
			if (random>12 && random<=24){
				System.out.print("BASTOS: "+actual_usu );
				if (actual_usu==11 || actual_usu==12 || actual_usu==10){
					actual_usu=0.5;
				}
				suma_usu=(actual_usu+suma_usu);
				System.out.println("\nsi vols una altra carta apreta 0, sino, apreta 1 \ntotal: "+suma_usu);
				cartes[random]=0;
				decisio=sc.nextInt();
				while (decisio>1){
					System.out.println("sol pots escriure un 0 o un 1");
					decisio=sc.nextInt();
					
				}
			}
			if (random>24 && random<=36){
				System.out.print("OROS: "+actual_usu );
				if (actual_usu==11 || actual_usu==12 || actual_usu==10){
					actual_usu=0.5;
				}
				suma_usu=(actual_usu+suma_usu);
				System.out.println("\nsi vols una altra carta apreta 0, sino, apreta 1\ntotal: "+suma_usu);
				cartes[random]=0;
				decisio=sc.nextInt();
				while (decisio>1){
					System.out.println("sol pots escriure un 0 o un 1");
					decisio=sc.nextInt();
				}
			}
			if (random>36 && random<=48){
				System.out.print("COPES: "+actual_usu );
				if (actual_usu==11 || actual_usu==12 || actual_usu==10){
					actual_usu=0.5;
				}
				suma_usu=(actual_usu+suma_usu);
				System.out.println("\nsi vols una altra carta apreta 0, sino, apreta 1\ntotal: "+suma_usu);
				cartes[random]=0;
				decisio=sc.nextInt();
				while (decisio>1){
					System.out.println("sol pots escriure un 0 o un 1");
					decisio=sc.nextInt();
				}
			}
			//En cas de que el jugador ha apretat 1, ara li toca a la maquina jugar
		}
			while (decisio==1){
				llegir_cartes=0;
				random=rnd.nextInt(48);
				actual_cpu=cartes[random];
				cartes[random]=0;
				while (actual_cpu==0){
					random=rnd.nextInt(48);
					actual_cpu=cartes[random];
				}
				if (actual_cpu==11 || actual_cpu==12 || actual_cpu==10){
					actual_cpu=0.5;
					
				}
				suma_cpu=actual_cpu+suma_cpu;
			
				//comença la comprobacio de qui ha guanyat la ronda
				//En cas de que la CPU sigui mes petit que 7.5 i es mes gran que el usuari, guanya
				if (suma_cpu<=7.5 && suma_usu<suma_cpu){
					vic_cpu++;
					System.out.println("Ha guanyat la CPU la ronda");
					System.out.println("Puntuacio: CPU -> "+vic_cpu+" USER -> "+vic_usu+"\n \n \n");
					entrada=1;
				}
				//En cas de que la cpu es mes gran de 7.5 i tambe es mes gran que el usuari, guanay el usuari
				if (suma_cpu>7.5 && suma_cpu>suma_usu){
					
					vic_usu++;
					System.out.println("Has guanyat la ronda");
					System.out.println("Puntuacio: CPU -> "+vic_cpu+" USER -> "+vic_usu+"\n \n \n");
					entrada=1;
				}
				//En cas de que la cpu sigui mes gran de 7.5, pero es mes petit que el usuari, guanya la CPU
				if(suma_cpu>7.5 && suma_cpu<suma_usu){
					vic_cpu++;
					System.out.println("Ha guanyat la CPU la ronda");
					System.out.println("Puntuacio: CPU -> "+vic_cpu+" USER -> "+vic_usu+"\n \n \n");
					entrada=1;
				}
				//En cas de que e lusuari es mes gran de 7.5 i la CPU es mes petita que 7.5, guamya la CPU
				if (suma_usu>7.5 && suma_cpu<7.5){
					vic_cpu++;
					System.out.println("Ha guanyat la CPU la ronda");
					System.out.println("Puntuacio: CPU -> "+vic_cpu+" USER -> "+vic_usu+"\n \n \n");
					entrada=1;
				}
				//comença la comprobacio de puntuacio aqui
				if (vic_usu==3){
					System.out.println("Has Guanyat");
					decisio=2;
				}else if (vic_cpu==3){
					System.out.println("Has Guanyat CPU");
					decisio=2;
				//Si el joc no ha acavat, entrarem en aquet else if
				}else if (vic_usu!=3 && vic_usu!=3 && entrada==1){
					decisio=0;
					suma_usu=0;
					suma_cpu=0;
					entrada=0;
					
				}
				// RAMON, NOSE SI ES AIXI COM VOLIES EL PROGRAMA O LES DECISIONS DE QUI GUANYAVA, PERO TAMPOC M'HAN EXPLICAT GAIRE MES, SUPOSO QUE ESTARA BE AIXI, MERCI
			}
		}
			

	}

}
