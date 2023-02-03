import java.util.ArrayList;

public class Digits
{
    /** The list of digits from the number used to construct this object.
     *  The digits appear in the list in the same order in which they appear in the original number.
     */
    private final ArrayList<Integer> digitList;

    /** Constructs a Digits object that represents num.
     *  Precondition: num >= 0
     */
    public Digits(int num)
    {
        digitList = new ArrayList<>();

        double iterations = Math.ceil(Math.log10(Math.max(1, num) + 0.001));
        for (int i = 0; i < iterations; i++) {
            digitList.add(0, num % 10);
            num /= 10;
        }
    }

    /** Returns true if the digits in this Digits object are in strictly increasing order;
     *  false otherwise.
     */
    public boolean isStrictlyIncreasing()
    {
        int current;
        int next = digitList.get(0);

        for (int i = 0; i < digitList.size() - 1; i++) {
            current = next;
            next = digitList.get(i + 1);
            if (current >= next) {
                return false;
            }
        }

        return true;
    }

    // GETTER METHOD: added to enable test code (not provided/needed in original FRQ)
    public ArrayList<Integer> getDigitList()
    {
        return digitList;
    }
}