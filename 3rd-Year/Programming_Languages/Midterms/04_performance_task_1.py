class performanceTask: # Normally PascalCase by convention but instructions want camelCase on classes
    @staticmethod
    def main() -> None:
        PASSING_SCORE = 5

        first_name = "Marc" 
        age = 21
        quiz_score = 10

        is_quiz_taken = True

        # Shorthand way of doing it but the instructions state
        # that True, False, and None keywords must be used
        # is_quiz_passed = quiz_score >= 5 if is_quiz_taken else None

        # What the instructions want:
        is_quiz_passed = None
        if is_quiz_taken:
            if quiz_score >= PASSING_SCORE:
                is_quiz_passed = True
            else:
                is_quiz_passed = False

        print(f"\nFirst Name: {first_name}\nAge: {age}")
        print(f"04 Quiz 1 Score: {quiz_score}\nStudent has taken the quiz: {'Yes' if is_quiz_taken else 'No'}")
        print(f"Student has passed the quiz: {is_quiz_passed}")

        quiz_score = float(quiz_score)
        print(f"\nRebinded Quiz Score to a float value (Ignore excess): {quiz_score}\n")
    

if __name__ == "__main__":
    performanceTask.main()