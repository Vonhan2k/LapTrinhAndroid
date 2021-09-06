
<?php
	$servername = "localhost";
	$username = "root";
	$password = "vertrigo";
	$dbname = "lazada";
	$conn = mysqli_connect($servername, $username, $password, $dbname);
	if (!$conn) {
		die("Lỗi: ". mysqli_connect_error());
	}
?>
