from rich import print
from tabulate import tabulate
from random import randint


class File:
    def __init__(self, identifier: int, name: str, type: str, protection: str, timestamp: str):
        self.identifier = identifier
        self.name = name
        self.type = type
        self.protection = protection
        self.timestamp = timestamp

        bytes_measurement = ("KB", "MB")
        self.size = f"{randint(1, 20)} {bytes_measurement[randint(0, len(bytes_measurement) - 1)]}"


class Utils:
    chosen_names = {}
    file_names = [
        "math_homework",
        "history_notes",
        "science_project",
        "english_essay",
        "art_sketches",
        "computer_science_code",
        "physics_lab_report",
        "language_vocabulary",
        "geography_map",
        "music_composition",
        "physical_education_log",
        "chemistry_experiment",
        "literature_reading_log",
        "social_studies_research",
        "foreign_language_flashcards",
        "graphic_design_portfolio",
        "biology_diagrams",
        "class_schedule",
        "exam_prep_notes",
        "programming_assignment",
        "coding_assignment"
    ]
    file_types = ["docx", "txt", "ppsx", "pdf"]
    file_protection = ["admin", "user", "guest"]

    @staticmethod
    def random_date() -> str:
        month = randint(1, 12)
        day = randint(1, 28)
        year = randint(2010, 2024)
        return f"{month}/{day}/{year}"

    @staticmethod
    def duplicate_check(name: str) -> str:
        if not name in Utils.chosen_names:
            Utils.chosen_names[name] = 1
            return name
        return f"{name}({Utils.chosen_names[name]})"

    @staticmethod
    def choose_random(data: list[str]) -> str:
        return data[randint(0, len(data) - 1)]

    @staticmethod
    def generate_random_file() -> File:
        identifier = randint(10000, 99999)
        name = Utils.duplicate_check(Utils.choose_random(Utils.file_names))
        file_type = Utils.choose_random(Utils.file_types)
        protection = Utils.choose_random(Utils.file_protection)
        timestamp = Utils.random_date()
        return File(identifier, name, file_type, protection, timestamp)


def main() -> None:
    FILE_COUNT = 20  # Feel free to change
    files: list[File] = []
    for i in range(FILE_COUNT):
        files.append(Utils.generate_random_file())

    table_data: list = []
    for file in files:
        table_data.append([file.name, file.type,
                          file.protection, file.size, file.timestamp])
    print(tabulate(table_data, headers=["File Name", "File Type", "File Protection",
                                        "File Protection", "File Timestamp"],
                   tablefmt="simple_grid"))


if __name__ == '__main__':
    main()
