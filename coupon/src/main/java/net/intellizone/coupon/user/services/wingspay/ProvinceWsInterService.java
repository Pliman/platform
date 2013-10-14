package net.intellizone.coupon.user.services.wingspay;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * <p>
 * An example of how this class may be used:
 * 
 * <pre>
 * ProvinceWsInterService service = new ProvinceWsInterService();
 * ProvinceWsInterDelegate portType = service.getProvinceWsInterDelegate();
 * portType.doBusiness(...);
 * </pre>
 * 
 * </p>
 * 
 */
@WebServiceClient(name = "ProvinceWsInterService", targetNamespace = "http://wsi.huateng.com/", wsdlLocation = "file:/D:/platform/platform/coupon/wsdl/provice.wsdl")
public class ProvinceWsInterService extends Service {

	private final static URL PROVINCEWSINTERSERVICE_WSDL_LOCATION;
	private final static Logger logger = Logger
			.getLogger(net.intellizone.coupon.user.services.wingspay.ProvinceWsInterService.class
					.getName());

	static {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = net.intellizone.coupon.user.services.wingspay.ProvinceWsInterService.class
					.getResource(".");
			url = new URL(baseUrl, "file:/D:/platform/platform/coupon/wsdl/provice.wsdl");
		} catch (MalformedURLException e) {
			logger
					.warning("Failed to create URL for the wsdl Location: 'file:/D:/platform/platform/coupon/wsdl/provice.wsdl', retrying as a local file");
			logger.warning(e.getMessage());
		}
		PROVINCEWSINTERSERVICE_WSDL_LOCATION = url;
	}

	public ProvinceWsInterService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public ProvinceWsInterService() {
		super(PROVINCEWSINTERSERVICE_WSDL_LOCATION, new QName("http://wsi.huateng.com/",
				"ProvinceWsInterService"));
	}

	/**
	 * 
	 * @return returns ProvinceWsInterDelegate
	 */
	@WebEndpoint(name = "ProvinceWsInterDelegate")
	public ProvinceWsInterDelegate getProvinceWsInterDelegate() {
		return super.getPort(new QName("http://wsi.huateng.com/", "ProvinceWsInterDelegate"),
				ProvinceWsInterDelegate.class);
	}
	
}
