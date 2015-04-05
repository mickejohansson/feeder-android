package org.mikaeljohansson.feeder.model;

import java.util.Collection;

public class FeedRepository {

    private static FeedRepository sInstance;

    private FeedRepository() {
    }

    public static FeedRepository getInstance() {
        if (sInstance == null) {
           sInstance = new FeedRepository();
        }

        return sInstance;
    }

    public interface GetAllPostsCallback {
        void onAllPostsLoaded(Collection<Post> postCollection);
        void onError(ErrorBundle error);
    }

    public void getAllPosts(GetAllPostsCallback getAllPostsCallback) {

    }
}
