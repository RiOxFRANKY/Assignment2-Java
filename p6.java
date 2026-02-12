class Int extends Object{
    int x ;
    public Int(int a){
        x = a;
    }

    @Override
    public String toString(){
        return String.valueOf(x);
    }
}



public class p6 {
    public static void main(String[] args) {
        Int x = new Int(5);
        System.err.println(x);
    }
}
