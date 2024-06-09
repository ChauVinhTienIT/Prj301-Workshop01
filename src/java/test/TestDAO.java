/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.AccountDao;
import dao.CategoryDao;
import dao.ProductDao;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Category;
import model.Product;

/**
 *
 * @author Lenovo
 */
public class TestDAO {

    public static void main(String[] args) {
        testProduct();
        testAccount();
        testCategory();
    }

    private static void testProduct() {
        List<Product> producList = new ArrayList<>();
        Product pro = null;

        ProductDao productDao = new ProductDao();
        producList = productDao.listAll();

        System.out.println("List All Products: ");

        for (Product product : producList) {
            System.out.println(product);
        }

        System.out.println("Search for '10NOTEP256': ");
        pro = productDao.getObjectById("10NOTEP256");
        System.out.println(pro);

    }

    private static void testCategory() {
        List<Category> cateList = new ArrayList<>();
        Category cate = null;

        CategoryDao categoryDao = new CategoryDao();
        cateList = categoryDao.listAll();

        System.out.println("List All Category: ");

        for (Category category : cateList) {
            System.out.println(category);
        }

        System.out.println("Search for 'admin': ");
        cate = categoryDao.getObjectById("1");
        System.out.println(cate);

    }

    private static void testAccount() {
        List<Account> accList = new ArrayList<>();
        Account acc = null;

        AccountDao accountDAO = new AccountDao();
        accList = accountDAO.listAll();

        System.out.println("List All Account: ");
        for (Account account : accList) {
            System.out.println(account);
        }

        System.out.println("Search for 'admin': ");
        acc = accountDAO.getObjectById("admin");
        System.out.println(acc);

    }
}
