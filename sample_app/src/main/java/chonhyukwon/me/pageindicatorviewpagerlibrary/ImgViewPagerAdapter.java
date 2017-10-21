package chonhyukwon.me.pageindicatorviewpagerlibrary;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"WeakerAccess", "SameParameterValue"})
public class ImgViewPagerAdapter extends FragmentStatePagerAdapter {
    final private List<String> mImgSrcArr = new ArrayList<>();

    public ImgViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ImgViewPagerFragment.instance(mImgSrcArr.get(position));
    }

    public void addData(List<String> data) {
        addData(data, false);
    }

    public void addData(List<String> data, boolean clearData) {
        if (clearData) {
            mImgSrcArr.clear();
        }
        mImgSrcArr.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mImgSrcArr.size();
    }
}
