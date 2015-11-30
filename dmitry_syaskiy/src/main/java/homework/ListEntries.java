package homework;

public class ListEntries {
	private ListEntriesNode head;
    private ListEntriesNode tail;
    public void addFront(Entry data)
    {
        ListEntriesNode a = new ListEntriesNode();
        a.setValue(data); 
        if(head == null)
        {
            head = a;
            tail = a;
        }
        else {
            a.setNext(head);
            head = a;
        }
    }
    public void addBack(Entry data) {
        ListEntriesNode a = new ListEntriesNode();
        a.setValue(data);
        if (tail == null)
        {
            head = a;
            tail = a;
        } else {
            tail.setNext(a);
            tail = a;
        }
    }
    public boolean deleteElement(Entry data)
    {
        if(head == null)
            return false;
        if (head.equals(tail)) {
            head = null;
            tail = null;
            return true;
        }
 
        if (head.getValue().equals(data)) {
            head = head.getNext();
            return true;
        }
        ListEntriesNode t = head;
        while (t.getNext() != null) {
            if (t.getNext().getValue().equals(data)) {
                if(tail.equals(t.getNext()))
                {
                    tail = t;
                }
                t.setNext(t.getNext().getNext());
                return true;
            }
            t = t.getNext();
        }
        return false;
    }
    public void printList()
    {
        ListEntriesNode t = head;   
        while (t != null)
        {
            System.out.println(t.getValue());
            t = t.getNext();
        }
    }
    public boolean checkEntry(Entry entry){
    	ListEntriesNode node = head;
    	if (node == null){
    		return true;
    	}
    	while(node != null){
    		if(node.getValue().equals(entry))
    		{
    			node.setValue(entry);
    			return false;
    		}
    		node = node.getNext();
    	}
    	return true;
    }
    public Entry getEntry(Consignment key){
    	ListEntriesNode node = head;
    	Entry entry = null;
    	while(node != null){
    		if(node.getValue().getConsignment().equals(key))
    		{
    			entry = node.getValue();
    		}
    		node = node.getNext();
    	}
    	return entry;
    }
    public int getListSize(){
    	int size = 0;
    	ListEntriesNode node = head;
    	while(node != null){
    		size++;
    		node = node.getNext();
    	}
    	return size;
    }
}
