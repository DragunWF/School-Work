namespace StudentGradeApplication
{
    public partial class FrmStudentGradeProgram : Form
    {
        public FrmStudentGradeProgram()
        {
            InitializeComponent();
        }

        private void generateAverageButton_Click(object sender, EventArgs e)
        {
            var name = nameTextBox.Text;
            try
            {
                double[] grades =
                {
                    double.Parse(englishTextBox.Text),
                    double.Parse(mathTextBox.Text),
                    double.Parse(scienceTextBox.Text),
                    double.Parse(filipinoTextBox.Text),
                    double.Parse(historyTextBox.Text)
                };

                double total = 0;
                foreach (double grade in grades)
                {
                    total += grade;
                }
                double average = total / grades.Length;
                var resultStr = average >= 75 ? "passed" : "failed";
                resultText.Text = $"The student has {resultStr}";
                averageLabel.Text = $"The average grade of {name} is {total / grades.Length}";
            }
            catch (Exception err)
            {
                MessageBox.Show("Please make sure your input is correct!");
            }
        }
    }
}