// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: idmapping.proto

package com.sogo.rdbparser.proto;

public final class IdMappingProto {
  private IdMappingProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * <pre>
   * 目前支持的userid类型，详见wiki
   * </pre>
   *
   * Protobuf enum {@code datacenter.IdType}
   */
  public enum IdType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>ID_UNKNOWN = 0;</code>
     */
    ID_UNKNOWN(0),
    /**
     * <code>AAID = 1;</code>
     */
    AAID(1),
    /**
     * <code>BBID = 2;</code>
     */
    BBID(2),
    /**
     * <code>CCID = 3;</code>
     */
    CCID(3),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>ID_UNKNOWN = 0;</code>
     */
    public static final int ID_UNKNOWN_VALUE = 0;
    /**
     * <code>AAID = 1;</code>
     */
    public static final int AAID_VALUE = 1;
    /**
     * <code>BBID = 2;</code>
     */
    public static final int BBID_VALUE = 2;
    /**
     * <code>CCID = 3;</code>
     */
    public static final int CCID_VALUE = 3;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static IdType valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static IdType forNumber(int value) {
      switch (value) {
        case 0: return ID_UNKNOWN;
        case 1: return AAID;
        case 2: return BBID;
        case 3: return CCID;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<IdType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        IdType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<IdType>() {
            public IdType findValueByNumber(int number) {
              return IdType.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return IdMappingProto.getDescriptor().getEnumTypes().get(0);
    }

    private static final IdType[] VALUES = values();

    public static IdType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private IdType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:datacenter.IdType)
  }

  public interface IdBriefOrBuilder extends
      // @@protoc_insertion_point(interface_extends:datacenter.IdBrief)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * the type of id
     * </pre>
     *
     * <code>.datacenter.IdType type = 1;</code>
     * @return The enum numeric value on the wire for type.
     */
    int getTypeValue();
    /**
     * <pre>
     * the type of id
     * </pre>
     *
     * <code>.datacenter.IdType type = 1;</code>
     * @return The type.
     */
    IdMappingProto.IdType getType();

    /**
     * <pre>
     * the value of id
     * </pre>
     *
     * <code>string value = 2;</code>
     * @return The value.
     */
    java.lang.String getValue();
    /**
     * <pre>
     * the value of id
     * </pre>
     *
     * <code>string value = 2;</code>
     * @return The bytes for value.
     */
    com.google.protobuf.ByteString
        getValueBytes();
  }
  /**
   * Protobuf type {@code datacenter.IdBrief}
   */
  public  static final class IdBrief extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:datacenter.IdBrief)
      IdBriefOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use IdBrief.newBuilder() to construct.
    private IdBrief(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private IdBrief() {
      type_ = 0;
      value_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new IdBrief();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private IdBrief(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              int rawValue = input.readEnum();

              type_ = rawValue;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              value_ = s;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return IdMappingProto.internal_static_datacenter_IdBrief_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return IdMappingProto.internal_static_datacenter_IdBrief_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              IdMappingProto.IdBrief.class, IdMappingProto.IdBrief.Builder.class);
    }

    public static final int TYPE_FIELD_NUMBER = 1;
    private int type_;
    /**
     * <pre>
     * the type of id
     * </pre>
     *
     * <code>.datacenter.IdType type = 1;</code>
     * @return The enum numeric value on the wire for type.
     */
    public int getTypeValue() {
      return type_;
    }
    /**
     * <pre>
     * the type of id
     * </pre>
     *
     * <code>.datacenter.IdType type = 1;</code>
     * @return The type.
     */
    public IdMappingProto.IdType getType() {
      @SuppressWarnings("deprecation")
      IdMappingProto.IdType result = IdMappingProto.IdType.valueOf(type_);
      return result == null ? IdMappingProto.IdType.UNRECOGNIZED : result;
    }

    public static final int VALUE_FIELD_NUMBER = 2;
    private volatile java.lang.Object value_;
    /**
     * <pre>
     * the value of id
     * </pre>
     *
     * <code>string value = 2;</code>
     * @return The value.
     */
    public java.lang.String getValue() {
      java.lang.Object ref = value_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        value_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * the value of id
     * </pre>
     *
     * <code>string value = 2;</code>
     * @return The bytes for value.
     */
    public com.google.protobuf.ByteString
        getValueBytes() {
      java.lang.Object ref = value_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        value_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (type_ != IdMappingProto.IdType.ID_UNKNOWN.getNumber()) {
        output.writeEnum(1, type_);
      }
      if (!getValueBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, value_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (type_ != IdMappingProto.IdType.ID_UNKNOWN.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, type_);
      }
      if (!getValueBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, value_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof IdMappingProto.IdBrief)) {
        return super.equals(obj);
      }
      IdMappingProto.IdBrief other = (IdMappingProto.IdBrief) obj;

      if (type_ != other.type_) return false;
      if (!getValue()
          .equals(other.getValue())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + type_;
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static IdMappingProto.IdBrief parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static IdMappingProto.IdBrief parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static IdMappingProto.IdBrief parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static IdMappingProto.IdBrief parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static IdMappingProto.IdBrief parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static IdMappingProto.IdBrief parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static IdMappingProto.IdBrief parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static IdMappingProto.IdBrief parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static IdMappingProto.IdBrief parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static IdMappingProto.IdBrief parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static IdMappingProto.IdBrief parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static IdMappingProto.IdBrief parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(IdMappingProto.IdBrief prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code datacenter.IdBrief}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:datacenter.IdBrief)
        IdMappingProto.IdBriefOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return IdMappingProto.internal_static_datacenter_IdBrief_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return IdMappingProto.internal_static_datacenter_IdBrief_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                IdMappingProto.IdBrief.class, IdMappingProto.IdBrief.Builder.class);
      }

      // Construct using com.sogo.bigdata.rdbparser.proto.IdMappingProto.IdBrief.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        type_ = 0;

        value_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return IdMappingProto.internal_static_datacenter_IdBrief_descriptor;
      }

      @java.lang.Override
      public IdMappingProto.IdBrief getDefaultInstanceForType() {
        return IdMappingProto.IdBrief.getDefaultInstance();
      }

      @java.lang.Override
      public IdMappingProto.IdBrief build() {
        IdMappingProto.IdBrief result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public IdMappingProto.IdBrief buildPartial() {
        IdMappingProto.IdBrief result = new IdMappingProto.IdBrief(this);
        result.type_ = type_;
        result.value_ = value_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof IdMappingProto.IdBrief) {
          return mergeFrom((IdMappingProto.IdBrief)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(IdMappingProto.IdBrief other) {
        if (other == IdMappingProto.IdBrief.getDefaultInstance()) return this;
        if (other.type_ != 0) {
          setTypeValue(other.getTypeValue());
        }
        if (!other.getValue().isEmpty()) {
          value_ = other.value_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        IdMappingProto.IdBrief parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (IdMappingProto.IdBrief) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int type_ = 0;
      /**
       * <pre>
       * the type of id
       * </pre>
       *
       * <code>.datacenter.IdType type = 1;</code>
       * @return The enum numeric value on the wire for type.
       */
      public int getTypeValue() {
        return type_;
      }
      /**
       * <pre>
       * the type of id
       * </pre>
       *
       * <code>.datacenter.IdType type = 1;</code>
       * @param value The enum numeric value on the wire for type to set.
       * @return This builder for chaining.
       */
      public Builder setTypeValue(int value) {
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * the type of id
       * </pre>
       *
       * <code>.datacenter.IdType type = 1;</code>
       * @return The type.
       */
      public IdMappingProto.IdType getType() {
        @SuppressWarnings("deprecation")
        IdMappingProto.IdType result = IdMappingProto.IdType.valueOf(type_);
        return result == null ? IdMappingProto.IdType.UNRECOGNIZED : result;
      }
      /**
       * <pre>
       * the type of id
       * </pre>
       *
       * <code>.datacenter.IdType type = 1;</code>
       * @param value The type to set.
       * @return This builder for chaining.
       */
      public Builder setType(IdMappingProto.IdType value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        type_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * the type of id
       * </pre>
       *
       * <code>.datacenter.IdType type = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearType() {
        
        type_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object value_ = "";
      /**
       * <pre>
       * the value of id
       * </pre>
       *
       * <code>string value = 2;</code>
       * @return The value.
       */
      public java.lang.String getValue() {
        java.lang.Object ref = value_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          value_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * the value of id
       * </pre>
       *
       * <code>string value = 2;</code>
       * @return The bytes for value.
       */
      public com.google.protobuf.ByteString
          getValueBytes() {
        java.lang.Object ref = value_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          value_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * the value of id
       * </pre>
       *
       * <code>string value = 2;</code>
       * @param value The value to set.
       * @return This builder for chaining.
       */
      public Builder setValue(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        value_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * the value of id
       * </pre>
       *
       * <code>string value = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearValue() {
        
        value_ = getDefaultInstance().getValue();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * the value of id
       * </pre>
       *
       * <code>string value = 2;</code>
       * @param value The bytes for value to set.
       * @return This builder for chaining.
       */
      public Builder setValueBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        value_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:datacenter.IdBrief)
    }

    // @@protoc_insertion_point(class_scope:datacenter.IdBrief)
    private static final IdMappingProto.IdBrief DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new IdMappingProto.IdBrief();
    }

    public static IdMappingProto.IdBrief getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<IdBrief>
        PARSER = new com.google.protobuf.AbstractParser<IdBrief>() {
      @java.lang.Override
      public IdBrief parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new IdBrief(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<IdBrief> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<IdBrief> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public IdMappingProto.IdBrief getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_datacenter_IdBrief_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_datacenter_IdBrief_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017idmapping.proto\022\ndatacenter\":\n\007IdBrief" +
      "\022 \n\004type\030\001 \001(\0162\022.datacenter.IdType\022\r\n\005va" +
      "lue\030\002 \001(\t*6\n\006IdType\022\016\n\nID_UNKNOWN\020\000\022\010\n\004A" +
      "AID\020\001\022\010\n\004BBID\020\002\022\010\n\004CCID\020\003B2\n com.sogo.bi" +
      "gdata.rdbparser.protoB\016IdMappingProtob\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_datacenter_IdBrief_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_datacenter_IdBrief_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_datacenter_IdBrief_descriptor,
        new java.lang.String[] { "Type", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
