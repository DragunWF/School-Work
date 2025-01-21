// MongoDB

// Setup collections
db.orders.insertOne({
  customer_name: "Rosalie",
  order_date: "2021-07-21T00:00:00Z",
  items: [
    {
      item_id: 1,
      item_name: "iPhone-X",
      quantity: 2,
      price_per_unit: 45000,
      total_price: 90000,
    },
  ],
  total_order_amount: 90000,
});

db.inventory.insertOne({
  _id: 1,
  item_name: "iPhone-X",
  category: "Electronics",
  price_per_unit: 45000,
  stock_quantity: 49,
});

// After Purchase
db.sales.insertOne({
  sale_date: "2021-07-21T00:00:00Z",
  item_id: 1,
  item_name: "iPhone-X",
  quantity_sold: 2,
  price_per_unit: 45000,
  total_sale_amount: 90000,
});

// Setup Collections with References
db.inventory.insertOne({
  _id: ObjectId(),
  item_name: "iPhone-X",
  category: "Electronics",
  price_per_unit: 45000,
  stock_quantity: 49,
});

db.orders.insertOne({
  customer_name: "Rosalie",
  order_date: "2021-07-21T00:00:00Z",
  items: [
    {
      item_id: ObjectId("675701fdc1f93809031fd772"),
      quantity: 2,
      price_per_unit: 45000,
      total_price: 90000,
    },
  ],
  total_order_amount: 90000,
});

db.sales.insertOne({
  sale_date: "2021-07-21T00:00:00Z",
  item_id: ObjectId("675701fdc1f93809031fd772"),
  quantity_sold: 2,
  price_per_unit: 45000,
  total_sale_amount: 90000,
});

// Update quantity after purchase
db.inventory.updateOne(
  { _id: ObjectId("675701fdc1f93809031fd772") },
  { $inc: { stock_quantity: -2 } }
);

// Check inventory level after purchase
db.inventory.find();
