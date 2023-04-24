package codewarsTraining;

public class BinaryToText {
	public static String binaryToText(String binary) {
	
		if(binary.isEmpty()) {
		  return "";
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < binary.length(); i++) {
		  String binaryByte = binary.substring(i, i + 8);
		  int asciiCode = Integer.parseInt(binaryByte, 2);
		  
		  sb.append((char) asciiCode);
		}
		
		return sb.toString();
	}
}
