package fdir.web.client.fdirclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ClientService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public String getResponse(String url) {
        WebClient client = webClientBuilder.build();
        Mono<String> response = client.get()
                                      .uri(url)
                                      .retrieve()
                                      .bodyToMono(String.class);

        return response.block();  // Blocking here for simplicity, but consider reactive return types for real applications

    }
}

