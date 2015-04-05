package org.mikaeljohansson.feeder.presentation.presenter;

import org.mikaeljohansson.feeder.domain.GetPosts;
import org.mikaeljohansson.feeder.model.ErrorBundle;
import org.mikaeljohansson.feeder.model.Post;

import java.util.Collection;

public class FeedListPresenter extends Presenter implements GetPosts.GetPostsCallback {

    private final FeedListView mView;

    public FeedListPresenter(FeedListView feedListView) {
        mView = feedListView;
    }

    @Override
    public void onCreate() {
        loadAllPosts();
    }

    @Override
    public void onStop() {
        //TODO: If this has been called, don't pass anything back to the view
    }

    private void loadAllPosts() {
        GetPosts getPosts = new GetPosts();
        getPosts.run(this);
    }

    @Override
    public void onPostsLoaded(Collection<Post> posts) {
        mView.showPosts(posts);
    }

    @Override
    public void onError(ErrorBundle errorBundle) {
        //TODO: Display error
    }

    public interface FeedListView {
        void showPosts(Collection<Post> posts);
    }
}
