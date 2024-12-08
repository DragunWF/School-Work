// MongoDB

// 1.
db.employees.insertMany([
  {
    id: 1,
    Name: "Steve Badiola",
    Salary: 16099.55,
    Position: "President",
    Rank: 1,
    ReportingTo: null,
  },
  {
    id: 2,
    Name: "Jamir Garcia",
    Salary: 14567.12,
    Position: "Vice-President",
    Rank: 2,
    ReportingTo: ["President"],
  },
  {
    id: 3,
    Name: "Reg Rubio",
    Salary: 13891.22,
    Position: "Secretary",
    Rank: 3,
    ReportingTo: ["Vice-President"],
  },
  {
    id: 4,
    Name: "Ian Tayao",
    Salary: 13000,
    Position: "Treasurer",
    Rank: 4,
    ReportingTo: ["Secretary", "Vice-President"],
  },
]);

// 2.
db.employees.updateMany({ ReportingTo: null }, { $unset: { ReportingTo: "" } });

// 3.
db.employees.updateMany({}, { $inc: { Salary: 5000 } });

// 4.
db.employees.updateMany(
  { Name: { $in: ["Reg Rubio", "Ian Tayao"] } },
  { $push: { ReportingTo: "President" } }
);

// 5.
db.employees.find({ Salary: { $gt: 21000 } });

// 6.
db.employees.find({
  Name: { $regex: "^[SR]", $options: "i" },
});

// 7.
db.employees.find({
  ReportingTo: { $nin: ["President"] },
});

// 8.
db.employees.updateMany({}, [
  {
    $set: {
      contact: {
        email: {
          $concat: [
            { $toLower: { $arrayElemAt: [{ $split: ["$Name", " "] }, 0] } },
            ".",
            { $toLower: { $arrayElemAt: [{ $split: ["$Name", " "] }, 1] } },
            "@gov.ph",
          ],
        },
        phone: {
          $concat: ["+", { $toString: "$Rank" }, " 1234567"],
        },
      },
    },
  },
]);
