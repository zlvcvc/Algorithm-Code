package Code_01_Sort;

/**
 * @ClassName Merge_Sort
 * @Description 归并排序
 * @Author ZhangLei
 * @Date 2019/7/1 21:00
 * @Version 1.0
 * 用递归先拆分数组到不能拆分为止，然后在合并过程中进行比较大小。
 * 时间复杂度：O(N*logN)
 **/
public class Merge_Sort {
    public static void MergeSort(int arr[]){
        if(arr.length<2 && arr==null){
            return;
        }
        sortProcess(arr,0,arr.length-1);
    }
    public static void sortProcess(int[] arr,int L, int R){
        if (L==R){
            return;
        }
        int mid=L+((R-L)>>1);//等同于(L+R)/2
        sortProcess(arr,L,mid);
        sortProcess(arr,mid+1,R);
        merge(arr,L,mid,R);
    }
    public static void merge(int arr[],int L,int mid,int R){
        int i=0;
        int p1=L;
        int p2=mid+1;
        int[] help=new int[R-L+1];
        while (p1<=mid && p2<=R){
            help[i++]=arr[p1]>arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            help[i++]=arr[p1++];
        }
        while (p2<=R){
            help[i++]=arr[p2++];
        }
        for (i=0;i<help.length;i++){
            arr[L+i]=help[i];
        }
    }
    public static void swap(int arr[],int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
    public static void main(String[] args) {
        int arr[]={5,1,6,4,8,2,9,3,5,7,10};
        MergeSort(arr);
        for (int i=0;i<arr.length-1;i++){
            System.out.print(arr[i]+",");
        }
    }
}
