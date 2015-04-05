package org.mikaeljohansson.feeder.model;

import java.util.Collection;

public class FeedRepository {

    public FeedRepository() {

    }

    public interface GetAllPostsCallback {
        void onAllPostsLoaded(Collection<Post> postCollection);
        void onError(RepositoryError error);
    }

    public void getAllPosts(GetAllPostsCallback getAllPostsCallback) {

    }
}
