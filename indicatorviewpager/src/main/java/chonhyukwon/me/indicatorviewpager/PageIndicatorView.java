package chonhyukwon.me.indicatorviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

@SuppressWarnings("unused")
public class PageIndicatorView extends LinearLayout {
    private int mIndicatorImg;
    private int mCurrPage;
    private int mTotalPageCnt;
    private int mDimen;

    public PageIndicatorView(Context context) {
        this(context, null);
    }

    public PageIndicatorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageIndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PageIndicatorView, defStyleAttr, 0);
        int defaultDimen = getResources().getDimensionPixelSize(R.dimen.indicator_space);
        mDimen = a.getDimensionPixelOffset(R.styleable.PageIndicatorView_spacing, defaultDimen);
        mIndicatorImg = a.getInt(R.styleable.PageIndicatorView_imgSrc, R.drawable.slide_indicator);
        setOrientation(HORIZONTAL);
        a.recycle();
    }

    @Nullable @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        PageIndicatorViewSavedState ss = new PageIndicatorViewSavedState(superState);
        //end
        ss.mCurrPage = mCurrPage;
        ss.mIndicatorImg = mIndicatorImg;
        ss.mTotalPageCnt = mTotalPageCnt;

        return ss;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        PageIndicatorViewSavedState ss = (PageIndicatorViewSavedState) state;
        mIndicatorImg = ss.mIndicatorImg;
        mCurrPage = ss.mCurrPage;
        super.onRestoreInstanceState(ss.getSuperState());
        setTotalPageNumber(ss.mTotalPageCnt);
    }

    public void setTotalPageNumber(int totalPageCount) {
        if ( totalPageCount <= 1 ) {
            setVisibility(View.INVISIBLE);
            return;
        }
        setVisibility(View.VISIBLE);
        removeAllViews();
        ImageView imageView;
        LayoutParams lp;
        for ( int i = 0; i < totalPageCount; i++ ) {
            imageView = new ImageView(getContext());
            lp =
                    new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

            if (i != totalPageCount - 1) {
                lp.setMarginEnd(mDimen);
            }
            if (i != 0) {
                lp.setMarginStart(mDimen);
            }

            imageView.setLayoutParams(lp);
            imageView.setImageResource(mIndicatorImg);

            addView(imageView);
        }
        setCurrPageNumber(mCurrPage);
        mTotalPageCnt = totalPageCount;
    }

    public void setCurrPageNumber(int currPageNumber) {
        int childCount = getChildCount();
        if ( currPageNumber >= childCount ) {
            throw new IndexOutOfBoundsException();
        }
        getChildAt(mCurrPage).setSelected(false);
        mCurrPage = currPageNumber;
        getChildAt(mCurrPage).setSelected(true);
    }

    public void setIndicatorImg(int drawableId) {
        mIndicatorImg = drawableId;
    }

    public void setSpacingDimenId(int dimenId) {
        mDimen = getContext().getResources().getDimensionPixelSize(dimenId);
    }

    private static class PageIndicatorViewSavedState extends BaseSavedState {
        Parcelable mSuperState;

        int mIndicatorImg;
        int mCurrPage;
        int mTotalPageCnt;

        PageIndicatorViewSavedState(Parcelable superState) {
            super(EMPTY_STATE);
            mSuperState = superState;
        }

        private PageIndicatorViewSavedState(Parcel in) {
            super(in);
            mSuperState = in.readParcelable(PageIndicatorViewSavedState.class.getClassLoader());
            int[] ints = new int[3];
            in.readIntArray(ints);
            mIndicatorImg = ints[0];
            mCurrPage = ints[1];
            mTotalPageCnt = ints[2];
        }

        @Override public void writeToParcel(Parcel out, int flags) {
            int[] ints = {mIndicatorImg, mCurrPage, mTotalPageCnt};
            out.writeIntArray(ints);
            super.writeToParcel(out, flags);
        }

        //required field that makes Parcelables from a Parcel
        public static final Creator<PageIndicatorViewSavedState> CREATOR =
                new Creator<PageIndicatorViewSavedState>() {
                    public PageIndicatorViewSavedState createFromParcel(Parcel in) {
                        return new PageIndicatorViewSavedState(in);
                    }
                    public PageIndicatorViewSavedState[] newArray(int size) {
                        return new PageIndicatorViewSavedState[size];
                    }
                };
    }
}
