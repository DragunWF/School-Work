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

    def get_name(self) -> str:
        return self.__name

    def get_arrival_time(self) -> int:
        return self.__arrival_time

    def get_burst_time(self) -> int:
        return self.__burst_time

    def calculate_turnaround_time(self) -> None:
        if self.__waiting_time is None:
            print(
                f"Waiting time has to be calculated first for process {self.__name}")
        elif self.__turnaround_time is None:
            self.__turnaround_time = self.__burst_time + self.__waiting_time
        else:
            print(
                f"Turnaround time has already been calculated for process {self.__name}")

    def get_turnaround_time(self) -> int:
        return self.__turnaround_time

    def set_waiting_time(self, value: int) -> None:
        self.__waiting_time = value

    def get_waiting_time(self) -> int:
        return self.__waiting_time


class FCFS:
    def __init__(self, attributes: tuple[tuple[int]]):
        self.__attributes: tuple[tuple[int]] = attributes
        self.__ready_queue: list[Process] = deque([])
        self.__average_waiting_time: int = None
        self.__average_turnaround_time: int = None
        self.__burst_times: list[tuple[int]] = []

    def main(self) -> None:
        self.add_table_contents()
        self.fcfs()
        self.order_processes()
        self.calculate_waiting_times()
        self.calculate_turnaround_times()
        self.calculate_averages()

        print("Gantt Chart")
        self.display_gantt_chart()

        print(f"Average Waiting Time: {self.__average_waiting_time}")
        print(f"Average Turnaround Time: {self.__average_turnaround_time}")

    def add_table_contents(self) -> None:
        for i in range(len(self.__attributes)):
            self.__ready_queue.append(
                Process(f"P{i + 1}", self.__attributes[i][0], self.__attributes[i][1]))

    def order_processes(self) -> None:
        current_waiting_time: int = 0
        for process in self.__ready_queue:
            self.__burst_times.append(
                (current_waiting_time, current_waiting_time + process.get_burst_time()))
            current_waiting_time += process.get_burst_time()

    def fcfs(self) -> None:
        # First-Come First-Serve Scheduling
        for i in range(len(self.__ready_queue)):
            is_sorted = True
            for j in range(len(self.__ready_queue) - 1):
                if self.__ready_queue[j].get_arrival_time() > self.__ready_queue[j + 1].get_arrival_time():
                    self.__ready_queue[j], self.__ready_queue[j + 1] = (
                        self.__ready_queue[j + 1], self.__ready_queue[j])
                    is_sorted = False
            if is_sorted:
                break

    def srtf(self) -> None:
        # Shortest Time Remaining First
        pass

    def round_robin(self, quantum: int) -> None:
        pass

    def calculate_waiting_times(self):
        for i in range(len(self.__ready_queue)):
            self.__ready_queue[i].set_waiting_time(self.__burst_times[i][0])

    def calculate_turnaround_times(self):
        for i in range(len(self.__ready_queue)):
            self.__ready_queue[i].calculate_turnaround_time()

    def calculate_averages(self):
        queue_len = len(self.__ready_queue)
        self.__average_waiting_time = round(
            sum([p.get_waiting_time() for p in self.__ready_queue]) / queue_len, 4)
        self.__average_turnaround_time = round(
            sum([p.get_turnaround_time() for p in self.__ready_queue]) / queue_len, 4)

    def display_gantt_chart(self) -> None:
        queue_len = len(self.__ready_queue)
        for i in range(queue_len):
            process = self.__ready_queue[i]
            print(f"{process.get_waiting_time()} {process.get_name()}", end=" ")
        print(self.__burst_times[queue_len - 1][1])


class Test:
    @staticmethod
    def print_values(values: list[Process], key: str) -> None:
        match (key):
            case "arrival_time":
                print([p.get_arrival_time() for p in values])
            case "burst_time":
                print([p.get_burst_time() for p in values])
            case "name":
                print([p.get_name() for p in values])
            case _:
                raise Exception("Invalid key for process!")


if __name__ == '__main__':
    # First index is the arrival time and the second index is the burst time
    FCFS(((2, 3), (3, 5), (0, 2), (1, 4), (4, 6))).main()
