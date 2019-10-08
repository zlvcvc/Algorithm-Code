package Code_01_Sort;

/**
 * @ClassName Choose_Sort
 * @Description 选择排序
 * @Author ZhangLei
 * @Date 2019/6/9 17:16
 * @Version 1.0
 *
 * 时间复杂度：O(N^2)
 **/
//与冒泡排序时间复杂度差不多，只是中间少去了很多交换的步骤
public class Choose_Sort {
    public static void ChooseSort(int arr[]){
        if(arr.length<2 && arr==null){
            return;
        }
        //me：应把最小的坐标index定下来 ，而开始一直是i与j在做比较。
        /*for (int i=0;i<arr.length-1;i++){
            int index = 0;
            for (int j=i+1;j<arr.length;j++){
                index=(arr[i]>arr[j])?j:i;
            }
            if (i!=index){
                swap(arr,i,index);
            }
        }*/
        //you：注意交换的时候i不能等于index
        for (int i=0;i<arr.length-1;i++){
            int index = i;
            for (int j=i+1;j<arr.length;j++){
                index=(arr[index]>arr[j])?j:index;
            }
            if (i!=index){
                swap(arr,i,index);
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
        ChooseSort(arr);
        for (int i=0;i<arr.length-1;i++){
            System.out.print(arr[i]+",");
        }
    }
}
