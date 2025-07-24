package chapter2;

import java.io.UnsupportedEncodingException;

/**
 * @author lh
 */
public class Primitive {
    public static void main(String[] args) {
        char c = 'x';
        char b = 'x';

        Character ch = Character.valueOf(c);
        ch = Character.valueOf(c);
        ch = 'x';

        // array element value init null
        String[] array = new String[10];
        for (int i = 0; i < array.length; i++) {
            String value = array[i];
            System.out.println("array " + i + " value: " + value);
        }
        //constructor this class an instance
        Primitive primitive = new Primitive();
    }

    //define a type
    {
        class ATypeName {/* Class body goes here */}
        ATypeName a = new ATypeName();
    }

    //only data type
    {
        class DataOnly {
            int i;
            double d;
            boolean b;
            char c;
            byte bb;
            short ss;
            int ii;
            long ll;
            float ff;
            double dd;

        }
        DataOnly data = new DataOnly();
        data.i = 47;
        data.d = 1.1;
        data.b = false;
//        not initial local variable comment scope
//        {
//            int x;
//            System.out.println(x);
//        }
//        invoke not define method error
//        data.run();
    }

    int storage(String s) throws UnsupportedEncodingException {
        final String interesting = "綠虜雷壟"; // Chinese ideograms
        interesting.length();

// Check length, in characters
        System.out.println(interesting.length()); // prints "4"

// Check encoded sizes
        final byte[] utf8Bytes = interesting.getBytes("UTF-8");
        System.out.println(utf8Bytes.length); // prints "12"

        final byte[] utf16Bytes= interesting.getBytes("UTF-16");
        System.out.println(utf16Bytes.length); // prints "10"

        final byte[] utf32Bytes = interesting.getBytes("UTF-32");
        System.out.println(utf32Bytes.length); // prints "16"

        final byte[] isoBytes = interesting.getBytes("ISO-8859-1");
        System.out.println(isoBytes.length); // prints "4" (probably encoded "????")

        final byte[] winBytes = interesting.getBytes("CP1252");
        System.out.println(winBytes.length); // prints "4" (probably encoded "????")

        //return uft8Bytes length
        return utf8Bytes.length;
    }



}
