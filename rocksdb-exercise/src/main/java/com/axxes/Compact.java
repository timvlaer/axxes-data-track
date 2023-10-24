package com.axxes;

import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;

import static com.axxes.LoadData.ROCKSDB_PATH;

public class Compact {

    public static void main(String[] args) {
        // a static method that loads the RocksDB C++ library.
        RocksDB.loadLibrary();

        // the Options class contains a set of configurable DB options
        // that determines the behaviour of the database.
        try (final Options options = new Options()) {

            // a factory method that returns a RocksDB instance
            try (final RocksDB db = RocksDB.open(options, ROCKSDB_PATH)) {
                System.out.println("Existing item count " + db.getLatestSequenceNumber());

                db.compactRange();

            }
        } catch (RocksDBException e) {
            // do some error handling
            System.err.println(e);
        }
    }
}
