package chonhyukwon.me.pageindicatorviewpagerlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;

import chonhyukwon.me.indicatorviewpager.PageIndicatorView;
import chonhyukwon.me.indicatorviewpager.SimpleImgViewPager;
import chonhyukwon.me.indicatorviewpager.SimpleImgViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    public static final String[] DEMO_IMG_URLS = {
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Geomag_snub_dodecahedron.jpg/1600px-Geomag_snub_dodecahedron.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Geomag_snub_dodecahedron.jpg/1600px-Geomag_snub_dodecahedron.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Geomag_snub_dodecahedron.jpg/1600px-Geomag_snub_dodecahedron.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Geomag_snub_dodecahedron.jpg/1600px-Geomag_snub_dodecahedron.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Geomag_snub_dodecahedron.jpg/1600px-Geomag_snub_dodecahedron.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Geomag_snub_dodecahedron.jpg/1600px-Geomag_snub_dodecahedron.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Geomag_snub_dodecahedron.jpg/1600px-Geomag_snub_dodecahedron.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Geomag_snub_dodecahedron.jpg/1600px-Geomag_snub_dodecahedron.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Geomag_snub_dodecahedron.jpg/1600px-Geomag_snub_dodecahedron.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Geomag_snub_dodecahedron.jpg/1600px-Geomag_snub_dodecahedron.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Geomag_snub_dodecahedron.jpg/1600px-Geomag_snub_dodecahedron.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Geomag_snub_dodecahedron.jpg/1600px-Geomag_snub_dodecahedron.jpg"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleImgViewPager simpleViewPager = findViewById(R.id.mPager);
        PageIndicatorView pagerIndicator = findViewById(R.id.mPagerIndicatorView);
        SimpleImgViewPagerAdapter adapter =
                new SimpleImgViewPagerAdapter(getSupportFragmentManager());
        simpleViewPager.setAdapter(adapter);
        adapter.addData(Arrays.asList(DEMO_IMG_URLS));
        simpleViewPager.setPageIndicatorView(pagerIndicator);
    }
}
