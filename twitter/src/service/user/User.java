package service.user;
import errorjson.*;

import org.json.JSONException;
import org.json.JSONObject;

import errorjson.ServiceRefused;
import errorjson.ServiceAccepted;

import tools.UserTools;

public class User {
	
	public User() {
		
	}
	
	public static JSONObject createUser(String login, String mdp, String nom, String prenom, String email) {
		if (login == null || mdp == null || nom == null || prenom == null || email == null) {
			return ServiceRefused.serviceRefused("arguments manquants","-1");
			}
		
		//tester si login deja utilisÃ©
		if(UserTools.userExists(login))
			return ServiceRefused.serviceRefused("Login deja existant", "-2");
		
		/*
		 * TODO
		 * insÃ©rer user dans la BD 
		 */
		return UserTools.addUser(login, mdp, nom, prenom, email);
		
	}
	
	public static JSONObject login(String login, String mdp) throws JSONException {
		if (login == null || mdp == null) {
			return ServiceRefused.serviceRefused("argument manquant","-1");
		}
		
		boolean is_user = tools.UserTools.userExists(login);
		if(!is_user) {
			return ServiceRefused.serviceRefused("Utilisateur inexistant","-2");
		}
		boolean mdp_ok = tools.UserTools.checkPasswd(login, mdp);
		if(!is_user) {
			return ServiceRefused.serviceRefused("Utilisateur inexistant","-2");
		}
		
		return tools.UserTools.loginUser(login,mdp);
	}
	
	public static JSONObject logOut(String login, String mdp) {
		if (login == null || mdp == null) {
			return ServiceRefused.serviceRefused("argument manquant","-1");
		}
		
		boolean is_connected = tools.UserTools.isConnected(login);
		if(!is_connected) {
				return ServiceAccepted.serviceAccepted("User deja deconnecté","-1");
			
		}
		
		return tools.UserTools.logOutUser(login,mdp);
		
	}
}