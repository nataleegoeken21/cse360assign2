package cse360assign2;

/* Natalee Goeken
 * Class ID: 397
 * Assignment 2
 * This assignment is to learn how to use github in connection with a java 
 * program that includes the git tool. 
 * 
 * 
 * My github should be public, but if any issues, the user/password to github:
 * username: nataleegoeken21
 * password: SparklesBelle21!
 * repository URL: https://github.com/nataleegoeken21/cse360assign2
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
		
		//making room in list by 50%
		if (count == list.length)
		{
			//increasing the list by 50% to ensure there will be room
			int newSizeList = (int) (1.5 * list.length);
			int[] newRoomList = new int[newSizeList];
			
			//put elements in new array
			for(int i = 0; i < list.length; i++)
			{
				newRoomList[i] = list[i];
			}
			list = newRoomList;
		}

		//if there is not room in the list
		else
		{
			//checking if there is not room in the list 
			for(int i = list.length-1; i >= 0; i--)
			{
				list[i] = list[i-1];
			}
			list[0] = numberAdded;
		}
		//increasing the count
		count++;
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
		
		//count makes sure that there is room in list by dividing it by the
		//length
		int size = 1 * count / list.length;
		//if there is less than 25% of room in the list 
		if (size < 0.75)
		{
			//increasing the list by 50% to ensure there will be room. create 
			//new list
			int newSizeList = (int) (0.75 * list.length);
			int[] newRoomList = new int[newSizeList];
			
			//put elements in new list
			for(int i = 0; i < newRoomList.length; i++)
			{	
				newRoomList[i] = list[i];
			}
			list = newRoomList;
		}
		//decreasing the count if there is not enough room in the list 
		index--;
	}
	
	/**
	 * This will return the first element in the list 
	 * 
	 * @return
	 */
	
	//finding the first element in the list
	public int first()
	{
		if (count == 0)
			return -1;
		return list[count-1];
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
	
	/**
	 * This will append the parameter to the end of the list and increase the 
	 * size by 50%
	 * 
	 * @param element
	 */
	
	//append the parameter to the end of the list 
	public void append(int element)
	{
		//making room in list by 50%
		if(count == list.length)
		{
			//have to do 1.5 so you take into consideration the list plus 50%
			//more room in the list 
			int newSizeList = (int) (1.5 * list.length);
			int[] newRoomList = new int[newSizeList];
			
			//put the elements in the list 
			for(int i = 0; i < list.length; i++)
			{
				newRoomList[i] = list[i];
			}

			list = newRoomList;
		}
		
		//adding to the end of the list
		list[count] = element;
		count++;
	}
	
	
	/**
	 * Return the possible number of locations that are in the list
	 * 
	 * @return
	 */
	public int size()
	{
		return count;
	}
	
}
