/**
 * Created by ScorpionOrange on 2016/12/14.
 * 三元组抽象结构
 */
public class TripleNode {
    private int row;
    private int column;
    private double value;

    public TripleNode(int row, int column, double value){
        super();
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public TripleNode(){
        this(0, 0, 0);
    }

    public int getRow(){
        return row;
    }

    public void setRow(int row){
        this.row = row;
    }

    public int getColumn(){
        return column;
    }

    public void setColumn(int column){
        this.column = column;
    }

    public double getValue(){
        return value;
    }

    public void setValue(double value){
        this.value = value;
    }

    @Override
    public String toString(){
        return "[(" + row + ", " + column + "), " + value + "]";
    }
}
