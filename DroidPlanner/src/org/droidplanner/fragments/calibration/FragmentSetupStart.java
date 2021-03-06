package org.droidplanner.fragments.calibration;

import org.droidplanner.fragments.SetupRadioFragment;
import org.droidplanner.fragments.calibration.SetupSidePanel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.droidplanner.R;

public class FragmentSetupStart extends SetupSidePanel {
	
	private TextView textTitle;
	private TextView textDesc;
	private int titleId;
	private int descId;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        final SetupRadioFragment setupFragment = (SetupRadioFragment) getParentFragment();

		final View view = inflater.inflate(R.layout.fragment_setup_panel_start, container, false);

		textTitle = (TextView) view.findViewById(R.id.setupTitle);
		textDesc = (TextView) view.findViewById(R.id.setupDesc);
		
		if(titleId!=0)
			textTitle.setText(titleId);
		if(descId!=0)
			textDesc.setText(descId);

		final Button btnStart = (Button)view.findViewById(R.id.buttonStart);
		btnStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setupFragment != null){
                    setupFragment.doCalibrationStep(1);
                }
            }
        });
		
		return view;
	}

	@Override
	public void updateDescription(int idDescription) {
		this.descId = idDescription;
		if(textDesc!=null)
			textDesc.setText(idDescription);
	}

	@Override
	public void updateTitle(int idTitle) {
		this.titleId = idTitle;
		if(textTitle!=null)
			textTitle.setText(idTitle);
	}

}
