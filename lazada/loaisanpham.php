<?php
	include_once("config.php");
	$truyvan = " SELECT * FROM `loaisanpham`";
	$ketqua = mysqli_query($conn, $truyvan);
	if ($ketqua) {
		while($dong=mysqli_fetch_array($ketqua)){
			echo $dong["TENLOAISP"]. "</br>";
		}
	}
?>