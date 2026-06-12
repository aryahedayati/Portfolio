package student;

public class Main
{
    public void addObserverForIntegerList(MinMidMax<Integer> mmm)
    {

        mmm.addObserver(new ListObserver<Integer>()
        {
            @Override
            public void pushedToList(MinMidMax<Integer> source , Integer element) {
                System.out.printf("Zur Liste hinzugefügt: %d -> neue Liste mit %d Elementen: %s\n",element,source.getNumItems(),source);
            }
            @Override
            public void poppedFromList(MinMidMax<Integer> source , Integer element) {
                System.out.printf("Von Liste entfernt: %d -> neue Liste mit %d Elementen: %s\n",element,source.getNumItems(),source);

            }
        });
    }

    public void addObserverForStringList(MinMidMax<String> mmm)
    {
        mmm.addObserver(new ListObserver<String>(){
            @Override
            public void pushedToList(MinMidMax<String> source ,String element){
                System.out.printf("Zur Liste hinzugefügt: %s -> neue Liste mit %d Elementen: %s\n",element,source.getNumItems(),source);
            }
            @Override
            public void poppedFromList(MinMidMax<String> source , String element) {
                System.out.printf("Von Liste entfernt: %s -> neue Liste mit %d Elementen: %s\n",element,source.getNumItems(),source);
            }
        });
    }

    public static void main(String[] args)
    {
        Main main = new Main();
        main.testWithInteger();

        System.out.println();
        main.testWithString();
    }

    //Methode nicht verändern!
    public void testWithInteger()
    {
        MinMidMax<Integer> mmm = new MinMidMax<>(3, 9, 1);
        addObserverForIntegerList(mmm);
        System.out.printf("Liste: %s\n", mmm);
        mmm.push(0);
        mmm.push(5);
        mmm.push(4);
        mmm.push(11);
        mmm.push(10);
        mmm.push(101);
        mmm.push(-15);
        mmm.push(-1);
        mmm.push(-1); //Wert schon vorhanden
        mmm.popRight();
        mmm.popLeft();
        mmm.popLeft();
        System.out.printf("Minimum: %d\n", mmm.getMinimum());
        System.out.printf("Maximum: %d\n", mmm.getMaximum());
        System.out.printf("Median: %d\n", mmm.getMid());
    }

    public void testWithString()
    {
        MinMidMax<String> mmm = new MinMidMax<>("bh", "ah", "fa", "ch", "bh"); //Element bh doppelt
        addObserverForStringList(mmm);
        System.out.printf("Liste: %s\n", mmm);
        mmm.push("ae");
        mmm.push("bb");
        mmm.push("ba");
        mmm.push("ck");
        mmm.push("cj");
        mmm.push("qa");
        mmm.push("aa");
        mmm.push("ac");
        mmm.push("ac"); //Element schon vorhanden
        mmm.popRight();
        mmm.popLeft();
        mmm.popLeft();
        mmm.popRight();
        mmm.popRight();
        System.out.printf("Minimum: %s\n", mmm.getMinimum());
        System.out.printf("Maximum: %s\n", mmm.getMaximum());
        System.out.printf("Median: %s\n", mmm.getMid());
        System.out.printf("Rückgabe popRight: %s\n", mmm.popRight());
        System.out.printf("Rückgabe popLeft: %s\n", mmm.popLeft());
        System.out.printf("Rückgabe popRight: %s\n", mmm.popRight());
        System.out.printf("Rückgabe popLeft: %s\n", mmm.popLeft());
        System.out.printf("Rückgabe popRight: %s\n", mmm.popRight());
        System.out.printf("Rückgabe popLeft: %s\n", mmm.popLeft());
        System.out.printf("Rückgabe popRight: %s\n", mmm.popRight());
        System.out.printf("Rückgabe popRight: %s\n", mmm.popRight()); //Element existiert nicht
    }
}