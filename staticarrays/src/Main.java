import java.util.Arrays;

public class Main
{
    public static int[] insertElement(int list2[], int x)
    {
        int[] newList2 = new int[list2.length + 1];

        // copy old elements
        for (int i = 0; i < list2.length; i++)
        {
            newList2[i] = list2[i];
        }

        newList2[list2.length] = x;

        return newList2;
    }

    public static int[] deleteElement(int list2[], int del)
    {
        if (del < 0 || del >= list2.length)
            return list2;

        int[] out = new int[list2.length - 1];

        //https://docs.oracle.com/javase/8/docs/api/java/lang/System.html
        //
        // cp before the del index
        System.arraycopy(list2, 0, out, 0, del);
        // cp after the del index
        System.arraycopy(list2, del + 1, out, del, list2.length - del - 1);
        return out;
    }

    public static void sortElements(int list2[])
    {
        Arrays.sort(list2);
    }

    public static float avgElements(int[] list1)
    {
        float sum = 0;

        for (int num : list1)
        {
            sum += num;
        }

        float avg = sum / list1.length;
        return avg;
    }

    public static void main(String[] args)
    {
        int[] list1 = {0,1,2,3,4,5,6,7,8,9,10};
        int[] list2 = {10,9,8,7,6,5,4,3,2,1,0};

        int x = 11;

        int del = 0;

        System.out.println("List 1: "+ Arrays.toString(list1));
        System.out.println("List 2: " + Arrays.toString(list2));

        int newList2[] = insertElement(list2, x);

        System.out.println("Inserted List2: " + Arrays.toString(newList2));

        sortElements(newList2);
        System.out.println("Sorted List 2: " + Arrays.toString(newList2));

        int[] afterDelete = deleteElement(newList2, del);
        System.out.println("After delete: " + Arrays.toString(afterDelete));

        System.out.println("Average of list1: " + avgElements(list1));
    }
}


/*

create a static array of ints called list1 using an initializer list
create a static array of zints called list2 using interactive input
methods that
print arr
insert an element to the array
delete an element from the array
avg the elements in the array

call each of the methods
sort the array
print the array

 */