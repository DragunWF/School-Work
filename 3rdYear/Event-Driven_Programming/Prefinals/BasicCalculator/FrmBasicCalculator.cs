using CalculatorPrivateAssembly;

namespace BasicCalculator
{
    public partial class FrmBasicCalculator : Form
    {
        public FrmBasicCalculator()
        {
            InitializeComponent();
            string[] operators = { "+", "-", "*", "/" };
            foreach (string symbol in operators)
            {
                OperatorCB.Items.Add(symbol);
            }
        }

        private void ComputeBtn_Click(object sender, EventArgs e)
        {
            try
            {
                float firstNum = float.Parse(FirstNumText.Text);
                float secondNum = float.Parse(SecondNumText.Text);
                string operation = OperatorCB.Text;
                switch (operation)
                {
                    case "+":
                        TotalText.Text = BasicComputation.Addition(firstNum, secondNum).ToString();
                        break;
                    case "-":
                        TotalText.Text = BasicComputation.Subtraction(firstNum, secondNum).ToString();
                        break;
                    case "*":
                        TotalText.Text = BasicComputation.Multiplication(firstNum, secondNum).ToString();
                        break;
                    case "/":
                        TotalText.Text = BasicComputation.Division(firstNum, secondNum).ToString();
                        break;
                    default:
                        throw new Exception("Invalid operator");
                }
            }
            catch (Exception err)
            {
                MessageBox.Show($"Make sure to validate your input! - {err.Message}");
            }
        }
    }
}