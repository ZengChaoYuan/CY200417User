package bean;

import java.sql.Date;

public class UserScore {
	private Long usId;
	private Long userId;
	private Long scoreState;
	private Long score;
	private Date usCtime;

	public UserScore(Long usId, Long userId, Long scoreState, Long score, Date usCtime) {
		super();
		this.usId = usId;
		this.userId = userId;
		this.scoreState = scoreState;
		this.score = score;
		this.usCtime = usCtime;
	}

	public UserScore() {
		super();
	}

	public Long getUsId() {
		return usId;
	}

	public void setUsId(Long usId) {
		this.usId = usId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getScoreState() {
		return scoreState;
	}

	public void setScoreState(Long scoreState) {
		this.scoreState = scoreState;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Date getUsCtime() {
		return usCtime;
	}

	public void setUsCtime(Date usCtime) {
		this.usCtime = usCtime;
	}

}
