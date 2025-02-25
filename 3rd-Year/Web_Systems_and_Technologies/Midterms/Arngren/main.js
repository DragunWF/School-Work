function trackQuery() {
  const searchBar = document.getElementById("searchBar");
  const query = searchBar.value;

  if (query.length) {
    alert(`Your query was "${query}".`);
    searchBar.value = "";
  }
}
