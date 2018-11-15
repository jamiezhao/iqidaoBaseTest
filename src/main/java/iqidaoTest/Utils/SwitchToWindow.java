package iqidaoTest.Utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SwitchToWindow {

	public static boolean changeWindow(WebDriver driver, String windowTitle){  
        boolean flag = false;  
        try { 
            //将页面上所有的windowshandle放在入set集合当中
            String currentHandle = driver.getWindowHandle();  
            Set<String> handles = driver.getWindowHandles();  
            for (String h : handles) {  
                if (h.equals(currentHandle))  
                    continue;  
                else {  
                	driver.switchTo().window(h);
                    //和当前的窗口进行比较如果相同就切换到windowhandle
                    //判断title是否和handles当前的窗口相同
                    if (driver.getTitle().contains(windowTitle)) {  
                        flag = true;  
//                        System.out.println("Switch to window: " + windowTitle + " successfully!");  
                        break;  
                    } else  
                        continue;  
                }  
            }  
        } catch (Exception e) {  
//            System.out.printf("Window: " + windowTitle + " cound not found!", e.fillInStackTrace());  
            flag = false;  
        }  
        return flag;  
    }
}
