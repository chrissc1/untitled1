public class asda {

    public boolean isLeapYear(int val)

    {

        if ((val % 4) == 0)

        {

            return true;

        }

        else

        {

            return (val % 400) == 0;

        }

    }
}
