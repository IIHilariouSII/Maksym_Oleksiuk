package org.example;

package Utils;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.config.EncoderConfig.encoderConfig;

public class RestWrapper {
    private static final String BASE_URL = "https://api.dropboxapi.com";
    private static final String TOKEN = "sl.BWVxZ1ofZ2wLRMVAURfiv30rySaq8boBdN_NLC-5zU_B8r7-PvodYfMa83cIRy3MxtmiyrQ3kc5xh2CM9DzmPLt03K15J4s-SkBlzweL_n3HKYksy3t62LA16cGNopo3UAQ1EDzc";
    public static RequestSpecification REQ_SPEC = new RequestSpecBuilder()
            .setConfig(RestAssured.config()
                    .encoderConfig(encoderConfig()
                            .appendDefaultContentCharsetToContentTypeIfUndefined(false)))
            .setBaseUri(BASE_URL)
            .setBasePath("/2/files")
            .setAuth(RestAssured.oauth2(TOKEN))
            .build();
}