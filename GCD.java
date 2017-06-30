
/* 求最大公约数 */
class GCD {
	//计算
	public static int gcd(int p, int q) {
		if (q == 0)
			return p;
		int r = p % q;
		return gcd(q, r);
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(5, 2));
	}
}