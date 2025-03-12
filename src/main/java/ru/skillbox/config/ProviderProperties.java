package ru.skillbox.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProviderProperties {

    @Value("${contacts.profile:default}")
    private String profile;

    @Value("${contacts.storage.loaderFileName}")
    private String loaderFileName;

    @Value("${contacts.storage.saverFileName}")
    private String saverFileName;

    public String getLoaderFileName() {
        return loaderFileName;
    }

    public String getSaverFileName() {
        return saverFileName;
    }

    public String getProfile() {
        return profile;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProviderProperties={");
        sb.append("loaderFileName='").append(loaderFileName).append('\'');
        sb.append(", saverFileName='").append(saverFileName).append('\'');
        sb.append(", profile='").append(profile).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
