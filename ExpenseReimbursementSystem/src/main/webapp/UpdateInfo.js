window.onload = function() {
	determineUser();
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