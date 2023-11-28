from rich import print
from tabulate import tabulate
from collections import deque


class Process:
    def __init__(self, name:str, arrival_time:int, burst_time: int):
        self.__name = name
        self.__arrival_time = arrival_time
        self.__burst_time = burst_time
        self.__waiting_time = None
        self.__turnaround_time = None

    def calculate_turnaround_time(self) -> None:
        if self.__waiting_time == None:
            print(f"Waiting time has to be calculated first for process {self.__name}")
        elif self.__turnaround_time != None:
            self.__turnaround_time = self.__burst_time + self.__waiting_time
        else:
            print(f"Turnaround time has already been calculated for process {self.__name}")

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
        self.__ready_queue:list[Process] = deque([])
        self.__average_waiting_time: int = None
        self.__average_turnaround_time: int = None
        self.__burst_times:list[tuple[int]] = []

    def main(self) -> None:
        self.add_table_contents(self.__ready_queue)
        self.bubble_sort(self.__ready_queue)
        Test.print_values(self.__ready_queue, "arrival_time")
        self.display_processes(self.__ready_queue)

    def add_table_contents(self, queue: list[Process]) -> None:
        # First index is arrival time and the second index is burst time
        attributes:tuple[tuple[int]] = ((2, 3), (3, 5),(0, 2), (1, 4), (4, 6))
        for i in range(len(attributes)):
            queue.append(Process(f"P{i + 1}", attributes[i][0], attributes[i][1]))

    def display_processes(self, queue: list[Process]) -> None:
        current_waiting_time:int = 0
        for process in queue:
            self.__burst_times.append((current_waiting_time, current_waiting_time + process.get_burst_time()))
            current_waiting_time += process.get_burst_time()

    def bubble_sort(self, queue: list[Process]) -> None:
        for i in range(len(queue)):
            is_sorted:bool = True
            for j in range(len(queue) - 1):
                if queue[j].get_arrival_time() > queue[j + 1].get_arrival_time():
                    queue[j], queue[j + 1] = queue[j + 1], queue[j]
                    is_sorted = False
            if is_sorted:
                break

    def display_gantt_chart(self) -> None:
        pass


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
    FCFS().main()
