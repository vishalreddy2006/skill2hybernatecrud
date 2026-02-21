package klh;

import klh.dao.ProductDAO;
import klh.entity.Product;

public class App {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

      
        dao.insert(new Product("Laptop","Gaming",75000,5));
        dao.insert(new Product("Mouse","Wireless",500,20));

        // READ
        Product p = dao.get(1);
        if(p != null)
            System.out.println(p.getName()+" "+p.getPrice());

        
        dao.updatePrice(1,70000);

        
        dao.delete(2);

        System.out.println("Done");
    }
}