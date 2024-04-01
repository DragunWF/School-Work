class Program
{
    static void Main()
    {
        // Doing this for practice
        // 1
        string[] classmates = { "Bastian", "Sardia", "Buante", "Gidan", "Kyle", "Marc" };
        foreach (string classmate in classmates)
        {
            Console.WriteLine(classmate);
        }

        // 2
        char[][] alphabets = {
            new char[] { 'a', 'b', 'c' }, new char[] { 'd', 'e', 'f' }
        };

        // 3
        string message = "why hello there!";
        Console.WriteLine(message.Contains("hello"));
    }
}
