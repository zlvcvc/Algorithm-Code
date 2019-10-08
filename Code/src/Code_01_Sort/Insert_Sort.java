package Code_01_Sort;

/**
 * @ClassName Insert_Sort
 * @Description 插入排序
 * @Author ZhangLei
 * @Date 2019/6/9 17:17
 * @Version 1.0
 *
 * 时间复杂度：最坏情况O(N^2)   最好情况O(N)
 **/
public class Insert_Sort {
    public static void InsertSort(int arr[]){
        if(arr.length<2 && arr==null){
            return;
        }
        for (int i=1;i<arr.length;i++){
            for (int j=i-1;j>=0&&arr[j]>arr[j+1];j--){
                    swap(arr,j,j+1);
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
        InsertSort(arr);
        for (int i=0;i<arr.length-1;i++){
            System.out.print(arr[i]+",");
        }
    }
}
