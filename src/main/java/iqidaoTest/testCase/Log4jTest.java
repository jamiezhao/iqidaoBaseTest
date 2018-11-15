package iqidaoTest.testCase;
import org.apache.log4j.Logger;  

public class Log4jTest  
{  
  
    public static Logger log = Logger.getLogger(Log4jTest.class);  
  
    /** 
     * @创建时间： 2016年2月22日 
     * @相关参数： 
     * @功能描述： 定义一个输出日志的方法 
     * <p> 
     * trace→debug→info→warn→error→fatal→off 
     * 级别依次升高，级别高的level会屏蔽级别低的level。 
     * </p> 
     */  
    public static void logTest()  
    {  
        log.trace("trace级别的日志输出");  
        log.info("info级别的日志输出");  
        log.debug("debug级别的日志输出");  
        log.warn("warn级别的日志输出");  
        log.error("error级别的日志输出");  
        log.fatal("fatal级别的日志输出");  
        try  
        {  
            System.out.println(9 / 0);  
        }  
        catch (RuntimeException e)  
        {  
            log.error(e.getMessage());  
        }  
    }  
  
    public static void main(String[] args)  
    {  
        logTest();  
    }  
  
}  