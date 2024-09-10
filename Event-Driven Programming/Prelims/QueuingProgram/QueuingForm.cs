namespace QueuingProgram
{
    public partial class QueuingForm : Form
    {
        private CashierClass cashier;
        private CashierWindowQueue cashierWindow;

        public QueuingForm()
        {
            InitializeComponent();
            cashier = new CashierClass();
            cashierWindow = new CashierWindowQueue();
            cashierWindow.Show();
        }

        private void btnCashier_Click(object sender, EventArgs e)
        {
            lblQueue.Text = cashier.CashierGeneratedNumber("P - ");
            CashierClass.getNumberInQueue = lblQueue.Text;
            CashierClass.CashierQueue.Enqueue(CashierClass.getNumberInQueue);
            cashierWindow.RefreshDisplay(); // Auto refreshes the queue display whenever a new item gets added
        }
    }
}
