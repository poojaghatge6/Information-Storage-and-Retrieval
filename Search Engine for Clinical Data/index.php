<?php
//$query = 'lung cancer';//$_GET['query'];
//$output=passthru("python C:/xampp/htdocs/ir/ir/query_new.py") ;
//$dir = 'C:/xampp/htdocs/ir/ir/';
//$dirs = scandir($dir);

//print_r($dirs);


//echo exec('python --version');
$arg1=$_GET['query'];
$command1 = escapeshellcmd(sprintf('python C:/xampp/htdocs/ir/ir/test_pooja.py "%s"', $arg1));
$output1 = shell_exec($command1);

$command2 = escapeshellcmd(sprintf('python C:/xampp/htdocs/ir/ir/test_divya.py "%s"', $arg1));
$output2 = shell_exec($command2);


//echo $_GET['source'];
if ($_GET['source']=="abstracts") {	
	sleep(1);
    $data=file_get_contents("abc.json");
	

} else {
	sleep(1);
    $data=file_get_contents("abc_divya.json");
	
	
}
echo $data;

// echo $output;

//print_r($_Post["result_final"]);
// $start_word = "123";
// $end_word = '4567';
// $output = passthru("python test.py ".$start_word." ".$end_word);
//echo $output; //
// $content =  json_decode(file_get_contents('cholangiocarcinoma.json'), true);
// echo $content;
?>