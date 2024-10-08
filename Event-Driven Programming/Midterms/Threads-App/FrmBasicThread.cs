using System.Runtime.InteropServices;

namespace Threads_App
{
    public partial class FrmBasicThread : Form
    {
        private Thread ThreadA;
        private Thread ThreadB;
        private bool started = false;

        public FrmBasicThread()
        {
            InitializeComponent();
            AllocConsole();
            ThreadA = new Thread(MyThreadClass.Thread1);
            ThreadA.Name = "Thread A Process";
            ThreadB = new Thread(MyThreadClass.Thread1);
            ThreadB.Name = "Thread B Process";
        }

        [DllImport("kernel32.dll", SetLastError = true)]
        [return: MarshalAs(UnmanagedType.Bool)]
        static extern bool AllocConsole();

        private void runBtn_Click(object sender, EventArgs e)
        {
            if (!started)
            {
                Console.WriteLine("-Before starting thread-");
                started = true;
                ThreadA.Start();
                ThreadB.Start();
                Thread.Sleep(1500 * 6);
                ThreadA.Join();
                ThreadB.Join();
                Console.WriteLine("-End Of Thread-");
                stateLabel.Text = "-End of Thread-";
            }
        }
    }
}
