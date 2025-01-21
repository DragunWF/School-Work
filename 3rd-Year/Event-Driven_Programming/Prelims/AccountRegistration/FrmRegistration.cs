namespace AccountRegistration
{
    public partial class FrmRegistration : Form
    {
        private readonly TextBox[] textBoxes;

        public FrmRegistration()
        {
            InitializeComponent();
            textBoxes = new TextBox[] {
                studentNoTextBox, lastNameTextBox, firstNameTextBox,
                middleNameTextBox, ageTextBox, contactNoTextBox
            };
        }

        private void nextButton_Click(object sender, EventArgs e)
        {
            if (!validateData())
            {
                MessageBox.Show("Please make sure that you've filled in all of the textboxes!");
                return;
            }

            StudentInfoClass.FirstName = firstNameTextBox.Text;
            StudentInfoClass.LastName = lastNameTextBox.Text;
            StudentInfoClass.MiddleName = middleNameTextBox.Text;
            StudentInfoClass.Address = addressRichTextBox.Text;
            StudentInfoClass.Program = programComboBox.Text;
            
            // Validates the number text boxes to make sure the user entered a valid number
            try
            {
                StudentInfoClass.Age = long.Parse(ageTextBox.Text);
                StudentInfoClass.ContactNo = long.Parse(contactNoTextBox.Text);
                StudentInfoClass.StudentNo = long.Parse(studentNoTextBox.Text);
            } 
            catch (FormatException err)
            {
                MessageBox.Show("Please make sure you type in a number for the age, contact number, and student number fields!");
                return;
            }

            // Resets the textbox values when the confirm dialog results in OK
            if (new FrmConfirm().ShowDialog() == DialogResult.OK)
            {
                foreach (TextBox textBox in textBoxes)
                {
                    textBox.Text = "";
                }
                programComboBox.Text = "";
                addressRichTextBox.Text = "";
            }
        }

        private bool validateData()
        {
            foreach (TextBox textBox in this.textBoxes)
            {
                if (string.IsNullOrWhiteSpace(textBox.Text))
                {
                    return false;
                }
            }
            return !(string.IsNullOrWhiteSpace(programComboBox.Text) || 
                     string.IsNullOrWhiteSpace(addressRichTextBox.Text));
        }
    }
}