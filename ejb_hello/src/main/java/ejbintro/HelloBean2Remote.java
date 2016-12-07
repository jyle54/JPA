package ejbintro;

import javax.ejb.Remote;

@Remote
public interface HelloBean2Remote {
    public String randomStr(int strLength);
}
