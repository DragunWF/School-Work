namespace _05_LabExer_1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

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
        }

        private void OnRegisterStudent(object sender, EventArgs e)
        {
            if (firstNameText.Text.Length == 0 || lastNameText.Text.Length == 0)
            {
                MessageBox.Show("First and last name fields cannot be empty!");
            }
            else if (!maleRadioButton.Checked && !femaleRadioButton.Checked)
            {
                MessageBox.Show("Please select a gender!");
            }
            else if (dayComboBox.Text == "-Day-" || monthComboBox.Text == "-Month-" || yearComboBox.Text == "-Year-")
            {
                MessageBox.Show("Please select an option from all combo boxes in your date of birth!");
            }
            else
            {
                string fullName = $"{firstNameText.Text} {middleNameText.Text} {lastNameText.Text}";
                string gender = maleRadioButton.Checked ? "Male" : "Female";
                string birthDate = $"{dayComboBox.Text}/{monthComboBox.Text}/{yearComboBox.Text}";
                MessageBox.Show($"Student name: {fullName}\nGender: {gender}\nDate of birth: {birthDate}");
            }
        }

        private void maleRadioButton_CheckedChanged(object sender, EventArgs e)
        {
            femaleRadioButton.Checked = false;
        }

        private void femaleRadioButton_CheckedChanged(object sender, EventArgs e)
        {
            maleRadioButton.Checked = false;
        }
    }
}