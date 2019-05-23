
public class LoggerCloud implements Logger {
    public void log(String message) {
        System.out.println("日志输出到云平台："+message);
    }
}
