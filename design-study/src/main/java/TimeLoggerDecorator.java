import java.util.Calendar;

public class TimeLoggerDecorator implements Logger {
    private Logger decoratorLogger;

    public TimeLoggerDecorator(Logger decoratorLogger){
        this.decoratorLogger = decoratorLogger;
    }
    public void logTime(){
        System.out.println(Calendar.getInstance().getTime());
    }
    public void log(String message) {
        decoratorLogger.log(message);
        logTime();
    }
}
