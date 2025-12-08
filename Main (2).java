import java.util.*;
public class Main
{
static Scanner reader = new Scanner(System.in);
public static void main(String []args)
  {	 int a[] = {1,2,5,6,3,42,1};
     int b[] = {1,2,3,4};
        
    System.out.println(L2ex2(buildList(a)));
	}
	
	public static Node<Integer> buildList(int[] a) {
		Node<Integer> h = new Node<Integer>(-1);
		Node<Integer> p = h;
		Node<Integer> x;
		for (int i = 0; i < a.length; i++) {
			x = new Node<Integer>(a[i]);
			p.setNext(x);
			p = p.getNext();
		}
		return h.getNext();
	}

	public static Node<Integer> buildList1() {
	    System.out.println("enter num");
	    int num = reader.nextInt();
		Node<Integer> h = new Node<Integer>(num);
		Node<Integer> p = h;
		Node<Integer> x;
		while(num!=-1) {
			x = new Node<Integer>(num);
			p.setNext(x);
			p = p.getNext();
		    System.out.println("enter num");
	        num = reader.nextInt();	
		}
		return h.getNext();
	}
		
public static void printt(Node <Integer> p){
	    while(p!=null){
	        System.out.println(p.getValue());
	        p=p.getNext();
	    }
}

public static void printRec(Node <Integer> p){
    if(p==null)
      return;
    
     System.out.println(p.getValue());
	        printRec(p.getNext());
       
}

public static void printEndToStart(Node <Integer> p){
    if(p==null)
      return;
    
	        printEndToStart(p.getNext());
	       System.out.println(p.getValue());
       
}
public static void printEven(Node <Integer> p){
	    while(p!=null){
	        if(p.getValue()%2==0){
	        System.out.println(p.getValue());}
	        p=p.getNext();
	    }
}
public static boolean isIn(Node <Integer> p,int x){
	    while(p!=null){
	        if(p.getValue()==x){
	        return true;}
	        p=p.getNext();
	    }
	   return false;
}
public static boolean isInRec(Node <Integer> p, int x){
    if(p==null)
      return false;
      
    if(p.getValue()==x){
        return true;
    }
 return isInRec(p.getNext(),x);
}

public static int sum(Node <Integer> p){
    int sum=0;
    while(p!=null){
        sum+=p.getValue();
        p=p.getNext();
    }
   return sum; 
}
public static Node<Integer> ex6(Node <Integer> p, int x){
    while(p.hasNext()){
        if (p.getNext().getValue()==x);
          p.setNext(p.getNext().getNext());
    }
    return p.getNext();
}

public static boolean ex8(Node <Integer> l1, Node <Integer> l2){
    if(l1==null)
      return true;
    
   
    if(!isIn(l2,l1.getValue())){
      return false;}
      
    return ex8(l1.getNext(),l2); } 

public static void ex9(Node <Integer> l1, Node <Integer> l2){
    if(l1==null)
      return;
    
   
    if(isIn(l2,l1.getValue())){
    System.out.println(l1.getValue());}
     
     ex9(l1.getNext(),l2); }
     
public static Node<Integer> ex10(Node <Integer> l1, Node <Integer> l2) {
		Node<Integer> h = new Node<Integer>(null);
		Node<Integer> p = h;
		while(l1!=null){
		 if(isIn(l2,l1.getValue())){
		     Node<Integer> x = new Node<Integer>(l1.getValue());
		     p.setNext(x);
		    	p = p.getNext();
		     
		 }
		    l1=l1.getNext();
		}
		return h.getNext();
	}     


 public static Node<Integer> L2ex1(Node <Integer> l1, Node <Integer> l2) {
		Node<Integer> h = new Node<Integer>(null);
		Node<Integer> p = h;
		Node<Integer> l11 = l1;
		Node<Integer> l22 = l2;
		while(l11!=null&&l22!=null)
		{
	    if(l11.getValue()>l22.getValue()){
	        p.setNext(l22);
		     p=p.getNext();
		     l22=l22.getNext();
	    }
	    else{
	          p.setNext(l11);
		     p=p.getNext();
		     l11=l11.getNext(); }  
		       
		}
		if(l11==null){
		   p.setNext(l22); 
		}
		else{
		    p.setNext(l11);
		}
		return h.getNext();
   
 }
  public static Node<Integer> L2ex2help(Node <Integer> p){
      Node<Integer> x = p;
      while(p.getNext()!=null){
          if(p.getNext().getValue()<x.getNext().getValue()){
              x=p;
          }
          p=p.getNext();    
      }
      return x;
  }
  public static Node<Integer> L2ex2(Node <Integer> p){
      Node<Integer> h = new Node<Integer>(null);
       h.setNext(p);
      	Node<Integer> x = new Node<Integer>(null);
		Node<Integer> k = x;
		 while(h.getNext()!=null){
		    x.setNext(L2ex2help(h).getNext());
		    h=ex6(h,L2ex2help(h).getNext().getValue());
		    x=x.getNext();
		 }
		 
		return h.getNext();
		 }
        
        
    

}