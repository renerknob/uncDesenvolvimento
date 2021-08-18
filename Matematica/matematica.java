public class matematica implements InterfaceMatematica {
	
	public float soma(float n1, float n2){
		
		float res = n1 + n2;
		return res;
	}
	public float sub(float n1, float n2){
		
		float sub = n1 - n2;
		return sub;
	}
	public float mult(float n1, float n2){
		
		float mult = n1 * n2;
		return mult;
	}
	public float div(float n1, float n2){
		
		float div = n1 / n2;
		return div;
	}
	public double raiz (double num){
		double res =(Math.sqrt(num));
		return res;
	}
	@Override
	public float somar(float n1, float n2) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double raiz(float numero) {
		// TODO Auto-generated method stub
		return 0;
	}

}