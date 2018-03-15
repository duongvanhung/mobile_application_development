<?php
	$longitude_1 = (isset($_POST['longitude_1_server'])) ? $_POST['longitude_1_server'] : '';
	$latitude_1 = (isset($_POST['latitude_1_server'])) ? $_POST['latitude_1_server'] : '';
	$longitude_2 = (isset($_POST['longitude_2_server'])) ? $_POST['longitude_2_server'] : '';
	$latitude_2 = (isset($_POST['latitude_2_server'])) ? $_POST['latitude_2_server'] : '';

	//Continue if longtitude and latitude are not null
	if($longitude_1 !== "" && $longitude_2 !== "" && $latitude_1 !== "" && $latitude_2 !=="") {
		// Formula
		$dLong = abs($longitude_1 - $longitude_2);
		$cosD = sin(deg2rad($latitude_2)) * sin(deg2rad($latitude_1)) + cos(deg2rad($latitude_2)) * cos(deg2rad($latitude_1))  * cos(deg2rad($dLong));
		//Conner between the edges of from the center to each Point
		$D = acos($cosD) * 180 / M_PI; 
		//Conner between the edges of from the center to each Point
		$d = $D * 40075/360; 
		echo $d;
	}
  ?>