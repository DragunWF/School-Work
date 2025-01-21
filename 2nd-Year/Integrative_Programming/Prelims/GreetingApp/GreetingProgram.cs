using System;

namespace GreetingApp
{
    class GreetingProgram
    {
        static void Main()
        {
            string name = input("Enter your name");
            int enrolledCourses = int.Parse(input("Enter the total number of your enrolled courses"));
            float favoriteBookPrice = float.Parse(input("Enter the price of your favorite book"));
            Console.WriteLine($"Name: {name}");
            Console.WriteLine($"Total enrolled courses: {enrolledCourses}");
            Console.WriteLine($"Price of my favorite book: {favoriteBookPrice}");
        }

        private static string input(string prompt)
        {
            Console.Write($"{prompt}: ");
            return Console.ReadLine();
        }
    }
}
