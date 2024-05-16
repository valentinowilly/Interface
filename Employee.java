package Interface;

// Kelas Employee
public class Employee implements Payable {
    Integer registrationNumber;
    String name;
    Integer salaryPerMonth;
    Invoice[] invoices;

    // Konstruktor untuk Employee dengan parameter nomor registrasi, nama, gaji, dan invoice
    public Employee(Integer registrationNumber, String name, Integer salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    @Override // Menghitung total pembayaran    
    public double getPayableAmount() {
        double totalInvoiceAmount = 0;
        for (Invoice invoice : invoices) {
            totalInvoiceAmount += invoice.getPayableAmount();
        }
        return totalInvoiceAmount; // Mengembalikan total invoice sebagai total belanja
    }

    @Override
    public String toString() { // Method toString untuk detail transaksi
        double totalBelanja = getPayableAmount();
        double gajiAkhir = salaryPerMonth - totalBelanja;

        // Menampilkan detail transaksi 
        String detail = "Nama\t\t\t: " + name + "\n" +
                        "Registration Num\t: " + registrationNumber + "\n" +
                        "Gaji Awal\t\t: Rp " + String.format("%.2f", (double) salaryPerMonth) + "\n" +
                        "Detail Belanja\t\t:\n";

        // Menambahkan detail setiap invoice
        for (int i = 0; i < invoices.length; i++) {
            detail += "\t" + (i + 1) + ". " + invoices[i] + "\n";
        }

        // Menampikan total belanja dan gaji akhir yang telah dihitung
        detail += "\t===============================\n" +
                  "\tTotal Belanja\t\t\tRp " + String.format("%.2f", totalBelanja) + "\n" +
                  "Gaji Akhir\t\t: Rp " + String.format("%.2f", gajiAkhir);

        return detail;
    }
}