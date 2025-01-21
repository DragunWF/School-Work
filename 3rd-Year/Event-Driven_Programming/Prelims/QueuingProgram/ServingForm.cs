namespace QueuingProgram
{
    public partial class ServingForm : Form
    {
        public ServingForm()
        {
            InitializeComponent();
        }

        public void UpdateServingNum(string queueNum)
        {
            lblServingNum.Text = queueNum;
        }
    }
}
