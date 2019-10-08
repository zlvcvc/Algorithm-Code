package Code_01_Sort;

/**
 * @ClassName Quick_Sort
 * @Description 快速排序
 * @Author ZhangLei
 * @Date 2019/7/3 20:46
 * @Version 1.0
 *
 * 时间复杂度：O(N*logN)，因为常数项小，所以使用最多
 **/
public class Quick_Sort {
    public static void QuickSort(int[] arr){
        if(arr.length<2 && arr==null){
            return;
        }
        QuickSort(arr,0,arr.length-1);
    }
    public static void QuickSort(int[] arr,int L,int R){
        if(L < R){
            swap(arr,L+(int)(Math.random()*(R-L+1)),R);
            int p[]=partition(arr,L,R);
            QuickSort(arr,L,p[0]-1);
            QuickSort(arr,p[1]+1,R);
        }
    }
    public static int[] partition(int[] arr,int L,int R){
        int less=L-1;
        //不用more=R+1，直接用R，循环完后交换就OK，这样可以节约一个变量的空间，
        int more=R;
        while (L<more){
            if (arr[L]<arr[R]){
                swap(arr,++less,L++);
            }else if(arr[L]>arr[R]){
                swap(arr,--more,L);
            }else{
                L++;
            }
        }
        swap(arr,more,R);
        return new int[] {less+1,more};
    }
    public static void swap(int arr[],int i,int j){
        /*int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;*/
        //TODO 下面交换有问题  ， 自身交换
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
    public static void main(String[] args) {
        //int arr[]={5,1,6,4,8,2,9,3,5,7,10};
        int arr[]={1,2,3};
        swap(arr,0,0);
        QuickSort(arr);
        for (int i=0;i<arr.length-1;i++){
            System.out.print(arr[i]+",");
        }
    }
}
