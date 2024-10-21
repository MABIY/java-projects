package com.lh.commons.annotationprocessor;

import com.fasterxml.jackson.annotation.JsonView;
import com.lh.commons.annotation.AutoValueDTO;
import com.lh.commons.annotation.Views;
import lombok.Data;

import java.util.List;

/**
 * @author lh
 */
@AutoValueDTO
@Data
public class OrderedPair<K,V extends String> extends Box<K> implements Pair<K,V> {
    @JsonView(value = Views.New.class)
    private K key;
    @JsonView(value = Views.New.class)
    private V value;

    @JsonView(value = Views.New.class)
    private List<String> a;

    @JsonView(value = Views.New.class)
    private List<K> b;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }

}
