using System;
using System.Globalization;

class GreetingProgram
{
    public static void Main()
    {
        string name = input("Enter your name");
        int enrolledCourses = int.Parse(input("Enter the total number of your enrolled courses"));
        float favoriteBookPrice = float.Parse(input("Enter the price of your favorite book"));
        Console.WriteLine($"Name: {name}");
        Console.WriteLine($"Enrolled Courses: {enrolledCourses}");
        Console.WriteLine($"Favorite Book Price: {favoriteBookPrice}");
    }

    private static string input(string prompt)
    {
        Console.Write($"{prompt}: ");
        #pragma warning disable CS8603 // Possible null reference return.
        return Console.ReadLine();
    }
}
