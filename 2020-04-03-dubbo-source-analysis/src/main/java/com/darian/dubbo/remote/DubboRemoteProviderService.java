
package com.darian.dubbo.remote;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@DubboService
@ConditionalOnProperty(value = "spring.profiles.active", havingValue = "remote")
@ConditionalOnMissingClass("com.darian.dubbo.remote.MockService")
public class DubboRemoteProviderService implements DubboRemoteInterface {

    @Override
    public String say() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.getClass().getName() + ".say";
    }
}