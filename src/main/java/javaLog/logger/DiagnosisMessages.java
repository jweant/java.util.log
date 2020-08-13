package javaLog.logger;

public class DiagnosisMessages {
	
	private DiagnosisMessages() {}
	
    public static String systemHealthStatus() {
    	int oneValue = 1;
      // collect system health information
    	return String.format("System health status with value %d", oneValue);
    }
    
    public static String systemHealthStatus2() {
    	int oneValue = 2;
      // collect system health information
    	return String.format("System health status with value %d", oneValue);
    }
    
    public static String systemHealthStatus3() {
    	int oneValue = 3;
      // collect system health information
    	return String.format("System health status with value %d", oneValue);
    }
    
    public static String systemHealthStatus4() {
    	int oneValue = 4;
      // collect system health information
    	return String.format("System health status with value %d", oneValue);
    }
  }