import redis.clients.jedis.Jedis;

public class TestRedisData {
    public static void main(String[] args) {
        //连接虚拟机，测试Redis的功能
        Jedis j = new Jedis("192.168.81.128");
        String s = j.get("UserIsNull");
        System.out.println(s);
        j.close();
    }
}
