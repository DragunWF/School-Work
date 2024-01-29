# Platform Technology (Operating Systems)
# Applying scheduling algorithms through Python code

# Requires two modules to install
# > pip install rich
# > pip install tabulate

from rich import print
from tabulate import tabulate
from collections import deque
from sys import argv


class Process:
    def __init__(self, name: str, arrival_time: int, burst_time: int):
        self.__name = name
        self.__arrival_time = arrival_time
        self.__burst_time = burst_time
        self.__start_burst_time = burst_time  # For displaying in the table
        self.__waiting_time: int = None
        self.__turnaround_time: int = None
        self.__completion_time: int = 0  # Default value

    def get_name(self) -> str:
        return self.__name

    def get_arrival_time(self) -> int:
        return self.__arrival_time

    def set_burst_time(self, value: int) -> None:
        self.__burst_time = value

    def get_burst_time(self) -> int:
        return self.__burst_time

    def get_start_burst_time(self) -> int:
        return self.__start_burst_time

    def set_completion_time(self, value) -> None:
        self.__completion_time = value

    def get_completion_time(self) -> int:
        return self.__completion_time

    def calculate_turnaround_time(self) -> None:
        if self.__completion_time is None:
            print(
                f"Process {self.__name}: Completion time has to be set first")
        elif self.__turnaround_time is None:
            self.__turnaround_time = self.__completion_time - self.__arrival_time
        else:
            print(
                f"Process {self.__name}: Turnaround time has already been calculated")

    def get_turnaround_time(self) -> int:
        return self.__turnaround_time

    def calculate_waiting_time(self) -> None:
        if self.__waiting_time is None:
            self.__waiting_time = self.__turnaround_time - self.__burst_time
        else:
            print(
                f"Process {self.__name}: Waiting time has already been calculated")

    def get_waiting_time(self) -> int:
        return self.__waiting_time


class ChartProcess:
    def __init__(self, start: int, name: str, end: int):
        self.__start = start
        self.__name = name
        self.__end = end

    def get_start(self) -> int:
        return self.__start

    def get_name(self) -> str:
        return self.__name

    def get_end(self) -> int:
        return self.__end

    def set_end(self, value: int) -> None:
        self.__end = value


