/*
Errors:
- ReferenceError (Caught in exception handling) from "c = d"
- LogicalError: Program goes through but does not produce the intended result
*/

let c = 10;
try {
  c = 20; // changed from "d" to "20"
} catch (error) {
  console.log("An Error!");
} finally {
  console.log("Finally!");
}
console.log(c);
