package estatesGo.Entity;


import javax.persistence.*;

@Entity
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pid;

	private String name;
	private String description;
	private int price;


	@ManyToOne
	@JoinColumn(name = "agent_id")
	private Agent agent;


	private String status;

	public Property(int pid, String name, String description, int price, String status) {
		super();
		this.pid = pid;
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
	}

	public Property() {
		// TODO Auto-generated constructor stub
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