class Scheduler:
    def __init__(self, queue: list[Process]):
        self.__ready_queue: list[Process] = deque(queue)
        self.__average_waiting_time: int = None
        self.__average_turnaround_time: int = None
        self.__gantt_chart: list[ChartProcess] = []
        self.__table = []

    def run(self, algorithm: str) -> None:
        self.__algorithm = algorithm.upper()
        match (self.__algorithm):
            case "FCFS":
                self.fcfs()
            case "SRTF":
                self.__srtf_chart: list[list] = [[0]]
                self.srtf()
            case "RR":
                self.round_robin(3)  # Default time quantum is 3
            case _:
                raise Exception("Scheduling algorithm not recognized!")

        self.set_completion_times()
        self.calculate_turnaround_times()
        self.calculate_waiting_times()
        self.calculate_averages()

        self.create_table()
        self.display_table()
        print(f"Average Waiting Time: {self.__average_waiting_time}")
        print(f"Average Turnaround Time: {self.__average_turnaround_time}")
        self.display_gantt_chart()

    def fcfs(self) -> None:
        # First-Come First-Serve
        # A simple bubble sort to sort the processes by its arrival time
        self.sort_ready_queue_by_arrival()

        # Visualize the Gantt Chart
        current_waiting_time = 0
        for process in self.__ready_queue:
            new_waiting_time = current_waiting_time + process.get_burst_time()
            self.__gantt_chart.append(
                ChartProcess(current_waiting_time, process.get_name(),
                             new_waiting_time))
            # process.set_completion_time(current_waiting_time)
            current_waiting_time += process.get_burst_time()

    def sjf(self) -> None:
        # Shortest Job First
        self.sort_ready_queue_by_arrival()

    def srtf(self) -> None:
        # Shortest Time Remaining First
        first_process = Utils.get_min_arrival_time(self.__ready_queue)
        current_processes: list[Process] = [first_process]
        max_time = Utils.get_max_time(self.__ready_queue)
        current_waiting_time = 1
        time_passed = 1

        self.__gantt_chart.append(ChartProcess(
            0, current_processes[0].get_name(), 1))
        first_process_index = self.__ready_queue.index(first_process)
        self.__ready_queue[first_process_index].set_completion_time(1)
        while time_passed <= max_time:
            # Enter processes when time passed meets its arrival time
            for process in self.__ready_queue:
                if process.get_arrival_time() == time_passed:
                    current_processes.append(process)

            # Burst Time Logic
            attributes: dict = Utils.get_min_burst_time(current_processes)
            min_process: Process = current_processes[attributes["index"]]
            min_process.set_burst_time(min_process.get_burst_time() - 1)

            # Identify when process is finished
            is_process_finished = False
            if min_process.get_burst_time() <= 0:
                is_process_finished = True

            # New Gantt Chart Logic
            if attributes["name"] != self.__gantt_chart[-1].get_name():
                self.__gantt_chart.append(ChartProcess(current_waiting_time, attributes["name"],
                                                       current_waiting_time))
            else:
                CURRENT_END_TIME = self.__gantt_chart[-1].get_end()
                self.__gantt_chart[-1].set_end(CURRENT_END_TIME + 1)

            # Pop process when burst time goes to 0 (Process finished)
            if is_process_finished:
                current_processes.pop(attributes["index"])

            # Increment time
            current_waiting_time += 1
            time_passed += 1

        for process in self.__gantt_chart:
            print([process.get_start(), process.get_name(), process.get_end()])

        # Old logic of setting completion time (doesn't work)
        # ready_queue_names = [p.get_name() for p in self.__ready_queue]
        # for i in range(1, len(self.__srtf_chart) - 1):
        #     completion_time = self.__srtf_chart[i + 1][1]
        #     process_index = ready_queue_names.index(self.__srtf_chart[i][0])
        #     current_ct = self.__ready_queue[process_index].get_completion_time()
        #     self.__ready_queue[process_index].set_completion_time(
        #         current_ct + completion_time)

    def round_robin(self, quantum: int) -> None:
        min_arrival_time = min([p.get_arrival_time()
                               for p in self.__ready_queue])
        current_queue: list[Process] = [
            p for p in self.__ready_queue if p.get_arrival_time() == min_arrival_time]
        self.__gantt_chart.append(ChartProcess(
            0, current_queue[0].get_name(), 1))

        process_index = 0
        time_passed = 0

        while current_queue:
            quantum_loop_met = False
            time_passed += 1

            # Add the processes that meet the arrival time
            for process in self.__ready_queue:
                if time_passed == process.get_arrival_time():
                    current_queue.append(process)
            if not current_queue:
                continue

            # Decrement the burst time of the process per iteration
            current_queue[process_index].set_burst_time(
                current_queue[process_index].get_burst_time() - 1)

            # Pop the process out of the queue once burst time runs out
            if current_queue[process_index].get_burst_time() <= 0:
                current_queue.pop(process_index)
                quantum_loop_met = True
            elif time_passed % quantum == 0:
                # When time passed meets the time quantum it switches to the next process of the circular queue
                process_index += 1
                quantum_loop_met = True

                # Process loops back at the beginning after the end
                if process_index >= len(current_queue):
                    process_index = 0

            # Update the Gantt Chart representation
            if quantum_loop_met and current_queue:
                self.__gantt_chart.append(ChartProcess(time_passed, current_queue[process_index].get_name(),
                                                       time_passed))
            # print(f"{[p.get_name() for p in current_queue]} {current_queue[process_index].get_name()}")

    def sort_ready_queue_by_arrival(self):
        for i in range(len(self.__ready_queue)):
            is_sorted = True
            for j in range(len(self.__ready_queue) - 1):
                if self.__ready_queue[j].get_arrival_time() > self.__ready_queue[j + 1].get_arrival_time():
                    self.__ready_queue[j], self.__ready_queue[j +
                                                              1] = self.__ready_queue[j + 1], self.__ready_queue[j]
                    is_sorted = False
            if is_sorted:
                break

    def set_completion_times(self) -> None:
        for process in self.__gantt_chart:
            process_index = None
            for i in range(len(self.__ready_queue)):
                if self.__ready_queue[i].get_name() == process.get_name():
                    process_index = i
                    break
            if process_index is None:
                raise Exception("Process not found!")
            self.__ready_queue[process_index].set_completion_time(
                process.get_end())

    def calculate_waiting_times(self) -> None:
        for i in range(len(self.__ready_queue)):
            self.__ready_queue[i].calculate_waiting_time()

    def calculate_turnaround_times(self) -> None:
        for i in range(len(self.__ready_queue)):
            self.__ready_queue[i].calculate_turnaround_time()

    def calculate_averages(self) -> None:
        queue_len = len(self.__ready_queue)
        self.__average_waiting_time = round(
            sum([p.get_waiting_time() for p in self.__ready_queue]) / queue_len, 4)
        self.__average_turnaround_time = round(
            sum([p.get_turnaround_time() for p in self.__ready_queue]) / queue_len, 4)

    def create_table(self) -> None:
        for process in self.__ready_queue:
            self.__table.append([process.get_name(), process.get_arrival_time(),
                                 process.get_start_burst_time(), process.get_completion_time(),
                                 process.get_turnaround_time(), process.get_waiting_time()])

    def display_table(self) -> None:
        algorithm_names = {"FCFS": "First-Come, First-Serve", "SRTF": "Shortest Remaining Time First",
                           "RR": "Round Robin"}
        print(
            f"{self.__algorithm}: {algorithm_names[self.__algorithm]} - Scheduling Algorithm")
        print(tabulate(self.__table, headers=["Name", "Arrival Time",
                                              "Burst Time", "Finish Time",
                                              "Turnaround Time", "Waiting Time"],
                       tablefmt="simple_grid"))

    def display_gantt_chart(self) -> None:
        print("+--------------- Gantt Chart ---------------+")
        for i in range(len(self.__gantt_chart)):
            process: ChartProcess = self.__gantt_chart[i]
            if (i + 1) != len(self.__gantt_chart):
                print(f"| {process.get_start()} | {process.get_name()}", end=" ")
            else:
                print(
                    f"| {process.get_start()} | {process.get_name()} | {process.get_end()}")


