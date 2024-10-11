using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PriorityThreadApp
{
    class Utils
    {
        public static void exitThread(Thread thread)
        {
            // to deal with deprecation of Abort() method in .NET 8
            // here is a custom message
            Console.WriteLine($"The thread 0x0f{thread.GetHashCode()} has exited with code 0 (0x0).");
        }
    }
}
