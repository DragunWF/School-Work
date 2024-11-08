namespace TextFileWriterApp
{
    public partial class FrmFileName : Form
    {
        public static string SetFileName = "";

        public FrmFileName()
        {
            InitializeComponent();
        }

        private void btnOkay_Click(object sender, EventArgs e)
        {
            SetFileName = $"{txtFileName.Text}.txt";
            Close();
        }
    }
}