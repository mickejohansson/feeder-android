package org.mikaeljohansson.feeder.presentation.presenter;

import org.mikaeljohansson.feeder.model.Post;

import java.util.Collection;

public class FeedListPresenter extends Presenter {

    public FeedListPresenter(FeedListView feedListView) {
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStop() {

    }

    public interface FeedListView {
        void showPosts(Collection<Post> posts);
    }
}
