package ThreadsPractice;

public class MultiReaderWriterDriver
{

    public static void testJavaRWSharedRes() throws InterruptedException
    {
        //UnoptimisedSharedRes<String> res = new UnoptimisedSharedRes<>("a0");
        JavaRWLockSharedRes<String> res = new JavaRWLockSharedRes<>("a0");
        //MyRWLockSharedResource<String> res = new MyRWLockSharedResource<>("a0");
        Thread r1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true) {
                    try {
                        System.out.println("Reader 1 got value " + res.read());
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "r1");

        Thread r2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true) {
                    try {
                        System.out.println("Reader 2 got value " + res.read());
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"r2");

        Thread w1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                int i=100;
                while (true) {
                    try {
                        String toWrite = "a";
                        toWrite = toWrite + String.valueOf(i);
                        System.out.println("Writer 1 wants to write value " + toWrite);
                        res.write(toWrite);
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        },"w1");
        Thread w2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                int i =1;

                while (true) {
                    try {
                        String toWrite = "a";
                        toWrite = toWrite + String.valueOf(i);
                        System.out.println("Writer 2 wants to write value " + toWrite);
                        res.write(toWrite);
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        }, "w2");
        r1.start();
        r2.start();
        w1.start();
        w2.start();
        w2.join();
        r1.join();
        r2.join();
        w1.join(10);
     }
    public static void main(String[] args) throws InterruptedException
    {
        testJavaRWSharedRes();

    }
}
