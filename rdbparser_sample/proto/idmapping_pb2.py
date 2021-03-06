# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: idmapping.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf.internal import enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='idmapping.proto',
  package='datacenter',
  syntax='proto3',
  serialized_options=_b('\n com.sogo.bigdata.rdbparser.protoB\016IdMappingProto'),
  serialized_pb=_b('\n\x0fidmapping.proto\x12\ndatacenter\":\n\x07IdBrief\x12 \n\x04type\x18\x01 \x01(\x0e\x32\x12.datacenter.IdType\x12\r\n\x05value\x18\x02 \x01(\t*6\n\x06IdType\x12\x0e\n\nID_UNKNOWN\x10\x00\x12\x08\n\x04\x41\x41ID\x10\x01\x12\x08\n\x04\x42\x42ID\x10\x02\x12\x08\n\x04\x43\x43ID\x10\x03\x42\x32\n com.sogo.bigdata.rdbparser.protoB\x0eIdMappingProtob\x06proto3')
)

_IDTYPE = _descriptor.EnumDescriptor(
  name='IdType',
  full_name='datacenter.IdType',
  filename=None,
  file=DESCRIPTOR,
  values=[
    _descriptor.EnumValueDescriptor(
      name='ID_UNKNOWN', index=0, number=0,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='AAID', index=1, number=1,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='BBID', index=2, number=2,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='CCID', index=3, number=3,
      serialized_options=None,
      type=None),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=91,
  serialized_end=145,
)
_sym_db.RegisterEnumDescriptor(_IDTYPE)

IdType = enum_type_wrapper.EnumTypeWrapper(_IDTYPE)
ID_UNKNOWN = 0
AAID = 1
BBID = 2
CCID = 3



_IDBRIEF = _descriptor.Descriptor(
  name='IdBrief',
  full_name='datacenter.IdBrief',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='type', full_name='datacenter.IdBrief.type', index=0,
      number=1, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='value', full_name='datacenter.IdBrief.value', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=31,
  serialized_end=89,
)

_IDBRIEF.fields_by_name['type'].enum_type = _IDTYPE
DESCRIPTOR.message_types_by_name['IdBrief'] = _IDBRIEF
DESCRIPTOR.enum_types_by_name['IdType'] = _IDTYPE
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

IdBrief = _reflection.GeneratedProtocolMessageType('IdBrief', (_message.Message,), {
  'DESCRIPTOR' : _IDBRIEF,
  '__module__' : 'idmapping_pb2'
  # @@protoc_insertion_point(class_scope:datacenter.IdBrief)
  })
_sym_db.RegisterMessage(IdBrief)


DESCRIPTOR._options = None
# @@protoc_insertion_point(module_scope)
