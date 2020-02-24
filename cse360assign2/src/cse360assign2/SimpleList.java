package cse360assign2;

/* Natalee Goeken
 * Class ID: 397
 * Assignment 1
 * This assignment is creating an array which it will be created so elements
 * can be added, searched, removed, counted, and stringed in the list. 
 */



/**
 *  This class contains several different methods which will be used to modify
 *  a list. first method is the SimpleList which will create our list and allow
 *  for there to be 10 elements in the list. We will also start off with having
 *  the count initially as 0. The next method is the add function which will
 *  add a parameter to the list and move the rest of the contents of the 
 *  list over. Remove is the next method and it finds a parameter in the list
 *  and can remove it. Next, the toString method which will return the list
 *  as a String. Finally, the last method is a search which will find the 
 *  location of the parameter in the list. All of these methods will be used
 *  in order to manipulate the list to do the different method descriptions
 *  listed above. 
 * 
 * @author nataleegoeken
 */

public class SimpleList 
{
	private int[] list;
	private int count;
	/**
	 * SimpleList will be created to make an array that will hold 10 integers
	 * and set the count to 0.  
	 */

	public SimpleList()
	{
		list = new int[10];
		count = 0;
	}

	/**
	 * Shift the elements to the right so the list can add an element to the 
	 * beginning of the list (at index 0). If the list is full, then the 
	 * element drops off the list. Then increment the count to display
	 * that an element was added to the list. 
	 * @param number
	*/

	public void add(int numberAdded) 
	{
		//first shift elements right
		//check that index is less than the count and greater than equal to 0
		//if true, add to index if the index assuming list is not full 
		for(int index = (count - 1); index >= 0; index--)
		{
			if (index < 9)
			{
				list[index + 1] = list[index];
			}
		}
		//add number to beginning (index 0)
		list[0] = numberAdded;
		//increment count to reflect added element 
		if (count < 10)
		{
			count++;
		}
	}
	
	/**
	 * Find an element in the list that you would like to remove, and if found,
	 * remove it from the list. If the element was removed, then adjust the 
	 * position of the other elements in the list and update count if needed.
	 * @param elementRemoved
	 */
	
	public void remove(int elementRemoved) 
	{
		//find index where the parameter element is located
		//only proceed if positive index
		int index = search(elementRemoved);
		if (index >= 0)
		{
			//replace element to be removed with next value in list
			//continue until end of list (count) and decrement count
			for(int i = index; i < count; i++)
			{
				if(i < 9)
				{
					list[i] = list[i + 1];
				}
			}
			count--;
		}
	}
	
	/**
	 * Count will return the number of elements that are stored within the list
	 * @return 
	 */

	public int count()
	{
		return count;
	}
	
	/**
	 * The toString method will return the items in the list as a String. 
	 * The elements in the list will have a space between them while having
	 * no space at the end of the element in the list. 
	 */
	
	public String toString()
	{
		String string = "";
		for(int i = 0; i < count; i++)
		{
			string += Integer.toString(list[i]);
			if (i < count - 1)
			{
				//separate elements in string with a space if not endd of list
				string += " ";
			}
		}
		return string;
	}
	/**
	 *The search method will return the location of a parameter in the list. 
	 *However, if the parameter is not in the list, it will return -1
	 *@param element
	* @return
	*/
	
	public int search(int element)
	{
		//if found exit the loop with the index
		//else if loop runs 10 times, return -1 
		int index = 0; 
		boolean found = false;
		
		//if the element is found in the list
		while(index < count && !found) 
		{
			found = (list[index] == element);
			index++;
		}
		
		//if the element is not found in the list 
		if(!found)
		{
			return -1;
		}
		return index - 1; //parameter is not in the list 
	}
	
	public int size()
	{
		return count;
	}
	
}
