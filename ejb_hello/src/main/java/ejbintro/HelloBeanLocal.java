package ejbintro;

import javax.ejb.Local;

@Local
public interface HelloBeanLocal {
    public String hello() ;
    public String randomStr();
}
