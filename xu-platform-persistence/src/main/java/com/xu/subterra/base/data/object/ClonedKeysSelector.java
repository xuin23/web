package com.xu.subterra.base.data.object;

import java.util.Set;

public class ClonedKeysSelector {
    private final Set<String> includeKeys;
    private final Set<String> excludeKeys;
    private final boolean includeAllCustomFields;

    public ClonedKeysSelector(Set<String> includeKeys, Set<String> excludeKeys, boolean includeAllCustomFields) {
        this.includeKeys = includeKeys;
        this.excludeKeys = excludeKeys;
        this.includeAllCustomFields = includeAllCustomFields;
    }

    public boolean isIncluded(String key, boolean isCustom) {
        if (isCustom && this.includeAllCustomFields) {
            return true;
        } else if (this.includeKeys != null) {
            if (this.excludeKeys != null) {
                return this.includeKeys.contains(key) && !this.excludeKeys.contains(key);
            } else {
                return this.includeKeys.contains(key);
            }
        } else if (this.excludeKeys != null) {
            return !this.excludeKeys.contains(key);
        } else {
            return true;
        }
    }
}