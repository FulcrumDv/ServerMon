package servermon.Metrics;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;


@Component 
public class CPU {
    private final OperatingSystemMXBean osBean;

    public CPU(){
        this.osBean = ManagementFactory.newPlatformMXBeanProxy(
            mbsc, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, OperatingSystemMXBean.class);


    }
    public void printProcessorUsuage(){

    }
    
}
