package com.lh.mapenum;

/**
 * @author lh
 */
public class Test {
    public static void main(String[] args) {
        TargetObject targetObject = TargetStructMapper.INSTANCE.from(
                SourceObject.builder()
                        .name("liuhua")
                        .productCategory("choro-box")
                        .build());
        System.out.println(targetObject.getProductCategory());
        System.out.println(targetObject.getName());
    }
}
