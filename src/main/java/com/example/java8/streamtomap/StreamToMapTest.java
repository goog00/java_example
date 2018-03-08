package com.example.java8.streamtomap;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToMapTest {

    class Item{
        String key;
        String name;


        public Item(String key, String name) {
            this.key = key;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Item(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    List<Item> items;

    @Before
    public void setUp(){
        items = new ArrayList<>();
        items.add(new Item("ONE","1"));
        items.add(new Item("ONE","2"));
        items.add(new Item("TWO","1"));
        items.add(new Item("THREE","1"));
        items.add(new Item("FOUR","2"));

    }

    @Test
    public void stream_to_map(){
        Map<String,Item> map = items.stream().collect(Collectors.toMap(Item::getKey,item->item,(key1, key2) -> key2));
        System.out.println(map);
    }

    @Test
    public void test(){
        Stream<Locale> locales  = Stream.of (Locale.getAvailableLocales ());
           //将具有相同特性的值群聚成组是非常见的，并且groupingBy方法直接就支持它。
                Map<String,List<Locale>> countryToLocales = locales.collect (
                               Collectors.groupingBy (Locale::getCountry));
              List<Locale> swissLocales = countryToLocales.get ("CH");
               System.out.println (swissLocales);
    }

}