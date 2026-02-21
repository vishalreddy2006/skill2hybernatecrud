package klh.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import klh.entity.Product;
import klh.util.HibernateUtil;

public class ProductDAO {

    public void insert(Product p){
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(p);
        tx.commit();
        s.close();
    }

    public Product get(int id){
        Session s = HibernateUtil.getFactory().openSession();
        Product p = s.get(Product.class,id);
        s.close();
        return p;
    }

    public void updatePrice(int id,double price){
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        Product p = s.get(Product.class,id);
        if(p!=null){
            p.setPrice(price);
        }
        tx.commit();
        s.close();
    }

    public void delete(int id){
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        Product p = s.get(Product.class,id);
        if(p!=null){
            s.delete(p);
        }
        tx.commit();
        s.close();
    }
}