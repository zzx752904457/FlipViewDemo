package githubzzx752904457.com.demo.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import githubzzx752904457.com.demo.R;

/**
 * Created by admin on 2016/9/20.
 */
public class FliperViewAdapter extends BaseAdapter {
    private Context context;
    private List<TextView> list;

    public FliperViewAdapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fliperview_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.viewPager = (ViewPager) convertView.findViewById(R.id.viewpager);
            viewHolder.tv1 = (TextView) convertView.findViewById(R.id.tv1);
            viewHolder.tv2 = (TextView) convertView.findViewById(R.id.tv2);
            viewHolder.tv3 = (TextView) convertView.findViewById(R.id.tv3);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        list = new ArrayList<>();
        list.add(viewHolder.tv1);
        list.add(viewHolder.tv2);
        list.add(viewHolder.tv3);

        viewHolder.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.viewPager.setCurrentItem(viewHolder.viewPager.getCurrentItem() - viewHolder.viewPager.getCurrentItem() % 3);
            }
        });

        viewHolder.tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.viewPager.setCurrentItem(viewHolder.viewPager.getCurrentItem() - viewHolder.viewPager.getCurrentItem() % 3 + 1);
            }
        });

        viewHolder.tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.viewPager.setCurrentItem(viewHolder.viewPager.getCurrentItem() - viewHolder.viewPager.getCurrentItem() % 3 + 2);
            }
        });
        viewHolder.viewPager.setAdapter(new ViewPagerAdapter(context));
        viewHolder.viewPager.setCurrentItem(1200);
        Log.e("position",viewHolder.viewPager.getCurrentItem()+"" );
        viewHolder.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("po", position+"");
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setTextColor(ContextCompat.getColor(context, R.color.gray));
                }
                list.get(position % 3).setTextColor(ContextCompat.getColor(context, R.color.white));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return convertView;
    }

    class ViewHolder {
        private ViewPager viewPager;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
    }
}
