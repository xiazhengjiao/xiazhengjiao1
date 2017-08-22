package com.pm.common.base.utils.apibase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pengf on 2014/9/26.
 */
public class SetAPIResultUtil {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void setFail(APIBaseResult result) {
        result.setErrorCode(ReturnCode.FAIL);
        result.setErrorDescription(result.getErrorDescription());
        result.setTimes(sdf.format(new Date()));
    }

    public static void setSuccess(APIBaseResult result) {
        result.setErrorDescription(ReturnCode.MSG_SUCCESS);
        result.setErrorCode(ReturnCode.SUCCESS);
        result.setTimes(sdf.format(new Date()));
    }
}
