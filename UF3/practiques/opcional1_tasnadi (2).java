//Tibi
package Teoria;
import java.io.*;
import java.util.*;

public class opcional1 {

	public static void main(String[] args) {
		boolean entrada1=true;
		ArrayList<String> cadena = new ArrayList<String>();
		System.out.println("Hola Ramon!");
		while (entrada1==true){
			entrada1=Menu(entrada1,cadena);
		}

	}
	public static boolean Menu(boolean entrada1, ArrayList cadena){
		boolean sortida=false;
		int decisio;
		Scanner sc=new Scanner (System.in);
				//Menu	
			do{
				try{
					System.out.println("Indica una de les segeunts opcions:\n1.Gestionar llista de preus\n2.Gestionar vendes\n3.Gestionar la caixa\n4.Sortir de l'aplicacio");
					decisio=sc.nextInt();
					while (decisio>4&&decisio<=0){
						System.out.println("Indica la opcio correcta:\n1.Gestionar llista de preus\n2.Gestionar vendes\n3.Gestionar la caixa\n4.Sortir de l'aplicacio");
						decisio=sc.nextInt();
					}
					if(decisio==1){
						System.out.println("Indica una de les subopcions:\n5.Carregar\n6.Afegir");
						decisio=sc.nextInt();
						while(decisio!=5&&decisio!=6){
							System.out.println("Indica la subopcio correcta:\n5.Carregar\n6.Afegir");
							decisio=sc.nextInt();
						}
						if(decisio==5){
							Carregar(cadena);
						}
						if(decisio==6){
							Afegir(cadena);
						}
					}
					if(decisio==2){
						System.out.println("Indica una de les subopcions:\n7.Vendes actuals\n8.Mes venut");
						decisio=sc.nextInt();
						while(decisio!=7&&decisio!=8){
							System.out.println("Indica la subopcio correcta:\n7.Vendes actuals\n8.Mes venut");
							decisio=sc.nextInt();
						}
						if(decisio==7){
							Vendes_actuals();
						}
						if(decisio==8){
							Mes_venut();
						}
					}
					if(decisio==3){
						System.out.println("Indica una de les subopcions:\n9.Mostrar Caixa\n10.Actualitzar la caixa");
						decisio=sc.nextInt();
						while(decisio!=9&&decisio!=10){
							System.out.println("Indica la subopcio correcta:\n9.Mostrar Caixa\n10.Actualitzar la caixa");
							decisio=sc.nextInt();
						}
						if(decisio==9){
							Mostrar_caixa();
						}
						if(decisio==10){
							Actualitzar_caixa();
						}
					}
					if (decisio==4){
						sortida=true;
						entrada1=false;
					}
				}catch(InputMismatchException e){
					System.out.println("Escriu un numero, no una lletra/caracter");
													
				}
			}while(sortida=false);
			
			return entrada1;
			
		
	}
	public static void Carregar(ArrayList cadena){
		String NomFit = "c:/tmp/preus.txt", s;
		Scanner sc=new Scanner (System.in);
		int posicio=0;
		posicio=0;
		//Mostro i carrego a l'array list el que hi ha al aexiu preus.txt
		try {
			cadena.clear();
		     FileReader fr = new FileReader(NomFit);
			 BufferedReader br = new BufferedReader(fr); 
			  do { 
			       s = br.readLine();
				   if (s != null){
					   cadena.add(s);
				   }
			   } while(s != null);
			   fr.close();
		       br.close();
		       //llegim l'arraylist aqui abaix
		       Iterator<String> llegir = cadena.iterator();
				while(llegir.hasNext()){
					String elemento = llegir.next();
					System.out.print(elemento+"\n");
				}
				
			   }catch(IOException e){ 
				   System.out.println("Error E/S: "+e);
			   }
		
		
	}
	public static void Afegir(ArrayList cadena){
		String NomFit = "c:/tmp/preus.txt", s;
		String [] part2= new String [100];
		Scanner sc=new Scanner (System.in);
		char [][] cadena2= new char[20][100];
		char lletra=' ',lletra2=' ';
		int entrada=0;
		boolean entrada3=false;
		//Afegim una linia a preus.txt
		try {
			   FileWriter fw = new FileWriter(NomFit,true);
			   BufferedWriter bw = new BufferedWriter(fw);
			   do{
				   	entrada3=false;
			       System.out.print("Escriu la nova linia seguint el segeunt format: Producte#Inicial#Numero \nUn cop acavis, presiona enter enlloc de escriure un nou producte");
			       s = sc.nextLine();
			       /**
			       String[] parts = s.split("#");
			       for (int entrada2=0;entrada2<part2.length;entrada2++){
			    	   if(parts[1]==part2[entrada]){
			    		   entrada3=true;
			    		   entrada2=part2.length;
			    	   }
			       }
			       if (entrada3==false){
			       part2[entrada]=parts[1];
			       entrada++;
			       **/
			       bw.write(s);
			       if (s.length()>0){
			    		   bw.newLine();
			       }
			       
			       cadena.add(s);
			      /**
			       }else{
			    	   System.out.println("Has introduit una inicial que ja esta repetida, torna a escriure");
			       }
			       **/
			   }while(s.length()>0);
			   bw.close();
			   fw.close();
			   		
			   }catch(IOException e){ 
				   System.out.println("Error E/S: "+e);
			   }
		
	}
	public static void Vendes_actuals(){
		String NomFit = "c:/tmp/vendes.txt", s;
		Scanner sc=new Scanner (System.in);
		//Mostrem el arxiu vendes
		try{
			FileWriter fw = new FileWriter(NomFit,true);
			BufferedWriter bw = new BufferedWriter(fw);
			do{
				System.out.println("Indica la nova venta indicant la inicial i la cantitat");
			   s = sc.nextLine();
		       bw.write(s);
		       if (s.length()>0){
		    		   bw.newLine();
		       }
		       
		   }while(s.length()>0);
		   bw.close();
		   fw.close();
		   
		   }catch(IOException e){ 
			   System.out.println("Error E/S: "+e);
		   }
	}
	public static void Mes_venut(){
		String NomFit = "c:/tmp/vendes.txt", s, mes_gran=" ",nom_producte=" ";
		String[] fraccio = new String[2];
		String[] fraccio2 = new String[3];
		String[] cadena1 = new String[100];
		int [] cantitat = new int [100];
		Scanner sc=new Scanner (System.in);
		int gran=0,num,flag=0,posicio=0;
		
		try {
			 FileReader fr = new FileReader(NomFit);
			 BufferedReader br = new BufferedReader(fr);
			 FileReader fr2 = new FileReader("c:/tmp/preus.txt");
		     BufferedReader br2 = new BufferedReader(fr2);
			  do { 
				  flag=0;
			       s = br.readLine();
			       if (s != null){
			    	   //Fraccionem el String en 2
			    	   fraccio = s.split(" ");
			    	   num = Integer.parseInt(fraccio[1]);
			    	  //Mirem si hi ha alguna similitut
			    	   for (int entrada=0;entrada<100;entrada++){
			    		   if (fraccio[0]==cadena1[entrada]){
			    			   cantitat[entrada]=cantitat[entrada]+num;
			    			   flag++;
			    			   entrada=100;
			    		   }
			    		   if (cadena1[entrada]== null){
			    			   posicio=entrada;
			    			   entrada=100;
			    		   }
			    		   
			    		   
			    	   }
			    	   if (flag==0){
			    		   cadena1[posicio]=fraccio[0];
			    		   cantitat[posicio]=num;
			    	   }
			    	   
			       }
			   } while(s != null);
			   fr.close();
		       br.close();
		       //Mirem quin es el mes gran i la seva inicial
		       for(int entrada=0;entrada<100;entrada++){
		    	   if(cantitat[entrada]>gran){
		    		   gran=cantitat[entrada];
		    		   mes_gran=cadena1[entrada];
		    	   }
		    	   
		    	   
		       }
		       //Tradueix la inicial a el nom que toca
		       do{
		    	   s = br2.readLine();
		    	   if(s != null){
		    		   fraccio2 = s.split("#");
		    		   if (fraccio2[1].equals(mes_gran)){
		    			   nom_producte=fraccio2[0];
		    		   }
		    	   }
		       }while(s != null);
		       
		       System.out.println("El producte mes venut es: "+nom_producte+" amb cantitat de: "+gran+"\n");
			
			   }catch(IOException e){ 
				   System.out.println("Error E/S: "+e);
			   }
		
		
	}
	public static void Mostrar_caixa(){
		String NomFit = "c:/tmp/caixa.txt", s;
		try {
			 FileReader fr = new FileReader(NomFit);
			 BufferedReader br = new BufferedReader(fr); 
			  do { 
			       s = br.readLine();
				   System.out.println(s);
			   } while(s != null);
			   fr.close();
		       br.close();
		       
				
			   }catch(IOException e){ 
				   System.out.println("Error E/S: "+e);
			   }
	}
	public static void Actualitzar_caixa(){
		
	}
	

}
