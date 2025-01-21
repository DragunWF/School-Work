using System.Runtime.InteropServices;

namespace PriorityThreadApp
{
    public partial class frmTrackThread : Form
    {
        private Thread threadA, threadB, threadC, threadD;
        private bool started = false;

        public frmTrackThread()
        {
            InitializeComponent();
            AllocConsole();
        }

        [DllImport("kernel32.dll", SetLastError = false)]
        [return: MarshalAs(UnmanagedType.Bool)]
        static extern bool AllocConsole();

        private void runBtn_Click(object sender, EventArgs e)
        {
            if (!started) // Prevents the button from getting started twice
            {
                Console.WriteLine("-Thread Starts");
                started = true;

                createThreads();
                startThreads();
                joinThreads();

                Console.WriteLine("-End of Thread-");
                threadStateText.Text = "-End of Thread-";
            }
        }

        private void createThreads()
        {
            threadA = new Thread(MyThreadClass.Thread1);
            threadB = new Thread(MyThreadClass.Thread2);
            threadC = new Thread(MyThreadClass.Thread1);
            threadD = new Thread(MyThreadClass.Thread2);
            threadA.Name = "threadA";
            threadB.Name = "threadB";
            threadC.Name = "threadC";
            threadD.Name = "threadD";
            threadA.Priority = ThreadPriority.Highest;
            threadB.Priority = ThreadPriority.Normal;
            threadC.Priority = ThreadPriority.AboveNormal;
            threadD.Priority = ThreadPriority.BelowNormal;
        }

        private void startThreads()
        {
            threadA.Start();
            threadC.Start();
            threadB.Start();
            threadD.Start();
        }

        private void joinThreads()
        {
            threadA.Join();
            threadB.Join();
            threadC.Join();
            threadD.Join();
        }
    }
}
