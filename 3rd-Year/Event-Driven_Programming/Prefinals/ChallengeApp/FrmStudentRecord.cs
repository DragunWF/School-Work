namespace ChallengeApp
{
    public partial class FrmStudentRecord : Form
    {
        private string path;

        public FrmStudentRecord()
        {
            InitializeComponent();
            lvRecords.View = View.Details;
            lvRecords.FullRowSelect = true;
            lvRecords.Columns.Add("Student Records:", -2);

            FormClosed += FrmStudentRecord_FormClosed;
        }

        private void FrmStudentRecord_FormClosed(object sender, FormClosedEventArgs e)
        {
            // Makes sure to close the forms that are hidden
            FormManager.getFrmRegistration().Close();
        }

        private void btnRegister_Click(object sender, EventArgs e)
        {
            FormManager.openRegistrationForm();
        }

        private void btnFind_Click(object sender, EventArgs e)
        {
            openFileDialog1.InitialDirectory = @"C:\";
            openFileDialog1.Title = "Browse Text Files";
            openFileDialog1.DefaultExt = "txt";
            openFileDialog1.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";

            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                path = openFileDialog1.FileName;
                lvRecords.Items.Clear(); // For clearing previous items

                using (StreamReader streamReader = File.OpenText(path))
                {
                    string line;
                    while ((line = streamReader.ReadLine()) != null)
                    {
                        lvRecords.Items.Add(new ListViewItem(line));
                    }
                }
            }
        }

        private void btnUpload_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Successfully Uploaded!");
            lvRecords.Items.Clear();
        }
    }
}
