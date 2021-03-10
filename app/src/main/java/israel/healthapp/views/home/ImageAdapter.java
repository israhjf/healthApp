package israel.healthapp.views.home;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import israel.healthapp.R;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;

    public ImageAdapter(Context c) {
        context = c;
    }

    public int getCount() {
        return thumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(130, 130));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 20, 5, 20);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(thumbIds[position]);
        return imageView;
    }

    private Integer[] thumbIds = {
            R.drawable.home_1, R.drawable.weight_scale,
            R.drawable.list_1, R.drawable.chart_bars,
            R.drawable.cutlery_1, R.drawable.calendar_grid_1,
            R.drawable.athletics, R.drawable.stretching,
            R.drawable.bulb_1, R.drawable.gear,
            R.drawable.alert_que
    };
}