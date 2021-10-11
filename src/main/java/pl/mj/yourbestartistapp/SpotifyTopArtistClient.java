package pl.mj.yourbestartistapp;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.mj.yourbestartistapp.model.Item;
import pl.mj.yourbestartistapp.model.SpotifyArtist;



@Controller
public class SpotifyTopArtistClient {



    @GetMapping("/")
    public String mainpage(OAuth2Authentication details){

        return "mainpage";
    }


    @GetMapping("/artist")
    public String getTopArtist(OAuth2Authentication details, Model model){
        String jwt = ((OAuth2AuthenticationDetails)details.getDetails()).getTokenValue();
        System.out.println(jwt);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Bearer "+jwt);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<SpotifyArtist> exchange=restTemplate.exchange("https://api.spotify.com/v1/me/top/artists?time_range=medium_term&limit=1&offset=0", HttpMethod.GET,httpEntity,SpotifyArtist.class);

        Artist artist = null;
        for(Item item : exchange.getBody().getItems()){
            artist = new Artist(item.getName(),item.getExternalUrls().getSpotify(),item.getImages().get(0).getUrl());

        }
        model.addAttribute("artist",artist);
        return "artist";
    }

}
