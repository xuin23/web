package com.xu.platform.persistence.model;

import com.xu.subterra.base.data.model.IType;

import java.util.Collection;

public interface IPrototype extends IPObject {
    String PROTO = "Prototype";
    String COLLECTION_KEY = "LIST";
    String KEY_NAME = "name";
    String KEY_SUPERTYPES = "supertypes";
    String KEY_INSTANCE_READONLY = "instanceReadOnly";
    String KEY_VERSIONED = "versioned";
    String KEY_ALLOWS_CUSTOM_FIELDS = "allowsCustomFields";
    String KEY_KEYS = "keys";
    String KEY_KEY_NAME = "name";
    String KEY_KEY_READONLY = "readOnly";
    String KEY_KEY_REQUIRED = "required";
    String KEY_KEY_TYPE = "type";
    String KEY_KEY_NOT_CACHED = "notCached";
    String KEY_ANNOTATIONS = "annotations";
    String KEY_ANNOTATION_NAME = "name";
    String KEY_ANNOTATION_VALUES = "values";
    String TYPE_SUPERTYPES_LIST = "PrototypeSupertypesList";
    String TYPE_KEYS_LIST = "PrototypeKeysList";
    String TYPE_ANNOTATIONS_LIST = "PrototypeAnnotationsList";
    String TYPE_ANNOTATIONS_VALUES_LIST = "PrototypeAnnotationsValuesList";
    String TYPE_KEY_STRUCT = "PrototypeKeyStruct";
    String TYPE_ANNOTATION_STRUCT = "PrototypeAnotationStruct";

    String getName();

    String getLabel();

    Collection getSupertypes();

    boolean isEachInstanceReadOnly();

    boolean allowsCustomFields();

    Collection getKeyNames();

    Collection getNonInheritedKeyNames();

    boolean isKeyDefined(String var1);

    boolean isKeyNonInherited(String var1);

    IPrototype getPrototypeDefiningKey(String var1);

    IType getKeyType(String var1);

    boolean isKeyRequired(String var1);

    boolean isKeyReadOnly(String var1);

    String getPrimaryKey();

    boolean isPrimaryKey(String var1);

    boolean canKeyBeCached(String var1);

    boolean isVersioned();

    /** @deprecated */
    @Deprecated
    Collection getAnotationKeys();

    Collection getAnnotationKeys();

    Collection getAnnotationValues(String var1);

    String getAnnotationValue(String var1);
}
