package hitbra.hackathon.warmup.spring.model;

public class DadosVeiculoResponse {
	private String code;
	private String message;
	private String date;
	private String hour;
	private String revision;
	private DadosContent content;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public DadosContent getContent() {
		return content;
	}

	public void setContent(DadosContent content) {
		this.content = content;
	}
}
