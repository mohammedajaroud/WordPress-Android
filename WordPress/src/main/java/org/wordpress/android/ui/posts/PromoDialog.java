package org.wordpress.android.ui.posts;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import org.wordpress.android.R;
import org.wordpress.android.widgets.WPTextView;

public class PromoDialog extends AppCompatDialogFragment {
    protected int mButtonPositiveId;
    protected int mDescriptionId;
    protected int mDrawableId;
    protected int mTitleId;

    public static PromoDialog newInstance(int drawableId, int titleId, int descriptionId, int buttonPositiveId) {
        PromoDialog fragment = new PromoDialog();
        Bundle args = new Bundle();
        args.putInt("drawableId", drawableId);
        args.putInt("titleId", titleId);
        args.putInt("descriptionId", descriptionId);
        args.putInt("buttonPositiveId", buttonPositiveId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        mDrawableId = getArguments().getInt("drawableId");
        mTitleId = getArguments().getInt("titleId");
        mDescriptionId = getArguments().getInt("descriptionId");
        mButtonPositiveId = getArguments().getInt("buttonPositiveId");
        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.promo_dialog, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn = (Button) view.findViewById(R.id.promo_dialog_button_positive);
        btn.setText(mButtonPositiveId);
        ImageView image = (ImageView) view.findViewById(R.id.promo_dialog_image);
        image.setImageResource(mDrawableId);
        WPTextView title = (WPTextView) view.findViewById(R.id.promo_dialog_title);
        title.setText(mTitleId);
        WPTextView desc = (WPTextView) view.findViewById(R.id.promo_dialog_description);
        desc.setText(mDescriptionId);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().cancel();
            }
        });
    }
}
