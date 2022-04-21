package laporan.application.com.model;

import java.io.Serializable;

public class bencana implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String tanggaljam;

    //DATA Bencana:
    String jenis;
    String lokasi;
    String tanggal;
    String waktu;
    String korban;
    String kerugian;

    String foto;
    String keterangan;

    String file;

    public bencana(
            int id,
            String tanggaljam,

            String jenis,
            String lokasi,
            String tanggal,
            String waktu,
            String korban,
            String kerugian,
            
            String foto,
            String keterangan
    ) {
        this.id = id;
        this.tanggaljam = tanggaljam;

        this.jenis = jenis;
        this.lokasi = lokasi;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.korban = korban;
        this.kerugian = kerugian;

        this.foto = foto;
        this.keterangan = keterangan;

        this.file = null;
    }

    public int getId() {
        return this.id;
    }

    public String getTanggaljam() {
        return this.tanggaljam;
    }

    public String getJenis() {
        return this.jenis;
    }
    
    public String getLokasi() {
        return this.lokasi;
    }
    
    public String getTanggal() {
        return this.tanggal;
    }

    public String getWaktu() {
        return this.waktu;
    }

    public String getKorban() {
        return this.korban;
    }

    public String getKerugian() {
        return this.kerugian;
    }

    public String getFoto() {
        return this.foto;
    }

    public String getKeterangan() {
        return this.keterangan;
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}


