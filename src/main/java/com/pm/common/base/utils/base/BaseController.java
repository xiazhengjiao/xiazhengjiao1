package com.pm.common.base.utils.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pm.common.base.utils.NetWorkUtil;
import com.pm.common.base.utils.apibase.APIBaseResult;
import com.pm.common.base.utils.apibase.SetAPIResultUtil;
import com.pm.common.base.utils.exceptions.ArgumentException;




/**
 *  增加公共参数
 */
public abstract class BaseController {
	
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired  
	private  HttpServletRequest req;
    
    protected APIBaseResult getAPIResult(APIBaseResult result) {
        return result;
    }

    public void buildException(APIBaseResult result, String path, Exception e, Object param) {
        if (e instanceof ArgumentException) {
            result.setErrorDescription(e.getMessage());
            SetAPIResultUtil.setFail(result);
        } else {
            e.printStackTrace();
            log.error("\n request : " + path + " \n params : \n" +  param, e);
            result.setErrorDescription("服务器接口异常！");
            SetAPIResultUtil.setFail(result);
        }
    }
    
    /**
     * 获取公共参数
     * @return
     * @throws Exception
    */
    protected Map<String,Object> getPublicParams() throws Exception{
    	
    	Map<String,Object> parameterMap=new HashMap<String,Object>();
    	try {
    		String ipAddress=NetWorkUtil.getIpAddress(req);   //获取客户端IP地址
    		String version=req.getParameter("version");
    		String sdkVersion=req.getParameter("sdk_version");
    		String channel=req.getParameter("channel");
    		String appname=req.getParameter("appname");
    		String platform=req.getParameter("platform");
    		String deviceId=req.getParameter("deviceId");
    		String deviceType=req.getParameter("deviceType");
    		String dateKey=req.getParameter("dateKey");
    		String appType=req.getParameter("appType");
    		String iswifi=req.getParameter("iswifi");
    		parameterMap.put("iswifi", iswifi);
    		parameterMap.put("appType", appType);
    		parameterMap.put("dateKey", dateKey);
    		parameterMap.put("deviceType", deviceType);
    		parameterMap.put("deviceId", deviceId);
    		parameterMap.put("platform", platform);
    		parameterMap.put("appname", appname);
    		parameterMap.put("channel", channel);
    		parameterMap.put("sdkVersion", sdkVersion);
    		parameterMap.put("version", version);
    		parameterMap.put("ipAddress", ipAddress);
		} catch (Exception e) {
			log.error("获取公共参数getPublicParams方法出错:" + e);
			e.printStackTrace();
		}
		return parameterMap;
    }
    

    
}
