# Nexters_duckjiduckji_socket_server

## **폴라로이드 데이터 규격 및 연동정보**

## 컨텐츠(폴라로이드, 포스팃) **데이터 규격 및 연동정보**

- 연동 url 정보(sockJs 파라미터로 넣을 값) → 추후 전달 예정
    - http://ip:port/room
- publish(Client →Socket Server)
    - url : /publish/room/{roomID}
    - msgType으로 요청 type을 구분
    - roomId는 UUID 형태로 제공 예정(ex. `550e8400-e29b-41d4-a716-446655440000`)
    - **msgType 종류**
        - **JOIN :** 방 참여
        - **LEAVE :** 방 퇴장
        - **CREATE :** 컨텐츠 생성
        - **UPDATE :** 컨텐츠 수정
        - **DRAG :** 위치 이동
        - **DELETE :** 컨텐츠 삭제
        - **ERROR** : 서버 에러
    
    ## 방 참여
    
    ```
    {
    			msgType: ”JOIN”,
    		    userId: “aaa1234”
    };
    ```
    
    ## 방 퇴장
    
    ```
    {
    				 	msgType: "LEAVE”,
    		      userId: “aaa1234”
    };
    ```
    
    ## 컨텐츠(폴라로이드, 포스팃)
    
    - **생성**
        
        ```
        
        ------------------------> PORAROID
        {
        					msgType : ”CREATE”,
        					contentType: "PORAROID"
        					data : {
        				    images : [“http://.....”, “http://.....”],
        				    title : “덕지덕지 회고방”,
        				    content: “회고를 시작합니다!.....”,
        						width: "100",
        						height: "100",
        						opacity: "0.1",
        						font: "???",
        					  point: {
        							x: "100",
        		 					y: "100",
        							rotation: ??
        						}
        				 }
        };
        
        ---------------------> POSIT (미사용)
        
        {
        					msgType : ”CREATE”,
        					contentType: "POSIT"
        					data : {
        				    content: “회고를 시작합니다!.....”,
        						width: "100",
        						height: "100",
        						opacity: "0.1",
        						font: "???",
        					  point: {
        							x: "100",
        		 					y: "100",
        							rotation: ??
        						}
        					}
        };
        
        ```
        
    - **수정**
        
        ```
        --------------> 컨텐츠 데이터 규격(이미지, 제목, 사진)
        {
        					msgType : ”UPDATE”,
        					contentType: "PORAROID"
        					contentId: “basd23as-22323..",
        		      data: {
        					    images : [“http://.....”],
        					    title : “덕지덕지 회고방”,
        					    content: “회고를 시작합니다!.....”,     
        							opacity: "0.1",
        							font: "???",
        					} 
        };
        
        {  ------------> 미사용
        					msgType : ”UPDATE”,
        					contentType: "POSTIT"
        					contentId: “basd23as-22323..",
        		      data: {
        					    content: “회고를 시작합니다!.....”,     
        					} 
        };
        
        --------------> 컨텐츠 데이터 규격(위치, rotation)
        {
        					msgType : ”DRAG”,
        					contentId: “basd23as-22323..",
        		      data : {
        					   point: {
        								x: "100",
        			 					y: "100",
        								rotation: ??
        						 }
        					}   
        };
        
        ```
        
    
    **폴라로이드 생성, 수정 상세 절차** 
    
    1. 파일 서버로 파일 전송 후 url 받음
    2. 이미지 url, 글 제목, 글 내용을 socket server로 전송
    
    - **삭제**
        
        ```
        *{*
        					msgType : ”DELETE”,
        					contentType: "POLAROID",
        		      **contentId: “basd23as-22323.."
        *};*
        ```
        
    
    - subscribe(Socket Server → Client)
        - url : /subscribe/room/{roomID}
        - 상세 데이터 규격은 **방 참여/퇴장, 컨텐츠 생성**을 제외하고는 publish와 동일
            - 컨텐츠 생성
                - contentId 추가
            - 방 참여/퇴장
                - 현재 방에 있는 유저 리스트
        - 모든 publish 데이터에서 responseTime 추가
            
            
        
        ## 방 참여
        
        ```
        {
        				 	msgType: ”JOIN”,
        					userId: "aaa1234", // 입장한 유저 id
        		      onLineUsers: [“aaa1234”, "aabbcs2", "asd2easd"]
        };
        ```
        
        ## 방 퇴장
        
        ```
        {
        				 	msgType: "LEAVE”,
        					userId: "asd2easd" // 퇴장한 유저 id
        					onLineUsers: [“aaa1234”, "aabbcs2"]
        };
        ```
        
        ## 컨텐츠
        
        - **생성**
            - publish 규격에서 contentId 추가
            
            ```
            
            ------------------------> PORAROID
            {
            					msgType : ”CREATE”,
            					contentType: "PORAROID"
            					contentId: “basd23as-22323..",
            					data : {
            				    images : [“http://.....”, “http://.....”],
            				    title : “덕지덕지 회고방”,
            				    content: “회고를 시작합니다!.....”,
            						width: "100",
            						height: "100",
            						opacity: "0.1",
            						font: "???",
            					  point: {
            							x: "100",
            		 					y: "100",
            							rotation: ??
            						}
            				 }
            };
            
            ---------------------> POSIT (미사용)
            
            {
            					msgType : ”CREATE”,
            					contentType: "POSIT"
            					contentId: “basd23as-22323..",
            					data : {
            				    content: “회고를 시작합니다!.....”,
            						width: "100",
            						height: "100",
            						opacity: "0.1",
            						font: "???",
            					  point: {
            							x: "100",
            		 					y: "100",
            							rotation: ??
            						}
            					}
            };
            
            ```
            
        
        ### 에러 메시지(서버 에러) → 필요할지..?
        
        ```
        {
        					msgType : ”ERROR”,
        					errorMsg: "api 서버 에러",
        					roomId: "aaabasd-...",
        };
        ```
