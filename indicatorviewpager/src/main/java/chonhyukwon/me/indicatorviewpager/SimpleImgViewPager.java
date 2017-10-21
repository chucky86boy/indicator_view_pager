package chonhyukwon.me.indicatorviewpager;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class SimpleImgViewPager extends ViewPager {
    private PageIndicatorView mPageIndicatorView;

    public SimpleImgViewPager(Context context) {
        this(context, null);
    }

    public SimpleImgViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        addOnPageChangeListener(new SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                updatePageIndicatorView(position);
            }
        });
    }

    private void updatePageIndicatorView(int position) {
        if (mPageIndicatorView != null) {
            mPageIndicatorView.setCurrPageNumber(position);
        }
    }


    public void setPageIndicatorView(PageIndicatorView pageIndicatorView) {
        mPageIndicatorView = pageIndicatorView;
        setPageIndicatorCnt();
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);
        setPageIndicatorCnt();
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
        updatePageIndicatorView(item);
    }

    private void setPageIndicatorCnt() {
        PagerAdapter adapter = getAdapter();
        if (adapter != null && mPageIndicatorView != null) {
            int cnt = getAdapter().getCount();
            mPageIndicatorView.setTotalPageNumber(cnt);
            adapter.registerDataSetObserver(new DataSetObserver() {
                @Override
                public void onChanged() {
                    super.onChanged();
                    PagerAdapter adapter = SimpleImgViewPager.this.getAdapter();
                    mPageIndicatorView.setTotalPageNumber(adapter.getCount());
                }
            });
        }
    }
}
