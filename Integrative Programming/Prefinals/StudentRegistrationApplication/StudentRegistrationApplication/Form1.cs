namespace StudentRegistrationApplication
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            List<string> programs = new()
            {
                "Bachelor of Science in Computer Science",
                "Bachelor of Science in Information Technology",
                "Bachelor of Science in Information Science",
                "Bachelor of Science in Computer Engineering"
            };

            for (int i = 1; i <= 31; i++)
            {
                dayComboBox.Items.Add(i.ToString());
            }
            for (int i = 1; i <= 12; i++)
            {
                monthComboBox.Items.Add(i.ToString());
            }
            for (int i = 1900; i <= 2024; i++)
            {
                yearComboBox.Items.Add(i.ToString());
            }
            foreach (string program in programs)
            {
                programComboBox.Items.Add(program);
            }
        }

        private void OnRegisterStudent(object sender, EventArgs e)
        {
            if (firstNameText.Text.Length == 0 || lastNameText.Text.Length == 0)
            {
                MessageBox.Show("First and last name fields cannot be empty!");
            }
            else if (dayComboBox.Text == "-Day-" || monthComboBox.Text == "-Month-" || yearComboBox.Text == "-Year-")
            {
                MessageBox.Show("Please select an option from all combo boxes in your date of birth!");
            }
            else if (programComboBox.Text == "-Select Program-")
            {
                MessageBox.Show("Please select a program!");
            }
            else
            {
                Display(GetName(), GetProgram());
                Display(GetName(), GetProgram(), GetGender());
                Display(GetName(), GetProgram(), GetGender(), GetBirthDate());
            }
        }

        private void Display(string inputName, string inputProgram)
        {
            string fullName = inputName, program = inputProgram;
            MessageBox.Show($"Student Name: {fullName}\nProgram: {program}");
        }

        private void Display(string inputName, string inputProgram, string inputGender)
        {
            string fullName = inputName, program = inputProgram, gender = inputGender;
            MessageBox.Show($"Student Name: {fullName}\nGender: {gender}\nProgram: {program}");
        }

        private void Display(string inputName, string inputProgram, string inputGender, string inputBirth)
        {
            string fullName = inputName, program = inputProgram, gender = inputGender, birthDate = inputBirth;
            MessageBox.Show($"Student Name: {fullName}\nGender: {gender}\nDate of birth: {birthDate}\nProgram: {program}");
        }

        private string GetName()
        {
            return $"{firstNameText.Text} {middleNameText.Text} {lastNameText.Text}";
        }

        private string GetGender()
        {
            return maleRadioButton.Checked ? "Male" : "Female";
        }

        private string GetProgram()
        {
            return programComboBox.Text;
        }

        private string GetBirthDate()
        {
            return $"{dayComboBox.Text}/{monthComboBox.Text}/{yearComboBox.Text}";
        }

        private void BrowseButton_Click(object sender, EventArgs e)
        {
            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                pictureBox1.Image = new Bitmap(openFileDialog1.FileName);
            }
        }
    }
}