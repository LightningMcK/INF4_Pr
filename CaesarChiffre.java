import java.util.Scanner;

public class CaesarChiffre {
	static String encode(int k, String s) {

		int len = s.length();
		int stelle;

		char[] TempCharArray = new char[len];

		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == ' ') {
				TempCharArray[i] = s.charAt(i);
			} else {
				stelle = (s.charAt(i) - 'a' + k);
				if (stelle > 26) {
					stelle = stelle % 26;
				}
				TempCharArray[i] = (char) (stelle + 'a');
			}
		}

		String EncodedString = new String(TempCharArray);

		return EncodedString;
	}

	static String decode(int k, String s) {
		int len = s.length();
		int stelle;

		char[] TempCharArray = new char[len];

		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == ' ') {
				TempCharArray[i] = s.charAt(i);
			} else {
				stelle = (s.charAt(i) - 'a' - k);
				if (stelle < 0) {
					stelle = stelle % 26 + 26;
				}
				TempCharArray[i] = (char) (stelle + 'a');
			}
		}

		String DecodedString = new String(TempCharArray);

		return DecodedString;
	}

	static int eingabe(String args[]) {

		System.out.println("Caesar-Chiffre\n==============");
		int auswahl = 0, k = 0;
		String decodeString = "", encodeString = "";

		System.out.println("Was moechten Sie tun?\n (1) Verschluesseln (2) Entschluesseln (3) Beenden\n");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ihre Auswahl: ");
		auswahl = scanner.nextInt();
	
		if (auswahl == 1) {

			Scanner EncodeScanner = new Scanner(System.in);
			System.out.println("Geben Sie den Wert von k an: ");
			k = EncodeScanner.nextInt();
			EncodeScanner.nextLine(); // This is needed to pick up the new line
			System.out.println("Geben Sie ein, was Sie verschluesseln moechten: ");
			encodeString = EncodeScanner.nextLine();
		
			System.out.println("Hier ist Ihre verschluesselte Nachricht: " + encode(k, encodeString.toLowerCase()));
			EncodeScanner.close();
			scanner.close();
			
			return 1;

		} else if (auswahl == 2) {

			Scanner DecodeScanner = new Scanner(System.in);
			System.out.println("Geben Sie den Wert von k an: ");
			k = DecodeScanner.nextInt();
			DecodeScanner.nextLine(); // This is needed to pick up the new line
			System.out.println("Geben Sie ein, was Sie entschluesseln moechten: ");
			decodeString = DecodeScanner.nextLine();
	
			System.out.println("Hier ist Ihre entschluesselte Nachricht: " + decode(k, decodeString.toLowerCase()));
			DecodeScanner.close();
			scanner.close();
			
			return 2;

		} else if (auswahl == 3) {
			
			scanner.close();
			return 3;
			
		} else {
			
			scanner.close();
			return 0;
		}

	}

	public static void main(String[] args) {
		
		eingabe(null);

	}
}