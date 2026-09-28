import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        bank.addCustomer("Jauda Avaro", "Zufaru");

        Customer nasabahAktif = bank.getCustomer(0);
        nasabahAktif.addAccount(new Account(1000000.0));
        Account rekeningAktif = nasabahAktif.getAccount(0);

        System.out.println("=========================================");
        System.out.println("        SELAMAT DATANG DI ATM BANK       ");
        System.out.println("=========================================");
        System.out.println("Nasabah: " + nasabahAktif.getFirstName() + " " + nasabahAktif.getLastName());

        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU TRANSAKSI ---");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Setor Tunai (Deposit)");
            System.out.println("3. Tarik Tunai (Withdraw)");
            System.out.println("4. Informasi Rekening");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.printf("Saldo Anda saat ini: Rp %,.2f\n", rekeningAktif.getBalance());
                    break;

                case 2:
                    System.out.print("Masukkan nominal setoran: Rp ");
                    double setor = scanner.nextDouble();
                    if (rekeningAktif.deposit(setor)) {
                        System.out.printf("Setoran berhasil! Saldo baru: Rp %,.2f\n", rekeningAktif.getBalance());
                    } else {
                        System.out.println("Gagal: Nominal setoran harus lebih dari 0.");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nominal penarikan: Rp ");
                    double tarik = scanner.nextDouble();
                    if (rekeningAktif.withdraw(tarik)) {
                        System.out.printf("Penarikan berhasil! Sisa saldo: Rp %,.2f\n", rekeningAktif.getBalance());
                    } else {
                        System.out.println("Gagal: Saldo tidak mencukupi atau nominal tidak valid.");
                    }
                    break;

                case 4:
                    System.out.println("\n[ Data Informasi Akun ]");
                    System.out.println("Nama Pemilik   : " + nasabahAktif.getFirstName() + " " + nasabahAktif.getLastName());
                    System.out.println("Jumlah Rekening: " + nasabahAktif.getNumOfAccounts());
                    System.out.println("Total Nasabah  : " + bank.getNumOfCustomers() + " orang terdaftar di sistem");
                    break;

                case 5:
                    running = false;
                    System.out.println("Terima kasih telah bertransaksi di ATM kami.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan masukkan angka 1 sampai 5.");
            }
        }

        scanner.close();
    }
}