using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PriorityThreadApp
{
    class MyThreadClass
    {
        public static void Thread1()
        {
            for (int i = 0; i <= 2; i++)
            {
                Thread thread = Thread.CurrentThread;
                Console.WriteLine(displayThreadInfo(thread.Name, i));
                Thread.Sleep(500); // 0.5 seconds
            }
            Utils.exitThread(Thread.CurrentThread);
        }

        public static void Thread2() 
        {
            Thread.Sleep(100); // startup delay
            for (int i = 0; i < 6; i++)
            {
                Thread thread = Thread.CurrentThread;
                Console.WriteLine(displayThreadInfo(thread.Name, i));
                Thread.Sleep(1500); // 1.5 seconds
            }
            Utils.exitThread(Thread.CurrentThread);
        }

        private static string displayThreadInfo(string threadName, int loopCount)
        {
            return $"Name of Thread: {threadName} = {loopCount}";
        }
    }
}
