# Demo FileByteWriter using New IO
This is a small project to simulate writing bytes to a file. The goal is to develop an algorithm efficient enough to pass the Java Friday Challenge. 
My idea with this project was to demonstrate how New IO (NIO) is more efficient than using traditional IO (still considering it buffered).

The NIO API was designed to provide high-performance I/O operations by using buffers and channels. It's faster than the traditional way but 
mainly because the follow reasons:
* NIO uses in-memory buffers to store data, eliminating overhead frequently in I/O operations and minimizing the number of system calls.
* Provides non-blocking I/O. It means that the thread is not blocked while waiting for I/O to complete. With this, the utilization of the system 
resources are more efficients and reduce the latency.
* The use of channels to transfer data between buffers and IO devices, allowing multiple I/O operations to be performed in parallel.

Finally, the use of buffers, non-blocking IO and channels in NIO provides more efficient and scalable IO API compared to traditional blocking IO.

To calculate the performance I used Microbenchemarking. This dependency is present in maven and can be easily configured in your application to calculate the performance.
My suggestion is to check in https://www.baeldung.com/java-microbenchmark-harness to more informations.

# Requirements
* Java 8
* Maven 3.10.1

# How to use
You only need execute the classe Benchmark.main() to run the report about the efficient of code. There I marked both codes (NIO and traditional IO) to calculate the
average time and see the result.
