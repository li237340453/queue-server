import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
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
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Server {
    /**
     public static class queue{
     String resturant_name;
     public volatile LinkedList<String>  queue_list;
     public volatile int ack=0;
     public volatile String ask="0";
     public queue(String name){
     queue_list=new LinkedList<>();
     resturant_name=name;
     }
     }
     **/
    public final static int PORT_first=688;
    public final static int PORT_second=689;
    public final static int PORT_third=700;
    public final static int PORT_forth=701;
    public final static int PORT_fifth=702;
    public final static int PORT_sixth=703;
    public final static int PORT_seventh=704;
    public final static int PORT_eighth=705;
    public final static int PORT_ninth=706;
    public final static int PORT_tenth=707;
    public final static int kengding=1;
    public final static int fouding=0;
    //static volatile LinkedList<String> query=new LinkedList<>();
    static volatile LinkedList<queue> query=new LinkedList<>();
    //public static volatile String ask="0";
    //public static volatile int ack=0;
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final static String USER = "kun";
    final static String PASS = "";
    static String line=null;
    public static void main(String[] args){
        Thread survaliance_1=new Thread(){
            @Override
            public void run() {
                try(ServerSocket server=new ServerSocket(PORT_first)){
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
        Thread survaliance_2=new Thread(){
            @Override
            public void run() {
                try(ServerSocket server=new ServerSocket(PORT_second)){
                    System.out.println("survaliance2 is running");
                    while (true){
                        try{
                            Socket connection =server.accept();
                            Thread task=new thread_second(connection);
                            task.start();
                        }catch (IOException ex){}
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("couldn't start server2");
                }
            }
        };
        Thread survaliance_3=new Thread(){
            @Override
            public void run() {
                try(ServerSocket server=new ServerSocket(PORT_third)){
                    System.out.println("survaliance3 is running");
                    while (true){
                        try{
                            Socket connection =server.accept();
                            Thread task=new thread_third(connection);
                            task.start();
                        }catch (IOException ex){}
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("couldn't start server3");
                }
            }
        };
        Thread survaliance_4=new Thread(){
            @Override
            public void run() {
                try(ServerSocket server=new ServerSocket(PORT_forth)){
                    System.out.println("survaliance4 is running");
                    while (true){
                        try {
                            Socket connection =server.accept();
                            Thread task=new thread_forth(connection);
                            task.start();
                        }catch (IOException ex){}
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread survaliance_5=new Thread(){
            @Override
            public void run() {
                try(ServerSocket server=new ServerSocket(PORT_fifth)){
                    System.out.println("survaliance5 is running");
                    while (true){
                        try {
                            Socket connection =server.accept();
                            Thread task=new thread_fifth(connection);
                            task.start();
                        }catch (IOException ex){}
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread survaliance_6=new Thread(){
            @Override
            public void run() {
                try(ServerSocket server=new ServerSocket(PORT_sixth)){
                    System.out.println("survaliance6 is running");
                    while (true){
                        try {
                            Socket connection =server.accept();
                            Thread task=new thread_sixth(connection);
                            task.start();
                        }catch (IOException ex){}
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread survaliance_7=new Thread(){
            @Override
            public void run() {
                try(ServerSocket server=new ServerSocket(PORT_seventh)){
                    System.out.println("survaliance7 is running");
                    while (true){
                        try {
                            Socket connection =server.accept();
                            Thread task=new thread_seven(connection);
                            task.start();
                        }catch (IOException ex){}
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread survaliance_8=new Thread(){
            @Override
            public void run() {
                try(ServerSocket server=new ServerSocket(PORT_eighth)){
                    System.out.println("survaliance8 is running");
                    while (true){
                        try {
                            Socket connection =server.accept();
                            System.out.println("accept");
                            Thread task=new thread_eighth(connection);
                            task.start();
                        }catch (IOException ex){}
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread survaliance_9=new Thread(){
            @Override
            public void run() {
                try(ServerSocket server=new ServerSocket(PORT_ninth)){
                    System.out.println("survaliance8 is running");
                    while (true){
                        try {
                            Socket connection =server.accept();
                            System.out.println("accept");
                            Thread task=new thread_ninth(connection);
                            task.start();
                        }catch (IOException ex){}
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread survaliance_10=new Thread(){
            @Override
            public void run() {
                try(ServerSocket server=new ServerSocket(PORT_tenth)){
                    System.out.println("survaliance10 is running");
                    while (true){
                        try {
                            Socket connection =server.accept();
                            System.out.println("accept");
                            Thread task=new thread_tenth(connection);
                            task.start();
                        }catch (IOException ex){}
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        survaliance_1.start();
        survaliance_2.start();
        survaliance_3.start();
        survaliance_4.start();
        survaliance_5.start();
        survaliance_6.start();
        survaliance_7.start();
        survaliance_8.start();
        //survaliance_10.start();
    }
    private static class thread_first extends Thread{

        //客户端订餐

        private Socket connection;
        private String time;

        thread_first(Socket connection){
            this.connection=connection;
        }

        @Override
        public void run() {
            try{
                System.out.println("customer interface is on");
                OutputStream outputStream=connection.getOutputStream();
                Writer writer=new OutputStreamWriter(outputStream,"UTF-8");
                InputStream inputStream=connection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                /*
                for (int c=reader.read();c!='\0';c=reader.read()){
                    time.append((char)c);
                }
                */
                time=bufferedReader.readLine();
                String name=time.toString();
                time=null;
                for (int i=0;i<query.size()&&i<4;i++) {
                    writer.write(query.get(i).resturant_name+"\r\n");
                    writer.flush();
                }
                OutputStream picture_out = connection.getOutputStream();
                byte[] buf = new byte[1024];
                int len = 0;
                //System.out.println("preparing to convey picture,after connect with client");
                /*
                for (int i=0;i<query.size()&&i<4;i++){
                    FileInputStream fis = new FileInputStream("E:\\"+query.get(i).resturant_name+".bmp");
loop1:              while ((len = fis.read(buf)) != -1)
                    {
                        picture_out.write(buf,0,len);
                    }
                    connection.shutdownOutput();
                    System.out.println("has conveyed picture");
                    fis.close();
                }
                */
                //OutputStream picture_out = connection.getOutputStream();
                /*
                byte[] buf = new byte[1024];
                int len = 0;
                while ((len = fis.read(buf)) != -1)
                {
                    picture_out.write(buf,0,len);
                }
                System.out.println("has conveyed picture");
                //connection.shutdownOutput();
                picture_out.flush();
                */
                //out.write("KFC");
                //out.flush();
                System.out.println("has conveyed hall name");
                /*
                for (int c=reader.read();c!=-1;c=reader.read()){
                    time.append((char)c);
                }
                */
                time=bufferedReader.readLine();
                System.out.println(time);
                /*
                for (int i=0;i<query.size();i++){
                    if(query.get(i).resturant_name.equals(time.toString())){
                        query.get(i).queue_list.add(name);
                    }
                }
                */
                //connection.shutdownOutput();
                picture_out.close();
                //in.close();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class thread_second extends Thread{
        //  客户端查询
        private Socket connection;
        private String name;

        thread_second(Socket connection){
            this.connection=connection;
        }

        @Override
        public void run() {
            System.out.println("customer is querying");
            try{
                //byte[] bufIn = new byte[1024];
                //int num = in.read(bufIn);
                //OutputStream out = connection.getOutputStream();
                //out.write("上传成功".getBytes());
                OutputStream outputStream=connection.getOutputStream();
                Writer writer=new OutputStreamWriter(outputStream,"UTF-8");
                InputStream inputStream=connection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                /*
                for (int c=reader.read();c!='\0';c=reader.read()){
                    name.append((char)c);
                }
                */
                name=bufferedReader.readLine();
                //name.append(reader.read());

                System.out.println(name);
                outterLoop1:while (true){
                    sleep(1000);
                    for (int i=0;i<query.size();i++) {
                        if (query.get(i).ask.equals(name)) {
                            //if(ask.equals("237340453")){
                            writer.write("1\r\n");
                            writer.flush();
                            break outterLoop1;
                        }
                    }
                }
                int oooo=0;
                //name.setLength(0);
                int answer=bufferedReader.read();
                outterLoop2:while (true){
                    if(answer==1)
                    {
                        for (int i=0;i<query.size();i++) {
                            if (query.get(i).ask.equals(name)) {
                                query.get(i).ack = kengding;
                                oooo=i;
                                break outterLoop2;
                            }
                        }
                    }else{
                        sleep(1000);
                    }
                }
                outterLoop3:while(true){
                    sleep(1000);
                    /*
                    for (int i=0;i<query.size();i++) {
                        if (query.get(i).ask.equals(name.toString())) {
                                query.get(i).ack = fouding;
                                break outterLoop3;
                        }
                    }
                    */
                    if(query.get(oooo).ask.equals("0")){
                        query.get(oooo).ack=fouding;
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static class thread_third extends Thread{
        //企业端同意
        private Socket connection;
        thread_third(Socket connection){
            this.connection=connection;
        }

        @Override
        public void run() {
            System.out.println("hall has been successful to connect");
            try{
                OutputStream outputStream=connection.getOutputStream();
                Writer writer=new OutputStreamWriter(outputStream,"UTF-8");
                InputStream inputStream=connection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));

                int weizhi=-1;
                System.out.println("successfully connected");

                /*
                for (int c=reader.read();c!='\0';c=reader.read()){
                    time.append((char)c);
                }
                String name=time.toString();
                */
                String name=bufferedReader.readLine();
                for (int i=0;i<query.size();i++){
                    if(name.equals(query.get(i).resturant_name)){
                        weizhi=i;
                        break;
                    }
                }
                //if(reader.read()==kengding){
                if(bufferedReader.readLine().equals("1")){
                    query.get(weizhi).ask=query.get(weizhi).queue_list.removeFirst();
                    writer.write(query.get(weizhi).ask+"\r\n");
                    writer.flush();
                }
                while (true){
                    if(query.get(weizhi).ack==kengding){
                        writer.write(query.get(weizhi).size());
                        writer.flush();
                        query.get(weizhi).ask="0";
                        break;
                    }else{
                        sleep(1000);
                    }
                }

                /*
                for (int c=reader.read();c!=-1;c=reader.read()){
                    time.append((char)c);
                }
                */
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class thread_forth extends Thread{
        //企业端加队列
        private Socket connection;
        private String name;
        private String phone;
        private String adress;

        thread_forth(Socket connection){
            this.connection=connection;
        }

        @Override
        public void run() {
            System.out.println("enterprise is adding resturant");

            Connection conn = null;
            Statement stmt = null;

            try {
                OutputStream outputStream=connection.getOutputStream();
                Writer writer=new OutputStreamWriter(outputStream,"UTF-8");
                InputStream inputStream=connection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                /*
                for (int c = reader.read(); c != '\0'; c = reader.read()) {
                    name.append((char) c);
                }
                */
                name=bufferedReader.readLine();

                /*
                StringBuilder phone=new StringBuilder();
                for (int c=reader.read();c!='\0';c=reader.read()){
                    phone.append((char)c);
                }
                */
                phone=bufferedReader.readLine();

                adress=bufferedReader.readLine();

                //sleep(500);

                //关闭连接
                //bufferedReader.close();
                query.add(new queue(name,adress, phone));
                System.out.println(query.get(0).resturant_adress);
                System.out.println(query.get(0).resturant_name);
                System.out.println(query.get(0).resturant_phone);
                System.out.println("have added");

                // 注册 JDBC 驱动
                Class.forName("com.mysql.jdbc.Driver");

                // 打开链接
                System.out.println("连接数据库...");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shangjia?characterEncoding=GBK","root","123456");
                // 执行查询
                System.out.println("读取数据...");
                stmt = conn.createStatement();
                String sql;

                sql="INSERT INTO shang_jia VALUES('"+name.toString()+"','"+phone.toString()+"','"+adress+"',"+"'asd');";
                System.out.println(sql);
                if (stmt.execute(sql))
                    System.out.println("successful into biao");
                else
                    System.out.println("failed into biao");
                //System.out.println(resultSet.next());

                sql = "SELECT name FROM shang_jia";
                ResultSet rs = stmt.executeQuery(sql);

                // 展开结果集数据库
                while(rs.next()){
                    // 通过字段检索
                    String name1 = rs.getString("name");

                    // 输出数据
                    System.out.print("name: " + name1);
                    System.out.print("\n");
                }
                // 完成后关闭
                rs.close();
                stmt.close();
                conn.close();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 关闭资源
                try{
                    if(stmt!=null) stmt.close();
                }catch(SQLException se2){
                }// 什么都不做
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }
        }
    }

    public static class thread_fifth extends Thread{
        //加入排队
        private Socket connection;
        thread_fifth(Socket connection){
            this.connection=connection;
        }

        @Override
        public void run() {
            try {
                OutputStream outputStream=connection.getOutputStream();
                Writer writer=new OutputStreamWriter(outputStream,"UTF-8");
                InputStream inputStream=connection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                /*
                for (int c=reader.read();c!='\0';c=reader.read()){
                    name.append((char)c);
                }
                */
                String resturant_name=bufferedReader.readLine();
                //name.setLength(0);
                /*
                for (int c=reader.read();c!='\0';c=reader.read()){
                    name.append((char)c);
                }
                */
                String customer_name=bufferedReader.readLine();
                //name.setLength(0);
                label:
                for (int i=0;i<query.size();i++){
                    if(query.get(i).resturant_name.equals(resturant_name)){
                        for (int j=0;j<query.get(i).queue_list.size();j++){
                            if (customer_name.equals(query.get(i).queue_list.get(j))){
                                writer.write(fouding);
                                writer.flush();
                                System.out.println("have not done reserved");
                                break label;
                            }
                        }
                        query.get(i).queue_list.add(customer_name);
                        writer.write(kengding);
                        writer.flush();
                        System.out.println("have done reserved");
                    }
                }

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class thread_sixth extends Thread{
        private Socket connection;
        thread_sixth(Socket connection){
            this.connection=connection;
        }

        @Override
        public void run() {
            super.run();
            try {
                System.out.println("start transfering picture");
                Writer out=new OutputStreamWriter(connection.getOutputStream());
                InputStream in =connection.getInputStream();
                StringBuilder name=new StringBuilder();
                InputStreamReader reader=new InputStreamReader(in,"ASCII");
                for (int c=reader.read();c!='\0';c=reader.read()){
                    name.append((char)c);
                }
                DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
                FileInputStream fis = new FileInputStream("F:\\tu.bmp");
                int size = fis.available();

                System.out.println("size = "+size);
                byte[] data = new byte[size];
                fis.read(data);
                dos.writeInt(size);
                dos.write(data);

                dos.flush();
                dos.close();
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //查询
    public static class thread_seven extends Thread{
        private Socket connection;
        private String name;

        thread_seven(Socket connection){
            this.connection=connection;
        }

        @Override
        public void run() {
            super.run();
            try {
                OutputStream outputStream=connection.getOutputStream();
                Writer writer=new OutputStreamWriter(outputStream,"UTF-8");
                InputStream inputStream=connection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                /*
                for (int c=reader.read();c!='\0';c=reader.read()){
                    name.append((char)c);
                }
                */
                name=bufferedReader.readLine();
                System.out.println(name);
                System.out.println(query.get(0).resturant_name);
                String temporary= name;
                for (int i=0;i<query.size();i++){
                    if(temporary.equals(query.get(i).resturant_name)){
                        writer.write(kengding);
                        writer.flush();
                        writer.write(query.get(i).resturant_phone+"\r\n");
                        writer.flush();
                        writer.write(query.get(i).resturant_adress+"\r\n");
                        writer.flush();
                    }else if (i==(query.size()-1)){
                        writer.write(fouding);
                        writer.flush();
                    }
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //取消
    public static class thread_eighth extends Thread {
        private Socket connection;
        private String name;

        thread_eighth(Socket connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            super.run();
            try {
                OutputStream outputStream=connection.getOutputStream();
                Writer writer=new OutputStreamWriter(outputStream,"UTF-8");
                InputStream inputStream=connection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                System.out.println("prepare to cancle");
                /*
                for (int c=reader.read();c!='\0';c=reader.read()){
                    name.append((char)c);
                }
                */
                name=bufferedReader.readLine();
                System.out.println(name);
                String resturant_name= name;
                //name.setLength(0);
                /*
                for (int c=reader.read();c!='\0';c=reader.read()){
                    name.append((char)c);
                }
                */
                name=bufferedReader.readLine();
                String username= name;
                System.out.println(username);
                System.out.println(query.get(0).queue_list.size());
                for (int i=0;i<query.size();i++){
                    if(query.get(i).resturant_name.equals(resturant_name)){
                        for (int j=0;j<query.get(i).queue_list.size();j++){
                            System.out.println(query.get(i).queue_list.get(j));
                            if (username.equals(query.get(i).queue_list.get(j))){
                                query.get(i).queue_list.remove(j);
                                writer.write(1);
                                writer.flush();
                                System.out.println(query.get(i).queue_list.size());
                                System.out.println("successful to cancle");
                            }
                        }
                    }
                }

                writer.write(0);
                writer.flush();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    public static class thread_ninth extends Thread {
        private Socket connection;
        private String name;

        thread_ninth(Socket connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            super.run();
            try {
                OutputStream outputStream=connection.getOutputStream();
                Writer writer=new OutputStreamWriter(outputStream,"UTF-8");
                InputStream inputStream=connection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                /*
                for (int c=reader.read();c!='\0';c=reader.read()){
                    name.append((char)c);
                }
                */
                name=bufferedReader.readLine();
                String resturant_name= name;
                for (int i=0;i<query.size();i++){
                    if(query.get(i).resturant_name.equals(resturant_name)){
                        writer.write(query.get(i).size());
                        writer.flush();
                    }
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class thread_tenth extends Thread {
        private Socket connection;

        thread_tenth(Socket connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            super.run();
            try {
                InputStream inputStream=connection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                line=bufferedReader.readLine();
                System.out.println(line);
                System.out.println("地址传递完成");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
