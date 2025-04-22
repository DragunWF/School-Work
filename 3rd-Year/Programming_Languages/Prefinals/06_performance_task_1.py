# Marc Plarisan | BSIT601 | Programming Languages
# Numerical input provided in both indirect and direct way
# Indirect: Numerical input through dictionary mapping
# Direct: Conversion of string to float

class Expense:
    def __init__(self, category_name: str):
        self.category_name = category_name
        self.estimated_cost = 0

    def enter_cost(self) -> None:
        self.input_choice()

    def input_choice(self) -> None:
        try:
            self.estimated_cost = float(
                input(f"{self.category_name} Estimated Cost: ")
            )
        except ValueError:
            return self.input_choice()

    def calculate_estimated_cost(self) -> float:
        self.estimated_cost = self.choices[self.chosen]


class PredefinedExpense(Expense):
    def __init__(self, category_name: str, choices: dict[str, float | int]):
        super().__init__(category_name)
        self.choices = choices
        self.chosen = None

    def enter_cost(self) -> None:
        self.input_choice()
        self.calculate_estimated_cost()

    def input_choice(self) -> None:
        self.print_choices()
        user_choice = input(f"Enter {self.category_name}: ").lower()
        if not user_choice in self.choices:
            print("Not a valid choice!")
            return self.input_choice()
        self.chosen = user_choice
        print()

    def print_choices(self) -> None:
        print(f"{self.category_name} Choices:")
        for choice, estimated_cost in self.choices.items():
            print(f"- {choice} ({estimated_cost} PHP)")


class Program:
    @staticmethod
    def main() -> None:
        expense_categories = (
            PredefinedExpense("Venue", {"home": 350.25,
                                        "stadium": 10300.35, "mcdo": 5750.75}),
            PredefinedExpense("Catering", {"buffet": 1250.95,
                                           "dessert": 530.25, "bbq": 755.23}),
            PredefinedExpense("decorations", {"normal": 250, "royalty": 1500}),
            PredefinedExpense("entertainment", {
                              "clowns": 500, "netflix": 750}),
            Expense("Miscellenous")
        )
        for category in expense_categories:
            category.enter_cost()

        predefined_budget = Program.enter_budget()
        total_estimated_cost = Program.get_total_estimated_cost(
            expense_categories
        )
        print(f"Total Estimated Cost: {total_estimated_cost} PHP")

        if predefined_budget >= total_estimated_cost:
            print("Expenses are within the budget")
        else:
            print("Expenses are outside the budget!")

    @staticmethod
    def enter_budget() -> float:
        try:
            return float(input("Predefined Budget: "))
        except ValueError:
            print("Invalid input! Enter a valid number...")
            return Program.enter_budget()

    @staticmethod
    def get_total_estimated_cost(expense_categories: list[Expense]) -> float:
        total_estimated_cost = 0
        for category in expense_categories:
            total_estimated_cost += category.estimated_cost
        return total_estimated_cost


if __name__ == "__main__":
    Program.main()
