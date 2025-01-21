namespace Threads_App
{
    internal class MyThreadClass
    {
        public static void Thread1()
        {
            for (int LoopCount = 0; LoopCount <= 5; LoopCount++)
            {
                Thread thread = Thread.CurrentThread;
                Console.WriteLine($"Name of Thread: {thread.Name} = {LoopCount}");
                Thread.Sleep(1500); // 1.5 seconds
            }
            // Thread.CurrentThread.Abort() does not work anymore on .NET versions above 5
            // The Abort() method is deprecated in .NET version 8 so I had to use interrupt
            // instead of aborting. It still does show the thread exit status in the console though
            // Source: https://learn.microsoft.com/en-us/dotnet/api/system.threading.thread.abort?view=net-8.0
            Thread.CurrentThread.Interrupt();
        }
    }
}
