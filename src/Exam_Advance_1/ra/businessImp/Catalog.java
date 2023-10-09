package ra.businessImp;

import ra.business.IShop;

import static ra.run.ProductManagement.sc;
public class Catalog implements IShop {
    private int catalogId;
    private String catalogName;
    private int priority;
    private String descriptions;
    private boolean catalogStatus;

    public Catalog() {
    }
    public Catalog(int catalogId, String catalogName, int priority, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescription(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData() {
//        TODO: nhập tất cả thông tin danh mục sản phẩm từ bàn phím
//        add catalogId
        System.out.print("Nhập vào mã danh mục: ");
        this.catalogId = Integer.parseInt(sc.nextLine());

//        add catalogName
        System.out.print("Nhập vào tên danh mục: ");
        this.catalogName = sc.nextLine();

//        add priority
        System.out.print("Nhập vào độ ưu tiên: ");
        this.priority = Integer.parseInt(sc.nextLine());

//        add descriptions
        System.out.print("Nhập vào mô tả danh mục: ");
        this.descriptions = sc.nextLine();

//        add catalogStatus
        System.out.print("Nhập vào trạng thái danh mục: ");
        this.catalogStatus = Boolean.parseBoolean(sc.nextLine());
    }
    @Override
    public void displayData() {
//        TODO: hiển thị thông tin danh mục gồm mã danh mục và tên danh mục sản phẩm
        System.out.printf("Mã danh mục: %d - Tên danh mục sản phẩm: %s\n", this.catalogId, this.catalogName);
    }
}