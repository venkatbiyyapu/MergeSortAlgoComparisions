# Merge Sort Algorithms Comparisions

## Overview

This project implements and compares different variations of the merge sort algorithm with varying thresholds and performance optimizations. It includes six versions of the merge sort algorithm:

1. **mergeSort0**: Basic recursive merge sort.
2. **mergeSort3**: Optimized merge sort using two arrays, alternating between them for recursive steps.
3. **mergeSort4**: Switches to insertion sort for small subarrays (below a threshold) and uses merge sort for larger arrays.
4. **mergeSort5**: Iterative bottom-up merge sort with array swapping for input/output.
5. **mergeSort6**: Combines insertion sort for small subarrays with an iterative bottom-up merge sort for larger subarrays.

## Graph Summary

- **Performance Comparison of Algorithms**:  
  When the threshold is set to 16, mergeSort3 consistently performs better than the other algorithms as the input size increases. MergeSort4 and MergeSort5 show similar effectiveness, while mergeSort6 performs worse, especially for larger inputs.
  
- **mergeSort0 (Choice-0)**:  
  This algorithm shows poor performance as the input size increases, particularly for larger values of N. The execution time grows rapidly with the input size.

- **Threshold Comparison**:  
  For mergeSort4 (Choice-4) and mergeSort6 (Choice-6), different threshold values (16, 32, 64) show varying results. With small inputs, the threshold of 16 performs best, but as input size grows, thresholds of 16 and 64 display similar performance for mergeSort4, while mergeSort6 with a threshold of 16 outperforms other values.

## How to Run the Program

### Requirements:
- **Java**: Make sure you have Java installed on your machine.

### Command Line Usage:

1. **Compile the Java Program**:
   ```
   javac Msort.java
   ```

2. **Run the Program**:
   You can run the program with different inputs for the array size (`n`), the choice of merge sort algorithm (`choice`), and the threshold value (`threshold`). If no values are provided, the defaults will be used.

   Example Command:
   ```
   java Msort [n] [choice] [threshold]
   ```

   - `n`: Size of the array to sort (default = 10000).
   - `choice`: Select the merge sort algorithm:
     - 0: **mergeSort0**
     - 3: **mergeSort3**
     - 4: **mergeSort4**
     - 5: **mergeSort5**
     - 6: **mergeSort6**
   - `threshold`: Threshold for algorithms that switch between insertion and merge sort (only applicable to choice-4 and choice-6).

   Example:
   ```
   java Msort 16000 4 16
   ```

   This will sort an array of size 16,000 using `mergeSort4` with a threshold of 16.

### Program Behavior:
- The program initializes an array of size `n` and runs the selected merge sort algorithm (`choice`) with the specified number of trials.
- Each algorithm is tested for its sorting speed, and you can compare results by using different choices and thresholds.

### Performance Insights:
- **Choice-3 (mergeSort3)** tends to outperform others for larger inputs.
- **Choice-6 (mergeSort6)** performs worse compared to the others, particularly for large inputs.
- Thresholds play a key role in performance for algorithms that combine insertion and merge sort.
