package exercise10_11_REST.SolutionProf.REST_Server.numbergame;

import java.util.Random;

public class Numbergame {
	private int score;
	private Random random;
	private int number;
	private boolean numberGuessed;

	public Numbergame() {
		random = new Random(new java.util.Date().getTime());
		number = 100 + 2 * random.nextInt(50) + 1;
		score = 0;
		numberGuessed = false;
	}

	public Gamestate getGamestate() {
		Gamestate gamestate = new Gamestate(Integer.toString(score), Integer.toString(number));
		return gamestate;
	}
	
	public Gamestate newGame() {
		score = 0;
		number = 100 + 2 * random.nextInt(50) + 1;
		numberGuessed = false;
		return getGamestate();
	}

	public void newNumber() {
		if (numberGuessed) {
			number = 100 + 2 * random.nextInt(50) + 1;
			numberGuessed = false;
		}
	}
	
	public String isPrime(String num) {
		String message;
		try { 
			int num1 = Integer.parseInt(num);
			numberGuessed = true;
			if (num1 == number && isPrimeNumber(number)) {
				score += number;
				message = "Right! " + num + " is a prime number";
			} else {
				message = "Wrong! " + num + " is not a prime number";
			}
		} catch (Exception ex) {
			message = "Invalid number " + num + " in request";
		}
		newNumber();
		return message;
	}
	
	public String isNotPrime(String num) {
		String message;
		try { 
			int num1 = Integer.parseInt(num);
			numberGuessed = true;
			if (num1 == number && !isPrimeNumber(number)) {
				score += number;
				message = "Right! " + num + " is not a prime number";
			} else {
				message = "Wrong! " + num + " is a prime number";
			}
		} catch (Exception ex) {
			message = "Invalid number " + num + " in request";
		}
		newNumber();
		return message;
	}
	
    private boolean isPrimeNumber(int i) {
        int k = 2;
        while (k * k <= i) {
            if (i % k == 0) {
                return false;
            }
            k = k + 1;
        }
        return true;
    }
}
