window.onload = function() {
    determineUser();
    directoryGenerator();
}
function determineUser() {
	fetch("http://localhost:8087/ExpenseReimbursementSystem/session").then(
		function(response) {
			let data = response.json();
			return data;
		}).then(
		function(data) {
			document.getElementById("welcome").innerText = "Welcome "+ data.firstName + " " + data.lastName;
            id = data;
            return data;
	})
}

function directoryGenerator() {
	fetch("http://localhost:8087/ExpenseReimbursementSystem/directory").then(
			function(response) {
				let data = response.json();
				return data;
			}).then(function(data) {
				console.log(data);
		// Create a HTML Table element.
		let table = document.createElement("TABLE");
		table.border = "1";

		// Add the header row.
		let row = table.insertRow(-1);
		let headerCell = document.createElement("TH");

		headerCell = row.insertCell(-1);
		headerCell.innerHTML = "First Name";

		headerCell = row.insertCell(-1);
		headerCell.innerHTML = "Last Name";

		headerCell = row.insertCell(-1);
		headerCell.innerHTML = "Email";

		headerCell = row.insertCell(-1);
		headerCell.innerHTML = "Department";
		
		headerCell = row.insertCell(-1);
		headerCell.innerHTML = "Managed by"

		// Add the data rows.
		// Add the data rows.
		for (let i = 0; i < data.length; i++) {
			row = table.insertRow(-1);

			let cell = row.insertCell(-1);
			cell.innerHTML = data[i].firstName;

			cell = row.insertCell(-1);
			cell.innerHTML = data[i].lastName;

			cell = row.insertCell(-1);
			cell.innerHTML = data[i].email;
			
			cell = row.insertCell(-1);
			cell.innerHTML = data[i].departmentId;
			
			cell = row.insertCell(-1);
			cell.innerHTML ="# "+ data[i].reportsTo;
			
		}

		// replace the empty div with a table
		let newTable = document.getElementById("DirectoryTable");
		newTable.innerHTML = "";
		newTable.appendChild(table);
	})
}