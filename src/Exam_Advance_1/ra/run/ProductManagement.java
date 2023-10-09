package ra.run;

import ra.businessImp.Catalog;
import ra.businessImp.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static List<Catalog> catalogs = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("*************************JAVA-HACKATHON-05-ADVANCE-2-MENU*************************");
            System.out.println("1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)");
            System.out.println("4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
            System.out.println("5. Thoát");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addCatalogs();
                    break;
                case 2:
                    addProducts();
                    break;
                case 3:
                    ascendingSortByProductPrice();
                    break;
                case 4:
                    searchProductsByCatalogName();
                    break;
                case 5:
                    sc.close();
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập vào các lựa chọn từ 1-5");
            }
        } while (true);
    }




    private static void addCatalogs() {
        System.out.print("Nhập vào số lượng danh mục sản phẩm muốn thêm: ");
        int numberOfCatalogsToAdd = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfCatalogsToAdd; i++) {
            System.out.println("Thêm danh mục thứ " + (i + 1));
            Catalog newCatalog = new Catalog();
            newCatalog.inputData();
            catalogs.add(newCatalog);
        }
        System.out.println("Hoàn tất việc thêm " + numberOfCatalogsToAdd + " danh mục!");


//        TEST addCatalogs() result
        System.out.println("DANH SÁCH DANH MỤC HIỆN CÓ");
        for (Catalog catalog : catalogs) {
            catalog.displayData();
        }
    }

    private static void addProducts() {
        System.out.print("Nhập vào số lượng sản phẩm muốn thêm: ");
        int numberOfProductsToAdd = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfProductsToAdd; i++) {
            System.out.println("Thêm sản phẩm thứ " + (i+1));
            Product newProduct = new Product();
            newProduct.inputData();
            products.add(newProduct);
        }

//        TEST addProducts result
        System.out.println("DANH SÁCH SẢN PHẨM HIỆN CÓ");
        for (Product product : products) {
            product.displayData();
        }
    }

    private static void ascendingSortByProductPrice() {
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Float.compare(o1.getImportPrice(), o2.getImportPrice());
            }
        };
        products.sort(comparator);

//        TEST ascendingSortByProductPrice() result
        System.out.println("SORTED PRODUCT BY PRICE IN ASCENDING ORDER");
        for (Product product : products) {
            product.displayData();
        }
    }

    private static void searchProductsByCatalogName() {
        System.out.print("Nhập vào tên danh mục sản phẩm: ");
        String catalogNameToSearch = sc.nextLine();
        boolean isNothingFound = true;

        for (Product product : products) {
            if (product.getCatalog().getCatalogName().trim().equalsIgnoreCase(catalogNameToSearch)) {
                isNothingFound = false;
                product.displayData();
            }
        }
        if (isNothingFound) {
            System.out.println("Không tìm thấy sản phẩm nào phù hợp với mã danh mục đã nhập");
        }
    }
}
