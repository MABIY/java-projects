package com.lh.javabase.string;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author lh
 */
public class PracticeString {
    public static void main(String[] args) {

        // the current JVM's default encoding is UTF-8
        {
            System.out.println(Charset.defaultCharset().displayName());
        }

        // charset uft-32 string encoding bytes length
        {
            Charset UTF_32 = Charset.forName("UTF_32");

            String en = "beautiful";
            assertEquals(9, en.length());
            assertEquals(9 * 4, en.getBytes(UTF_32).length);

            String de = "schöne";
            assertEquals(6, de.length());
            assertEquals(6 * 4, de.getBytes(UTF_32).length);

            String cn = "美丽";
            assertEquals(2, cn.length());
            assertEquals(2 * 4, cn.getBytes(UTF_32).length);
        }
    }
}
