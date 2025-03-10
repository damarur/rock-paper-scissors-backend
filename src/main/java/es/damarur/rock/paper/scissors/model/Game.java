package es.damarur.rock.paper.scissors.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Instant datetime;

	@Column
	private String nickname;

	@Column
	@Enumerated(EnumType.STRING)
	private Choice userChoice;

	@Column
	@Enumerated(EnumType.STRING)
	private Choice machineChoice;

	@Column
	@Enumerated(EnumType.STRING)
	private Result result;

	@Embedded
	@Builder.Default
	private Audit audit = new Audit();

}
