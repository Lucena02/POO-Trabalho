public class SmartCamera extends SmartDevice{
	
	private int resx;
        private int resy;
	private int size;

	public SmartCamera(){
		super();
		this.resx = 0;
		this.resy = 0;
		this.size = 0;	
	}

	public SmartCamera(Modo modo, String codigo, double consumoDiario, double custoInstalacao, int resx, int resy, int size) {
		super(modo, codigo, consumoDiario, custoInstalacao);
		this.resx = resx;
		this.resy = resy;
		this.size = size;
	}

	public SmartCamera(SmartCamera cm){
		super(cm);
		this.resx = cm.getresx();
		this.resy = cm.getresy();
		this.size = cm.getsize();
	}

	public int getresx(){
		return resx;
	}

	public void setresx(int resx){
		this.resx = resx;
	}

	public int getresy(){
		return resy;
	}

	public void setresy(int resy){
		this.resy = resy;
	}

	public int getsize(){
		return size;
	}

	public void setsize(int size){
		this.size = size;
	}


	@Override
	public boolean equals (Object o){
		if (this == o) return true;
		if (o == NULL || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		SmartCamera that = (SmartCamera) o;
		return (this.resx == that.getresx() && 
			this.resy == that.getresy() && 
			this.size == that.getsize())
	}	

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString())
			.append("Res x: ").append(this.resx)
			.append("Res y: ").append(this.resy) 
			.append("Size: ").append(this.size);
		return sb.toString();
	}

	@Override
	public SmartCamera clone(){
		return new SmartCamera(this);
	}





    	public double calculoCusto(){



        	return 0;
    	}
}
