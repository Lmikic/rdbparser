package com.sogo.rdbparser.task;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import com.google.protobuf.InvalidProtocolBufferException;
import com.sogo.rdbparser.proto.IdMappingProto;
import net.whitbeck.rdbparser.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.whitbeck.rdbparser.EntryType.KEY_VALUE_PAIR;

public class RdbFileParser {

    private static Logger logger = LoggerFactory.getLogger(RdbFileParser.class);

    public static void printRdbFile(File file) throws Exception {
        RdbParser parser = new RdbParser(file);
        Entry e;
        while ((e = parser.readNext()) != null) {
            switch (e.getType()) {

                case DB_SELECT:
                    System.out.println("Processing DB: " + ((DbSelect)e).getId());
                    System.out.println("------------");
                    break;

                case EOF:
                    System.out.print("End of file. Checksum: ");
                    for (byte b : ((Eof)e).getChecksum()) {
                        System.out.print(String.format("%02x", b & 0xff));
                    }
                    System.out.println();
                    System.out.println("------------");
                    break;

                case KEY_VALUE_PAIR:
                    System.out.println("Key value pair");
                    KeyValuePair kvp = (KeyValuePair)e;
                    System.out.println("Key: " + new String(kvp.getKey(), "ASCII"));
                    if (kvp.hasExpiry()) {
                        System.out.println("Expiry (ms): " + kvp.getExpiryMillis());
                    }
                    System.out.println("Value type: " + kvp.getValueType());
                    System.out.print("Values: ");
                    for (byte[] val : kvp.getValues()) {
                        // System.out.print(new String(val, "ASCII") + " ");
                        System.out.print(new String(val, Charset.forName("UTF-8")) + " ");
                    }
                    System.out.println();
                    System.out.println("------------");
                    break;
            }
        }
    }

    public static void parseIdMappingRdbFile(String rdbFilePath) {
        File rdbFile = new File(rdbFilePath);
        RdbParser parser = null;
        try {
            parser = new RdbParser(rdbFile);
        } catch (IOException e) {
            logger.error("fail to parse rdb file[{}]", rdbFile);
            System.exit(-1);
        }
        Entry parsedRdbEntry = null;
        while (true) {
            try {
                parsedRdbEntry = parser.readNext();
                if (null == parsedRdbEntry) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
            if (parsedRdbEntry.getType().equals(KEY_VALUE_PAIR)) {
                KeyValuePair kvp = (KeyValuePair)parsedRdbEntry;
                List<byte[]> values = kvp.getValues();
                if (null == values || values.size() == 0) {
                    continue;
                }
                int cnt = 0;
                for (byte[] value : values) {
                    cnt ++;
                    IdMappingProto.IdBrief idBrief = null;
                    try {
                        idBrief = IdMappingProto.IdBrief.parseFrom(value);
                    } catch (InvalidProtocolBufferException e) {
                        logger.error("[{}]:fail to deserialize class of IdBrief", cnt);
                        e.printStackTrace();
                        continue;
                    }
                    if (null == idBrief) {
                        logger.error("IdBrief is empty");
                        continue;
                    }
                    String resValue = idBrief.getValue();
                    System.out.println("resValue:" + resValue);
                }
            }
        }
    }

    public static void main(String[] args) {
        if (null == args || args.length < 2) {
            System.out.println("Please input the path of filename.rdb");
            System.exit(-1);
        }
        String rdbFilePath = args[1];
//        String rdbFilePath = "./8001.rdb";
        File file = new File(rdbFilePath);
        try {
            //RdbFileParser.printRdbFile(file);
            RdbFileParser.parseIdMappingRdbFile(rdbFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
