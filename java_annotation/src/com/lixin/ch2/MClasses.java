package com.lixin.ch2;

@Table(tableName="t_classes")
public class MClasses {
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column("cid")
	private int  id;
	
	@Column("cname")
	private String name;
	
	@Column("caddress")
	private String addr;
	
	@Column("cqq")
	private String qq;

}
