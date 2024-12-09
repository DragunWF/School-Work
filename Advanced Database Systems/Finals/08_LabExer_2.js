// MongoDB

// 1.1
db.emb_customer.insertOne({
  _id: 1,
  customername: "Smith",
  address: {
    country: "Philippines",
    province: "Rizal",
    municipality: "Taytay",
    brgy: "Dolores",
    street: "286-A, Costalina",
  },
});

// 1.2
db.addresses.insertOne({
  country: "Philippines",
  province: "Rizal",
  municipality: "Taytay",
  brgy: "Dolores",
  street: "286-A, Costalina",
});

db.ref_customer.insertOne({
  _id: 1,
  customername: "Smith",
  address_ref_id: ObjectId("6756d407c1f93809031fd768"),
});

// 2.1
db.emb_student.insertOne({
  _id: 1,
  stud_name: "Leo",
  school: "OrCa",
  classes: [
    {
      subject: "Math",
      teacher: "Marcel",
      schedule: "Monday",
    },
    {
      subject: "English",
      teacher: "Elinor",
      schedule: "Tuesday",
    },
    {
      subject: "Science",
      teacher: "Maritess",
      schedule: "Wednesday",
    },
  ],
});

// 2.2
db.classes.insertMany([
  {
    subject: "Math",
    teacher: "Marcel",
    schedule: "Monday",
  },
  {
    subject: "English",
    teacher: "Elinor",
    schedule: "Tuesday",
  },
  {
    subject: "Science",
    teacher: "Maritess",
    schedule: "Wednesday",
  },
]);

db.ref_student.insertOne({
  _id: 1,
  stud_name: "Leo",
  school: "OrCa",
  classes: [
    ObjectId("6756d681c1f93809031fd76c"),
    ObjectId("6756d681c1f93809031fd76d"),
    ObjectId("6756d681c1f93809031fd76e"),
  ],
});

// 3.1
db.items.insertMany([
  { _id: 1, item_category: "Bag" },
  { _id: 2, item_category: "Mobile Phones" },
]);

// 3.2
db.inventory.insertMany([
  { _id: 101, Brand: "Samsung", Model: "Note10", item_id: 2 },
  { _id: 102, Brand: "HawkBag", Model: "HK2", item_id: 1 },
]);

// 3.3
db.items
  .aggregate([
    {
      $lookup: {
        from: "inventory",
        localField: "_id",
        foreignField: "item_id",
        as: "stocks",
      },
    },
    { $match: { item_category: "Mobile Phones" } },
  ])
  .pretty();

db.items
  .aggregate([
    {
      $lookup: {
        from: "inventory",
        localField: "_id",
        foreignField: "item_id",
        as: "stocks",
      },
    },
    { $match: { item_category: "Bag" } },
  ])
  .pretty();
