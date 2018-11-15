package iqidaoTest.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class OverrideIReTry implements IRetryAnalyzer {  
	   private int retryCount         = 0;
	    private int maxRetryCount     = 0;   // retry a failed test 2 additional times

	    public boolean retry(ITestResult result) {
	        if (retryCount <maxRetryCount) {
	            retryCount++;
	            return true;
	        }
	        return false;
	    }
	}