/**
 * Created by ScorpionOrange on 2016/12/14.
 * 三元组的顺序存储及其还原过程
 */
public class SparseArray {
    private TripleNode[] data;
    private int rows;
    private int cols;
    private int nums;

    public TripleNode[] getData(){
        return data;
    }

    public void setData(TripleNode[] data){
        this.data = data;
        this.nums = data.length;
    }

    public int getRows(){
        return rows;
    }

    public void setRows(int rows){
        this.rows = rows;
    }

    public int getCols(){
        return cols;
    }

    public void setCols(int cols){
        this.cols = cols;
    }

    public int getNums(){
        return nums;
    }

    public void setNums(int nums){
        this.nums = nums;
    }

    public SparseArray(){
        super();
    }

    public SparseArray(int maxSize){
        data = new TripleNode[maxSize];
        for(int i = 0; i < data.length; i++){
            data[i] = new TripleNode();
        }
        rows = 0;
        cols = 0;
        nums = 0;
    }

    public SparseArray(double[][] arr){
        this.rows = arr.length;
        this.cols = arr[0].length;
        // 统计有多少非零元素，以便于下面空间的申请
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] != 0){
                    nums++;
                }
            }
        }

        // 根据上面统计的非零数据的个数，将每一个非零元素的信息进行保存
        data = new TripleNode[nums];
        for(int i = 0, k = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] != 0){
                    data[k] = new TripleNode(i, j, arr[i][j]);
                    k++;
                }
            }
        }
    }

    public void printArrayOfRC(){
        System.out.println("稀疏矩阵的三元组储存结构为： ");
        System.out.println("行数为" + rows +"， 列数为" + cols + "， 非零元素个数为" + nums);
        System.out.println("行下标    列下标    元素值");
        for(int i = 0; i < nums; i++){
            System.out.println("" + data[i].getRow()
                         + "    " + data[i].getColumn()
                         + "    " + data[i].getValue());
        }
    }

    public void printArr(){
        System.out.println("稀疏矩阵的多维数据结构为：");
        System.out.println("行数为" + rows + "， 列数为" + cols + "， 非零元素个数为" + nums);
        double[][] origArr = reBackToArr();
        for(int i = 0; i < origArr.length; i++){
            for(int j = 0; j < origArr[0].length; j++){
                System.out.print(origArr[i][j] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    public double[][] reBackToArr(){
        double[][] arr = new double[rows][cols];
        for(int i = 0; i <nums; i++){
            arr[data[i].getRow()][data[i].getColumn()] = data[i].getValue();
        }
        return arr;
    }

    public SparseArray transpose(){
        SparseArray tm = new SparseArray(nums); // 创建一个转置后的矩阵对象
        tm.cols = rows; // 行列变化，非零个数不变
        tm.rows = cols;
        tm.nums = nums;
        int q = 0;
        // 从小到大扫描列号，然后进行变化
        for(int col = 0; col < cols; col++){
            for(int p = 0; p < nums; p++){
                if(data[p].getColumn() == col){
                    tm.data[q].setColumn(data[p].getRow());
                    tm.data[q].setRow(data[p].getColumn());
                    tm.data[q].setValue(data[p].getValue());
                    q++;
                }
            }
        }
        return tm;
    }
}
