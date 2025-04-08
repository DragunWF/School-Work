// Marc Plarisan | BSIT601 | Web Systems and Technologies

function main() {
  const googleAge = 25;
  const age = input("What is the age of your favorite artist?");

  // Checks the value of the age and responds accordingly based on the conditions
  if (age > googleAge) {
    respond(`They're ${age} old and they're older than Google.`);
  } else if (age < googleAge) {
    respond(`They're ${age} and they're younger than Google.`);
  } else {
    respond(`They're ${age} and they're as old as Google.`);
  }
}

function input(question) {
  // This piece of syntax converts the user input into a number
  let output = Number(prompt(question));

  // Checks if the input is a valid number and reprompts the user if it is not
  if (Number.isNaN(output)) {
    alert("Invalid input! Please type an integer...");
    return input(question);
  }

  // It returns the valid number
  return Number(output);
}

function respond(content) {
  // This function displays the output in a popup box and in the console
  alert(content);
  console.log(content);
}

// This starts the main program
main();
