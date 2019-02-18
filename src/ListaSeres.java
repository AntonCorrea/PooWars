
import java.util.ArrayList;

	

public class ListaSeres {
	
	private ArrayList<SerVivo> Lista;
	
	public static int victoria;
	
	public ListaSeres() {
		this.Lista = new ArrayList<SerVivo>();
	}
	
	public SerVivo get(int n) {
		return Lista.get(n);
	}
	
	public void add(SerVivo obj) {
		this.Lista.add(obj);
	}
	
	public void printAllData() {

		for(int i=0;i<SerVivo.id;i++) {
			System.out.println(this.Lista.get(i).printdata());
		}
	}	

	public void printfield() {
		
		System.out.print("#");
		for(int x=0;x<SerVivo.campoX+1;x++) {
			System.out.print("  "+x);		
		}System.out.println();
		
		String s="";
	
		for(int y=0;y<SerVivo.campoY+2;y++){ 
			System.out.print(y);
			if(y<10) System.out.print(" ");
			for(int x=0;x<SerVivo.campoX+1;x++){
				if(x>10) System.out.print("░");
				boolean b=false;
				int i=0;
				while(i<SerVivo.id && b==false) {
					if(this.Lista.get(i).getPos()[0]==x && this.Lista.get(i).getPos()[1]==y) {
						s="░"+this.Lista.get(i).getNombre();
						b=true;
					}else s="░░░";
				i++;
				}System.out.print(s);
			}System.out.print("\n");
		}
	}

	public int checkAttack(SerVivo attacker) {
		int b=-1;
		for(int i=0;i<SerVivo.id;i++) {
			if(attacker.getClass() != this.Lista.get(i).getClass() && this.Lista.get(i).isVivo()) {
				if( Math.sqrt( Math.pow((attacker.getPos()[0]-this.Lista.get(i).getPos()[0]),2)+Math.pow((attacker.getPos()[1]-this.Lista.get(i).getPos()[1]),2)) <2) {
					b=i;
				}else {
					b=-1;
					}
				}
			}
		return b;
		
	}

	public void updateAll() {
		int nw=0;
		int ns=0;
		int rendirse;
		for(int i=0;i<SerVivo.id;i++) {
			if(this.get(i).isVivo()) {					
				if(this.checkAttack(this.get(i))!=-1 )
					this.get(i).hacerdaño(this.get(this.checkAttack(this.get(i))));
					if(this.get(i).getSalud()<0) {
						System.out.println("\t"+this.get(i).getNombre()+" ah caido!!!");
						this.get(i).setVivo(false);
						this.get(i).setNombre("><");
					}
				else 
					this.get(i).step();
	
				if(this.get(i) instanceof Wookie) nw++;
				if(this.get(i) instanceof Sith) ns++;
				

			}
		}
		if(nw<=SerVivo.id/10) {
			
			rendirse=(int)((Math.random()*(-100-400+1)+400 ));
			
			if (rendirse<0) {
				System.out.println("Los Wookies se han rendido!!");
				ListaSeres.victoria=-1;
			}
			if (nw==0) {
				System.out.println("Todos los Wookies han muerto!!");
				ListaSeres.victoria=-1;
			}
		}
		if(ns<=SerVivo.id/10) {
			
			rendirse=(int)((Math.random()*(-100-400+1)+400 ));
			
			if (rendirse<0) {
				System.out.println("Los Siths se han rendido");
				ListaSeres.victoria=1;
			}
			if (nw==0) {
				System.out.println("Todos los Siths han muerto!!");
				ListaSeres.victoria=1;
			}	
			
		}
	}
	
}
