class Question:
    def __init__(self, question, answer):
        self.content = question
        self.answer = answer.lower()


class Quiz:
    def __init__(self, questions):
        self.questions = questions
        self.incorrect_questions = []
        self.score = 0

    def display_incorrect(self):
        print("Incorrect Questions:")
        for question in self.incorrect_questions:
            print(f"{question}\n")

    def run(self):
        print("Questions:")
        for i in range(len(self.questions)):
            question = self.questions[i]
            print(f"{i + 1}. {question.content}")
            player_option = input("Answer: ").lower()
            if player_option == question.answer:
                print("You got the correct answer!")
                self.score += 1
            else:
                s = f"{question.content} = {question.answer}"
                self.incorrect_questions.append(s)
        print(f"Score: {self.score}/{len(self.questions)}")
        self.display_incorrect()


def main():
    questions = [
        Question("Sense external information through aural, haptic, or visual modality",
                 "sensation"),
        Question("interprets and extracts basic meanings of the external information",
                 "perception"),
        Question("stores short-term or long-term information about external procedures, rules, relations, schemas, and the likes",
                 "memory"),
        Question("formulates and revises a solution or plan, decides based on various information in the memory, and finally acits it out by commandding the motor system",
                 "decision/executor"),
        Question("It is the difference between the intentions of the users and what the system allows to do or how well the system supports those actions",
                 "gulf of execution"),
        Question("It is the degree to which the system provides representations that can be directly perceived and interpreted in terms of user expectations and intentions",
                 "gulf of evaluation"),
        Question("It stands for goals, operators, methods, and selection rules",
                 "GOMS model"),
        Question("These are tasks that a user wants to accomplish",
                 "goals"),
        Question("These are basic perceptual, cognitive, or motor actions used to accomplish.",
                 "operators"),
        Question("These involve a sequence of procedures that can accomplish a goal.",
                 "methods"),
        Question("These are personal rules users follow in selecting a method to be used",
                 "selection rules"),
        Question("the observable area a person can see through the eyes",
                 "FOV"),
        Question("the distance from the eyes to the surface of the display",
                 "viewing distance"),
        Question("It is the area subtended by the display from a particular viewing distance",
                 "display field of view"),
        Question("These are small rectangular areas which compose a display system",
                 "pixel"),
        Question("the number of pixels in the horizontal and vertical directions for a fixed area",
                 "display resolution"),
        Question("The resolution perceived by the eye from a fixed distance",
                 "visual acuity"),
        Question("It is the amount of light emitted by an object or as perceived by the human eye",
                 "brightness"),
        Question("the human response to different wavelengths of light, namely for those corresponding to red, green, blue, and their mixture",
                 "color"),
        Question("the relative difference in brightness or color between two objects",
                 "contrast"),
        Question("it is also known as volume, this refers to the amount of sound energy",
                 "intensity"),
        Question("This is the energy transmitted in the form of waves with different frequencies",
                 "sound"),
        Question("This refers to the time differences among sound waves that originate from the same source",
                 "phase"),
        Question("This is the ability of a machine or a program to identify words and phrases in spoken language and convert them to a machine-readable format",
                 "speech recognition"),
        Question("It is the branch of AI that uses computer software to understand input made in the form of sentence in text or speech format.",
                 "natural language understanding"),
        Question("It is also known as motor capabilities. It pertains to the discipline focused on creating products and interfaces which are comfortable and efficient to use.",
                 "ergonomics"),
        Question("It is a model of human movement that predicts the time required to move rapidly to a target area as a function of the distance to the size of the target",
                 "fitts' law"),
        Question("It is another method of initiating and performing voluntary movement. Humans exhibit different motor control practices with different devices",
                 "motor control")
    ]
    quiz = Quiz(questions)
    quiz.run()


if __name__ == "_main_":
    main()
