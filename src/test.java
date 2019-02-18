/*Instrucciones:
 * _Ingrese el valor que definira la longitud del campo de batalla,
 * la altura del campo se dara por X/2.
 * 
 * _Ingrese cantidad de Wookies y de Siths.
 * 
 * _Se renderizara los datos de los participantes y el campo de batalla.
 * 
 * _Ingrese cualquier valor en la consola para avanzar por turno.
 * 
 * _Puede escribir "salir" para terminar la simulacion prematuramente.
 * 
 * Referencias:
 * Wx	-> Un Wookie
 * Sx	-> Un Sith
 * ><	-> Un cadaver
 * HP	-> Salud
 * DMG	-> Daño
 * MP	-> Milicronianos
 * WT	-> Peso
 * POs	-> Posicion dentro del campo de batalla
*/


import java.util.Scanner;
public class test {
	
	private static Scanner reader;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListaSeres e=new ListaSeres();
		reader = new Scanner(System.in);
		
		System.out.print("Ingrese el tamaño del campo de batalla: ");
		SerVivo.campoX=reader.nextInt();
		SerVivo.campoY=SerVivo.campoX/2;
		
		System.out.print("Ingrese la cantidad de Wookies: ");
		int n=reader.nextInt();
		
		for(int i=0;i<n;i++) {
			e.add(new Wookie());
		}
		
		System.out.print("Ingrese la cantidad de Siths: ");
		n=reader.nextInt();
		
		for(int i=0;i<n;i++) {
			e.add(new Sith());
		}
		
		

		//e.printAll();
		int k=0;
		String s="";
		while(k<1000 && !s.equals("salir") && (ListaSeres.victoria==0)) {
			k++;
			System.out.println("||||||||||||||||||||||||||||||||||||");
			System.out.println("Turno:"+k);
			System.out.println("||||||||||||||||||||||||||||||||||||");
			e.printAllData();
			System.out.println("------------------BATALLA------------------");
			e.printfield();
			System.out.println("-------------------------------------------");

			s=reader.next();
			
			System.out.println("------------------INFORME------------------");
			
			e.updateAll();
			
			System.out.println("-------------------------------------------");
			
		}
		
	}

}
