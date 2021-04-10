package javaalgos;

public class PrimitiveTypes {
	
	public static boolean isOddParity(int s) {
		boolean check = false;
		while(s != 0) {
			check ^= true;
			s &= (s-1);
		}
		return check;
	}
	
	public static int swapBits(int s, int i, int j) {
		if(((s >>> i) & 1) != ((s >>> j) & 1)) {
			int bitmask = 1 << i | 1 <<j;
			return s^bitmask;
		}else {
			return s;
		}
	}
}