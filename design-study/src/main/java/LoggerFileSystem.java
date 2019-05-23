
public class LoggerFileSystem implements Logger{

    public void log(String message) {
        System.out.println("日志输出到本地文件系统："+message);
    }
}
