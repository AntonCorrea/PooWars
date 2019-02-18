
public class Wookie extends SerVivo{
	
	private int escudo;
	
	public Wookie() {
		String nm = "W";
		double hp = this.rng(100, 300); 
		double mp = this.rng(0, 40);
		double wt = this.rng(80, 200);
		int dmg = (int)(hp*0.25 + mp*0.25 + wt*0.5);	
		int position[]=new int[2];
		position[0]=(int)this.rng(2, SerVivo.campoX/2);
		position[1]=(int)this.rng(2, SerVivo.campoY-2);
		
		this.nacer(nm, hp, mp, wt, dmg, position);
		
		this.setEscudo((int)this.rng(-40, 40));
		
		if(this.getEscudo()<0) this.setEscudo(0);
	}
	

	
	public int getEscudo() {
		return escudo;
	}

	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}
	
	public void recibeDaño(double dmg) {
		this.setSalud(this.getSalud()+this.getEscudo()-dmg);
		this.setEscudo((int)(this.getEscudo()-dmg));
	}
}
