package webapp.demof_schedule;

import org.noear.solon.annotation.XBean;

@XBean("job:Task3Run")
public class Task3Run implements Runnable {
    @Override
    public void run() {
        System.out.println("我是定时任务: Task3Run(for props)");
    }
}
