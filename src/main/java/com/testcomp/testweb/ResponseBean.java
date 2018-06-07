package com.testcomp.testweb;

import java.util.List;

public class ResponseBean {  
  
    private static final String OK = "ok";  
    private static final String ERROR = "error";  
  
    private Meta meta;  
    private Object data;
    private List<Object> dataList;
  
    public ResponseBean success() {  
        this.meta = new Meta(true, OK);  
        return this;  
    }  
  
    public ResponseBean success(Object data) {  
        this.meta = new Meta(true, OK);  
        this.data = data;  
        return this;  
    }
    
    public ResponseBean success(List<Object> dataList) {  
        this.meta = new Meta(true, OK);  
        this.dataList = dataList;  
        return this;  
    }
  
    public ResponseBean failure() {  
        this.meta = new Meta(false, ERROR);  
        return this;  
    }  
  
    public ResponseBean failure(String message) {  
        this.meta = new Meta(false, message);  
        return this;  
    }  
  
    public Meta getMeta() {  
        return meta;  
    }  
  
    public Object getData() {  
        return data;  
    }
    
    public List<Object> getDataList() {
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}



	public class Meta {  
  
        private boolean success;  
        private String message;  
  
        public Meta(boolean success) {  
            this.success = success;  
        }  
  
        public Meta(boolean success, String message) {  
            this.success = success;  
            this.message = message;  
        }  
  
        public boolean isSuccess() {  
            return success;  
        }  
  
        public String getMessage() {  
            return message;  
        }  
    }  
} 