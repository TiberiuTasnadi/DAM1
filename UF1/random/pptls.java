//Tibi
package exercicis;
import java.util.Scanner;
import java.util.Random;
public class pptls {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rnd=new Random();
		int [] user= new int [30];
		int [] cpu= new int [30];
		int entrada, sortida=30, vic_cpu=0, vic_user=0,user2, cpu2,entrada2;
		System.out.println("0.Pedra\n1.Paper\n2.Tisora\n3.Lagarto\n4.Spock");
		for(entrada=0;entrada<sortida;entrada++){
			user2=sc.nextInt();
			cpu2=rnd.nextInt(4);
			user[entrada]=user2;
			cpu[entrada]=cpu2;
			if ((user2==0 && cpu2==1) || (user2==0 && cpu2==4) || (user2==1 && cpu2==2) || (user2==1 && cpu2==4) || (user2==2 && cpu2==0) || (user2==2 && cpu2==4) || (user2==3 && cpu2==2) || (user2==3 && cpu2==1) || (user2==4 && cpu2==1) || (user2==4 && cpu2==3)){
				System.out.println("Has perdut la ronda. La maquina ha tret: ");
				vic_cpu++;
				if (cpu[entrada]==0){
					System.out.print("Pedra");
				}
				if (cpu[entrada]==1){
					System.out.print("Paper");
				}
				if (cpu[entrada]==2){
					System.out.print("Tisora");
				}
				if (cpu[entrada]==3){
					System.out.print("Lagarto");
				}
				if (cpu[entrada]==4){
					System.out.print("Spock");
				}
			}else if(user2==cpu2){
				System.out.println("Heu empatat. La maquina ha tret un :");
				if (cpu[entrada]==0){
					System.out.print("Pedra");
				}
				if (cpu[entrada]==1){
					System.out.print("Paper");
				}
				if (cpu[entrada]==2){
					System.out.print("Tisora");
				}
				if (cpu[entrada]==3){
					System.out.print("Lagarto");
				}
				if (cpu[entrada]==4){
					System.out.print("Spock");
				}
			}else{
				System.out.println("Has guanayat la ronda. La maquina ha tret un :");
				vic_user++;
				if (cpu[entrada]==0){
					System.out.print("Pedra");
				}
				if (cpu[entrada]==1){
					System.out.print("Paper");
				}
				if (cpu[entrada]==2){
					System.out.print("Tisora");
				}
				if (cpu[entrada]==3){
					System.out.print("Lagarto");
				}
				if (cpu[entrada]==4){
					System.out.print("Spock");
				}
			}
			if (vic_user==3){
				System.out.println("\nHas guanayt el joc. Aqui els resultats:");
				for (entrada2=0;entrada2<(entrada+1);entrada2++){
					System.out.println("\n\nRonda : "+(entrada2+1));
					if (user[entrada2]==0){
						System.out.print("User: Pedra \nCPU:\n");
					}
					if (user[entrada2]==1){
						System.out.print("User: Paper \nCPU:\n");
					}
					if (user[entrada2]==2){
						System.out.print("User: Tisora \nCPU:\n");
					}
					if (user[entrada2]==3){
						System.out.print("User: Lagarto \nCPU:\n");
					}
					if (user[entrada2]==4){
						System.out.print("User: Spock \nCPU:\n");
					}
					if (cpu[entrada2]==0){
						System.out.print("Pedra");
					}
					if (cpu[entrada2]==1){
						System.out.print("Paper");
					}
					if (cpu[entrada2]==2){
						System.out.print("Tisora");
					}
					if (cpu[entrada2]==3){
						System.out.print("Lagarto");
					}
					if (cpu[entrada2]==4){
						System.out.print("Spock");
					}
				}
				System.out.println("\nResum -> User: "+vic_user+" CPU: "+vic_cpu);
				entrada=sortida;
			}
			if (vic_cpu==3){
				System.out.println("\nHa guanayt el joc la maquina. Aqui els resultats:");
				for (entrada2=0;entrada2<(entrada+1);entrada2++){
					System.out.println("\n\nRonda : "+(entrada2+1));
					if (user[entrada2]==0){
						System.out.print("User: Pedra \nCPU:");
					}
					if (user[entrada2]==1){
						System.out.print("User: Paper \nCPU:");
					}
					if (user[entrada2]==2){
						System.out.print("User: Tisora \nCPU:");
					}
					if (user[entrada2]==3){
						System.out.print("User: Lagarto \nCPU:");
					}
					if (user[entrada2]==4){
						System.out.print("User: Spock \nCPU:");
					}
					if (cpu[entrada2]==0){
						System.out.print("Pedra");
					}
					if (cpu[entrada2]==1){
						System.out.print("Paper");
					}
					if (cpu[entrada2]==2){
						System.out.print("Tisora");
					}
					if (cpu[entrada2]==3){
						System.out.print("Lagarto");
					}
					if (cpu[entrada2]==4){
						System.out.print("Spock");
					}
					
				}
				System.out.println("\n\nResum -> User: "+vic_user+" CPU: "+vic_cpu);
				entrada=sortida;
			}
			
			
		}
	}

}
