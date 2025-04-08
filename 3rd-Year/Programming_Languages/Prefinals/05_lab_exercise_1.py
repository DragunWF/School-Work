# Marc Plarisan | BSIT601 | Programming Languages - 05 Lab Exercise 1

class Trip:
    def __init__(self, starting_location: str, destination: str, mode_of_transport: str, distance: float, speed: float):
        self.starting_location = starting_location
        self.destination = destination
        self.mode_of_transport = mode_of_transport

        self.distance = distance
        self.speed = speed

    def compute_travel_time(self) -> float:
        return self.distance / self.speed

    def is_long_trip(self) -> bool:
        return self.compute_travel_time() > 5

    def print_details(self) -> None:
        print(f"""
Starting Location: {self.starting_location}
Destination: {self.destination}
Mode of Transport: {self.mode_of_transport}
Distance: {self.distance}
Speed: {self.speed}
Takes more than 5 hours: {self.is_long_trip()}
Total Travel Time: {round(self.compute_travel_time(), 1)} Hours
""")


class Program:
    @staticmethod
    def main() -> None:
        trip = Trip(
            input("Starting Location: "),
            input("Destination: "),
            input("Mode of Transport: "),
            Program.num_input("Distance (Kilometers): "),
            Program.num_input("Speed (KM/H): ")
        )
        if trip.is_long_trip():
            print(
                "Warning Time: Travel time will take more than 5 hours. A stop/rest is recommended."
            )
        trip.print_details()

    @staticmethod
    def num_input(prompt: str) -> float:
        try:
            return float(input(prompt))
        except ValueError:
            print("Invalid input! Please try again...")
            return Program.num_input(prompt)


if __name__ == "__main__":
    Program.main()
