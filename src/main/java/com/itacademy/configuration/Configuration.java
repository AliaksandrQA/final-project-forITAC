package com.itacademy.configuration;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(
        {
                "system:properties",
                "file:config.properties",
                "system:env"
        }
)
public interface Configuration extends Config {
    @Key("USER_NAME")
    String username();

    @Key("PASSWORD")
    String password();

    @Key("BASE_API_URL")
    String baseApiUrl();

    @Key("BASE_UI_URL")
    String baseUiUrl();


}
