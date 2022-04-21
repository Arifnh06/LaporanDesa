package laporan.application.com.libs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import laporan.application.com.model.bencana;
import laporan.application.com.model.kegiatan;

public class DatabaseHandler extends SQLiteOpenHelper {

	Context context;
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAMA = "laporandesa";

	public static final String TABLE_KEGIATAN = "serahterima";
	public static final String TABLE_BENCANA = "pelanggaran";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAMA, null, DATABASE_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	public void createTable() {
		SQLiteDatabase db = this.getWritableDatabase();


		db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_KEGIATAN + "(" +

				"id INTEGER PRIMARY KEY, " +
				"tanggaljam TEXT, " +



				"ket_rupam TEXT," +
				"ket_p2u TEXT," +
				"ket_kplp TEXT," +
				"ket_perawat TEXT," +
				"ket_satops1 TEXT," +
				"ket_satops2 TEXT," +



				"foto TEXT," +
				"keterangan TEXT," +

				"file TEXT)");


		db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_BENCANA + "(" +

				"id INTEGER PRIMARY KEY, " +
				"tanggaljam TEXT, " +

				"nama TEXT," +
				"alamat TEXT," +
				"pasal TEXT," +
				"pidana TEXT," +
				"blok TEXT," +
				"jenis_pelanggaran TEXT," +

				"foto TEXT," +
				"keterangan TEXT," +

				"file TEXT)");

		db.close();
	}

	public void kegiatanInsertData(kegiatan data) {

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put("tanggaljam", data.getTanggaljam());


		values.put("ket_rupam", data.getJeniskegiatan());
		values.put("ket_p2u", data.getNamakegiatan());
		values.put("ket_kplp", data.getLokasikegiatan());
		values.put("ket_perawat", data.getTglkegiatan());
		values.put("ket_satops1", data.getWaktukegiatan());
		values.put("ket_satops2", data.getPesertakegiatan());


		values.put("foto", data.getFoto());
		values.put("keterangan", data.getKeterangan());

		values.put("file", data.getFile());

		db.insert(TABLE_KEGIATAN, null, values);

		db.close();
	}

	public void kegiatanUpdateData(kegiatan data) {

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put("tanggaljam", data.getTanggaljam());

		values.put("ket_rupam", data.getJeniskegiatan());
		values.put("ket_p2u", data.getNamakegiatan());
		values.put("ket_kplp", data.getLokasikegiatan());
		values.put("ket_perawat", data.getTglkegiatan());
		values.put("ket_satops1", data.getWaktukegiatan());
		values.put("ket_satops2", data.getPesertakegiatan());

		values.put("foto", data.getFoto());
		values.put("keterangan", data.getKeterangan());

		values.put("file", data.getFile());

		db.update(TABLE_KEGIATAN, values, "id=?", new String[] { String.valueOf(data.getId())});
		db.close();
	}

	public void kegiatanDeleteData(kegiatan data) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_KEGIATAN, "id=?", new String[] { String.valueOf(data.getId())});
		db.close();
	}

	public ArrayList<kegiatan> kegiatanListData() {

		ArrayList<kegiatan> result = new ArrayList<>();
		try {
			String sql = "SELECT * FROM " + TABLE_KEGIATAN + " ORDER BY id DESC LIMIT 0, 10";
			SQLiteDatabase db = this.getReadableDatabase();
			Cursor cursor = db.rawQuery(sql, null);
			if(cursor.getCount() > 0) {
				cursor.moveToFirst();
				for(int i=0; i<cursor.getCount(); i++) {
					kegiatan item = new kegiatan(
							cursor.getInt(0),
							cursor.getString(1),

							cursor.getString(2),
							cursor.getString(3),
							cursor.getString(4),
							cursor.getString(5),

							cursor.getString(6),
							cursor.getString(7),
							cursor.getString(8),
							cursor.getString(9)

					);
					item.setFile(cursor.getString(10));
					result.add(item);
					cursor.moveToNext();
				}
			}
			cursor.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public void bencanaInsertData(bencana data) {

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put("tanggaljam", data.getTanggaljam());

		values.put("nama", data.getJenis());
		values.put("alamat", data.getLokasi());
		values.put("pasal", data.getTanggal());
		values.put("pidana", data.getWaktu());
		values.put("blok", data.getKorban());
		values.put("jenis_pelanggaran", data.getKerugian());

		values.put("foto", data.getFoto());
		values.put("keterangan", data.getKeterangan());

		values.put("file", data.getFile());

		db.insert(TABLE_BENCANA, null, values);

		db.close();
	}

	public void bencanaUpdateData(bencana data) {

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put("tanggaljam", data.getTanggaljam());

		values.put("nama", data.getJenis());
		values.put("alamat", data.getLokasi());
		values.put("pasal", data.getTanggal());
		values.put("pidana", data.getWaktu());
		values.put("blok", data.getKorban());
		values.put("jenis_pelanggaran", data.getKerugian());

		values.put("foto", data.getFoto());
		values.put("keterangan", data.getKeterangan());

		values.put("file", data.getFile());

		db.update(TABLE_BENCANA, values, "id=?", new String[] { String.valueOf(data.getId())});
		db.close();
	}

	public void bencanaDeleteData(bencana data) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_BENCANA, "id=?", new String[] { String.valueOf(data.getId())});
		db.close();
	}

	public ArrayList<bencana> bencanaListData() {

		ArrayList<bencana> result = new ArrayList<>();
		try {
			String sql = "SELECT * FROM " + TABLE_BENCANA + " ORDER BY id DESC LIMIT 0, 10";
			SQLiteDatabase db = this.getReadableDatabase();
			Cursor cursor = db.rawQuery(sql, null);
			if(cursor.getCount() > 0) {
				cursor.moveToFirst();
				for(int i=0; i<cursor.getCount(); i++) {
					bencana item = new bencana(
							cursor.getInt(0),
							cursor.getString(1),

							cursor.getString(2),
							cursor.getString(3),
							cursor.getString(4),
							cursor.getString(5),
							cursor.getString(6),
							cursor.getString(7),

							cursor.getString(8),
							cursor.getString(9)
					);
					item.setFile(cursor.getString(10));
					result.add(item);
					cursor.moveToNext();
				}
			}
			cursor.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}


}
