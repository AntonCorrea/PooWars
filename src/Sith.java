
public class Sith extends SerVivo{
	
	public Sith() {
		String nm = "S";
		double hp = this.rng(100, 250); 
		double mp = this.rng(80, 250);
		double wt = this.rng(40, 80);
		int dmg = (int)(hp*0.25 + mp*0.5 + wt*0.25);
		int position[]=new int[2];
		position[0]=(int)this.rng(SerVivo.campoX/2, SerVivo.campoX-1);
		position[1]=(int)this.rng(2, SerVivo.campoY-2);
		
		this.nacer(nm, hp, mp, wt, dmg, position);
	}
	

}
