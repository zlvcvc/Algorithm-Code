package Code_01_Sort;

/**
 * @ClassName Bubble_Sort
 * @Description 冒泡排序
 * @Author ZhangLei
 * @Date 2019/6/9 16:58
 * @Version 1.0
 *
 * 时间复杂度：O(N^2)
 **/
public class Bubble_Sort {
    public static  void BubbleSort(int arr[]){
        if(arr.length<2 && arr==null){
            return;
        }
        //me：0(N^2)
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    swap(arr,i,j);
                }
            }
        }
        //you：0((N^2+N)/2)优于上面
        for (int end=arr.length-1;end>0;end--){
            for (int k=0;k<end;k++){
                if (arr[k]>arr[k+1]){
                    swap(arr,k,k+1);
                }
            }
        }
    }
    public static void swap(int arr[],int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
    public static void main(String[] args) {
        int arr[]={5,1,6,4,8,2,9,3,5,7,10};
        BubbleSort(arr);
        for (int i=0;i<arr.length-1;i++){
            System.out.print(arr[i]+",");
        }
    }
}
