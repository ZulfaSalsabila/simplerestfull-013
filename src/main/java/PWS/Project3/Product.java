/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PWS.Project3;

/**
 *
 * @author ROG
 */
class Product {//membuat class product
    private String id;//deklarasi variable id dengan tipe data string
    private String name;//deklarasi variable name dengan tipe data string
    private String qty;//deklarasi variable qty dengan tipe data string
    private String price;//deklarasi variable price dengan tipe data string

    public String getQty() {//membuat method untuk memanggil nilai QTY
        return qty;
    }

    public void setQty(String qty) {//membuat method set untuk menyimpan qty
        this.qty = qty;
    }

    public String getPrice() {//membuat method untuk memanggil nilai Price
        return price;
    }

    public void setPrice(String price) {//membuat method set untuk menyimpan price
        this.price = price;
    }
    

    public String getId() {//membuat method untuk memanggil nilai id
        return id;
    }

    public void setId(String id) {//membuat method set untuk menyimpan id
        this.id = id;
    }

    public String getName() {//membuat method untuk memanggil nilai QTY
        return name;
    }

    public void setName(String name) {//membuat method set untuk menyimpan name
        this.name = name;
    }

   
    
}
