from rich import print
from tabulate import tabulate
from collections import deque


class Process:
    def __init__(self, name: str, arrival_time: int, burst_time: int):
        self.__name = name
        self.__arrival_time = arrival_time
        self.__burst_time = burst_time
        self.__waiting_time = None
        self.__turnaround_time = None

    def calculate_turnaround_time(self) -> None:
        if self.__waiting_time == None:
            print(
                f"Waiting time has to be calculated first for process {self.__name}")
        elif self.__turnaround_time != None:
            self.__turnaround_time = self.__burst_time + self.__waiting_time
        else:
            print(
                f"Turnaround time has already been calculated for process {self.__name}")

    def get_name(self) -> str:
        return self.__name

    def get_arrival_time(self) -> int:
        return self.__arrival_time

    def get_burst_time(self) -> int:
        return self.__burst_time

    def get_waiting_time(self) -> int:
        return self.__waiting_time

    def get_turnaround_time(self) -> int:
        return self.__turnaround_time


class FCFS:
    def __init__(self, attributes: tuple[tuple[int]]):
        self.__attributes: tuple[tuple[int]] = attributes
        self.__ready_queue: list[Process] = deque([])
        self.__average_waiting_time: int = None
        self.__average_turnaround_time: int = None
        self.__burst_times: list[tuple[int]] = []

    def main(self) -> None:
        self.add_table_contents()
        self.bubble_sort()
        Test.print_values(self.__ready_queue, "arrival_time")
        self.display_processes()
        self.display_gantt_chart()

    def add_table_contents(self) -> None:
        for i in range(len(self.__attributes)):
            self.__ready_queue.append(
                Process(f"P{i + 1}", self.__attributes[i][0], self.__attributes[i][1]))

    def display_processes(self) -> None:
        current_waiting_time: int = 0
        for process in self.__ready_queue:
            self.__burst_times.append(
                (current_waiting_time, current_waiting_time + process.get_burst_time()))
            current_waiting_time += process.get_burst_time()

    def bubble_sort(self) -> None:
        for i in range(len(self.__ready_queue)):
            is_sorted: bool = True
            for j in range(len(self.__ready_queue) - 1):
                if self.__ready_queue[j].get_arrival_time() > self.__ready_queue[j + 1].get_arrival_time():
                    self.__ready_queue[j], self.__ready_queue[j + 1] = (
                        self.__ready_queue[j + 1], self.__ready_queue[j])
                    is_sorted = False
            if is_sorted:
                break

    def calculate_waiting_times(self):
        pass

    def display_gantt_chart(self) -> None:
        print(Test.print_values(self.__ready_queue, "name"))
        print(self.__burst_times)


class Test:
    @staticmethod
    def print_values(values: list[Process], key: str) -> None:
        match (key):
            case "arrival_time":
                print([process.get_arrival_time() for process in values])
            case "burst_time":
                print([process.get_burst_time() for process in values])
            case "name":
                print([process.get_name() for process in values])
            case _:
                raise Exception("Invalid key for process!")


if __name__ == '__main__':
    # First index is the arrival time and the second index is the burst time
    FCFS(((2, 3), (3, 5), (0, 2), (1, 4), (4, 6))).main()
