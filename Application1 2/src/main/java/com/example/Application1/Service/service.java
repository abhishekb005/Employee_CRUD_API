package com.example.Application1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.util.Optional;
import javax.naming.ServiceUnavailableException;

import com.example.Application1.Model.CommonData;
@Service
public class service {
    @Autowired
    private RestTemplate template;

    @Autowired
    private DiscoveryClient discoveryClient;

    public Optional<URI> serviceUrl(String service) {
        return discoveryClient.getInstances(service)
                .stream()
                .findFirst()
                .map(si -> si.getUri());
    }

    public CommonData sendMyCommonData(CommonData str) throws ServiceUnavailableException{
        

        URI url = serviceUrl("application17")
                .map(s -> s.resolve("/recieveData"))
                .orElseThrow(ServiceUnavailableException::new);
        CommonData Response = template.postForObject(url,
                        str,CommonData.class);
        return Response;
    }
}
