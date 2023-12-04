# Platform Technology (Operating Systems)
# Applying scheduling algorithms through Python code
# Programmed by DragunWF
# My GitHub: https://github.com/DragunWF

# Requires two modules to install
# > pip install rich
# > pip install tabulate

from rich import print
from tabulate import tabulate
from collections import deque


class Process:
    def __init__(self, name: str, arrival_time: int, burst_time: int):
        self.__name = name
        self.__arrival_time = arrival_time
        self.__burst_time = burst_time
        self.__waiting_time: int = None
        self.__turnaround_time: int = None
        self.__completion_time: int = 0  # Default value
        self.__algorithm = None

    def get_name(self) -> str:
        return self.__name

    def get_arrival_time(self) -> int:
        return self.__arrival_time

    def set_burst_time(self, value: int) -> None:
        self.__burst_time = value

    def get_burst_time(self) -> int:
        return self.__burst_time

    def set_completion_time(self, value) -> None:
        self.__completion_time = value

    def get_completion_time(self) -> int:
        return self.__completion_time

    def calculate_turnaround_time(self) -> None:
        if self.__waiting_time is None:
            print(
                f"Process {self.__name}: Waiting time has to be calculated first")
        elif self.__turnaround_time is None:
            self.__turnaround_time = self.__burst_time + self.__waiting_time
        else:
            print(
                f"Process {self.__name}: Turnaround time has already been calculated")

    def get_turnaround_time(self) -> int:
        return self.__turnaround_time

    def calculate_waiting_time(self) -> None:
        if self.__waiting_time is None:
            self.__waiting_time = self.__completion_time - self.__arrival_time
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
        self.__burst_times: list[tuple[int]] = []
        self.__gantt_chart: list[ChartProcess] = []

    def run(self, algorithm: str) -> None:
        self.__algorithm = algorithm.upper()
        match (self.__algorithm):
            case "FCFS":
                self.fcfs()
            case "SRTF":
                self.__srtf_chart: list[list] = [[0]]
                self.srtf()
            case "RR":
                self.round_robin(3) # Default time quantum is 3
            case _:
                raise Exception("Scheduling algorithm not recognized!")

        self.calculate_waiting_times()
        self.calculate_turnaround_times()
        self.calculate_averages()

        print("Gantt Chart")
        self.display_gantt_chart()

        print(f"Average Waiting Time: {self.__average_waiting_time}")
        print(f"Average Turnaround Time: {self.__average_turnaround_time}")

    def fcfs(self) -> None:
        # First-Come First-Serve
        # A simple bubble sort to sort the processes by its arrival time
        for i in range(len(self.__ready_queue)):
            is_sorted = True
            for j in range(len(self.__ready_queue) - 1):
                if self.__ready_queue[j].get_arrival_time() > self.__ready_queue[j + 1].get_arrival_time():
                    self.__ready_queue[j], self.__ready_queue[j + 1] = (
                        self.__ready_queue[j + 1], self.__ready_queue[j])
                    is_sorted = False
            if is_sorted:
                break

        # Visualize the Gantt Chart
        current_waiting_time = 0
        for process in self.__ready_queue:
            self.__gantt_chart.append(
                ChartProcess(current_waiting_time, process.get_name(), 
                            current_waiting_time + process.get_burst_time()))
            self.__burst_times.append(
                (current_waiting_time, current_waiting_time + process.get_burst_time()))
            current_waiting_time += process.get_burst_time()

        # Set completion time of all processes in the ready queue
        for i in range(len(self.__ready_queue)):
            self.__ready_queue[i].set_completion_time(self.__burst_times[i][0])
        
        Utils.display_chart(self.__gantt_chart)

    def srtf(self) -> None:
        # Shortest Time Remaining First
        current_processes: list[Process] = []
        max_time = Utils.get_max_time(self.__ready_queue)
        current_ct = 1
        time_passed = 0
        previous_process_name = ""

        while time_passed < max_time:
            # Find processes with the same arrival time as the time passed
            for process in self.__ready_queue:
                if process.get_arrival_time() == time_passed:
                    current_processes.append(process)

            # Burst Time Logic
            attributes: dict = Utils.get_min_burst_time(current_processes)
            min_process: Process = current_processes[attributes["index"]]
            min_process.set_burst_time(min_process.get_burst_time() - 1)
            if min_process.get_burst_time() <= 0:
                current_processes.pop(attributes["index"])

            # Gantt Chart Logic
            if attributes["name"] != previous_process_name:
                self.__srtf_chart.append(
                    [attributes["name"], current_ct])
            elif attributes["name"] == previous_process_name:
                self.__srtf_chart[len(self.__srtf_chart) - 1][1] += 1

            current_ct += 1
            time_passed += 1
            previous_process_name = attributes["name"]

        ready_queue_names = [p.get_name() for p in self.__ready_queue]
        for i in range(1, len(self.__srtf_chart) - 1):
            completion_time = self.__srtf_chart[i + 1][1]
            process_index = ready_queue_names.index(self.__srtf_chart[i][0])
            current_ct = self.__ready_queue[process_index].get_completion_time(
            )
            self.__ready_queue[process_index].set_completion_time(
                current_ct + completion_time)

    def round_robin(self, quantum: int) -> None:
        arrival_times = [p.get_arrival_time() for p in self.__ready_queue]
        min_arrival_time = min(arrival_times)
        current_queue: list[Process] = [p for p in self.__ready_queue if p.get_arrival_time() == min_arrival_time]
        self.__gantt_chart = [ChartProcess(0, current_queue[0].get_name(), 1)]

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
        
        Utils.display_chart(self.__gantt_chart)


    def calculate_waiting_times(self):
        for i in range(len(self.__ready_queue)):
            self.__ready_queue[i].calculate_waiting_time()

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
        match (self.__algorithm):
            case "FCFS":
                queue_len = len(self.__ready_queue)
                for i in range(queue_len):
                    process = self.__ready_queue[i]
                    print(
                        f"{self.__burst_times[i][0]} {process.get_name()}", end=" ")
                print(self.__burst_times[queue_len - 1][1])
            case "SRTF":
                print(0, end=" ")
                for i in range(1, len(self.__srtf_chart)):
                    print(
                        f"{self.__srtf_chart[i][0]} {self.__srtf_chart[i][1]}", end=" ")
                print()
            case "RR":
                pass
            case _:
                raise Exception("Algorithm is not recognized!")


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
                print(f"{process.get_name()} {process.get_end()}")


def main() -> None:
    old_example = [Process("P1", 1, 1), Process("P2", 0, 5), Process("P3", 3, 2),
                   Process("P4", 1, 2), Process("P5", 2, 3)]
    # 0 2 3 5 11 17 24
    # 4 9 3 7 5 6 12
    processes = [Process("E", 0, 4), Process("F", 2, 9), Process("G", 3, 3),
                 Process("H", 5, 7), Process("I", 11, 5), Process("J", 17, 6),
                 Process("K", 24, 12)]
    Scheduler(old_example).run("FCFS")
    # Scheduler(processes.copy()).run("SRTF")
    # Scheduler(processes).run("RR")


if __name__ == "__main__":
    main()
