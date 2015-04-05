package org.mikaeljohansson.feeder.domain;

import org.mikaeljohansson.feeder.model.ErrorBundle;
import org.mikaeljohansson.feeder.model.FeedRepository;
import org.mikaeljohansson.feeder.model.Post;

import java.util.Collection;

public class GetPosts implements FeedRepository.GetAllPostsCallback {

    private GetPostsCallback mCallback;
    FeedRepository mFeedRepository;

    public GetPosts() {
        // TODO: handle this with injection?
        mFeedRepository = FeedRepository.getInstance();
    }

    public void run(GetPostsCallback callback) {
        mCallback = callback;
        mFeedRepository.getAllPosts(this);
    }

    @Override
    public void onAllPostsLoaded(Collection<Post> posts) {
        mCallback.onPostsLoaded(posts);
    }

    @Override
    public void onError(ErrorBundle errorBundle) {
        mCallback.onError(errorBundle);
    }

    public interface GetPostsCallback {
        void onPostsLoaded(Collection<Post> posts);
        void onError(ErrorBundle errorBundle);
    }
}
