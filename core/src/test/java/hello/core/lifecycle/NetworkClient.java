package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {
    private String url;

    public NetworkClient() {
        //this.url = url;
        System.out.println("생성자 호출 , url = " + url);
        connect();
        call("초기화 연결 메세지 ");
        disConnect();
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void connect(){
        System.out.println("connect : "+ url);
    }

    public void call(String message){
        System.out.println("call : " + url + "message  = : " + message);
    }


    public void disConnect(){
        System.out.println("Close : " + url );
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        System.out.println("c초기화 연결 메세지 ");
    }

    @Override
    public void destroy() throws Exception {
        disConnect();
    }
}
