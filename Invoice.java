package Interface;

// Interface Payable
interface Payable {
    double getPayableAmount(); // Mendapatkan jumlah yang harus dibayar
}

// Kelas Invoice
public class Invoice implements Payable {
    String productName;
    Integer quantity;
    Integer pricePerItem;

    // Konstruktor untuk Invoice dengan parameter nama produk, kuantitas, dan harga per item
    public Invoice(String productName, Integer quantity, Integer pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double getPayableAmount() {
        return quantity * pricePerItem; // Menghitung total pembayaran invoice
    }

    @Override
    public String toString() { // Method toString untuk detail invoice
        return quantity + " buah " + productName + "\t\t\tRp " + String.format("%.2f", getPayableAmount());
    }
}