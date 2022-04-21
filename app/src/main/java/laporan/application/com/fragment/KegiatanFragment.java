package laporan.application.com.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import laporan.application.com.laporan.MainActivity;
import elapor.application.com.elapor.R;

public class KegiatanFragment extends Fragment {

	public static Button buatlaporan;
	public static ListView listview;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		View rootView = inflater.inflate(R.layout.fragment_kegiatan, container, false);

		buatlaporan = rootView.findViewById(R.id.buatlaporan);
		listview = rootView.findViewById(R.id.listview);

		listview.setAdapter(MainActivity.kegiatanAdapter);

		buatlaporan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((MainActivity) getActivity()).buatLaporanKegiatan();
			}
		});


		return rootView;
	}
}
