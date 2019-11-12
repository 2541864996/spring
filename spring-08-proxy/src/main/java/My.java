public class My {
    public static void main(String[] args) {
        //找到中介
        Intermediary intermediary=new Intermediary(new Landlord());
        //进行租房
        intermediary.getLandlord();

    }
}
