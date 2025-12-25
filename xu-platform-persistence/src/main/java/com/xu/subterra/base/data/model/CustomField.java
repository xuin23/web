package com.xu.subterra.base.data.model;

import org.w3c.dom.Element;

import java.io.Serializable;
import java.util.*;

public final class CustomField implements ICustomField, Serializable {

    private static final String ATTR_ID = "id";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_DESCRIPTION = "description";
    private static final String ATTR_MAPPING = "mapping";
    private static final String ATTR_DEPENDS_ON = "dependsOn";
    private static final String ATTR_TYPE = "type";
    private static final String ATTR_MULTI = "multi";
    private static final String ATTR_REQUIRED = "required";
    private static final String ATTR_DEFAULT = "default";
    public static final String LIST_SUFFIX = "List";
    private final String id;
    private final IType type;
    private final String name;
    private final String descr;
    private final String dependsOn;
    private final String mappingId;
    private final boolean required;
    private final Object defaultValue;
    private final IFieldMappingObtainer mappingObtainer;
    private Set<String> dependingFields;

    public static ICustomField parseField(Element option, IDefaultValueObtainer obtainer) {
        return parseField(option, obtainer, (String) null);
    }

    public static ICustomField parseField(Element option, IDefaultValueObtainer obtainer, String keyInfo) {
        return parseField(option, obtainer, (IFieldMappingObtainer) null, keyInfo);
    }

    public static ICustomField parseField(Element option, IDefaultValueObtainer obtainer, IFieldMappingObtainer mappingObtainer, String keyInfo) {
        return parseField(option, obtainer, mappingObtainer, keyInfo, (IType) null);
    }

    public static ICustomField parseField(Element option, IDefaultValueObtainer obtainer, IFieldMappingObtainer mappingObtainer, String keyInfo, IType type) {
        return null;
    }

    private static IType parseType(String typeAttr, String multiAttr, String id, String keyInfo) {
        return null;
    }

    public CustomField(String id, IType type, String name, String descr, boolean required, Object defaultValue) {
        this(id, type, name, descr, (String) null, (String) null, (IFieldMappingObtainer) null, required, defaultValue);
    }

    public CustomField(String id, IType type, String name, String descr, String dependsOn, String mappingId, IFieldMappingObtainer mappingObtainer, boolean required, Object defaultValue) {
        this.dependingFields = new HashSet();
        this.id = id;
        this.type = type;
        this.name = name;
        this.descr = descr;
        this.dependsOn = dependsOn;
        this.mappingId = mappingId;
        this.mappingObtainer = mappingObtainer;
        this.required = required;
        this.defaultValue = defaultValue;
    }

    public String getId() {
        return this.id;
    }

    public IType getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.descr;
    }


    public CustomField asPlainText() {
        return this;
    }


    public CustomField asConflicted() {
        String fieldId = "*Conflicting*" + this.getId();
        return new CustomField(fieldId, this.getType(), "*Conflicting*" + this.getName(), this.getDescription(), this.getDependsOn(), this.mappingId, (IFieldMappingObtainer) null, this.isRequired(), this.getDefaultValue());
    }


    public String getDependsOn() {
        return this.dependsOn;
    }


    public Collection<String> getDependentFieldIds() {
        return this.dependingFields;
    }

    public void addDependingField(String fieldId) {
        this.dependingFields.add(fieldId);
    }


    public IRelationMapping getDependencyMapping() {
        return this.mappingObtainer != null ? this.mappingObtainer.obtainFieldMapping(this.type, this.mappingId) : null;
    }


    public IFieldMappingObtainer getDependencyMappingObtainer() {
        return this.mappingObtainer;
    }

    public boolean isRequired() {
        return this.required;
    }

    public boolean isMulti() {
        return this.type instanceof IListType;
    }

    public boolean isReference() {
        return this.type instanceof IReferenceType;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public String toString() {
        return this.id + "[type=" + this.type + "]";
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ICustomField) {
            ICustomField customField = (ICustomField) obj;
            if (this.id.equals(customField.getId())) {
                return true;
            }
        }

        return false;
    }

    public interface IDefaultValueObtainer {
        Object obtainDefaultValue(String var1, IType var2);
    }

    public interface IFieldMappingObtainer {

        IRelationMapping obtainFieldMapping(IType var1, String var2);
    }
}
