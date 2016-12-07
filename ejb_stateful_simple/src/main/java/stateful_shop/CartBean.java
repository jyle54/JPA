package stateful_shop;

import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

/*
Tilallisen istuntopavun toteutus

Toteutetaan tilallinen (Stataful) sessiopapu, jonne tallennetaan tietoja tuotteista. 

@Stateful
public class CartBean {
    private ArrayList<String> items;

    @PostConstruct
    public void initialize() {
        // TODO: Tuotteiden alustaminen
    }

    public void addItem(String item) {
        // TODO: Tuotteen lisääminen
    }

    public void removeItem(String item) {
        // TODO: Tuotteen poistaminen
    }

    public ArrayList<String> getItems() {
        // TODO: Tuotteiden palauttaminen
    }
    
    public int getSize() {
        // TODO: Palauttaa tuotelista koon
    }
}

*/


@Stateful
public class CartBean {
    private ArrayList<String> items;

    @PostConstruct
    public void initialize() {
        items = new ArrayList<String>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public ArrayList<String> getItems() {
        return items;
    }
    
    public int getSize() {
        return items.size();
    }
}