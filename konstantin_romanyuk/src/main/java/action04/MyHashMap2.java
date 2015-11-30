package action04;

import java.util.Iterator;



public class MyHashMap2 {
		private int capacity=16;
	private Entry[] map=new Entry[capacity]; 	
		public MyHashMap2(){for (int i=0;i<capacity;i++)
		{map[i]=new Entry(0,null,null,null);}
		       }
	public static void main(String[] args) {
		MyHashMap2 hMap=new MyHashMap2();
		hMap.put(new Party(1,"f"), new Product1("cheese", TypeProduct.Bread) );
		hMap.put(new Party(2,"f"), new Product1("kovbaza", TypeProduct.Bread) );
		hMap.put(new Party(3,"f"), new Product1("caviar", TypeProduct.Bread) );
		//System.out.println(hMap.get(new Party(1,"f")));
	}
	public boolean put(Party number, Product1 prod){
		int hh=number.hashCode()%capacity;
		Entry temp=new Entry(hh,null,null);
		int index=0;
		System.out.println(hh);
		temp=map[hh];
		while (!(temp==null)){
		if (temp.party==number) {index=-1;return false;}
		else temp=temp.next; index++;}
		if(index>-1){map[hh]=new Entry(hh,number,prod); return true;}
		else return false;
		
		/*if (map[hh].next==null)
		{if (map[hh].party==number) return false;
		else {map[hh]=new Entry(hh,number,prod,null); 
		return true;}}
		else{if(map[hh].party==number) return false;
		     if(map[hh].next==new Entry(hh,number,prod)) return false;
		     if(!(map[hh].party==number)){map[hh].next=new Entry(hh,number,prod,null); return true;}
			return false;*/
		}
		
	
	public Product1 get(Party part){
		Product1 result=null;
		int hash=part.hashCode()%capacity;
		Iterator<Entry> iter1=map[hash].iterator();
		Iterator<Entry> iter2=map[hash].iterator();
		while (iter1.hasNext() && iter2.hasNext())
		{if(iter2.next().party.equals(part))
			result=iter1.next().prod;
			}		
			return result;
	}
		
			
	class Entry {
		Party party;
		Product1 prod;
		Entry next;
		int hash;
		Entry(int hash, Party party, Product1 prod, Entry next){
			this.hash=hash;
			this.party=party;
			this.prod=prod;
			this.next=next;
		}
		 Entry(int hash, Party party, Product1 prod){
				this.hash=hash;
				this.party=party;
				this.prod=prod;
				}
	}
	}
