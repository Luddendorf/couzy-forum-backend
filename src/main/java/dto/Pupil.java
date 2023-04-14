package dto;

public class Pupil {
	private Long pupilId;
	private String name;

	public Pupil() {
		// TODO Auto-generated constructor stub
	}

	public Pupil(Long pupilId, String name) {
		super();
		this.pupilId = pupilId;
		this.name = name;
	}

	public Long getPupilId() {
		return pupilId;
	}

	public void setPupilId(Long pupilId) {
		this.pupilId = pupilId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
