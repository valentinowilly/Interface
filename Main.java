package Interface;

import java.util.Scanner; // Mengimport fungsi scanner

public class Main { 
    public static void main(String[] args) {
        // Membuat scanner
        Scanner scanner = new Scanner(System.in);

        // Memanggil objek nama, no registrasi, dan gaji
        String name;
        int registrationNumber, salaryPerMonth;

        // Membuat tampilan menu/halaman awal
        System.out.println("========[KOPERASI KARYAWAN]========");
        System.out.println("Pilihan program:");
        System.out.println("1. Login");
        System.out.println("2. Belanja");
        System.out.println("3. Lihat Detail Belanja");
        System.out.println("4. Keluar");
        System.out.print("Masukkan pilihan Anda: ");
        int choice = scanner.nextInt(); // Meminta input pilihan

        Employee employee = null; // Deklarasi dengan null  
        Invoice[] invoices = null;

        // Looping program
        while (choice != 4) {
            switch (choice) {
                case 1: // Meminta user untuk login
                    System.out.print("Masukkan nama anda: ");
                    scanner.nextLine(); // clear buffer
                    name = scanner.nextLine();
                    System.out.print("Masukkan nomor registrasi pegawai: ");
                    registrationNumber = scanner.nextInt();
                    System.out.print("Masukkan jumlah gaji per bulan: ");
                    salaryPerMonth = scanner.nextInt();
                    invoices = new Invoice[0]; // Reset invoice
                    employee = new Employee(registrationNumber, name, salaryPerMonth, invoices);
                    System.out.println("USERINFO: Successfully logged in!");    
                    break;
                case 2: // Menampilkan daftar produk dan harganya
                    System.out.println("Daftar Produk:");
                    System.out.println("1. Air Mineral -- Rp 4,500.00");
                    System.out.println("2. Pulpen -- Rp 2,000.00");
                    System.out.println("3. Correction Tape -- Rp 5,000.00");
                    System.out.println("4. Spidol -- Rp 8,000.00");
                    System.out.println("5. Tinta Spidol -- Rp 35,000.00");
                    System.out.println("6. Kabel Data -- Rp 25,000.00");
                    System.out.println("7. Mouse Geming -- Rp 450,000.00");
                    System.out.println("8. Steelseries Mechanical Gaming Keyboard -- Rp 790,000.00");
                    System.out.println("9. Razer Goliathus Control Mousepad -- Rp 290,000.00");
                    System.out.println("10. Steelseries Artics 1 Gaming Headset -- Rp 800,000.00");
                    System.out.println("11. SanDisk Extreme Pro M.2 NVME 500GB -- Rp 1,700,000.00");
                    System.out.println("12. GSkill Ripjaws V DDR4 8GB RAM @ 3200Mhz -- Rp 450,000.00");
                    System.out.println("13. Diecast Innova Reborn Venturer -- Rp 1,500,000.00");
                    System.out.println("14. Selesai belanja");
                    System.out.print("Masukkan pilihan produk: ");
                    int productChoice = scanner.nextInt();
                    while (productChoice != 14) { // Looping untuk membeli produk
                        System.out.print("Masukkan jumlah yang ingin dibeli: ");
                        int quantity = scanner.nextInt();
                        // Menambahkan invoice baru ke array invoice 
                        Invoice[] tempInvoices = new Invoice[invoices.length + 1];
                        System.arraycopy(invoices, 0, tempInvoices, 0, invoices.length);
                        tempInvoices[invoices.length] = new Invoice(getProductName(productChoice), quantity, getProductPrice(productChoice));
                        invoices = tempInvoices;
                        System.out.println("Berhasil menambahkan ke keranjang belanja.");
                        System.out.print("Masukkan pilihan produk: ");
                        productChoice = scanner.nextInt();
                    }
                    employee.invoices = invoices; // Mengupdate invoice setelah selesai belanja
                    break;
                case 3:
                    if (employee != null) { // Menampilkan detail belanja pegawai
                        System.out.println("===============================[EMPLOYEE STATS]==================================");
                        System.out.println(employee);
                        System.out.println("\n========[KOPERASI KARYAWAN]========");
                        System.out.println("Pilihan program:");
                        System.out.println("1. Login");
                        System.out.println("2. Belanja");
                        System.out.println("3. Lihat Detail Belanja");
                        System.out.println("4. Keluar");
                        System.out.print("Masukkan pilihan Anda: ");
                    } else {
                        System.out.println("Anda harus login terlebih dahulu!"); // Apabila belum melewati pilihan 1
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka 1, 2, 3, atau 4."); // Apabila pilihan tidak di range 1-4
            }
            System.out.print("Masukkan pilihan Anda: ");
            choice = scanner.nextInt();
        }
    }

    // Mendapatkan nama produk sesuai pilihan
    private static String getProductName(int choice) {
        switch (choice) {
            case 1:
                return "Air Mineral";
            case 2:
                return "Pulpen";
            case 3:
                return "Correction Tape";
            case 4:
                return "Spidol";
            case 5:
                return "Tinta Spidol";
            case 6:
                return "Kabel Data";
            case 7:
                return "Mouse Geming";
            case 8:
                return "Steelseries Mechanical Gaming Keyboard";
            case 9:
                return "Razer Goliathus Control Mousepad";  
            case 10:
                return "Steelseries Artics 1 Gaming Headset";
            case 11:
                return "SanDisk Extreme Pro M.2 NVME 500GB";
            case 12:
                return "GSkill Ripjaws V DDR4 8GB RAM @ 3200Mhz";  
            case 13:
                return "Diecast Innova Reborn Venturer";
            default:
                return "Unknown";
        }
    }

    // Mendapatkan harga produk sesuai pilihan
    private static int getProductPrice(int choice) {
        switch (choice) {
            case 1:
                return 4500;
            case 2:
                return 2000;
            case 3:
                return 5000;
            case 4:
                return 8000;
            case 5:
                return 35000;
            case 6:
                return 25000;
            case 7:
                return 450000;
            case 8:
                return 790000;
            case 9:
                return 290000;  
            case 10:
                return 800000;
            case 11:
                return 1700000;
            case 12:
                return 450000;  
            case 13:
                return 1500000;
            default:
                return 0;
        }
    }
}