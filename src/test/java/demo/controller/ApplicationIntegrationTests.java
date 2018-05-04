package demo.controller;

import demo.Application;
import demo.model.GetCountryRequest;
import demo.model.GetCountryResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationIntegrationTests {

    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

    private int port = 8080;

    @Before
    public void init() throws Exception {
        marshaller.setPackagesToScan(ClassUtils.getPackageName(GetCountryRequest.class));
        marshaller.afterPropertiesSet();
    }

    @Test
    public void testSendAndReceive() {
        WebServiceTemplate template = new WebServiceTemplate(marshaller);
        GetCountryRequest request = new GetCountryRequest();

        request.setName("Spain");
        System.out.println(request);
        GetCountryResponse getCountryResponse = (GetCountryResponse) template.marshalSendAndReceive("http://localhost:8080/ws", request);
        System.out.println(getCountryResponse.toString());
    }
}
