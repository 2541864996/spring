package demo02;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//注册到容器中
public class Superman {
    //自动注入 也可以写到set方法上面
    @Autowired
    private Bolt bolt;
    //自动注入
    @Autowired
    private Garfield garfield;

    public Superman() {
    }

    public Superman(Bolt bolt, Garfield garfield) {
        this.bolt = bolt;
        this.garfield = garfield;
    }

    public Bolt getBolt() {
        return bolt;
    }

    public void setBolt(Bolt bolt) {
        this.bolt = bolt;
    }

    public Garfield getGarfield() {
        return garfield;
    }

    public void setGarfield(Garfield garfield) {
        this.garfield = garfield;
    }
}
