<?php
//$query = 'lung cancer';//$_GET['query'];
//$output=passthru("python C:/xampp/htdocs/ir/ir/query_new.py") ;
//$dir = 'C:/xampp/htdocs/ir/ir/';
//$dirs = scandir($dir);

//print_r($dirs);


//echo exec('python --version');
$disease=$_GET['query'];
$gene=$_GET['query3'];
$age=$_GET['query2'];

$command1 = escapeshellcmd(sprintf('python C:/xampp/htdocs/ir/ir/dropdown_pooja.py "%s" "%s" "%s"', $disease, $age, $gene));
$output1 = shell_exec($command1);


$command2 = escapeshellcmd(sprintf('python C:/xampp/htdocs/ir/ir/dropdown_query.py "%s" "%s" "%s"', $disease, $age, $gene));
$output2 = shell_exec($command2);


	
if ($_GET['source']=="abstracts") {	
	sleep(1);
    $data=file_get_contents("abc_dropdown.json");
	

} else {
	sleep(1);
    $data=file_get_contents("abc_divya.json");
	
	
}
echo $data;

//sleep(2);
//$result = file_get_contents('./abc.json');
//echo $result;

//print_r($_Post["result_final"]);
// $start_word = "123";
// $end_word = '4567';
// $output = passthru("python test.py ".$start_word." ".$end_word);
//echo $output; //
// $content =  json_decode(file_get_contents('cholangiocarcinoma.json'), true);
// echo $content;
?>