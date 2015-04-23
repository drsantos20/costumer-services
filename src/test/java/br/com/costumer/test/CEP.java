package br.com.costumer.test;

public class CEP {

	public static void main(String[] args) {
		String cep = "33333333333";
		int subs = cep.length();;
		for (int i = 0; i < cep.length(); i++) {
			cep = changeCharInPosition(subs-1, '0', cep);
			System.out.println(cep);
			subs=subs-1;
		}
	}
	
	public static String changeCharInPosition(int position, char ch, String str){
	    char[] charArray = str.toCharArray();
	    charArray[position] = ch;
	    return new String(charArray);
	}
}
