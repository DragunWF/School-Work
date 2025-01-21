namespace ChallengeApp
{
    public partial class FrmRegistration : Form
    {
        public FrmRegistration()
        {
            InitializeComponent();
            FormManager.setFrmRegistration(this);
        }

        private void btnRegister_Click(object sender, EventArgs e)
        {
            // Form Data
            string fileName = $"{txtStudentNo.Text}.txt";
            string fullName = $"{txtLastName.Text}, {txtFirstName.Text}, {txtMI.Text}";
            string correctDateFormat = dtpBirthday.Value.ToString("yyyy-MM-dd");
            string[] info =
            {
                $"Student No.: {txtStudentNo.Text}",
                $"Full Name: {fullName}",
                $"Program: {cbProgram.Text}",
                $"Gender: {cbGender.Text}",
                $"Age: {txtAge.Text}",
                $"Birthday: {correctDateFormat}",
                $"Contact No.: {txtContactNo.Text}"
            };

            // Write to text file
            string docPath = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);
            using (StreamWriter outputFile = new StreamWriter(Path.Combine(docPath, fileName)))
            {
                foreach (string line in info)
                {
                    outputFile.WriteLine(line);
                }
            }

            // I added this extra bit so I and the users can know where the file is located at
            MessageBox.Show($"Your file has been generated at {docPath}\\{fileName}");
        }

        private void btnRecords_Click(object sender, EventArgs e)
        {
            FormManager.openStudentRecordForm();
        }
    }
}
