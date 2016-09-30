
public class Fraction {
	//fields (has-as)
	private int num;
	private int den;
	
	//constructor
	public Fraction(int num, int den) {
		this.num = num;
		this.den = den;
	}
	
	//behaviors
	//add
	public Fraction addFraction(int n, int d) {
		int newNum = (this.num * d) + (this.den * n);
		int newDen = (this.den * d);
		Fraction result = simplify(newNum, newDen);
		return result;
	}
	
	//multiply
	public Fraction multFraction(int n, int d) {
		int newNum = (this.num * n);
		int newDen = (this.den * d);
		Fraction result = simplify(newNum, newDen);
		return result;
	}
	
	//reciprocal
	public Fraction reciprocal(int n, int d) {
		Fraction result = new Fraction(d,n);
		return result;
	}
	
	//simplify
	public Fraction simplify(int n, int d) {
		int nomSimp = n / (gcd(n, d));
		int denSimp = d / (gcd(n, d));
		Fraction result = new Fraction(nomSimp, denSimp);
		return result;			
	}
	
	//Greatest Common Denominator		
	public int gcd(int n, int d) {
		while(n != d) {
			if( n > d)
				n -= d;
			else
				d -= n;
		}
		return n;
	}
	
	//toString
	public String toString() {
		return (num + "/" + den);
	}

	

	public static void main(String[] args) {
		Fraction test1 = new Fraction(12,36);
		System.out.println("Test 1: " + test1);
		System.out.println("Add: " + test1.addFraction(1,4));
		System.out.println("Simplify: " + test1.simplify(test1.num, test1.den));
		System.out.println("Multiply: " + test1.multFraction(1,4));
		System.out.println("Reciprocal: " + test1.reciprocal(test1.num, test1.den));
		System.out.println();
		Fraction test2 = new Fraction(33,35);
		System.out.println("Test 2: " + test2);
		System.out.println("Add: " + test2.addFraction(1,5));
		System.out.println("Simplify: " + test2.simplify(test2.num, test2.den));
		System.out.println("Multiply: " + test2.multFraction(1,5));
		System.out.println("Reciprocal: " + test2.reciprocal(test2.num, test2.den));

	}

}
