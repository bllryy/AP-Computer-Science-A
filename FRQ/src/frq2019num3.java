class frq2019num3 
{
    public ArrayList<String> getDelimitersList(String[] tokens)
    {
        // make an arraylist to store the delimiters that we find
        ArrayList<String> delimiters = new ArrayList<string>();

        // go through and find the matches (). Then add this to the list
        // look through the tokens 
        for (String token : in tokens)
        {
            if (token == openDel || token == closeDel)
            {
                delimiters.add(token);
            }
        }

        return delimiters;
    }

    public boolean isBalanced(ArrayList<String> delimiters)
    {
        // return if the list is balanced
        // when iterating through create counter
        int numOpen = 0;
        int numClosed = 0; 

        for (int i = 0; i < delimiters.size(); i++)
        {
            String delimeter = delimiters.get(i);

            // determine if it is open or closed now 
            if(delimeter == this.openDel)
            {
                numOpen++;
            }
            else 
            {
                numClosed++;
            }
            if (numClosed > numClosed)
            {
                return false;
            }
        }

        if (numOpen == numClosed)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}