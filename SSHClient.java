import com.jcraft.jsch.*;

public class SSHClient {
    public static void main(String[] args) {
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession("user", "host", 22);
            session.setPassword("password");
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            
            Channel channel = session.openChannel("shell");
            channel.setInputStream(System.in);
            channel.setOutputStream(System.out);
            channel.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
