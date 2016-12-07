package ejbintro;

import java.util.Random;
import javax.ejb.Stateless;

@Stateless
public class HelloBean implements HelloBeanLocal {
    public String hello() {
        return "hello from EJB!";
    }

    // randomly generating a 5 characters long string
    public String randomStr() {
        Random rand = new Random();
        String str = "";
        for (int i = 0; i < 5; i++) {
          str += (char) (48 + rand.nextInt(47));
        }
        return str;
    }
}
