//中介
public class Intermediary implements Renting{
    //中介需要一个房东才可以进行租房
    private Landlord landlord;

    public Intermediary() {
    }

    public Intermediary(Landlord landlord) {
        this.landlord = landlord;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    //中介的不仅可以进行租房，也可以进行其他的事情
    public void renting() {
        seekHouses();
        landlord.renting();
    }

    private void seekHouses(){
        System.out.println("中介带你看房");
    }
}
