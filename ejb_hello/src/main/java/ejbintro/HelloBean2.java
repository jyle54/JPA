package ejbintro;

import java.util.Random;
import javax.ejb.Stateless;

@Stateless
public class HelloBean2 implements HelloBean2Remote {

    // randomly generating a String which has strLength characters
    public String randomStr(int strLength) {
        Random rand = new Random();
        char[] str = new char[strLength];
        for (int i = 0; i < strLength; i++) {
          str[i] = (char) (48 + rand.nextInt(47));
        }
        return new String(str);
    }

}
