package cryptography.ciphers.ellipticCurve;

import java.math.BigDecimal;

public class EllipticCurve {
	final public BigDecimal BIT_MAX_VALUE_128 = new BigDecimal("128");
	final public BigDecimal BIT_MAX_VALUE_256 = new BigDecimal("256");
	
	public BigDecimal P;		//bigger than all # points on Curve
	public BigDecimal A;
	public BigDecimal B;
	public BigDecimal b;
	
	public EllipticCurve(){
		this.A = new BigDecimal("-1");
		this.B = new BigDecimal("188");
		this.P = new BigDecimal("751");
		this.b = BIT_MAX_VALUE_128 ;
	}
	
	public EllipticCurve(BigDecimal A, BigDecimal B, BigDecimal P, int b){
		this.A = A;
		this.B = B;
		this.P = P;
		this.b = (b == 256)? BIT_MAX_VALUE_256 : BIT_MAX_VALUE_128 ;
	}
	
	String getEqn() {
		return "y^2 mod "+this.P+" = x^3 + ("+this.A+")x + ("+this.B+") ) mod "+this.P;
	}
}
