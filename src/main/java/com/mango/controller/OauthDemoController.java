package com.mango.controller;

import com.mango.service.OauthDemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("http://34.83.15.61:3000") // 확인 필요
@RequiredArgsConstructor//생성자 문제 발생
@Tag(name = "OAuthDemo", description = "OAuth 2.0 구글 데모 API")
@RequestMapping(value ="/api/oauth2/login", produces = "application/json")
public class OauthDemoController {
    OauthDemoService oauthDemoService;
    @Autowired // Autowired 어노테이션 추가 후 this.oauthDemoService = null 해결
    public OauthDemoController(OauthDemoService oauthDemoService){
        this.oauthDemoService = oauthDemoService;
    }
    @GetMapping("/code/{registrationId}")
    @Operation(summary = "Google 소셜 로그인")
    public void googleLogin(@RequestParam String code, @PathVariable String registrationId) {
        oauthDemoService.socialLogin(code, registrationId);
    }
}
