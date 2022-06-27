<?php
session_start();
if(isset($_POST['username']) && isset($_POST['password']))
{
    // connexion à la base de données
    $dsn = 'mysql:dbname=bionic;host=localhost';
    $user = 'root';
    $password = 'mysql2022';

    $db = new PDO('mysql:host=localhost;dbname=bionic', $user, $password);

    // on applique les deux fonctions mysqli_real_escape_string et htmlspecialchars
    // pour éliminer toute attaque de type injection SQL et XSS
    $username = $db->quote($_GET['username']);
    $password = $db->quote($_GET['password']);

    if($username !== "" && $password !== "")
    {
        $return = $db->prepare( 'SELECT count(*) FROM User WHERE UserName = :username and Password = :password' );
        $return->bindValue( 'username', $_GET['username'], PDO::PARAM_INT );
        $return->bindValue( 'password', $_GET['password'], PDO::PARAM_INT );
        $reponse = $return->execute();
        $count = $reponse['count(*)'];
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
?>