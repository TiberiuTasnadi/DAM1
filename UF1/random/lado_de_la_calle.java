
import java.util.Scanner;
public class lado_de_la_calle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero;
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica el numero. Finalitza amb 0");
		numero = sc.nextInt();
		while(numero!=0){
			if(numero%2==0){
				System.out.println("DRETA");
			}
				else{
					System.out.println("ESQUERRA");
				}
				
			numero = sc.nextInt();
		
		}
	}

}
