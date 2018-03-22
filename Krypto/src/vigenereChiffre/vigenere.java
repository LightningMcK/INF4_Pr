package vigenereChiffre;

import java.util.Scanner;

public class vigenere {

	static String encode(String key, String s) {

		int lenKey = key.length();
		int len = s.length();
		int stelle, j = 0;

		char[] TempCharArray = new char[len];

		if (lenKey != len) {

			do {

				key = key.concat(String.valueOf(key.charAt(j)));
				if (j > lenKey) { j = 0; } else { j++; }
				lenKey = key.length();

			} while (lenKey != len);

		}

		for (int i = 0; i < len; i++) {

			if (s.charAt(i) == ' ') {
				TempCharArray[i] = s.charAt(i);
			} else {
				stelle = (s.charAt(i) - 'a') + (key.charAt(i) - 'a');

				if (stelle >= 26) {
					stelle = stelle % 26;
				}
				TempCharArray[i] = (char) (stelle + 'a');
			}

		}

		String EncodedString = new String(TempCharArray);

		return EncodedString;
	}

	static int eingabe(String args[]) {

		String keyWord = "";
		String encodeString;

		System.out.println("Was ist ihr Schluesselwort?");
		Scanner scanner = new Scanner(System.in);
		keyWord = scanner.nextLine();

		System.out.println("Was ist ihr Klartext?");
		encodeString = scanner.nextLine();

		System.out.println("Ihr verschluesselter Text: " + encode(keyWord.toLowerCase(), encodeString.toLowerCase()));

		scanner.close();
		return 0;

	}

	public static void main(String[] args) {

		eingabe(null);

	}

}