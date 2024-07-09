package com.github.danilodequeiroz.gradlefundamentals;

import org.gradle.api.artifacts.CacheableRule;
import org.gradle.api.artifacts.ComponentMetadataContext;
import org.gradle.api.artifacts.ComponentMetadataRule;

/**
 * If you run the ':dependencies' task and you see something weird in there, which you didn't expect, and
 * then find out that the metadata of one component is not as it should be, you can use such rules to adjust it.
 */

@CacheableRule
public class Slf4jSimpleRule implements ComponentMetadataRule {
    @Override
    public void execute(ComponentMetadataContext componentMetadataContext) {
        componentMetadataContext.getDetails().allVariants(variantMetadata ->
                variantMetadata.withDependencies(dependencyMetadata ->
                        dependencyMetadata.removeIf(directDependencyMetadata ->
                                directDependencyMetadata.getName().equals("slf4j-api")
                        )
                )
        );

    }
}
