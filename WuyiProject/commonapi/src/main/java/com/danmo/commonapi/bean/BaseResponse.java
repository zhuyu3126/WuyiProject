package com.danmo.commonapi.bean;
import java.io.Serializable;
import java.util.List;

/**
 * retrofit网络请求基类
 * @author zhuyu
 *
 */
public class BaseResponse<T> implements Serializable {
	String uuid;
	String msg;
	int code ;
	int total;
	T data;
	List<T> rows;

	public BaseResponse(String uuid, String msg, int status) {
		this.uuid = uuid;
		this.msg = msg;
		this.code = status;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
