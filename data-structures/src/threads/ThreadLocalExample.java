package threads;

public class ThreadLocalExample
{
    public static class MyRunnable implements Runnable
    {
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        private Integer integer;
        @Override
        public void run()
        {
            threadLocal.set((int) (Math.random()*100));
            integer = 3;
            //System.out.println(threadLocal.get());
            System.out.println(integer);
        }
    }

    public static class SharedValue
    {
        private int value;

        public static SharedValue instance = new SharedValue();

        public SharedValue()
        {
            this.value = 0;
        }

        public void add(int newVal) {
            System.out.println("Executing thread "+ Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.value = this.value + newVal;
        }
    }

    public static void main(String[] args)
    {
//        MyRunnable myRunnable = new MyRunnable();
//        //Thread thread1 = new Thread(myRunnable, "t1");
//        Thread thread2 = new Thread(myRunnable, "t2");
//        for (int i=0;i<1;i++) {
//            Thread thread1 = new Thread(myRunnable, "t1");
//            thread1.start();
//        }
//        //thread1.start();
//        thread2.start();

        //SharedValue sharedValue = new SharedValue();

        Thread thread1 = new Thread(new Runnable()
        {
            private SharedValue sharedValue = SharedValue.instance;

            @Override
            public void run()
            {
                //System.out.println("Executing thread "+ Thread.currentThread().getName());
                sharedValue.add(3);
                System.out.println(sharedValue.value);
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable()
        {
            private SharedValue sharedValue = SharedValue.instance;

            @Override
            public void run()
            {
                //System.out.println("Executing thread "+ Thread.currentThread().getName());
                sharedValue.add(5);
                System.out.println(sharedValue.value);
            }
        }, "thread2");

        thread2.start();
        thread1.start();
    }
}
