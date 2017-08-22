package com.pm.common.base.utils.apibase;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by pengf on 2015/11/26.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class APIBaseResult {
    protected int errorCode;
    protected String errorDescription;
    private Object result;
    private Long totalCount;
    private String times;
    
    // 弹框
 	private  AlertBean alertInfo;
    
    public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}
    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
    
    public AlertBean getAlertInfo() {
		return alertInfo;
	}

	public void setAlertInfo(AlertBean alertInfo) {
		this.alertInfo = alertInfo;
	}

	private static APIBaseResult sourceMissErrResult;
    public static APIBaseResult buildErrorResult(String errorDescription) {
        APIBaseResult apiBaseResult = new APIBaseResult();
        SetAPIResultUtil.setFail(apiBaseResult);
        apiBaseResult.setErrorDescription(errorDescription);
        apiBaseResult.setResult("");
        return apiBaseResult;
    }
    public static APIBaseResult getSourceMissErrResult() {
        if (null == sourceMissErrResult) {
            sourceMissErrResult = new APIBaseResult();
            SetAPIResultUtil.setFail(sourceMissErrResult);
            sourceMissErrResult.setErrorDescription("Source is Missing!");
            sourceMissErrResult.setResult("");
        }
        return sourceMissErrResult;
    }
    public static APIBaseResult getSourceInValidErrResult() {
        if (null == sourceMissErrResult) {
            sourceMissErrResult = new APIBaseResult();
            SetAPIResultUtil.setFail(sourceMissErrResult);
            sourceMissErrResult.setErrorDescription("Source is Invalid!");
            sourceMissErrResult.setResult("");
        }
        return sourceMissErrResult;
    }
    public static APIBaseResult getMissVersionErrResult() {
        if (null == sourceMissErrResult) {
            sourceMissErrResult = new APIBaseResult();
            SetAPIResultUtil.setFail(sourceMissErrResult);
            sourceMissErrResult.setErrorDescription("Version is missing!");
            sourceMissErrResult.setResult("");
        }
        return sourceMissErrResult;
    }
    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
