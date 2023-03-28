package codewarsTraining;

public class SpeedLimit {

    public static int speedLimit(final int speed, final int[] signals) {
        
 	int fine = 0;
 	
 	for(int i = 0; i < signals.length; i++) {
 		if (speed > signals[i]) {
 			if (speed >= (signals[i] + 10) && speed >= (signals[i] + 19)) {
 				fine += 100;
 			} else if (speed >= (signals[i] + 20) && speed >= (signals[i] + 29)) {
 				fine += 250;
 			} else if (speed >= (signals[i] + 30)) {
 				fine += 500;
 			}
 	    	
 	    	System.out.println("Multa: " + fine);
         i = 0;
 		}
     System.out.println("Numero de limites: " + i);
 	}
 	System.out.println("Longitud: " + signals.length);
 	return fine;
 }

}
