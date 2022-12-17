/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PWS.Project3;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ROG
 */
@RestController//untuk menandakan suatu class adalah controller
@ControllerAdvice//digunakan untuk menghandle exception dan error
public class ProductServiceController {//membuat class product service controller
    private static Map<String, Product> productRepo = new HashMap<>();//membuat objek hashmap untuk penyimpanan sementara
    static {
        Product honey = new Product();//membuat objek untuk class product
      honey.setId("1");//mengisi id pada object honey
      honey.setName("Honey");//mengisi name pada object honey
      honey.setQty("2");//mengisi qty pada object honey
      honey.setPrice("12000");//mengisi price pada object honey
      productRepo.put(honey.getId(), honey);//memanggil object honey dan menyimpannya pada product repo
      
      Product almond = new Product();//membuat objek untuk class product
      almond.setId("2");//mengisi id pada object almond
      almond.setName("Almond");//mengisi name pada object almond
      almond.setQty("2");//mengisi qty pada object almond
      almond.setPrice("12000");//mengisi price pada object almond
      productRepo.put(almond.getId(), almond);//memanggil object almond dan menyimpannya pada product repo
    }
    
    //Comment untuk Memanggil GET
    @RequestMapping(value = "/products")//membuat request mapping untuk request method  pada class controller
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);//mengembalikan nilai productrepo
    }
    
    //Commant untuk Memanggil Method POST
    @RequestMapping(value = "/products", method = RequestMethod.POST)//membuat request mapping untuk request method  pada class controller post
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        //fungsi ketika id yang ingin dibuat sudah ada
        if(productRepo.containsKey(product.getId())){
            return new ResponseEntity<>("Id prduct already exists!",HttpStatus.OK);
        }
        //fungsi untuk menambahkan product
        else{
            productRepo.put(product.getId(), product);
            return new ResponseEntity<>("Product is created successfully",HttpStatus.CREATED);
        }
    }
    //Method PUT
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)//membuat request mapping untuk request method  pada class controller put
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { 
        if(!productRepo.containsKey(id))throw new ProductNotfoundException();//membuat statment if jika data yang di edit belum ada
      productRepo.remove(id);//untuk meremove id
      product.setId(id);//mengeset kembali id
      productRepo.put(id, product);//mengambil nilai id
      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);//pesan jika data product sudah di update
    }
     
    //Comment ketika pesan exception yang sudah kita panggil dan ingin menghapus id
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)//membuat request mapping untuk request method  pada class controller delete
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        if(!productRepo.containsKey(id))throw new ProductNotfoundException();//membuat statment jika data berhasil di hapus
        productRepo.remove(id);//meremove productrepo melalui id
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);//menampilkan pesan jika data berhasil di hapus
    } 
    
    @ExceptionHandler(value = ProductNotfoundException.class)//membuat class exception jika product ada yang error/product tidak ada
    public ResponseEntity<Object> exception(ProductNotfoundException exception) {
      return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);//mengambilkan nilai serta menampilkan pesan 
   }
}
