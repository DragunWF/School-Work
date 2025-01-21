using System;

namespace ComputeAverageApp
{
    class ComputeAverageProgram
    {
        private static void Main()
        {
            const int GRADE_COUNT = 5;
            Console.WriteLine($"Enter {GRADE_COUNT} grades separated by a new line:");
            double sum = 0;
            for (int i = 0; i < GRADE_COUNT; i++)
            {
                sum += double.Parse(Console.ReadLine());
            }
            double average = sum / GRADE_COUNT;
            Console.WriteLine($"The average is {average} and round off to {Math.Round(average)}");
        }
    }
}
