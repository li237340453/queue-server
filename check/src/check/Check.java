package check;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Check {
    public static void main(String[] args) {

        Thread survaliance_1=new Thread(){
            @Override
            public void run() {
                try(ServerSocket server=new ServerSocket(30004)){
                    System.out.println("survaliance1 is running");
                    while (true){
                        try{
                            Socket connection =server.accept();
                            Thread task=new thread_first(connection);
                            task.start();
                        }catch (IOException ex){}
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("couldn't start server1");
                }
            }
        };
        survaliance_1.start();
    }
    private static class thread_first extends Thread{


        private Socket socket;
        thread_first(Socket connection){
            this.socket=connection;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream=socket.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                String line=bufferedReader.readLine();
                System.out.println(line);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

