/*
Note, this program isn't meant to be ran. I'm just here to code the instructions asked.
1. Create a method named getCircleDiameter that takes a radius of double type as the parameter. The method should return the diameter of a circle. To compute the diameter of a circle, multiply the radius by 2.
2. Create a struct named Product where its fields are code, description, and price. 
3. Create a class named Person with an instance variable named full_name. Declare one (1) constructor without a parameter and initialize the variable with a default value.
4. Create a class named Account with an instance variable named account_number. Make this class a member of the Accounts namespace. 
*/

// 1.
class Circle
{
    double getCircleDiameter(double radius)
    {
        return radius * 2;
    }
}

// 2.
struct Product
{
    string code;
    string description;
    double price;
}

// 3.
class Person
{
    string full_name;

    public Person(string full_name)
    {
        this.full_name = full_name;
    }
}

// 4.
namespace Accounts
{
    class Account
    {
        int account_number;
    }
}