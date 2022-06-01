package cryptography.random.randomInt;

import java.util.Random;

public class RandomInt {

	public static int getBetween(int min, int max) {
		return new Random().nextInt(max - min + 1) + min;
	}

}
