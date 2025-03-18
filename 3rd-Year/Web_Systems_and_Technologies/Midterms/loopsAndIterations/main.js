function submitAge() {
  const age = parseInt(document.getElementById("userAge").value.trim());
  if (Number.isNaN(age)) {
    alert("Invalid age input!");
    return;
  }

  if (age >= 25) {
    alert("User is 25 years old or above");
  } else if (age < 100) {
    alert("User entered a number that is less than 100");
  }
}

function performLoops() {
  const firstOutput = document.getElementById("firstOutput");
  const secondOutput = document.getElementById("secondOutput");
  const thirdOutput = document.getElementById("thirdOutput");

  for (let i = 0; i <= 30; i++) {
    firstOutput.innerHTML += `${i}<br />`;
    console.log(i);
  }

  for (let i = 0; i <= 40; i++) {
    if (i % 2 === 0) {
      secondOutput.innerHTML += `${i}<br />`;
      console.log(i);
    }
  }

  for (let i = 40; i >= 10; i--) {
    if (i % 3 === 0) {
      thirdOutput.innerHTML += `${i}<br />`;
      console.log(i);
    }
  }
}

performLoops();
