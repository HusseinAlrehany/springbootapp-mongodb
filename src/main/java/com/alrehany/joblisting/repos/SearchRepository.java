package com.alrehany.joblisting.repos;

import com.alrehany.joblisting.models.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);
}
