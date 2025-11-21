class frq12020
{
    public int countElectronicsByMaker(String maker)
    {
        int count = 0;
        for (Gizmo obj : purchases)
        {
            if (obj.isElectrontic && obj.getMaker() == maker)
            {
                count++;
            }
        }
        return count;
    }

    public boolean hasAdjacentEqualPair()
    {
        if(purchases.size() < 2)
        {
            return false;
        }

        for (int i = 0; i< purchases.size(); i++)
        {
            if (purchases.get(i).equals(purchases.get(i - 1)))
            return true;
        }
        return false;
    }

    
}