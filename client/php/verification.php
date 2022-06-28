<?php
session_start();
if(isset($_POST['username']) && isset($_POST['password']))
{
    // connexion à la base de données
    $dsn = 'mysql:dbname=bionic;host=localhost';
    $user = 'root';
    $password = 'mysql2022';

    $db = new PDO('mysql:host=localhost;dbname=bionic', 'root', 'mysql2022');

    // on applique les deux fonctions mysqli_real_escape_string et htmlspecialchars
    // pour éliminer toute attaque de type injection SQL et XSS
    $username = $db->quote($_POST['username']);
    $password = $db->quote($_POST['password']);
    debug_to_console($username);
    debug_to_console($password);

    if($username !== "" && $password !== "")
    {
        $sql = 'SELECT count(*) FROM User WHERE UserName = :username and Password = :password';

        $return = $db->prepare($sql,array(PDO::ATTR_CURSOR => PDO::CURSOR_FWDONLY) );
        $return->execute(array('username' => $_POST['username'], 'password' => $_POST['password']));

        $count = $return->fetchColumn();
        if($count!=0) // nom d'utilisateur et mot de passe correctes
        {
            $_SESSION['username'] = $username;
            header('Location: principale.php');
        }
        else
        {
            header('Location: login.php?erreur=1'); // utilisateur ou mot de passe incorrect
        }
    }
    else
    {
        header('Location: login.php?erreur=2'); // utilisateur ou mot de passe vide
    }
}
else
{
    header('Location: login.php');
}
mysqli_close($db); // fermer la connexion

function debug_to_console($data) {
    $output = $data;
    if (is_array($output))
        $output = implode(',', $output);

    echo "<script>console.log('Debug Objects: " . $output . "' );</script>";
}
?>