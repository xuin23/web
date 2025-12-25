//package com.xu.tracker.model;
//
//import com.xu.subterra.base.data.model.*;
//import com.xu.subterra.base.data.model.internal.EnumType;
//import com.xu.subterra.base.data.model.internal.ListType;
//import com.xu.subterra.base.data.model.internal.PrimitiveType;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class TypeFactory {
//
//    private static final TypeFactory instance = new TypeFactory();
//
//    private final Map<String, IStructType> typeName2StructType = new HashMap();
//
//    private final Map<String, IListType> typeName2ListType = new HashMap();
//
//
//    public static TypeFactory getInstance() {
//        return instance;
//    }
//
//    private TypeFactory() {
//    }
//
//
//    public IPrimitiveType getPrimitiveType( Class clazz) {
//        return this.getPrimitiveType((Class)clazz, (String)null);
//    }
//
//
//    public IPrimitiveType getPrimitiveType( String typeName) {
//        return this.getPrimitiveType((String)typeName, (String)null);
//    }
//
//
//    public IPrimitiveType getPrimitiveType( Class clazz,  String subtype) {
//        return new PrimitiveType(clazz.getName(), subtype);
//    }
//
//
//    public IPrimitiveType getPrimitiveType( String typeName,  String subtype) {
//        return new PrimitiveType(typeName, subtype);
//    }
//
//
//    public IListType getListType( String typeId,  IType itemType) {
//        IListType list = new ListType(typeId, itemType);
//        this.typeName2ListType.put(typeId, list);
//        return list;
//    }
//
//
//    public IListType getListType( String typeId) {
//        return (IListType)this.typeName2ListType.get(typeId);
//    }
//
//
//    public IStructType getStructType(String id, Map keys) {
//        return this.getStructType(id, keys, (IStructValueSerializer)null);
//    }
//
//
//    public IStructType getStructType( String id,  Map keys,  IStructValueSerializer serializer) {
//        IStructType struct = new StructType(id, keys, serializer);
//        this.typeName2StructType.put(id, struct);
//        return struct;
//    }
//
//
//    public IStructType getStructType( String id) {
//        return (IStructType)this.typeName2StructType.get(id);
//    }
//
//
//    public IReferenceType getReferenceType( String prototypeName) {
//        return new ReferenceType(prototypeName);
//    }
//
//
//    public IEnumType getEnumType(String enumId) {
//        return new EnumType(enumId);
//    }
//
//    public boolean isBoolean( IType type) {
//        return isPrimitive(type) && Boolean.class.getName().equals(((IPrimitiveType)type).getTypeName());
//    }
//
//    private static boolean isPrimitive( IType type) {
//        return type instanceof IPrimitiveType;
//    }
//}
