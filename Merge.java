import java.util.Arrays;

public class Merge {
  public static void mergesort(int[] data) {
    sort(data, new int[data.length], 0, data.length - 1);
  }

  private static void sort(int[] data, int[] temp, int lo, int hi) {
    //System.out.println(Arrays.toString(data) + " lo = "+lo+", hi = "+hi);
    if (lo >= hi) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(data, temp, lo, mid);
    sort(data, temp, mid + 1, hi);
    merge(data, temp, lo, mid, hi);
  }

  private static void merge(int[] data, int[] temp, int lo, int mid, int hi) {
    //System.out.println("\tMerging "+ Arrays.toString(data)+" at "+lo+","+mid+","+hi);
    int[] data1 = new int[mid-lo+1];
    int[] data2 = new int[hi-mid];

    for (int i = 0; i <= hi-lo; i++) {
      temp[lo+i] = data[lo+i];
    }

    int i = 0;
    int j = 0;
    while (i < mid-lo+1 && j < hi-mid) {
      if (temp[lo+i] < temp[mid+j+1]) {
        data[lo+i+j] = temp[lo+i];
        i++;
      } else {
        data[lo+i+j] = temp[mid+j+1];
        j++;
      }
      //System.out.println("\t"+Arrays.toString(temp)+" i="+i+",j="+j);
    }

    while (i < mid-lo+1) {
      data[lo+i+j] = temp[lo+i];
      i++;
    }
    while (j < hi-mid) {
      data[lo+i+j] = temp[mid+j+1];
      j++;
    }
  }
}
