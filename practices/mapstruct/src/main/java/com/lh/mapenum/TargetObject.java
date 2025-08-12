package com.lh.mapenum;

import lombok.Data;
import lombok.Getter;

/**
 * @author lh
 */
@Data
public class TargetObject {
    private String name;
    private ProductCategory productCategory;

    @Getter
    public enum ProductCategory {
        CHOROBOX("choro-box"){
            @Override
            public String desc() {
                return "测试";
            }
        };

        ProductCategory(String value) {
            this.value = value;
        }

        private String value;

        public abstract String desc();

        public static ProductCategory from(String a) {
            return CHOROBOX;
        }
    }

}
