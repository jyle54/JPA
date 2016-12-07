package jpaharkat;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SimpleEntity
 * 
 */
@Entity
@Table(name = "SIMPLEENTITY")
@NamedQueries({
@NamedQuery(name = "selectAll", query = "SELECT a from SimpleEntity a"),
@NamedQuery(name = "etsiKirjain", query = "SELECT a from SimpleEntity a where a.name like 'K%'"),
@NamedQuery(name = "etsiKirjain2", query = "SELECT a from SimpleEntity a where a.name like '%a%'"),
@NamedQuery(name = "etsiKirjain3", query = "SELECT a from SimpleEntity a where a.name like '%ä%' or a.name like '%l%'")
})
public class SimpleEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String desc;

	public SimpleEntity() {
		super();
	}
	
	public SimpleEntity(long id, String n, String d) {
		this.id = id;
		this.name = n;
		this.desc = d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String toString() {
		return this.name + this.desc;
	}

}
