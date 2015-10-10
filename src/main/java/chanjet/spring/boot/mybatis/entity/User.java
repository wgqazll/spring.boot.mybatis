package chanjet.spring.boot.mybatis.entity;


import java.io.Serializable;


public class User implements Serializable{
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
