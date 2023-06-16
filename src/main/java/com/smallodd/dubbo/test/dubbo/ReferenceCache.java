package com.smallodd.dubbo.test.dubbo;

import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ReferenceCache {

    private static final ConcurrentMap<String, GenericService> CACHE = new ConcurrentHashMap<>();

    public static GenericService getReference(String registryUrl, String interfaceName) {
        String cacheKey = registryUrl + "#" + interfaceName;

        GenericService reference = CACHE.get(cacheKey);
        if (reference != null) {
            return reference;
        }

        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setRegistry(new RegistryConfig(registryUrl));
        referenceConfig.setInterface(interfaceName);
        referenceConfig.setGeneric(true);

        reference = referenceConfig.get();
        CACHE.put(cacheKey, reference);

        return reference;
    }
}
