//Tibi
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
public class UF3_PractObli_tasnadi_tiberiu {

	public static void main(String[] args) {
		boolean sortida=false;
		//Aquesta boolean ens servira per sortir del programa en cas de que el usuari ellegieix la opcio 9
		int decisio=0,decisio2,cantitat_equips,cant_partits=0;
		//decisio ens servira per mourens dins del menu
		//decisio2 ens servia per mourens als submenus
		//cantitat_equips ens servira per indicar quants equips volem entrar al arxiu equipts.txt
		//cant_partits servira per indicar quants partits volem entrar a l'arxiu resultats
		int [][] resultats= new int[10][5];
		//Resultats guardara els partits guanyats, perduts, empatats i la puntuacio
		int [][] golejats=new int [11][3];
		//golejats guardara gols a favor i gols en contra de cada equip
		String NomFitResultats = "c:/tmp/resultats.bin";
		String NomFitEquips = "c:/tmp/equips.txt";
		String NomFitClassi = "c:/tmp/classi.txt";
		String NomFitInformes = "c:/tmp/informes.txt";
		//Aquest trings son les rutes dels arxius
		ArrayList<String> cadena = new ArrayList<String>();
		//L'array list guardara el nom dels equips per no tenir que entrar al arxiu sempre
		System.out.println("----------------Benxingut!----------------");
		//inicialitzem resultats a 0
		for (int entrada=0;entrada<10;entrada++){
			for(int entrada2=0;entrada<4;entrada++){
				resultats[entrada][entrada2]=0;
			}
		}
		//Aqui comença el menu
			do{
				try{
					Scanner sc=new Scanner (System.in);
					System.out.println("1.Mostrar Equips\n2.Alta Equips\n3.Alta Resultats Partits\n4.Processar Resultats\n5.Fer Classificacio\n6.Informes\n7.Consultes\n9.Sortida");
					decisio=sc.nextInt();
					//decisio sera l'apartat on entrarem
					while (decisio>9 || decisio<1 || decisio == 8){
						//controlem que la dada sigui correcta
						//Al pdf deia que 9 sera la opcio de sortir, pero de la 8 no deia res, aixi que la deshabilitem
						System.out.println("Indica la opcio correcta:\n1.Mostrar Equips\n2.Alta Equips\n3.Alta Resultats Partits\n4.Processar Resultats\n5.Fer Classificacio\n6.Informes\n7.Consultes\n9.Sortida");
						decisio=sc.nextInt();
					}
					//En cas de voler entrar en la opcio 1 entrarem aqui
					if (decisio==1){
						//Primer entrarem a la funcio seguent per omblir l'array list dels noms dels equips
						MostrarEquips(cadena, NomFitEquips);
						//Un cop sortit del la funcio llegirem l'arrayList amb el segeunt codi:
						Iterator<String> llegir = cadena.iterator();
						while(llegir.hasNext()){
							String elemento = llegir.next();
							System.out.print(elemento+"\n");
						}
					}
					//En cas de voler entrar en la opcio 2 entrarem aqui
					if (decisio==2){
						//En aquest apartat afegirem equips al arxiu equips.txt
						System.out.println("Indica la cantitat de equips que vols introduir (Maxim 10 equips)");
						cantitat_equips=sc.nextInt();
						
						//Entro dins de la funcio epr insertar un equip nou
						AltaEquips(cantitat_equips,cadena,NomFitEquips);
					}
					//En cas de voler entrar en la opcio 3 entrarem aqui
					if (decisio==3){
						//Aqui insertarem al fitxer resultats, els resultats dels partits
						System.out.println("Indica quants partits vols entrar:");
						cant_partits=sc.nextInt();
						AltaResultats(cadena,cant_partits,NomFitResultats, NomFitEquips);
					}
					//En cas de voler entrar en la opcio 4 entrarem aqui
					if (decisio==4){
						//Aqui mostrarem els resultats llegit el fitxer resulats.bin
						MostrarResultats(cadena,resultats, NomFitResultats, NomFitEquips);
					}
					//En cas de voler entrar en la opcio 5 entrarem aqui
					if (decisio==5){
						//Aqui escriruem dins del arxiu classi.txt ordenat per punts el equip que mes en te
						FerClassi(NomFitClassi,resultats,cadena,NomFitEquips);
					}
					//En cas de voler entrar en la opcio 6 entrarem aqui
					if (decisio==6){
						//Aqui tindrem un submenu amb 2 opcions espesificades abaix
						System.out.println("1.Menys Golejats\n2.Rei Empats");
						//Aqui preguntem per el submenu
						decisio2=sc.nextInt();
						while (decisio2!=1&&decisio2!=2){
							//controlem l'entrada del submenu
							System.out.println("Indica les opcions correctes(1 o 2)");
							decisio2=sc.nextInt();
						}
						if (decisio2==1){
							//En cas de entrar en aquest apartat, escriurem al arxiu informes el equim menys golejat
							MenysGolejat(NomFitEquips,NomFitInformes,NomFitResultats,cadena,golejats,resultats);
						}
						//En cas de entrar en aquest apartat, escriurem al arxiu informes el equip mes empatat
						if (decisio2==2){
							ReiEmpats(NomFitEquips,cadena,resultats,NomFitInformes,golejats,NomFitResultats);
						}
					}
					//En cas de voler entrar en la opcio 7 entrarem aqui
					if (decisio==7){
						Consultes(NomFitInformes);
					}
					//En cas de voler entrar en la opcio 9 entrarem aqui
					if (decisio==9){
						sortida=true;
					}
				}catch(InputMismatchException e){
					//Si l'usuari ha intorduit algo que no toca i salti un error, entrarem aqui i tornarem al menu
					System.out.println("Escriu un numero, no una lletra/caracter");
					Scanner sc=new Scanner (System.in);
					decisio=0;
				}
			}while(sortida==false);
		
	}
	public static void MostrarEquips (ArrayList cadena, String NomFitEquips){
		//Aquesta funcio cargara l'array list dels equips que hi han per poderlos mostrar desde el mein
		String s;
		Scanner sc=new Scanner (System.in);
		try {
			cadena.clear();
		    FileReader fr = new FileReader(NomFitEquips);
			BufferedReader br = new BufferedReader(fr); 
			do { 
				s = br.readLine();
			   	if (s != null){
				cadena.add(s);
			   	}
			   }while(s != null);
			   fr.close();
		       br.close();
		 }catch(IOException e){ 
			   System.out.println("Error E/S: "+e);
		}
	}
	public static void AltaEquips (int cant_equips,ArrayList cadena, String NomFitEquips){
		//Aqui afegirem un equip
		String s;
		Scanner sc=new Scanner (System.in);
		int equips_dins_fit=0,paraules_intorduides=0;
		try {
			
			FileWriter fw = new FileWriter(NomFitEquips,true);
			BufferedWriter bw = new BufferedWriter(fw);
			//mirem quants tenim escrist dins del arxiu perque no poden superar els 10. Ens assegurem de que esta carregada fent que el programa entri per si sol, en cas de que aquesta sigui la primera opcio del usuri
			MostrarEquips(cadena,NomFitEquips);
			equips_dins_fit=cadena.size();
			
			//Si hi han 10 equips, tornarem al mein
			if (equips_dins_fit==10){
				System.out.println("Ja hi han 10 equips");
				main(null);
			}
			//Si tenim mes de 10 equips sumants els que ja hi han mes els que volem, entrarem aqui per tornar a indicar la cantitat que volem entrar.
		    while ((equips_dins_fit+cant_equips)>10){
		    	System.out.println("Hi han mes de 10 equips. Torna a introduir la cantitat que vols intorduir");
		    	cant_equips=sc.nextInt();
		    	sc.nextLine();
		    }
		   
		    do{
		    //Un cop passat per les comprovacions, entrarem en aquest do per escrirue dins del fitxer la linia
			  System.out.println("Indica el nom del equip");
		       s = sc.nextLine();
		       bw.write(s);
		       bw.newLine();
		       //Aquest contador serveix per no intorudir mes paralues de les que volem
		       paraules_intorduides++;
		   }while(paraules_intorduides<cant_equips);
		   
		   bw.close();
		   fw.close();
		 }catch(IOException e){ 
			   System.out.println("Error E/S: "+e);
		}
	}
	public static void AltaResultats (ArrayList cadena,int cantitat_partits, String NomFitResultats, String NomFitEquips){
	//Aqui escriurem disn del arxiu reusltats.bin (binari) els resultars dels partits	
		Scanner sc=new Scanner (System.in);
		int escriure,posicio=1,cantitat_entrats=0,identificador_equip1,gols_equip1,identificador_equip2,gols_equip2;
		MostrarEquips(cadena,NomFitEquips);
		Iterator<String> llegir = cadena.iterator();
		//primer mostrarem per pantalla els identificadors i els partits
		while(llegir.hasNext()){
				String elemento = llegir.next();
				System.out.print(posicio+"-"+elemento+"\n");
				posicio++;
			}
		System.out.println("----------------------------");
		try{
			DataOutputStream Escriure=new DataOutputStream(new FileOutputStream(NomFitResultats, true));
			do{
				//Un cop mostrar, guardarem a unes variables els resultats per despres cargals al arxiu
				cantitat_entrats=cantitat_entrats+1;
				System.out.println("Intordueix partit"+cantitat_entrats);
				cantitat_entrats=cantitat_entrats-1;
				System.out.println("Indica el numero del equip:");
				identificador_equip1=sc.nextInt();
				System.out.println("Indica els gols marcats");
				gols_equip1=sc.nextInt();
				System.out.println("Indica el numero del seguent equip:");
				identificador_equip2=sc.nextInt();
				System.out.println("Indica els gols marcats");
				gols_equip2=sc.nextInt();
				while ((identificador_equip1==identificador_equip2)|| gols_equip1<0 || gols_equip2<0){
					//En cas de escriure els mateixos identificadors de equip o que els gols siguin negatius entrarem aqui i haurem de tornar a esciure
					System.out.println("No pots indicar 2 cops el mateix equip o indicar gols negatius, torna a intoruirho TOT");
					llegir = cadena.iterator();
					posicio=1;
					while(llegir.hasNext()){
							String elemento = llegir.next();
							System.out.print(posicio+"-"+elemento+"\n");
							posicio++;
						}
					System.out.println("Indica el numero del equip:");
					identificador_equip1=sc.nextInt();
					System.out.println("Indica els gols marcats");
					gols_equip1=sc.nextInt();
					System.out.println("Indica el numero del seguent equip:");
					identificador_equip2=sc.nextInt();
					System.out.println("Indica els gols marcats");
					gols_equip2=sc.nextInt();
				}
				//Quan acabem, esciruem al arxiu passanli les variables. Tambe mostrarem un resum del que hem escrit 
				System.out.println(identificador_equip1+"#"+gols_equip1+"#"+identificador_equip2+"#"+gols_equip2);
				Escriure.writeInt(identificador_equip1);
				Escriure.writeInt(gols_equip1);
				Escriure.writeInt(identificador_equip2);
				Escriure.writeInt(gols_equip2);
				cantitat_entrats++;
			}while(cantitat_entrats<cantitat_partits);
			
           }
		catch(IOException e){
            System.out.println("Error E/S");
        }
	}
	public static void MostrarResultats (ArrayList cadena, int [][] resultats, String NomFitResultats, String NomFitEquips){
	//Aqui mostrarem els resultarts del fitxer resultats.bin	
		int posicio1=0,posicio2=0,gols1=0,gols2=0,posicio=1;
		//posicio1 es el identificador del primer equip
		//posicio2 es el identificador del segon euqip
		//gols1 es la cantiatt de gols que ha marcat el equip1
		//gols2 es la cantiat de gols que ha marxat el equip2
		try{
			//reiniciem la matriu a 0, per si aquest a sigut el segon cop que entrem sobrecarregar els resultats
        	DataInputStream LeeFichero=new DataInputStream(new FileInputStream(NomFitResultats));
        	for (int entrada1=0;entrada1<10;entrada1++){
        		for (int entrada2=0;entrada2<5;entrada2++){
        			 resultats[entrada1][entrada2]=0;
        		}
        	}
                       		
        	do{
        	//Aqui llegirem el primer resultats
        	//guardarem a les variables que toca els resultats
            posicio1=LeeFichero.readInt();
            System.out.print(posicio1+"#");
            gols1=LeeFichero.readInt();
            System.out.print(gols1+"#");
            posicio2=LeeFichero.readInt();
            System.out.print(posicio2+"#");
            gols2=LeeFichero.readInt();
            System.out.print(gols2+"#");
            //Aqui compararem els resultats dels gols
            //La posicio 0 es guarda el identificador
            //La posicio 1 guarda partits guanyats
            //La posicio 2 guarda partits perduts
            //La posicio 3 guarda partits empatats
            //La posicio 4 guarda la puntuacio
            if (gols2>gols1){
            	//si el equip 2 ha marcat mes gols, sumarem un 1 a guanyats del equip2, sumarem un 1 perudts del equip1 i 3 punts al equip2
            	resultats[posicio2][1]=resultats[posicio2][1]+1;
            	resultats[posicio1][2]=resultats[posicio1][2]+1;
            	resultats[posicio2][4]=resultats[posicio2][4]+3;
            }
            if (gols1>gols2){
            	//si el equip 1 ha marcat mes gols, sumarem un 1 a guanyats del equip1, sumarem un 1 perudts del equip2 i 3 punts al equip1
            	resultats[posicio1][1]=resultats[posicio1][1]+1;
            	resultats[posicio2][2]=resultats[posicio2][2]+1;
            	resultats[posicio1][4]=resultats[posicio1][4]+3;
            }
            if (gols1==gols2){
            	//si han quedat empat sumarem un 1 a empat dels 2 equips i un 1 a la puntuacio
            	resultats[posicio1][3]=resultats[posicio1][3]+1;
            	resultats[posicio2][3]=resultats[posicio2][3]+1;
            	resultats[posicio1][4]=resultats[posicio1][4]+1;
            	resultats[posicio2][4]=resultats[posicio2][4]+1;
            }
            //Al final guardarem el identiifcador a la linia que toca
            resultats[posicio1][0]=posicio1;
            resultats[posicio2][0]=posicio2;
            System.out.print("\n");
            //quan no temin mes que llegir, petara i anirem al cathc, on mostrarem per pantalla la matriu
        	}while(true);
        	
        }catch(EOFException e){
        	//Aqui mostrem per pantalla la matriu
            System.out.println("--Equips-----|--Guanyats----|---Perduts-------|----Empatats---|-----Puntuacio-------|");
            for(int entrada1=1;entrada1<10;entrada1++){
            	for(int entrada2=0;entrada2<5;entrada2++){
            		//En cas de estar a la pocisio [x][0] de la matriu entrarem aqui
            		if (entrada2==0){
            			//cargarem l'arrayList
            			MostrarEquips(cadena, NomFitEquips);
            			//tradiurem del identificador al equip que li toca, ja que estan ordenar els identificadors
            			System.out.print(cadena.get(entrada1-1)+"\t\t");
            			           				
            		}else{
            			//Aqui mostrem els resultats en cas de no estar a la posicio 0 i tenir que fer tot allo
            			System.out.print(resultats[entrada1][entrada2]+"\t\t");
            		}
            	}
            	System.out.print("\n");
            	//Quan a al seguent posicio 0 de la matriu estem a 0, significa que no hi ha cap equip, ja que no ni ha cap amb identificador 0 i tanquem el for
            	if (resultats[entrada1+1][0]==0){
            		entrada1=10;
            	}
            	
            }
          System.out.println("-----------------------------------------------------------------------------");  
        }catch(IOException e){
            System.out.println("Error E/S");
        }
	}
	
