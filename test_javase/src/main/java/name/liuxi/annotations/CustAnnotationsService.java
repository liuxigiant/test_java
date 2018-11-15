package name.liuxi.annotations;

public class CustAnnotationsService {

    @Schedule(scheduleName = "sc1", cron = "0 0/30 * * * ?")
    public void handler(){
        System.out.println("do something ...");
    }

    @Schedule(scheduleName = "sc21", cron = "0 0 23 * * ?", desc = "每天23点执行一次")
    @Schedule(scheduleName = "sc22", cron = "0 0 1 * * ?", desc = "每天凌晨1点执行一次")
    public void handler2(){
        System.out.println("do something ...");
    }
}
