import java.util.LinkedList;

public class queue extends LinkedList {
    String resturant_name;
    String resturant_adress;
    String resturant_phone;
    public volatile LinkedList<String>  queue_list;
    public volatile int ack=0;
    public volatile String ask="0";
    public queue(String name,String adress,String phone){
        queue_list=new LinkedList<>();
        resturant_name=name;
        resturant_adress=adress;
        resturant_phone=phone;
    }
}