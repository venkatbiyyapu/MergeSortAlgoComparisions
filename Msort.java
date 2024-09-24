/** Sample starter code for merge sort.
 *  @author rbk
 *  @author SA 
 * shuffling the array after every trail takes lot of time
 * create worst case input and copy to input array after every trail
 * not the best option. but saves time
 * if space is an issue, use csgrads1.utdallas.edu server
 */

package VXB220005;
import java.util.Random;

public class Msort {
    public static Random random = new Random();
    public static int numTrials = 50;
	public static int[] wcInput; //inp array
	public static int threshold = 16; // threshold for insertion sort
	public static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

    public static void main(String[] args) {
	int n = 10000;
	int choice=6;
	if(args.length > 0) { n = Integer.parseInt(args[0]); }
	if(args.length > 1) { choice = Integer.parseInt(args[1]); }
	if(args.length > 2) { threshold = Integer.parseInt(args[2]); }
    int[] arr = new int[n]; // initally inp. finally sorted
	wcInput = new int[n];
    wcInitArray(wcInput, 0, wcInput.length);
	Timer timer = new Timer();
	switch(choice) {
		case 0:
			for(int i=0; i<numTrials; i++) {
				initArray(arr);
				mergeSort0(arr);
			}
			break;
		case 3:
			for(int i=0; i<numTrials; i++) {
				initArray(arr);;
				mergeSort3(arr);
			}
			break;
		case 4:
			for(int i=0; i<numTrials; i++) {
				initArray(arr);
				mergeSort4(arr);
			}
			break;// etc
		case 5:
			for(int i=0; i<numTrials; i++) {
				initArray(arr);
				mergeSort5(arr);
			}
			break;
		case 6:
			for(int i=0; i<numTrials; i++) {
				initArray(arr);
				mergeSort6(arr);
			}
			break;// etc
	}
	timer.end();
	timer.scale(numTrials);
	System.out.println("n:"+ n + "\n"+ "Choice: " + choice + "\n" + timer);

    }

