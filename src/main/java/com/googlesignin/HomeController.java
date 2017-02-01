package com.googlesignin;

import com.google.api.client.googleapis.auth.oauth2.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.Json;
import com.google.api.client.json.jackson.JacksonFactory;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.Consumes;
import java.io.File;
import java.io.FileReader;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.Constants.REDIRECT_URI;


@Controller
public class HomeController {
	

	@RequestMapping(value="/home", method=RequestMethod.GET )
	public String getLoginForm(){ return "home"; }


	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public void getToken(@RequestBody AuthResult authResult) throws Exception {
		String authCode =authResult.getCode();
		System.out.println(authCode);
//
//		String CLIENT_SECRET_FILE = "src/main/resources/config/client_secret.json";
//
//// Exchange auth code for access token
//		GoogleClientSecrets clientSecrets =
//				GoogleClientSecrets.load(
//						JacksonFactory.getDefaultInstance(), new FileReader(CLIENT_SECRET_FILE));
//		GoogleTokenResponse tokenResponse =
//				new GoogleAuthorizationCodeTokenRequest(
//						new NetHttpTransport(),
//						JacksonFactory.getDefaultInstance(),
//						"https://www.googleapis.com/oauth2/v4/token",
//						clientSecrets.getDetails().getClientId(),
//						clientSecrets.getDetails().getClientSecret(),
//						authCode,
//						REDIRECT_URI)  // Specify the same redirect URI that you use with your web
//						// app. If you don't have a web version of your app, you can
//						// specify an empty string.
//						.execute();
//
//		String accessToken = tokenResponse.getAccessToken();
//
//// Use access token to call API
//		GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
//		Drive drive =
//				new Drive.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential)
//						.setApplicationName("Auth Code Exchange Demo")
//						.build();
//		File file = drive.files().get("appfolder").execute();
//
//// Get profile info from ID token
//		GoogleIdToken idToken = tokenResponse.parseIdToken();
//		GoogleIdToken.Payload payload = idToken.getPayload();
//		String userId = payload.getSubject();  // Use this value as a key to identify a user.
//		String email = payload.getEmail();
//		boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
//		String name = (String) payload.get("name");
//		String pictureUrl = (String) payload.get("picture");
//		String locale = (String) payload.get("locale");
//		String familyName = (String) payload.get("family_name");
//		String givenName = (String) payload.get("given_name");
//
	}

}
