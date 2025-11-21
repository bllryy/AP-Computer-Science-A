public class DogWalker
{
    int amtDogs = company.numAvailableDogs(hour);
    int dogsWalked = amtDogs;

    if (amtDogs > maxDogs)
    {
        dogsWalked = maxDogs;
    }

    company.updateDogs(hour, dogsWalked);

    return dogsWalked;
}
