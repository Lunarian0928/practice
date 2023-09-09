package com.example.demo.controller; 

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.plexpt.chatgpt.ChatGPT;

class AnswerService { 
    // 클래스: 효율적인 작업을 위해 나만의 데이터 타입을 정의해놓은 겁니다.
    // 본 클래스는 ChatGPT의 대답을 들을 수 있는 관련 클래스입니다.
    
    String location; // 함수의 매개변수 같은 느낌입니다. 
    
    AnswerService(String location){ // 클래스 생성자
        this.location = location; // 사용자가 서울, 강릉 등 위치를 입력값으로 보낼 수 있도록 만듭니다.
    } 
    
    public String requestAnswer() {  
        // 클래스 메서드로 클래스를 정의하면 쓸 수 있는 함수입니다.
        // chatGPT에게 답변을 받아오는 함수입니다.
        ChatGPT chatGPT = ChatGPT.builder()
            .apiKey("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")
            .build()
            .init();        
        // github에 올라와있는 https://github.com/PlexPt/chatgpt-java/tree/main를 사용하였습니다.
        // 밑으로 내리시다 보면, English Doc.이라는 링크 있으니 여기서 사용법 확인하시면 됩니다.

        String message = this.location + " " + "여행지 추천해줘"; 
        // chatGPT에게 보낼 메시지입니다.
        // 일단은 단순하게 여행지 추천해줘라고 보냈지만
        // 국내로 제한하여야 하며, 기간, 여비 등 상세 조건까지 고려하여 메세지를 수정할 필요가 있습니다.

        String answer = chatGPT.chat(message); // chatGPT에게 문자를 보내고 답변을 얻어옵니다.
        return answer; // 답변을 리턴합니다.
    }
}

// class SpotContent { 아직 구현 못했어요 ㅠㅠ 무시하셔도 됩니다.
//     final String name;
//     final String oneLineExplanation;

//     SpotContent(String name, String oneLineExplanation){
//         this.name = name;
//         this.oneLineExplanation = oneLineExplanation;
//     } 

//     String getName() {
//         return name;
//     }

//     String getOneLineExplanation() {
//         return oneLineExplanation;
//     }
// }

@RestController
public class GuideController {
    @GetMapping("/guide/{location}")
    // http://localhost:8080/guide/서울, http://localhost:8080/guide/강릉 등
    // location에 여러분이 원하는 값을 넣을 수 있고,
    // 그런 주소를 만들어줍니다

    // 주소에 해당하는 페이지 정보입니다
    public String getAnswer(@PathVariable("location") String location) {
        // PathVariable을 통해 {location}, 저걸 가져올 수 있습니다
        // 이게 없다면 /guide/서울, /guide/강릉 .... 엄청 많이 만들어야겠죠?
        
        AnswerService answerService = new AnswerService(location);
        String answer = answerService.requestAnswer();

        String[] strData = answer.split(". ");
        for (String str:strData) {
            if (!str.matches("[0-9].*")) {
                System.out.println(str);
            }
        }
        return answer;    
    }
    
}
