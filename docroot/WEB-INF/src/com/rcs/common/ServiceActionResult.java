package com.rcs.common;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Class made specially for transporting responses from the service layer. <br
 * /> Please avoid the use of exceptions to perform this task. Exceptions are
 * meant for other purposes like for exceptional situations.
 *
 * @author juan
 */
public class ServiceActionResult<T> implements Serializable {

    private static Log logger = LogFactoryUtil.getLog(ServiceActionResult.class);
    private static final long serialVersionUID = 1L;
    private boolean success = false;
    private final T payload;    
    private int responseCode;
    private String message;
    private String messageKey;
    
    public ServiceActionResult(boolean success, T payload) {
        this.success = success;
        this.payload = payload;        
    }

    /**
     * Return the payload of this service action result. This is intended to aid
     * on the lack of return types.
     *
     * @return
     */
    public T getPayload() {
        return payload;
    }

    /**
     * Check if this service action result represents a successful status.
     *
     * @return
     */
    public boolean isSuccess() {
        return success;
    }

   /**
     * Build a successful service result.
     *
     * @param <T>
     * @param payload
     * @param keys
     * @return
     */
    public static <T> ServiceActionResult<T> buildSuccess(T payload) {              
        return new ServiceActionResult<T>(true, payload);
    }

   /**
     * Build a failure service result.
     *
     * @param <T>
     * @param payload
     * @param keys
     * @return
     */
    public static <T> ServiceActionResult<T> buildFailure(T payload) {
        return new ServiceActionResult<T>(false, payload);
    }

    public int getResponseCode() {
		return responseCode;
	}
	
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}
}
