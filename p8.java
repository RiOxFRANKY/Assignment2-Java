
class StringReverse implements CharSequence{
    String val;
    public StringReverse(String temp){
        this.val = temp;
    }

    @Override
    public char charAt(int x){
        if (x >= val.length()) throw new IndexOutOfBoundsException("Index Out of Bounds");

        return this.val.charAt(val.length() - 1 - x);
    }

    @Override
    public int length(){
        return this.val.length();
    }

    @Override
    public CharSequence subSequence(int i , int j){
        
        if(i >= val.length() || j >= val.length()) throw new IndexOutOfBoundsException("Index Out of Bounds");

        int n = this.length();
        return this.val.subSequence( n - 1 - j, n - 1 -i);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder(this.val);
        return result.reverse().toString();
    }
}


public class p8 {
    

}
