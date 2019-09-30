window.onload = function() {
	pendingManagerTableGenerator();
}


function pendingManagerTableGenerator() {
	fetch("http://localhost:8087/ExpenseReimbursementSystem/managerRequestsByDpt").then(
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
		headerCell.innerHTML = "Reimbursement ID";
		
		headerCell = row.insertCell(-1);
		headerCell.innerHTML = "EmployeeId";
		
		headerCell = row.insertCell(-1);
		headerCell.innerHTML = "Dollar Amount";

		headerCell = row.insertCell(-1);
		headerCell.innerHTML = "Reason";

		headerCell = row.insertCell(-1);
		headerCell.innerHTML = "Status";
		
		headerCell = row.insertCell(-1);
		headerCell.innerHTML = "Resolved By";

		// Add the data rows.
		for (let i = 0; i < data.length; i++) {
			if(data[i].status === 1){
			row = table.insertRow(-1);
			let cell = row.insertCell(-1);
			cell.innerHTML = data[i].reimbursementId;
			
			cell = row.insertCell(-1);
			cell.innerHTML = data[i].employeeId;
			
			cell = row.insertCell(-1);
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
			
			cell = row.insertCell(-1);
			cell.innerHTML = data[i].approvedBy;
			}
		}

		// replace the empty div with a table
		let newTable = document.getElementById("managerViewdpt");
		newTable.innerHTML = "";
		newTable.appendChild(table);
	})
}
