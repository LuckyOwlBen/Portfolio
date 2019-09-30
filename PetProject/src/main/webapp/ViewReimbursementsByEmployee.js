let id = null;
window.onload = function() {
    document.getElementById('idButton').addEventListener('click',requestsByEmployeeGenerator);
}

function requestsByEmployeeGenerator() {
	id = document.getElementById('textBox').value;
	fetch("http://localhost:8087/ExpenseReimbursementSystem/returnByEmployee?empid=" + id).then(
			function(response) {
				let data = response.json();
				return data;
			}).then(function(data) {

	// Create a HTML Table element.
	let table = document.createElement("TABLE");
	table.border = "1";

	// Add the header row.
	let row = table.insertRow(-1);
	let headerCell = document.createElement("TH");

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Dollar Amount";

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Reason";

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Status";

	// Add the data rows.
	for (let i = 0; i < data.length; i++) {
		row = table.insertRow(-1);

		let cell = row.insertCell(-1);
		cell.innerHTML = "$" + data[i].dollarAmount;

		cell = row.insertCell(-1);
		cell.innerHTML = data[i].reason;

		cell = row.insertCell(-1);
		if (data[i].status === 1) {
			cell.innerHTML = "Pending";
		} else if (data[i].status === 2) {
			cell.innerHTML = "Approved";
		} else {
			cell.innerHTML = "Denied";
		}
	}

	// replace the empty div with a table
	let newTable = document.getElementById("tableByEmployee");
	newTable.innerHTML = "";
	newTable.appendChild(table);
	})
}