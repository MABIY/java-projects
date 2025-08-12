package com.lh.mapenum;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author lh
 */
@Mapper
public interface TargetStructMapper {
    TargetStructMapper INSTANCE = Mappers.getMapper(TargetStructMapper.class);

    @Mapping(target = "productCategory", expression = "java(TargetObject.ProductCategory.from(sourceObject.getProductCategory()))")
    TargetObject from(SourceObject sourceObject);
}
