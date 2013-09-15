
/*
 *  Authors: Jackie Lang, Kimia Nikazm, Alexander Swainson
 * Date: 15/09/2013
 * Project: MP0b
 */

public class MP0b {
	public static int recursiveSearch( int a[], int x, int j ){
		if( x<0)
			return -1;
	
		if( a[j]==x)
			return j;
		else j++; 
	
		return recursiveSearch( a, x, j);
	}
		
	public static int find(int x,int[] a) {
	    return linearSearch(x, a);
	}

    private static int linearSearch(int x, int[] a) {
    	for (int i = 0; i < a.length; ++i) {
            if (x == a[i]) 
                return i;
        }
    	return -1;
    }

    public static void main ( String[] args ) {
        int[] a = new int[10000];
        int j = 0;

        for( int i=0; i<10000; i++)
        	a[i]=i+1; 			
																		
		System.out.println(recursiveSearch(a, 5999, j));
    }
}
