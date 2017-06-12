//Tibi
package exercicis;
import java.util.Scanner;
public class radar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int distancia_ini,velocitat_ini,temps_ini;
		float vel_mitja,metres_seg,multa;
		System.out.print("Indica la distancia \n");
		distancia_ini=sc.nextInt();
		System.out.print("Indica la velocitat \n");
		velocitat_ini=sc.nextInt();
		System.out.print("Indica el temps \n");
		temps_ini=sc.nextInt();
		while (distancia_ini!=0 && velocitat_ini!=0 && temps_ini!=0){
			while(distancia_ini<=-1 || velocitat_ini<=-1 || temps_ini<=-1){
				System.out.print("ERROR \n");
				System.out.print("Indica la distancia \n");
				distancia_ini=sc.nextInt();
				System.out.print("Indica la velocitat \n");
				velocitat_ini=sc.nextInt();
				System.out.print("Indica el temps \n");
				temps_ini=sc.nextInt();
			}
			vel_mitja=(float)distancia_ini/temps_ini;
			
			metres_seg=(float)(velocitat_ini*10)/36;
			
			multa=(float)(metres_seg*0.2)+metres_seg;
			
			if (metres_seg>=vel_mitja){
				System.out.print("OK \n");
			}else if(vel_mitja>metres_seg && vel_mitja<multa){
				System.out.print("MULTA \n");
			}else {
				System.out.print("PUNTOS \n");
			}
			System.out.print("Indica la distancia \n");
			distancia_ini=sc.nextInt();
			System.out.print("Indica la velocitat \n");
			velocitat_ini=sc.nextInt();
			System.out.print("Indica el temps \n");
			temps_ini=sc.nextInt();
						
		}
		
			
	}

}