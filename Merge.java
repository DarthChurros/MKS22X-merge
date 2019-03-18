import java.util.Arrays;

public class Merge {
  public static void mergesort(int[] data) {
    int[] temp = new int[data.length];
    for (int i = 0; i < temp.length; i++) {
      temp[i] = data[i];
    }

    sort(data, temp, 0, data.length - 1);
  }

  private static void sort(int[] data, int[] temp, int lo, int hi) {
    //System.out.println(Arrays.toString(data) + " lo = "+lo+", hi = "+hi);
    if (lo >= hi) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(temp, data, lo, mid);
    sort(temp, data, mid + 1, hi);
    merge(data, temp, lo, mid, hi);
  }

  private static void merge(int[] data, int[] temp, int lo, int mid, int hi) {
    //System.out.println("\tMerging "+ Arrays.toString(temp)+" at "+lo+","+mid+","+hi);

    int i = 0;
    int j = 0;
    while (i < mid-lo+1 && j < hi-mid) {
      //System.out.println("\t"+Arrays.toString(data)+" i="+i+",j="+j);
      if (temp[lo+i] < temp[mid+j+1]) {
        data[lo+i+j] = temp[lo+i];
        i++;
      } else {
        data[lo+i+j] = temp[mid+j+1];
        j++;
      }
    }
    //System.out.println("\t"+Arrays.toString(temp)+" i="+i+",j="+j);

    while (i < mid-lo+1) {
      data[lo+i+j] = temp[lo+i];
      i++;
    }
    while (j < hi-mid) {
      data[lo+i+j] = temp[mid+j+1];
      j++;
    }

    //for (int k = lo; k <= hi; k++) temp[k] = data[k];
  }
}
