package githubzzx752904457.com.demo.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import githubzzx752904457.com.demo.R;

/**
 * Created by admin on 2016/9/20.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private int[] images = {R.mipmap.a0, R.mipmap.a1, R.mipmap.a2};
    private Context context;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position % images.length]);
        ((ViewPager) container).addView(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }


    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
