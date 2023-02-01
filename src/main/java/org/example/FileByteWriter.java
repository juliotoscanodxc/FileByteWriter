package org.example;


import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class FileByteWriter {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void executeWithBufferOutput() throws IOException {
        byte[] bytes = new byte[100_000_000];
        Random random = new Random(0);
        random.nextBytes(bytes);
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("bytes.bin"))) {
            stream.write(bytes);
        } catch (IOException e) {
            System.out.println("Error writing bytes to file: " + e.getMessage());
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void executeWithNIO() throws IOException {
        byte[] bytes = new byte[100_000_000];
        Random random = new Random(0);
        random.nextBytes(bytes);
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("bytes.bin", "rw")) {
            FileChannel channel = randomAccessFile.getChannel();
            channel.write(ByteBuffer.wrap(bytes));
        } catch (IOException e) {
            System.out.println("Error writing bytes to file: " + e.getMessage());
        }
    }
}
