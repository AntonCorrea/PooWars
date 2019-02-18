import java.text.DecimalFormat;

public class SerVivo {
	
	public static int campoX;
	public static int campoY;
	
	private String nombre;
	public static int id=0;
	private int[] pos=new int[2]; 
	private double salud;
	private double peso;
	private double mlcrn;
	private boolean vivo;
	private int daño;
	private int dir=1;
	
	
	
	public SerVivo() {
	}
	
	public void nacer(String nm,double hp,double mp,double wt,int dmg, int[] pos) {

		this.setNombre(nm+SerVivo.id);
		SerVivo.id++;
		this.setSalud(hp);
		this.setPeso(wt);
		this.setMlcrn(mp);
		this.setDaño(dmg);		
		this.pos=pos;
		this.setVivo(true);
	}
	
	public void recibeDaño(double dmg) {
		this.setSalud(this.getSalud()-dmg);
	}
	
	public void hacerdaño(SerVivo target) {
		target.recibeDaño(this.getDaño());
		System.out.println(this.getNombre()+" ataco a "+target.getNombre());
	}
		
	public double rng(int a,int b) {
		return(Math.random()*(b-a+1)+a );
	}
	
	public String printdata() {
		DecimalFormat df = new DecimalFormat("####000.0");
		DecimalFormat pf = new DecimalFormat("####00");
		return 
		"_"+this.nombre
		+" | HP: "+(df.format(this.getSalud()))
		+" | DMG: "+(df.format(this.getDaño()))
		+" | WT: "+(df.format(this.getPeso()))
		+" | MP: "+(df.format(this.getMlcrn()))
		+" | POS: ("+pf.format(this.getPos()[0])+","+pf.format(this.getPos()[1])+")"
		;
	}
	
	public void step() {
		int[] pos=new int[2];
		
		if(this.pos[0]>SerVivo.campoX-1 || this.pos[0]<1)
			this.setDir(-(this.getDir()));
				
		if(this instanceof Wookie)
			pos[0]=this.getPos()[0]+this.getDir();
		
		if(this instanceof Sith)
			pos[0]=this.getPos()[0]-this.getDir();
		
		
		int stepY=(int)(this.rng(-1000, 1000));
		if (stepY>0)
			pos[1]=this.getPos()[1]+1;
		else
			pos[1]=this.getPos()[1]-1;
		
		if(this.pos[1]>SerVivo.campoY-1)  
			pos[1]=this.getPos()[1]-1;
		if(this.pos[1]<1)
			pos[1]=this.getPos()[1]+1;
		
		this.setPos(pos);
	}
	
	//gtrs & strs
	public double getSalud() {
		return salud;
	}

	public void setSalud(double salud) {
		this.salud = salud;
	}

	public double getMlcrn() {
		return mlcrn;
	}

	public void setMlcrn(double mlcrn) {
		this.mlcrn = mlcrn;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		SerVivo.id = id;
	}
	
	public int[] getPos() {
		return pos;
	}

	public void setPos(int[] pos) {
		this.pos = pos;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}
}