    public static void insertionSort(int[] arr,int p , int r) {
		for (int i = p + 1; i<r+1; i++) {
			int k = arr[i];
			int j = i - 1;
			while ( j >= p && k < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = k;
		}
    }

    public static void mergeSort0(int[] arr) {
		mergeSort0(arr, 0, arr.length-1);

    }
	public static void mergeSort0(int[] a, int p, int r){
		if (p < r) {
				int q = p+(r-p)/2;
				mergeSort0(a, p, q);
				mergeSort0(a, q + 1, r);
				merge(a, p, q, r);
		}
	}
	public static void mergeSort3(int[] arr) {
		int []b = new int[arr.length];
		System.arraycopy(arr,0,b,0,arr.length);
		mergeSort3(arr, b, 0, arr.length-1);
    }
	public static void mergeSort3(int [] a,int [ ]b ,int p, int r){
		if (p < r) {
			int q = p+(r-p)/2;
			mergeSort3(b, a, p, q);
			mergeSort3(b, a, q + 1, r);
			merge(a, b, p, q, r);
		}
	}
	public static void mergeSort4(int[] arr) {
		int []b = new int[arr.length];
		System.arraycopy(arr,0,b,0,arr.length);
		mergeSort4(arr, b, 0, arr.length-1);
	}
	public static void mergeSort4(int [] a,int [ ]b ,int p, int r){
		if (p < r) {
			if (r-p+1 < threshold)
			insertionSort(a, p, r);
			else {
				int q = p+(r-p)/2;
				mergeSort4(b, a, p, q);
				mergeSort4(b, a, q + 1, r);
				merge(a, b, p, q, r);
			}
		}
	}
	public static void mergeSort5(int[] a) {
		int n = a.length;
		int [] b = new int[n];
		int [] inp = a;
		for(int i = 1; i < n; i = 2*i) {
			for (int j = 0; j < n; j = j + 2 * i) {
				merge(b, inp, j, Math.min(j + i - 1, n - 1), Math.min(j + 2 * i - 1, n - 1));
			}
			int[] t = inp;
			inp = b;
			b = t;
		}
		if (a != inp){
			System.arraycopy(inp,0,a,0,n);
		}
	}

	public static void mergeSort6(int[] a) {
		int n = a.length;
		int [] b = new int[n];
		int [] inp = a;
		for (int j = 0; j < n; j = j + threshold)
			insertionSort(a, j, Math.min(j + threshold - 1,n-1));
		for(int i = threshold; i < n; i = 2*i) {
			for (int j = 0; j < n; j = j + 2 * i) {
				merge(b, inp, j, Math.min(j + i - 1, n - 1), Math.min(j + 2 * i - 1, n - 1));
			}
			int[] t = inp;
			inp = b;
			b = t;
		}
		if (a != inp){
			System.arraycopy(inp,0,a,0,n);
		}
	}

	public static void merge(int [] a,int p,int q, int r) {
		int[] b = new int[a.length];
		for (int i = p; i <= r; i++) {
			b[i] = a[i];
		}
		int i = p;
		int j = q + 1;
		int k = p;
		while (i <= q && j <= r) {
			if (b[i] <= b[j]) {
				a[k++] = b[i++];
			} else {
				a[k++] = b[j++];
			}
		}
		while (i <= q) {
			a[k++] = b[i++];
		}
		while (j <= r) {
			a[k++] = b[j++];
		}
	}
	public static void merge(int[] a , int []b , int p, int q , int r){
		int i = p, k = p, j = q + 1;
		while (i <= q && j <= r) {
			if (b[i] <= b[j])
				a[k++] = b[i++];
			else
				a[k++] = b[j++];
		}
		while (i <= q) {
			a[k++] = b[i++];
		}
		while (j <= r) {
			a[k++] = b[j++];
		}
	}


	
	/* initialize the array with worst case input. Nice algorithm
	 * src: https://stackoverflow.com/questions/24594112/when-will-the-worst-case-of-merge-sort-occur
	*/
    public static void wcInitArray(int[] arr, int start, int sz){

        if (sz == 1) { arr[start] = 1; return;}
        int lsz = sz/2;
        //int rsz = (sz%2 == 0 ? lsz : lsz+1);
        wcInitArray(arr, start, lsz);
        wcInitArray(arr, start + lsz, (sz%2 == 0 ? lsz : lsz+1));
        for ( int i = start; i < start + lsz; i++){
            arr[i] *= 2;
        }
        for ( int i = start + lsz; i < start + sz; i++){
            arr[i] = arr[i] * 2 - 1;
        }
    }
	
	// copy array inp to arr
	public static void initArray(int[] arr){
        System.arraycopy(wcInput, 0, arr, 0, arr.length);
	}
	


   /** Timer class for roughly calculating running time of programs
     *  @author rbk
     *  Usage:  Timer timer = new Timer();
     *          timer.start();
     *          timer.end();
     *          System.out.println(timer);  // output statistics
     */

    public static class Timer {
        long startTime, endTime, elapsedTime, memAvailable, memUsed;
        boolean ready;

        public Timer() {
            startTime = System.currentTimeMillis();
            ready = false;
        }

        public void start() {
            startTime = System.currentTimeMillis();
            ready = false;
        }

        public Timer end() {
            endTime = System.currentTimeMillis();
            elapsedTime = endTime-startTime;
            memAvailable = Runtime.getRuntime().totalMemory();
            memUsed = memAvailable - Runtime.getRuntime().freeMemory();
            ready = true;
            return this;
        }

        public long duration() { if(!ready) { end(); }  return elapsedTime; }

        public long memory()   { if(!ready) { end(); }  return memUsed; }

	public void scale(int num) { elapsedTime /= num; }
	
        public String toString() {
            if(!ready) { end(); }
            return "Time: " + elapsedTime + " msec.\n" + "Memory: " + (memUsed/1048576) + " MB / " + (memAvailable/1048576) + " MB.";
        }
    }
    
    /** @author rbk : based on algorithm described in a book
     */


    /* Shuffle the elements of an array arr[from..to] randomly */
    public static class Shuffle {
	
	public static void shuffle(int[] arr) {
	    shuffle(arr, 0, arr.length-1);
	}

	public static<T> void shuffle(T[] arr) {
	    shuffle(arr, 0, arr.length-1);
	}

	public static void shuffle(int[] arr, int from, int to) {
	    int n = to - from  + 1;
	    for(int i=1; i<n; i++) {
		int j = random.nextInt(i);
		swap(arr, i+from, j+from);
	    }
	}

	public static<T> void shuffle(T[] arr, int from, int to) {
	    int n = to - from  + 1;
	    Random random = new Random();
	    for(int i=1; i<n; i++) {
		int j = random.nextInt(i);
		swap(arr, i+from, j+from);
	    }
	}

	static void swap(int[] arr, int x, int y) {
	    int tmp = arr[x];
	    arr[x] = arr[y];
	    arr[y] = tmp;
	}
	
	static<T> void swap(T[] arr, int x, int y) {
	    T tmp = arr[x];
	    arr[x] = arr[y];
	    arr[y] = tmp;
	}

	public static<T> void printArray(T[] arr, String message) {
	    printArray(arr, 0, arr.length-1, message);
	}

	public static<T> void printArray(T[] arr, int from, int to, String message) {
	    System.out.print(message);
	    for(int i=from; i<=to; i++) {
		System.out.print(" " + arr[i]);
	    }
	    System.out.println();
	}
    }
}