class Utils:
    @staticmethod
    def get_min_burst_time(queue: list[Process]) -> dict:
        if not queue:
            return None
        min_value = queue[0].get_burst_time()
        min_process_name = queue[0].get_name()
        min_process_index = 0
        for i in range(1, len(queue)):
            if queue[i].get_burst_time() < min_value and queue[i].get_burst_time() != 0:
                min_value = queue[i].get_burst_time()
                min_process_name = queue[i].get_name()
                min_process_index = i
        return {"name": min_process_name, "index": min_process_index}

    @staticmethod
    def get_min_arrival_time(queue: list[Process]) -> Process:
        min_process = queue[0]
        min_arrival_time = queue[0].get_arrival_time()
        for process in queue:
            if process.get_arrival_time() < min_arrival_time:
                min_process = process
                min_arrival_time = process.get_arrival_time()
        return min_process

    @staticmethod
    def get_max_time(queue: list[Process]) -> int:
        return sum([p.get_burst_time() for p in queue])

    @staticmethod
    def print_values(values: list[Process], key: str) -> None:
        # For Testing
        match (key):
            case "arrival_time":
                print([p.get_arrival_time() for p in values])
            case "burst_time":
                print([p.get_burst_time() for p in values])
            case "completion_time":
                print([p.get_completion_time() for p in values])
            case "waiting_time":
                print([p.get_waiting_time() for p in values])
            case "name":
                print([p.get_name() for p in values])
            case _:
                raise Exception("Invalid key for process!")

    @staticmethod
    def display_chart(values: list[ChartProcess]) -> None:
        print("Test Gantt Chart")
        for i in range(len(values)):
            process: ChartProcess = values[i]
            if (i + 1) != len(values):
                print(f"{process.get_start()} {process.get_name()}", end=" ")
            else:
                print(
                    f"{process.get_start()} {process.get_name()} {process.get_end()}")


class ProcessCreator:
    def __init__(self):
        self.__data: list[Process] = []

    def create_process(self) -> Process:
        name = input("Process name: ")
        arrival_time = self.input_num("Arrival Time: ")
        burst_time = self.input_num("Burst Time: ")
        return Process(name, arrival_time, burst_time)

    def choose_option(self, prompt: str) -> str:
        option = input(f"{prompt} (y/n)").lower()
        if option == "y" or option == "yes":
            return "y"
        elif option == "n" or option == "no":
            return "n"
        print("Invalid option! Choose either yes or no (y/n)")
        return self.choose_option(prompt)

    def input_num(self, prompt: str) -> int:
        try:
            output = int(input(prompt))
            if output < 0:
                raise ValueError()
            return output
        except ValueError:
            print("Invalid input! It must be a number that is greater or equal to 0!")
            return self.input_num(prompt)

    def get_data(self) -> list:
        return self.__data

    def run(self) -> None:
        while True:
            is_continue = self.choose_option()
            if is_continue == "n":
                break
            self.__data.append(self.create_process())


def main() -> None:
    # 1 0 3 1 2
    # 1 5 2 2 3
    old_example = [Process("P1", 1, 1), Process("P2", 0, 5), Process("P3", 3, 2),
                   Process("P4", 1, 2), Process("P5", 2, 3)]
    # 0 2 3 5 11 17 24
    # 4 9 3 7 5 6 12
    processes = [Process("E", 0, 4), Process("F", 2, 9), Process("G", 3, 3),
                 Process("H", 5, 7), Process("I", 11, 5), Process("J", 17, 6),
                 Process("K", 24, 12)]

    algorithm = "FCFS"  # Default algorithm
    if len(argv) > 1:
        algorithm = argv[1].upper()
    match (algorithm):
        case "FCFS":
            Scheduler(old_example).run("FCFS")
        case "SRTF":
            Scheduler(old_example).run("SRTF")
        case "RR":
            Scheduler(processes).run("RR")
        case _:
            raise Exception("Algorithm entered is not recognized!")


if __name__ == "__main__":
    main()
