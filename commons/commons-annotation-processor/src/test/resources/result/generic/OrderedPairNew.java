package com.lh.commons.annotationprocessor.value;

import com.lh.commons.annotationprocessor.OrderedPair;
import java.lang.String;
import java.util.List;
import lombok.Data;

@Data
public class OrderedPairNew<K, V extends String> {
  private List<K> b;

  private K key;

  private V value;

  private List<String> a;

  public OrderedPair assignTo(OrderedPair entity) {
    entity.setB(b);
    entity.setKey(key);
    entity.setValue(value);
    entity.setA(a);
    return entity;
  }

  public OrderedPair patchTo(OrderedPair entity) {
    if (b != null ) {
      entity.setB(b);
    }
    if (key != null ) {
      entity.setKey(key);
    }
    if (value != null ) {
      entity.setValue(value);
    }
    if (a != null ) {
      entity.setA(a);
    }
    return entity;
  }

  public OrderedPairNew from(OrderedPair entity) {
    OrderedPairNew dto = new OrderedPairNew();
    dto.setB(b);
    dto.setKey(key);
    dto.setValue(value);
    dto.setA(a);
    return dto;
  }
}
