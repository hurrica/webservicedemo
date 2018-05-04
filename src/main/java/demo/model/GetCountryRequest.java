package demo.model;

import lombok.Data;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name"})
@XmlRootElement(namespace = "http://com.bluepay/webserver/demo/gs-producing-web-service", name = "getCountryRequest")
@Data
public class GetCountryRequest {

    @XmlElement(required = true)
    private String name;

}