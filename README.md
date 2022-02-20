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
    	"msgType":"”JOIN”",
        "roomId":"550e8400-e29b-41d4-a716-446655440000",
        "userId":“aaa1234”
    };
    ```
    
    ## 방 퇴장
    
    ```
    {
    	msgType: "LEAVE”,
        roomId: "550e8400-e29b-41d4-a716-446655440000"
    	userId: “aaa1234”
    };
    ```
    
    ## 컨텐츠(폴라로이드, 포스팃)
    
    - **생성**
        
        ```
       {
        	msgType : ”CREATE”,
            roomId: "550e8400-e29b-41d4-a716-446655440000",
            contentId: null,
            userId: "xowns9418",
        	contentType: "PORAROID"
        	data : {
        	    images : [{
                        link: "http://imgs",
                        order: 0
                    }],
        	    content: “회고를 시작합니다!.....”,
        	    width: 100.1, -> Double
        	    height: 100.1, -> Double
        	    opacity: 0.1, -> Double
        		font: "FONT",
                rotation: "80",
        	    point: {
        			x: 50.1, -> Double
        			y: 50.1 -> Double
        		}
        	}
        };
                
        ```
        
    - **컨텐츠 내용변경**
        
        ```
        --------------> 컨텐츠 데이터 규격(이미지, 사진)
        {
           	msgType : ”UPDATE”,
            roomId: "550e8400-e29b-41d4-a716-446655440000",
            contentId: "asjdiwsjd-..,
            userId: "xowns9418",
        	contentType: "PORAROID"
        	data : {
        	    images : [{
                        link: "http://imgs",
                        order: 0
                    }],
        	    content: “회고를 시작합니다!.....”,
        	    width: 100.1, -> Double
        	    height: 100.1, -> Double
        	    opacity: 0.1, -> Double
        		font: "FONT",
                rotation: "80",
        	    point: {
        			x: 50.1, -> Double
        			y: 50.1 -> Double
        		}
        	}
        };
      
             
        ```
    - **컨텐츠 위치이동**
        
        ```
        --------------> 컨텐츠 데이터 규격(roataion, x, y)
        {
        	msgType : ”DRAG”,
            roomId: "550e8400-e29b-41d4-a716-446655440000",
            contentId: "asjdiwsjd-..,
            userId: "xowns9418",
        	contentType: "PORAROID"
        	data : {
        	    rotation: "80",
        	    point: {
        			x: 50.1, -> Double
        			y: 50.1 -> Double
        		}
        	}
        };
                   
        ```
    
    
    - **삭제**
        
        ```
        {
        		msgType : ”DELETE”,
                roomId: "550e8400-e29b-41d4-a716-446655440000"
        		contentType: "POLAROID",
        	    contentId: “basd23as-22323..",
                userId: "xowns9418
        };
        ```
        
    
    - subscribe(Socket Server → Client)
        - url : /subscribe/room/{roomID}
        - 상세 데이터 규격은 **컨텐츠 생성**을 제외하고는 publish와 동일
            - contentId 추가
        - 모든 publish 데이터에서 responseTime 추가
            
            
        
        ## 컨텐츠
        
        - **생성**
            - publish 규격에서 contentId 추가
            
            ```
           {
            		msgType : ”CREATE”,
                    roomId: "550e8400-e29b-41d4-a716-446655440000",
                    contentId: "aasdasd-...",
                    userId: "xowns9418",
                    contentType: "PORAROID"
                    data : {
                        images : [{
                                link: "http://imgs",
                                order: 0
                            }],
                        content: “회고를 시작합니다!.....”,
                        width: 100.1, -> Double
                        height: 100.1, -> Double
                        opacity: 0.1, -> Double
                        font: "FONT",
                        rotation: "80",
                        point: {
                            x: 50.1, -> Double
                            y: 50.1 -> Double
                        }
                    }
            };
            
        
            ```
            
        
        ### 에러 메시지(서버 에러)
        
        ```
        {
        		msgType : ”ERROR”,
        		errorMsg: "api 서버 에러",
        		roomId: "aaabasd-...",
        };
        ```
