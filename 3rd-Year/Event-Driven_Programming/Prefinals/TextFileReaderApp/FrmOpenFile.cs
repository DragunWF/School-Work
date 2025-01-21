namespace TextFileReaderApp
{
    public partial class FrmOpenFile : Form
    {
        private string path;

        public FrmOpenFile()
        {
            InitializeComponent();
            lvShowText.View = View.Details;
            lvShowText.FullRowSelect = true;

            lvShowText.Columns.Add("Text Read From File:", -2); // The -2 width makes the column fit the ListView width
        }

        private void btnOpen_Click(object sender, EventArgs e)
        {
            DisplayToList();
        }

        private void DisplayToList()
        {
            // I had to change the code a bit from the lab's pdf because that one throws
            // an error if the user closes the dialog without choosing any path.
            // My modification makes sure that does not happen.
            openFileDialog1.InitialDirectory = @"C:\";
            openFileDialog1.Title = "Browse Text Files";
            openFileDialog1.DefaultExt = "txt";
            openFileDialog1.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";

            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                path = openFileDialog1.FileName;
                lvShowText.Items.Clear(); // For clearing previous items

                using (StreamReader streamReader = File.OpenText(path))
                {
                    string line;
                    while ((line = streamReader.ReadLine()) != null)
                    {
                        lvShowText.Items.Add(new ListViewItem(line));
                    }
                }
            }
        }
    }
}
