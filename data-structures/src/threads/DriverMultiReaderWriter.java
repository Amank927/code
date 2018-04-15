package threads;

public class DriverMultiReaderWriter
{
    public static void main(String[] args)
    {
        MultiReaderWriterSharedResource resource = new MultiReaderWriterSharedResource();
        Thread w1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true) {
                    resource.increaseCount();
                }
            }
        }, "w1");

        Thread w2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true) {
                    resource.increaseCount();
                }
            }
        }, "w2");


        Thread r1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                int i =0;
                while (true) {
                    if(i%5 == 0) {
                        resource.getCount();
                    }
                    i++;
                }
            }
        }, "r1");

        Thread r2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                int i =0;
                while (true) {
                    if(i%10 == 0) {
                        resource.getCount();
                    }
                    i++;
                }


            }
        }, "r2");
        Thread r3 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                int i =0;
                while (true) {
                    if(i%10 == 0) {
                        resource.getCount();
                    }
                    i++;
                }


            }
        }, "r3");
        r1.start();
        w1.start();
        r2.start();
        r3.start();
        //w2.start();
    }
}
