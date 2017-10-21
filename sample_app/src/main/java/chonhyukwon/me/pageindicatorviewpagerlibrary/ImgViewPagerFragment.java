package chonhyukwon.me.pageindicatorviewpagerlibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImgViewPagerFragment extends Fragment {
    private static final String KEY_ARG_IMG = " key_arg_img_uri";

    private ImageView mImageView;

    public static Fragment instance(String imgSrc) {
        Bundle args = new Bundle();
        args.putString(KEY_ARG_IMG, imgSrc);
        Fragment frag = new ImgViewPagerFragment();
        frag.setArguments(args);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        mImageView = (ImageView) inflater
                .inflate(R.layout.fragment_img_view_pager_simple, container, false);
        initiateData();
        return mImageView;
    }

    private void initiateData() {
        if (getArguments() == null) return;
        String imgSrc = getArguments().getString(KEY_ARG_IMG);
        Glide.with(this)
                .load(imgSrc)
                .into(mImageView);
    }
}
