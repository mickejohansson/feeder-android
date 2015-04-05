package org.mikaeljohansson.feeder.presentation.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.mikaeljohansson.feeder.R;
import org.mikaeljohansson.feeder.model.Post;
import org.mikaeljohansson.feeder.presentation.presenter.FeedListPresenter;

import java.util.Collection;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class FeedListActivity extends ActionBarActivity implements FeedListPresenter.FeedListView {

    private FeedListPresenter mFeedListPresenter;

    @InjectView(R.id.feedlistview)
    ListView mListView;

    private FeedListAdapter mFeedListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_list_activity);

        ButterKnife.inject(this);

        mFeedListAdapter = new FeedListAdapter(this);
        mListView.setAdapter(mFeedListAdapter);

        mFeedListPresenter = new FeedListPresenter(this);
        mFeedListPresenter.onCreate();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();

        mFeedListPresenter.onStop();
    }

    @Override
    public void showPosts(Collection<Post> posts) {
        if (posts != null) {
            mFeedListAdapter.setData(posts);
        }
    }
}
