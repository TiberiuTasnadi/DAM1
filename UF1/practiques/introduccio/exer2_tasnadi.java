//Tibi
package exercicis;
import java.util.Scanner;
import java.util.Random;
public class mates {

	public static void main(String[] args) {
		Random rnd=new Random();

		Scanner sc=new Scanner(System.in);
		int add,casos,sortida=0,percentatge, contador_casos=0, opcio1, opcio2,cont_correcte=0,cont_incorrecte=0, opcio3, correcte, resultat1,resultat2,operador, operando1, operando2, rang=89;
		System.out.println("Indica el numero de casos");
		casos=sc.nextInt();
		operando1=rnd.nextInt(1000);
		operando2=rnd.nextInt(1000);
		//Depenent del operador, fare un tipus de operacio o un altra
		operador=rnd.nextInt(3);
		while (casos>=contador_casos && sortida!=1){	
			//Aqui faig la suma
			while (operador==0 && casos>contador_casos){
				resultat2=operando1+operando2;
				add=rnd.nextInt(30);
				correcte=rnd.nextInt(4);
				opcio3=rnd.nextInt(resultat2+add);
				opcio2=rnd.nextInt(resultat2-add);
				opcio1=rnd.nextInt(resultat2+add);
				contador_casos++;
				System.out.println(operando1+"+"+operando2);
				if (correcte==0){
					correcte++;
				}
				if(correcte==1){
					System.out.println("1) "+resultat2+" 2) "+opcio1+" 3) "+opcio2+" 4) "+opcio3);
				}else if(correcte==2){
					System.out.println("1) "+opcio1+" 2) "+resultat2+" 3) "+opcio2+" 4) "+opcio3);
				}else if(correcte==3){
					System.out.println("1) "+opcio2+" 2) "+opcio1+" 3) "+resultat2+" 4) "+opcio3);
				}else if(correcte==4){
					System.out.println("1) "+opcio3+" 2) "+opcio1+" 3) "+opcio2+" 4) "+resultat2);
				}
				System.out.println("Opcio correcta:");
				resultat1=sc.nextInt();
				//Aqui pujo el contadors, depenent de la resposta anterior
				if (resultat1==correcte){
					cont_correcte++;
					operando1=rnd.nextInt(1000);
					operando2=rnd.nextInt(1000);
					operador=rnd.nextInt(3);
				}else{
					cont_incorrecte++;
					operando1=rnd.nextInt(1000);
					operando2=rnd.nextInt(1000);
					operador=rnd.nextInt(3);	
				}
			}
				while(operador==1 && casos>contador_casos){
					//Aqui faig la resta
					while (operando1>operando2 && casos>contador_casos && operador==1){
						//Aqui faig la resta si el operador1 es mes gran que el 2
						resultat2=operando1-operando2;
						add=rnd.nextInt(30);
						correcte=rnd.nextInt(5);
						opcio3=rnd.nextInt(resultat2-add);
						opcio2=rnd.nextInt(resultat2+add);
						opcio1=rnd.nextInt(resultat2-add);
						contador_casos++;
						System.out.println(operando1+"-"+operando2);
						if (correcte==0){
							correcte++;
						}
						if(correcte==1){
							System.out.println("1) "+resultat2+" 2) "+opcio1+" 3) "+opcio2+" 4) "+opcio3);
						}else if(correcte==2){
							System.out.println("1) "+opcio1+" 2) "+resultat2+" 3) "+opcio2+" 4) "+opcio3);
						}else if(correcte==3){
							System.out.println("1) "+opcio2+" 2) "+opcio1+" 3) "+resultat2+" 4) "+opcio3);
						}else if(correcte==4){
							System.out.println("1) "+opcio3+" 2) "+opcio1+" 3) "+opcio2+" 4) "+resultat2);
						}
						System.out.println("Opcio correcta:");
						resultat1=sc.nextInt();
						//Aqui pujo el contadors, depenent de la resposta anterior
						if (resultat1==correcte){
							cont_correcte++;
							operando1=rnd.nextInt(1000);
							operando2=rnd.nextInt(1000);
							operador=rnd.nextInt(3);
						}else{
							cont_incorrecte++;
							operando1=rnd.nextInt(1000);
							operando2=rnd.nextInt(1000);
							operador=rnd.nextInt(3);
						}
					}
					while (operando2>operando1 && casos>contador_casos && operador==1){
						//Aqui faig la resta si el operador2 es mes gran que el 1
							resultat2=operando2-operando1;
							add=rnd.nextInt(30);
							correcte=rnd.nextInt(4);
							opcio3=rnd.nextInt(resultat2+add);
							opcio2=rnd.nextInt(resultat2-add);
							opcio1=rnd.nextInt(resultat2+add);
							contador_casos++;
							System.out.println(operando2+"-"+operando1);
							if (correcte==0){
								correcte++;
							}
							if(correcte==1){
								System.out.println("1) "+resultat2+" 2) "+opcio1+" 3) "+opcio2+" 4) "+opcio3);
							}else if(correcte==2){
								System.out.println("1) "+opcio1+" 2) "+resultat2+" 3) "+opcio2+" 4) "+opcio3);
							}else if(correcte==3){
								System.out.println("1) "+opcio2+" 2) "+opcio1+" 3) "+resultat2+" 4) "+opcio3);
							}else if(correcte==4){
								System.out.println("1) "+opcio3+" 2) "+opcio1+" 3) "+opcio2+" 4) "+resultat2);
							}
							System.out.println("Opcio correcta:");
							resultat1=sc.nextInt();
							//Aqui pujo el contadors, depenent de la resposta anterior
							if (resultat1==correcte){
								cont_correcte++;
								operando1=rnd.nextInt(1000);
								operando2=rnd.nextInt(1000);
								operador=rnd.nextInt(3);
							}else{
								cont_incorrecte++;
								operando1=rnd.nextInt(1000);
								operando2=rnd.nextInt(1000);
								operador=rnd.nextInt(3);
				
							}
						}
				}
				while(operador==2 && casos>contador_casos){
					//Aqui faig la multiplicacio
				resultat2=operando1*operando2;
				add=rnd.nextInt(30);
				correcte=rnd.nextInt(4);
				opcio3=rnd.nextInt(resultat2+add);
				opcio2=rnd.nextInt(resultat2-add);
				opcio1=rnd.nextInt(resultat2+add);
				contador_casos++;
				System.out.println(operando1+"x"+operando2);
				if (correcte==0){
					correcte++;
				}
				if(correcte==1){
					System.out.println("1) "+resultat2+" 2) "+opcio1+" 3) "+opcio2+" 4) "+opcio3);
				}else if(correcte==2){
					System.out.println("1) "+opcio1+" 2) "+resultat2+" 3) "+opcio2+" 4) "+opcio3);
				}else if(correcte==3){
					System.out.println("1) "+opcio2+" 2) "+opcio1+" 3) "+resultat2+" 4) "+opcio3);
				}else if(correcte==4){
					System.out.println("1) "+opcio3+" 2) "+opcio1+" 3) "+opcio2+" 4) "+resultat2);
				}
				System.out.println("Opcio correcta:");
				resultat1=sc.nextInt();
				//Aqui pujo el contadors, depenent de la resposta anterior
				if (resultat1==correcte){
					cont_correcte++;
					operando1=rnd.nextInt(1000);
					operando2=rnd.nextInt(1000);
					operador=rnd.nextInt(3);
				}else{
					cont_incorrecte++;
					operando1=rnd.nextInt(1000);
					operando2=rnd.nextInt(1000);
					operador=rnd.nextInt(3);
				}
			}
				while(operador==3 && casos>contador_casos){
					//Aqui faig la divisio
					while (operando1>operando2 && casos>contador_casos && operador==3){
						//Aqui faig la divisio si el operado1 es mes gran que el 2
						resultat2=operando1/operando2;
						add=rnd.nextInt(30);
						correcte=rnd.nextInt(4);
						opcio3=rnd.nextInt(resultat2+add);
						opcio2=rnd.nextInt(resultat2-add);
						opcio1=rnd.nextInt(resultat2-add);
						contador_casos++;
						System.out.println(+operando1+"/"+operando2);
						if (correcte==0){
							correcte++;
						}
						if(correcte==1){
							System.out.println("1) "+resultat2+" 2) "+opcio1+" 3) "+opcio2+" 4) "+opcio3);
						}else if(correcte==2){
							System.out.println("1) "+opcio1+" 2) "+resultat2+" 3) "+opcio2+" 4) "+opcio3);
						}else if(correcte==3){
							System.out.println("1) "+opcio2+" 2) "+opcio1+" 3) "+resultat2+" 4) "+opcio3);
						}else if(correcte==4){
							System.out.println("1) "+opcio3+" 2) "+opcio1+" 3) "+opcio2+" 4) "+resultat2);
						}
						System.out.println("Opcio correcta:");
						resultat1=sc.nextInt();
						//Aqui pujo el contadors, depenent de la resposta anterior
						if (resultat1==correcte){
							cont_correcte++;
							operando1=rnd.nextInt(1000);
							operando2=rnd.nextInt(1000);
							operador=rnd.nextInt(3);
						}else{
							cont_incorrecte++;
							operando1=rnd.nextInt(1000);
							operando2=rnd.nextInt(1000);
							operador=rnd.nextInt(3);
						}
					}
					while (operando1<operando2 && casos>contador_casos && operador==3){
						//Aqui faig la divisio si el operado2 es mes gran que el 1
						resultat2=operando2/operando1;
						add=rnd.nextInt(30);
						correcte=rnd.nextInt(4);
						opcio3=rnd.nextInt(resultat2-add);
						opcio2=rnd.nextInt(resultat2+add);
						opcio1=rnd.nextInt(resultat2+add);
						contador_casos++;
						System.out.println(+operando2+"/"+operando1);
						if (correcte==0){
							correcte++;
						}
						if(correcte==1){
							System.out.println("1) "+resultat2+" 2) "+opcio1+" 3) "+opcio2+" 4) "+opcio3);
						}else if(correcte==2){
							System.out.println("1) "+opcio1+" 2) "+resultat2+" 3) "+opcio2+" 4) "+opcio3);
						}else if(correcte==3){
							System.out.println("1) "+opcio2+" 2) "+opcio1+" 3) "+resultat2+" 4) "+opcio3);
						}else if(correcte==4){
							System.out.println("1) "+opcio3+" 2) "+opcio1+" 3) "+opcio2+" 4) "+resultat2);
						}
						System.out.println("Opcio correcta:");
						resultat1=sc.nextInt();
						//Aqui pujo el contadors, depenent de la resposta anterior
						if (resultat1==correcte){
							cont_correcte++;
							operando1=rnd.nextInt(1000);
							operando2=rnd.nextInt(1000);
							operador=rnd.nextInt(3);
						}else{
							cont_incorrecte++;
							operando1=rnd.nextInt(1000);
							operando2=rnd.nextInt(1000);
							operador=rnd.nextInt(3);
						}
					}
				}
					// Per acabar, aqui faig els resultats finals i el tant percents			
				if (contador_casos == casos){
					percentatge=(cont_correcte*100)/casos;
					System.out.println("Resultats finals: "+cont_correcte+"/"+casos+" Percentatge: "+percentatge+"%");
					sortida=1;
					
				}
				
			
				}
	}
	
}
	

	
