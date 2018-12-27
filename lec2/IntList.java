public class IntList{
    public int first;
    public IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public void print(String info){
        System.out.println(info);
        IntList curr = this;
        while(curr!=null){
            System.out.println(curr.first);
            curr = curr.rest;
        }
    }
    /** Return the size of the list using recursion */
    public int size(){
        if(rest == null){
            return 1;
        }else{
            return this.rest.size() + 1;
        }
    }
    /** Return the size of list using iteration */
    public int iterativeSize(){
        int i = 0;
        IntList curr = this;
        while(curr!=null){
            i++;
            curr = curr.rest;
        }
        return i;
    }
    /** get the ith item of list */
    public int get(int i){
        IntList p = this;
        for(int j = 0;j < i;j++){
            p = p.rest;
            if(p == null){
                System.out.println("IntList: Out of range!");
                System.exit(1);
            }
        }
        return p.first;
    }

    /** increment List L by x: return a new IntList*/
    public static IntList incrList(IntList L, int x){
        IntList newL = new IntList(L.first+x,null);
        IntList p_L = L;
        IntList p_newL = newL;
        while(p_L.rest!=null){
            p_newL.rest = new IntList(p_L.rest.first + x, null);
            p_newL = p_newL.rest;
            p_L = p_L.rest;
        }
        return newL;
    }
    /** increment List L by x: sharing memory*/
    public static IntList dincrList(IntList L, int x){
        IntList p = L;
        while(p!=null){
            p.first += x;
            p = p.rest;
        }
        return L;
    }
    public static void main(String[] args){
        IntList L1 = null;
        // L1.print("null"); L1 point to nothing, so can't use .print() 

        IntList L = new IntList(5,null);
        
        L.rest = new IntList(6,null);
        L.rest.rest = new IntList(7,null);

        L.print("L"+L);
        System.out.println("size: " + L.size());
        System.out.println("iterativeSize: " + L.iterativeSize());
        System.out.println("0th item: " + L.get(0));
        // System.out.println("3th item: " + L.get(3));
        
        IntList L_dincr = IntList.dincrList(L, 3);
        L_dincr.print("L_dincr: " + L_dincr);
        L.print("L: " + L);

        IntList L_incr = IntList.incrList(L, 4);
        L_incr.print("L_incr: " + L_incr);
        L.print("L: " + L);

        
        
    }
}