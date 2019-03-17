import java.util.Arrays;

public class Merge {
  public static void mergesort(int[] data) {
    sort(data, 0, data.length - 1);
  }

  public static void sort(int[] data, int lo, int hi) {
    //System.out.println(Arrays.toString(data) + " lo = "+lo+", hi = "+hi);
    if (lo >= hi) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(data, lo, mid);
    sort(data, mid + 1, hi);
    merge(data, lo, mid, hi);
  }

  public static void merge(int[] data, int lo, int mid, int hi) {
    //System.out.println("\tMerging "+ Arrays.toString(data)+" at "+lo+","+mid+","+hi);
    int[] data1 = new int[mid-lo+1];
    int[] data2 = new int[hi-mid];

    for (int i = 0; i < data1.length; i++) {
      data1[i] = data[lo+i];
    }
    for (int i = 0; i < data2.length; i++) {
      data2[i] = data[mid+i+1];
    }

    int i = 0;
    int j = 0;
    while (i < mid-lo+1 && j < hi-mid) {
      if (data1[i] < data2[j]) {
        data[lo+i+j] = data1[i];
        i++;
      } else {
        data[lo+i+j] = data2[j];
        j++;
      }
      //System.out.println("\t"+Arrays.toString(data1)+","+Arrays.toString(data2)+" i="+i+",j="+j);
    }

    while (i < mid-lo+1) {
      data[lo+i+j] = data1[i];
      i++;
    }
    while (j < hi-mid) {
      data[lo+i+j] = data2[j];
      j++;
    }
  }
}
