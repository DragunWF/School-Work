using Timer = System.Windows.Forms.Timer;

namespace QueuingProgram
{
    public partial class CashierWindowQueue : Form
    {
        private ServingForm servingForm;

        public CashierWindowQueue()
        {
            InitializeComponent();
            servingForm = new ServingForm();
            servingForm.Show();
        }

        private void btnRefresh_Click(object sender, EventArgs e)
        {
            DisplayCashierQueue(CashierClass.CashierQueue);
        }

        private void btnNext_Click(object sender, EventArgs e)
        {
            CashierClass.CallNextInLine();
            RefreshDisplay(); // Auto refreshes the queue display whenever the an item gets removed
            servingForm.UpdateServingNum(CashierClass.getLastDequeuedNum());
        }

        public void DisplayCashierQueue(IEnumerable<string> CashierList)
        {
            listCashierQueue.Items.Clear();
            foreach (object obj in CashierList)
            {
                listCashierQueue.Items.Add(obj.ToString());
            }
        }

        public void RefreshDisplay()
        {
            Timer timer = new Timer();
            timer.Interval = 1000;
            timer.Tick += new EventHandler(btnRefresh_Click);
            timer.Start();
        }
    }
}
