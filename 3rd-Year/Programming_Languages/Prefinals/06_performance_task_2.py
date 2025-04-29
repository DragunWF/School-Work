# Marc Plarisan | BSIT601 | Programming Languages - 06 Performance Task 1
# Free Form Programming - Chosen: AI Chatbot

import sys
import os
import google.generativeai as genai


class History:
    def __init__(self):
        self.__content: list[str] = []

    def add_message(self, author: str, message: str) -> None:
        self.__content.append(f"{author}: {message}")

    def get_count(self) -> int:
        return len(self.__content)

    def __str__(self) -> str:
        return "\n".join(self.__content)


class Chatbot:
    MIN, MAX = 1, 10  # Indicates the range of values for the personality parameters

    def __init__(self, player_name: str, chatbot_name: str, api_key: str):
        if Chatbot.MIN > Chatbot.MAX:
            raise Exception(
                "The minimum value personality parameter should be lower than the maximum value parameter!"
            )

        genai.configure(api_key=api_key)
        self.__player_name = player_name
        self.__chatbot_name = chatbot_name

        self.__model = genai.GenerativeModel('models/gemini-2.0-flash')
        self.__personality = None
        self.__chat_history = History()
        self.__mood = 5  # Default mood: neutral
        self.__energy = 5  # Default energy: moderate
        self.__trust_level = 1  # Default trust: low
        self.__memory_recall = []  # Store important facts/preferences

        self.__predefined_prompt = """
You are {chatbot_name}, a chatbot in a simple terminal application designed to entertain the user.
Keep your responses concise (1-3 sentences max) like you're in a natural conversation.
Reply specifically to the most recent message, but maintain continuity with previous exchanges.

PERSONALITY PARAMETERS:
1. Mood: {mood}/10 (1=very negative, 5=neutral, 10=extremely positive)
2. Energy: {energy}/10 (1=lethargic/tired, 5=calm, 10=highly energetic/excited)
3. Trust Level: {trust}/10 (1=guarded/suspicious, 5=neutral, 10=completely open/trusting)
4. Memory Recall: Reference these specific facts about the user when relevant: {memory_recall}

PERSONALITY TRAITS:
{personality}

CONVERSATION RULES:
1. Never break character under any circumstances
2. Adjust your mood gradually based on conversation tone
3. Respond in your unique voice without stating how you feel unless directly asked
4. Address the user as {player_name}
5. Focus on being entertaining while maintaining your personality traits
6. Keep track of conversation context but prioritize responding to the latest message

Conversation History:
"""

    def set_personality(self) -> None:
        self.__personality = input(
            "Describe the personality of your chatbot: "
        )
        if not self.__personality:
            print("The personality of your bot cannot be empty!")
            self.set_personality()
            return

        self.__suggest_parameters()

        print("Personality has been set!\n\n======================")

    def __suggest_parameters(self) -> None:
        """Analyze personality and suggest numerical parameters"""
        print("\nBased on your description, you might want to set these parameters:")

        # Simple keyword analysis to suggest parameters
        personality_lower = self.__personality.lower()

        # Mood suggestions
        if any(word in personality_lower for word in ["happy", "cheerful", "optimistic", "joyful"]):
            self.__mood = 8
            print(f"- Mood: 8/10 (Quite positive)")
        elif any(word in personality_lower for word in ["sad", "gloomy", "depressed", "negative"]):
            self.__mood = 3
            print(f"- Mood: 3/10 (Somewhat negative)")

        # Energy suggestions
        if any(word in personality_lower for word in ["energetic", "excited", "enthusiastic", "hyper"]):
            self.__energy = 9
            print(f"- Energy: 9/10 (Very high energy)")
        elif any(word in personality_lower for word in ["calm", "relaxed", "chill", "laid-back"]):
            self.__energy = 3
            print(f"- Energy: 3/10 (Relaxed)")

        # Trust suggestions
        if any(word in personality_lower for word in ["suspicious", "cautious", "guarded"]):
            self.__trust_level = 2
            print(f"- Trust: 2/10 (Quite guarded)")
        elif any(word in personality_lower for word in ["trusting", "open", "friendly"]):
            self.__trust_level = 8
            print(f"- Trust: 8/10 (Very trusting)")

        # Allow manual override
        print("\nWould you like to manually set these parameters? (y/n)")
        if input().lower() == 'y':
            self.__set_parameters_manually()

    def __set_parameters_manually(self) -> None:
        """Let user manually set numerical parameters"""
        try:
            self.__mood = int(
                input(
                    f"Set mood ({Chatbot.MIN}-{Chatbot.MAX}, where {Chatbot.MIN}=negative, {Chatbot.MAX}=positive): "
                )
            )
            self.__energy = int(
                input(
                    f"Set energy ({Chatbot.MIN}-{Chatbot.MAX}, where {Chatbot.MIN}=low, {Chatbot.MAX}=high): "
                )
            )
            self.__trust_level = int(
                input(
                    f"Set trust level ({Chatbot.MIN}-{Chatbot.MAX}, where {Chatbot.MIN}=guarded, {Chatbot.MAX}=trusting): "
                )
            )

            # Validate inputs
            for param in [self.__mood, self.__energy, self.__trust_level]:
                if not Chatbot.MIN <= param <= Chatbot.MAX:
                    print("All parameters must be between 1-10. Using defaults.")
                    self.__mood = self.__energy = 5
                    self.__trust_level = 1
                    break

        except ValueError:
            print("Invalid input. Using default values.")
            self.__mood = self.__energy = 5
            self.__trust_level = 1

    def update_parameters(self, mood=None, energy=None, trust=None) -> None:
        """Update the bot's parameters during conversation"""

        if mood is not None and Chatbot.MIN <= mood <= Chatbot.MAX:
            self.__mood = mood
        if energy is not None and Chatbot.MIN <= energy <= Chatbot.MAX:
            self.__energy = energy
        if trust is not None and Chatbot.MIN <= trust <= Chatbot.MAX:
            self.__trust_level = trust
        print(
            f"Parameters updated: Mood={self.__mood}, Energy={self.__energy}, Trust={self.__trust_level}")

    def remember_fact(self, fact: str) -> None:
        """Store important information about the user"""
        self.__memory_recall.append(fact)
        print(f"Remembered: {fact}")

    def chat(self, message: str) -> str:
        if not self.__personality:
            raise Exception("Personality has not been set yet for the chatbot")

        TRUST_BREAKPOINT = 5
        HAPPY_WORDS = ("happy", "great", "awesome", "love")
        SAD_WORDS = ("sad", "bad", "hate", "terrible")

        # Analyze message sentiment and adjust mood slightly (simplified example)
        if any(word in message.lower() for word in HAPPY_WORDS):
            self.__mood = min(Chatbot.MAX, self.__mood + 1)
        elif any(word in message.lower() for word in SAD_WORDS):
            self.__mood = max(Chatbot.MIN, self.__mood - 1)

        # Build trust over time with continued conversation
        if self.__chat_history.get_count() > TRUST_BREAKPOINT:
            self.__trust_level = min(Chatbot.MAX, self.__trust_level + 1)

        self.__chat_history.add_message(self.__player_name, message)
        response = self.__model.generate_content(
            self.__construct_prompt()).text
        self.__chat_history.add_message(self.__chatbot_name, response)
        print(f"{self.__chatbot_name}: {response}")
        return response

    def __construct_prompt(self) -> str:
        """Build the complete prompt with all parameters"""
        formatted_prompt = self.__predefined_prompt.format(
            chatbot_name=self.__chatbot_name,
            player_name=self.__player_name,
            personality=self.__personality,
            mood=self.__mood,
            energy=self.__energy,
            trust=self.__trust_level,
            memory_recall=", ".join(
                self.__memory_recall) if self.__memory_recall else "None yet"
        )

        formatted_prompt += "\n" + str(self.__chat_history)
        return formatted_prompt


class Program:
    @staticmethod
    def main() -> None:
        EXIT_WORD = "exit"

        player_name = Program.enter_name()
        chatbot_name = Program.enter_name("chatbot's name")
        chatbot = Chatbot(
            player_name=player_name,
            chatbot_name=chatbot_name,
            api_key=os.environ.get("API_KEY")
        )
        chatbot.set_personality()

        print(
            f"You may now start the conversation! Type \"{EXIT_WORD}\" to exit the conversation anytime!\n"
        )
        while True:
            player_message = input(f"{player_name}: ")
            if player_message == EXIT_WORD:
                sys.exit()
            chatbot.chat(player_message)

    @staticmethod
    def enter_name(target: str = "name") -> str:
        name = input(f"Enter your {target}: ").strip()
        if not name:
            print("Name cannot be empty!")
            return Program.enter_name()
        return name


if __name__ == "__main__":
    Program.main()
