package Base;

/**
 * @author diegoraian
 *
 */
public class DadosConexao {
	private String ip;
	
	private Integer porta;

	public DadosConexao(String ip, Integer port) {
		this.ip =  ip;
		this.porta = port;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPorta() {
		return porta;
	}

	public void setPorta(Integer porta) {
		this.porta = porta;
	}


	
	
}
