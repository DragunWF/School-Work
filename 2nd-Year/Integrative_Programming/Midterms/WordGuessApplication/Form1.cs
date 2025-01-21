using System.Text;

namespace WordGuessApplication
{
    public partial class Form1 : Form
    {
        private const string correctWord = "ubiquity";

        public Form1()
        {
            InitializeComponent();
            StringBuilder incompleteWord = new StringBuilder();
            incompleteWord.Append(correctWord[0]);
            for (int i = 1; i < correctWord.Length; i++)
            {
                incompleteWord.Append(i % 2 == 0 ? correctWord[i] : "?");
            }
            wordLabel.Text = incompleteWord.ToString();
        }

        private void guessButton_Click(object sender, EventArgs e)
        {
            string guess = wordBox.Text.ToLower(); // case insensitive
            if (guess == correctWord)
            {
                wordLabel.Text = correctWord;
                MessageBox.Show("Correct guess");
            }
            else
            {
                wrongWordList.Items.Add(guess);
                MessageBox.Show("Wrong guess!\nTry Again.");
            }
            wordBox.Text = "";
        }
    }
}
