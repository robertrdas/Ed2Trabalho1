package apps;

/*classe para o que simula uma struct em c, 
 * com um campo chave para ordenação e um campo qualquer*/
public class Componente {
	private int key;
	private String msg;

	public Componente() {
	};

	public Componente(int chave) {
		key = chave;
		msg = "Atividade de ED2";
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
