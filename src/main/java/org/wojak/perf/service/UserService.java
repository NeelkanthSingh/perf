package org.wojak.perf.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.Text;
import org.wojak.perf.entity.User;
import org.wojak.perf.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User addUser() {
    HttpGet httpGet = new HttpGet("https://json-placeholder.mock.beeceptor.com/users");
    httpGet.setHeader("Content-Type", "application/json");
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      CloseableHttpResponse response = httpClient.execute(httpGet);
      HttpEntity entity = response.getEntity();
      if (entity != null) {
        String result = EntityUtils.toString(entity);
        User user = userRepository.save(User.builder().userList(result).build());
        return ResponseEntity.ok(user).getBody();
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return null;
  }

}
