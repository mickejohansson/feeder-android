package org.mikaeljohansson.feeder.presentation.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.mikaeljohansson.feeder.R;
import org.mikaeljohansson.feeder.model.Post;

import java.util.ArrayList;
import java.util.Collection;

public class FeedListAdapter extends BaseAdapter {

    private static final long ITEM_ID_POST = 0;

    private final Context mContext;
    private ArrayList<Post> mPosts = new ArrayList<>();

    public FeedListAdapter(Context context) {
        mContext = context.getApplicationContext();
    }

    @Override
    public int getCount() {
        return mPosts.size();
    }

    @Override
    public Object getItem(int position) {
        return mPosts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.feed_list_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.title.setText(mPosts.get(0).getTitle());

        return convertView;
    }

    public void setData(Collection<Post> posts) {
        mPosts = new ArrayList<>(posts);
        notifyDataSetChanged();
    }

    private class ViewHolder {
        public TextView title;
    }
}
