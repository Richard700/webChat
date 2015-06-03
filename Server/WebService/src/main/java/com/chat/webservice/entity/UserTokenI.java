package com.chat.webservice.entity;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by vlad
 * Date: 03.06.15_16:59
 */
@JsonSerialize(as = UserToken.class)
public interface UserTokenI {

    @JsonProperty("token")
    String getToken();

}
