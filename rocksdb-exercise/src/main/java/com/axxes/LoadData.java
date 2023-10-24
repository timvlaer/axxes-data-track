package com.axxes;

import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.rocksdb.Options;

public class LoadData {

    public static final String ROCKSDB_PATH = "/tmp/tst-rocksdb-bla";

    public static void main(String[] args) {
        // a static method that loads the RocksDB C++ library.
        RocksDB.loadLibrary();

        // the Options class contains a set of configurable DB options
        // that determines the behaviour of the database.
        try (final Options options = new Options().setCreateIfMissing(true)) {

            // a factory method that returns a RocksDB instance
            try (final RocksDB db = RocksDB.open(options, ROCKSDB_PATH)) {
                System.out.println("Existing item count " + db.getLatestSequenceNumber());

                for (int i = 0; i < 10000; i++) {
                    var randomKey = "key" + String.format("%02d", Math.round(Math.random() * 100));
                    var randomValue = "value" + Math.round(Math.random() * 1000000);
                    System.out.printf("Putting %s:%s%n", randomKey, randomValue);
                    db.put(randomKey.getBytes(), randomValue.getBytes());
                }

            }
        } catch (RocksDBException e) {
            // do some error handling
            System.err.println(e);
        }
    }
}
