

public class SupermanSync {
	
	private static volatile SupermanSync superman;
	
    public static SupermanSync getInstance() {
    	SupermanSync localInstance = superman;
    	if (localInstance == null) {
    		synchronized (SupermanSync.class) {
    			localInstance = superman;
    			if (localInstance == null) {
    				superman = localInstance = new SupermanSync();
    			}
    		}
    	}
    	return localInstance;
    }
}
