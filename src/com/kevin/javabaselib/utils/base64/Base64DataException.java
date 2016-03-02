package com.kevin.javabaselib.utils.base64;

/**
 * Created by bailiangjin on 16/3/2.
 */

import java.io.IOException;

/**
 * This exception is thrown by {@link Base64InputStream} or {@link Base64OutputStream}
 * when an error is detected in the data being decoded.  This allows problems with the base64 data
 * to be disambiguated from errors in the underlying streams (e.g. actual connection errors.)
 */
public class Base64DataException extends IOException {
    public Base64DataException(String detailMessage) {
        super(detailMessage);
    }
}
