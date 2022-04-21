package laporan.application.com.model;

import java.io.Serializable;


public class kegiatan implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String tanggaljam;

    //DATA Kegiatan:
    String jeniskegiatan;
    String namakegiatan;
    String lokasikegiatan;
    String tglkegiatan;
    String waktukegiatan;
    String pesertakegiatan;

    String foto;
    String keterangan;

    String file;

    public kegiatan(
            int id,
            String tanggaljam,

            String jeniskegiatan,
            String namakegiatan,
            String lokasikegiatan,
            String tglkegiatan,
            String waktukegiatan,
            String pesertakegiatan,
            
            String foto,
            String keterangan
    ) {
        this.id = id;
        this.tanggaljam = tanggaljam;

        this.jeniskegiatan = jeniskegiatan;
        this.namakegiatan = namakegiatan;
        this.lokasikegiatan = lokasikegiatan;
        this.tglkegiatan = tglkegiatan;
        this.waktukegiatan = waktukegiatan;
        this.pesertakegiatan = pesertakegiatan;

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

    public String getJeniskegiatan() {
        return this.jeniskegiatan;
    }

    public String getNamakegiatan() {
        return this.namakegiatan;
    }

    public String getLokasikegiatan() {
        return this.lokasikegiatan;
    }

    public String getTglkegiatan() {
        return this.tglkegiatan;
    }

    public String getWaktukegiatan() {
        return this.waktukegiatan;
    }

    public String getPesertakegiatan() {
        return this.pesertakegiatan;
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


