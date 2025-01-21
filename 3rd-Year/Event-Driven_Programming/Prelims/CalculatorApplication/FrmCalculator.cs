namespace CalculatorApplication
{
    public partial class FrmCalculator : Form
    {
        private double num1, num2;
        private CalculatorClass cal;

        public FrmCalculator()
        {
            InitializeComponent();
            cal = new CalculatorClass();
        }

        private void btnEqual_Click(object sender, EventArgs e)
        {
            if (isInputValid())
            {
                switch (cbOperator.Text)
                {
                    case "+":
                        cal.CalculateEvent += new Formula<double>(cal.GetSum);
                        lblDisplayTotal.Text = cal.GetSum(num1, num2).ToString();
                        cal.CalculateEvent -= new Formula<double>(cal.GetSum);
                        break;
                    case "-":
                        cal.CalculateEvent += new Formula<double>(cal.GetDifference);
                        lblDisplayTotal.Text = cal.GetDifference(num1, num2).ToString();
                        cal.CalculateEvent -= new Formula<double>(cal.GetDifference);
                        break;
                    case "*":
                        cal.CalculateEvent += new Formula<double>(cal.GetProduct);
                        lblDisplayTotal.Text = cal.GetProduct(num1, num2).ToString();
                        cal.CalculateEvent -= new Formula<double>(cal.GetProduct);
                        break;
                    case "/":
                        cal.CalculateEvent += new Formula<double>(cal.GetQuotient);
                        lblDisplayTotal.Text = cal.GetQuotient(num1, num2).ToString();
                        cal.CalculateEvent -= new Formula<double>(cal.GetQuotient);
                        break;
                    default:
                        // Validates the arithmetic operator selected in the combo box
                        MessageBox.Show("Operator is not recognized!");
                        break;
                }
            }
        }

        private bool isInputValid()
        {
            if (string.IsNullOrWhiteSpace(txtBoxInput1.Text) || string.IsNullOrWhiteSpace(txtBoxInput2.Text)) 
            {
                MessageBox.Show("Please do not leave any of the number boxes empty!");
                return false;
            }
            try
            {
                num1 = double.Parse(txtBoxInput1.Text);
                num2 = double.Parse(txtBoxInput2.Text);
            }
            catch (FormatException err)
            {
                MessageBox.Show("Please make sure you typed in valid numbers!");
                return false;
            }
            return true;
        }
    }
}
