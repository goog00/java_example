package com.example.java8.filter_slice;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class FilterSliceTest {

    List<Post> posts;

    @Before
    public void setUp(){
        posts = new ArrayList<>();

        posts.add(new Post("Java 8 is jammed packed with some cool",
                "java 8, eclipse", 459));
        posts.add(new Post("The Date-Time package introduced in the Java SE 8",
                "java 8, date time api", 750));
        posts.add(new Post("Prefer empty collection to null is a basic",
                "clean code, java", 245));
        posts.add(new Post("Screencast #1: Intro to filtering collections",
                "java, java tutorial, guava", 1234));
        posts.add(new Post("Screencast #2: Intro to transforming objects",
                "java, java tutorial", 9483));
    }

    @Test
    public void filter_with_predicate(){
        List<Post> postWithLesThan500 = posts.stream().filter(p->p.wordlength < 500).collect(Collectors.toList());
        assertEquals(2, postWithLesThan500.size());
    }

    @Test
    public void filter_unique_elements(){

        List<String> tags = posts.stream().map(Post::getDescription).flatMap(tag-> Arrays.stream(tag.split(",")).map(String::trim)).map(String::toLowerCase)
                .map(Object::toString)
                .distinct()
                .collect(Collectors.toList());

        tags.forEach(System.out::println);

    }

    @Test
    public void filter_and_truncate(){
        List<Post> firstTwoPosts = posts.stream().limit(2).collect(Collectors.toList());
        System.out.println(firstTwoPosts.size());

    }


    @Test
    public void skipping_elements(){
        List<Post> firstTwoPosts = posts.stream().skip(4)
                .collect(Collectors.toList());
        System.out.println(firstTwoPosts);
    }



    class Post{
        String description;
        String tags;
        int wordlength;

        public Post(String description, String tags, int wordlength) {
            this.description = description;
            this.tags = tags;
            this.wordlength = wordlength;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public int getWordlength() {
            return wordlength;
        }

        public void setWordlength(int wordlength) {
            this.wordlength = wordlength;
        }

        @Override
        public String toString() {
            return "Post{" +
                    "description='" + description + '\'' +
                    ", tags='" + tags + '\'' +
                    ", wordlength=" + wordlength +
                    '}';
        }
    }
}