	public static void FerClassi (String NomFitClassi ,int [][] resultats,ArrayList cadena,String NomFitEquips){
		//fer classi escirura al arxiu classi.txt ordenat del mes gran al petit, els putns que te l'equip 
		int sortida=50,mes_puntuacio=-1,nom_equip_gran=0,cont_false,cont_cantitat=0;
		boolean sortida2=true,entrada3=true;
		//tindrem una array de boleans per saber si el identificador que comparem amb el gran, ja ho hem fet abans o no (si estra true, el podrem comparar, sino no)
		boolean[] comprovar = new boolean [10];
		String Equip,s;
		//inicialitzem l'array de booleans a true
		for (int entrada=0; entrada<10;entrada++){
			comprovar[entrada]=true;
		}
		//carguem l'arraylist aqui
		MostrarEquips(cadena,NomFitEquips);
		if (resultats[1][0]==0){
			//En cas de no tenir cargada la matriu de resultats, entrarem aqaui i obligarem al usuari de anarhi
			System.out.println("Primer passa per procesar Resultats");
			main(null);
		
		}
		try{
			FileWriter fw = new FileWriter(NomFitClassi,false);
			//fico false, peque sempre que entro hauria de estar actualizat, no empagat abaix
			BufferedWriter bw = new BufferedWriter(fw);
			do{
				//mes_puntacio sera una variable que guardara els punts mes grans
				mes_puntuacio=-1;
				//entrada3 es per exitar entrar en cas de que la seguent linia es un 0 i ens cargui com a mes puntuacio
				entrada3=true;
				for (int entrada1=1; entrada1<sortida;entrada1++){
					
					if (resultats[entrada1][0]==0){
						entrada3=false;
						//En cas de tnir un 0 a identificador, tornarem false entrada 3 i no entrarem mes a les altres opcions
						
					}
					
					if (mes_puntuacio<resultats[entrada1][4]&&comprovar[entrada1]==true&&entrada3==true){
						//si a l'apartat de puntuacio es mes gran que la puntuacio mes gran cargada a la variables i a la matexa posicio que el identificador a l'array de booleans estra a true (no feta servir anteriorment) podrem efectuar el segeunt:
						//mes puntacio sera el resultats d'aquesta poscio	
						mes_puntuacio=resultats[entrada1][4];
						//tambe guardem el identificador en aquesta variable
						nom_equip_gran=resultats[entrada1][0];
					}
					//Aqui soritrem en cas de tenir un 0 com a indetificador
					if (resultats[entrada1][0]==0){
						//cont cantitat indicare la cantitat de equps que hi han a la matriu 
						cont_cantitat=entrada1;
						entrada1=50;
						
					}
				
				}
				//posarem false el identifiacador de la boolean per no tornarelo a agafar, ja que ja estara posicionat
				comprovar[nom_equip_gran]=false;
				//escriurem al arxiu el nom, gracies a la traduccio de l'arraylist i la seva puntuacio
				bw.write(cadena.get(nom_equip_gran-1)+"#"+mes_puntuacio);
				bw.newLine();
				//cont false seriva per mirar quants false tenim a la boolean
				cont_false=1;
				for (int entrada1=0; entrada1<10;entrada1++){
					if (comprovar[entrada1]==false){
						//sempre que trovem un false punarem el contador
						cont_false++;
					}
				}
				//si la cantita de false i cantiat de equips a la matriu, es major, sortirem del bucle i estara escrit el arxiu
			}while(cont_false<cont_cantitat);
			bw.close();
			fw.close();
		    
		 }catch(IOException e){ 
			   System.out.println("Error E/S: "+e);
		}
		System.out.println("------------------------------------------------------------------");
		try {
			//Un cop escriu, llegirem el arxiu aqui abaix
			FileReader fr = new FileReader(NomFitClassi);
			BufferedReader br = new BufferedReader(fr); 
			do { 
				s = br.readLine();
			   	if (s != null){
				System.out.println(s);
			   	}
			}while(s != null);
			br.close();
			fr.close();
			System.out.println("------------------------------------------------------------------");
		
		 }catch(IOException e){ 
			   System.out.println("Error E/S: "+e);
		}
	}
	public static void MenysGolejat (String NomFitEquips,String NomFitInformes,String NomFitResultats,ArrayList cadena,int [][] golejats,int[][] resultats){
		//aquesta opcio del submenu calculara el equip menys golejat
		String s;
		int posicio1,gols1,posicio2,gols2,Equip=1,gfavor=0,gcontra=0,petit;
		boolean entrada=true;
		//a data guardare la data del dia que s'escriu
		Date data = new Date();
		SimpleDateFormat dt = new SimpleDateFormat ("dd/MM/yyyy");
		if (resultats[1][0]==0){
			//contorlo si el usuari ha entrar primer a resultats per cargar la matriu, sino, el faig anar
			System.out.println("Primer passa per procesar Resultats");
			main(null);
		
		}
		try {
			DataInputStream LeeFichero=new DataInputStream(new FileInputStream(NomFitResultats));
			for (int entrada1=0;entrada1<10;entrada1++){
				//inicialitzo la matriu qeu guardare els resultats dels gols
        		for (int entrada2=0;entrada2<3;entrada2++){
        			 golejats[entrada1][entrada2]=0;
        		}
        	}
			do{
				//llegirem el fitxer de reusultats.bin i el guardarem a les segeunts variables.
		        	posicio1=LeeFichero.readInt();
		        	gols1=LeeFichero.readInt();
		        	posicio2=LeeFichero.readInt();
		        	gols2=LeeFichero.readInt();
		           //un cop guats els resutlats del partit que toca, guardarem auqest reusltats a la matriu
		        	//Posicio 0 guardara el identificador del equip
		        	//Posicio 1 guardara els gols que ha marcat el equip
		        	//Posicio 2 guardara els gols que li han fet
		        	golejats[posicio1][1]=golejats[posicio1][1]+gols1;
		        	golejats[posicio1][2]=golejats[posicio1][2]+gols2;
		        	golejats[posicio2][1]=golejats[posicio2][1]+gols2;
		        	golejats[posicio2][2]=golejats[posicio2][2]+gols1;
		        	golejats[posicio1][0]=posicio1;
		        	golejats[posicio2][0]=posicio2;
		    //Un cop no hi haigui mes per llegir saltarem al catch        
			}while(true);
			
			
		
		 }catch(IOException e){ 
			   try{
				   //inicilitzarem petit amb la cantiat del primer equip per poderla compara.
				   petit=golejats[1][2];
				   FileWriter fw = new FileWriter(NomFitInformes,true);
				   BufferedWriter bw = new BufferedWriter(fw);
				   for (int ent=1;ent<11;ent++){
					   //recorrem la matriu i si hi ha un euqip amb menys gols que li han marcat, guardarem la informacio d'aquest equip. Tambe haurem de mirar que no sigui un equip amb identificador 0 (osigui que no existeix, ja que tambe tindra un 0 a gols que lñi han marcat)
						if (golejats[ent][2]<=petit && golejats[ent][0]!=0){
							petit=golejats[ent][2];
							Equip=golejats[ent][0];
							gfavor=golejats[ent][1];
							gcontra=golejats[ent][2];
						}
						
				   }
				   //Carreguem l'array list entrant a la primera funcio
					  MostrarEquips(cadena, NomFitEquips);
					  //Escriurem dins del fitxer la DATA, MENYSGOLEJATS, EQUIP,GOLS A FAVOR I GOLS EN CONTRA amb la inforamacio que tenim de la matriu gracies al for
					  bw.write(dt.format(data)+"#MenysGolejat#"+cadena.get(Equip-1)+"#"+gfavor+"#"+gcontra);
					  bw.newLine();
				   	  bw.close();
					  fw.close();
			   }catch(IOException f){ 
				   System.out.println("Error E/S: "+f);
			   }
		 }
	}
	public static void ReiEmpats (String NomFitEquips,ArrayList cadena, int [][] resultats,String NomFitInformes,int [][] golejats,String NomFitResultats){
		//ReiEmpats fara casi el mateix que la de abans.
		Date data = new Date();
		int posicio1,gols1,posicio2,gols2,gran,pisicio=0;
		SimpleDateFormat dt = new SimpleDateFormat ("dd/MM/yyyy");
		if (resultats[1][0]==0){
			System.out.println("Primer passa per procesar Resultats");
			main(null);
		
		}
		try{
			   //Com la de abans, cargarem a la matriu gojats els resultats dels gols. No tornarem a explicar el proces.
			   DataInputStream LeeFichero=new DataInputStream(new FileInputStream(NomFitResultats));
				for (int entrada1=0;entrada1<10;entrada1++){
	        		for (int entrada2=0;entrada2<3;entrada2++){
	        			 golejats[entrada1][entrada2]=0;
	        		}
	        	}
				do{
			        	posicio1=LeeFichero.readInt();
			        	gols1=LeeFichero.readInt();
			        	posicio2=LeeFichero.readInt();
			        	gols2=LeeFichero.readInt();
			           
			        	golejats[posicio1][1]=golejats[posicio1][1]+gols1;
			        	golejats[posicio1][2]=golejats[posicio1][2]+gols2;
			        	golejats[posicio2][1]=golejats[posicio2][1]+gols2;
			        	golejats[posicio2][2]=golejats[posicio2][2]+gols1;
			        	golejats[posicio1][0]=posicio1;
			        	golejats[posicio2][0]=posicio2;
			           
				}while(true);
		}catch(IOException e){ 
			try{
				//A gran guardare el resultat del primer quip per poderlo comparar
			gran=resultats[1][3];
			FileWriter fw = new FileWriter(NomFitInformes,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (int ent=1;ent<10;ent++){
				//Amb aquest for miro el euqip amb mes partits empatats. i controlo de que no sigui una linia que no hi haigui cap partit
				if (resultats[ent][3]>=gran && resultats[ent][0]!=0){
					//guardo el identificador del equip i sobreescric la cantitat de gran
					gran=resultats[ent][3];
					pisicio=resultats[ent][0];
					
				}
			}
			//Aqui converteixo posicio en una valdia per l'arraylist, ja que ella va desde el 0 al 10.
			for (int ent=1;ent<10;ent++){
				if (golejats[ent][0]==pisicio){
					pisicio=ent-1;
					ent=10;
					
				}
			}
			if (pisicio==0){
				pisicio++;
			}
			//Carrego l'arrayList i escriic seguint CASI el mateix format que l'anterior
			MostrarEquips(cadena, NomFitEquips);
			bw.write(dt.format(data)+"#ReyEmpats#"+cadena.get(golejats[pisicio][0])+"#"+golejats[pisicio][2]+"#"+golejats[pisicio][1]);
			bw.newLine();
		   	bw.close();
			fw.close();
			
			
			}catch(IOException f){
			System.out.println("Error E/S: "+f);
			}
		}
		
	}
	public static void Consultes (String NomFitInformes){
		//per acabar, tenim l'aparatat de consultes, on marcarem una data i ens dira disn del fitxer informes el resutlat
		Scanner sc = new Scanner(System.in);
		String data;
		int dia,mes,any;
		Date date = new Date();
		String s = "a";
		//Aquestes dos array seriran per fer un SPLIT
		String [] fraccio = new String [3];
		String [] fraccio2 = new String [5];
		try{
			//primer llegeixo la data que vol el usuari
			System.out.println("Indica la data seguint el segeunt format [dd/mm/yyyy]:");
			data=sc.nextLine();
			fraccio = data.split("/");
			//Faig un SPLI que guardara en la posivio 0 el dia, 1 el mes i 2 el any.
			//Ara passarem de String a Int, ja que haurem de fer comprovacions matematiques 
			any=Integer.parseInt(fraccio[2]);
			mes=Integer.parseInt(fraccio[1]);
			dia=Integer.parseInt(fraccio[0]);
			//Si es febrer i has fiat un dia mes gran de 28 entraras aqui
			if (mes==2&&dia>28){
				System.out.println("Febrer te fins a 28 dies");
				Consultes(NomFitInformes);
			}
			//Si has ficat un mes de 31 dies entraras aqui
			if (dia>31){
				System.out.println("No hi han mesos de mes de 31 dies");
				Consultes(NomFitInformes);
			}
			//Si has ficat un mes parell amb mes de 30 dies entraras aqui
			if ((mes==4 && dia>30) || (mes==6 && dia>30) || (mes==4 && dia>30) || (mes==9 && dia>30) || (mes==11 && dia>30)){
				System.out.println("Aquest mes no te 31 dies");
				Consultes(NomFitInformes);
			}
			//si has ficat un mes que no existeix entraars aqui
			if (mes>12){
				System.out.println("No existeix aquest mes");
				Consultes(NomFitInformes);
			}
			//un cop comprovat, mostrarem
			try{
				FileReader fr = new FileReader(NomFitInformes);
				BufferedReader br = new BufferedReader(fr); 
				System.out.println("-------------------------------------------------------------");
				do { 
					s = br.readLine();
					if (s != null){
						//faig un Split de la linia que llegeixo per podem mirar la data. En aquesta array es guardara a la posicio 0 la data per poderla comparar.
						fraccio2=s.split("#");
						if (fraccio2[0].equals(data)){
							//En cas de trovar similitut amb la data que hem ficat i la posicio 0 del split, es mostrara la linia
							System.out.println(s);
				   		}
				   }
				
			   } while(s != null);
			
				System.out.println("-------------------------------------------------------------");
			
		}catch(IOException f){
			System.out.println("Error E/S: "+f);
		}
	
	}catch(ArrayIndexOutOfBoundsException e){
		System.out.println("Segueix el format");
	}
	}
	//Aqui acava.
}
