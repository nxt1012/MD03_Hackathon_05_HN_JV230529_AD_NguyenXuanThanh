package ra.businessImp;

import ra.business.IShop;

import static ra.run.ProductManagement.*;

public class Product implements IShop {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
    }
    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
//        TODO: nhập thông tin sản phẩm từ bàn phím (trừ exportPrice và catalog)
//        tính exportPrice = importPrice * RATE
//        cho phép chọn danh mục sản phẩm từ danh sách sản phẩm đang quản lý
//        add productId
        System.out.print("Nhập vào mã sản phẩm: ");
        this.productId = Integer.parseInt(sc.nextLine());

//        add productName
        System.out.print("Nhập vào tên sản phẩm: ");
        this.productName = sc.nextLine();

//        add title
        System.out.print("Nhập vào tiêu đề sản phẩm: ");
        this.title = sc.nextLine();

//        add descriptions
        System.out.print("Nhập vào mô tả sản phẩm: ");
        this.descriptions = sc.nextLine();

//        add catalog
        System.out.println("Vui lòng chọn mã danh mục cho sản phẩm từ danh sách dưới đây.");
        if (catalogs.isEmpty()) {
//            TODO: thêm cơ chế tạo mới mã danh mục khi không có (if)
            System.out.println("Danh sách mã danh mục hiện trống. Vui lòng tạo mới mã danh mục trước khi tiếp tục");
            Catalog newCatalog = new Catalog();
            newCatalog.inputData();
            catalogs.add(newCatalog);
            this.catalog = newCatalog;

        } else {
            System.out.println("************************DANH SÁCH MÃ DANH MỤC HIỆN CÓ************************");
            for (Catalog catalog : catalogs) {
                catalog.displayData();
            }
            System.out.print("Nhập vào mã danh mục: ");
            int catalogId = Integer.parseInt(sc.nextLine());
            Catalog result = new Catalog();
            boolean isCatalogExist = false;
            for (Catalog catalog : catalogs) {
                if (catalog.getCatalogId() == catalogId) {
                    isCatalogExist = true;
                    result = catalog;
                    break;
                }
            }

            if (isCatalogExist) {
                this.catalog = result;
//            TODO: thêm cơ chế tạo mới mã danh mục khi không có (thêm else)
            } else {
                System.out.println("Mã danh mục bạn vừa nhập không tồn tại");
                boolean isCatalogCreated = true;
                do {
                    System.out.println("Bạn có muốn tạo mã danh mục mới không?");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            Catalog newCatalog = new Catalog();
                            newCatalog.inputData();
                            catalogs.add(newCatalog);
                            this.catalog = newCatalog;
                            isCatalogCreated = false;
                            break;
                        case 2:
                            System.out.println("Mã danh mục không thể để trống");
                            break;
                        default:
                            System.err.println("Bạn chỉ có thể lựa chọn 1 hoặc 2");
                    }
                } while (isCatalogCreated);
            }

        }

//        add importPrice
        System.out.print("Nhập vào giá nhập: ");
        this.importPrice = Float.parseFloat(sc.nextLine());

//        calculate exportPrice = importPrice * RATE
        this.exportPrice = this.importPrice * RATE;

//        add productStatus
        System.out.print("Nhập vào trạng thái sản phẩm [true/false]: ");
        this.productStatus = Boolean.parseBoolean(sc.nextLine());
    }

    @Override
    public void displayData() {
//        TODO: in thông tin sản phẩm gồm mã sản phẩm, tên sản phẩm, tên danh mục sản phẩm, giá bán sản phẩm, trạng thái
        System.out.printf("Mã sản phẩm: %d - Tên sản phẩm: %s - Tên danh mục sản phẩm: %s\n", this.productId, this.productName, this.catalog.getCatalogName());
        System.out.printf("Giá bán sản phẩm: %.2f - Trạng thái sản phẩm: %b\n", this.exportPrice, this.productStatus);
    }
}
