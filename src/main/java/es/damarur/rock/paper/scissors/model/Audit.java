package es.damarur.rock.paper.scissors.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Audit {

	@Column(name = "created_at", updatable = false)
	private Instant createdAt;

	@Column(name = "modified_at")
	private Instant modifiedAt;

	@PrePersist
	public void prePersist() {
		if (this.createdAt == null) {
			createdAt = Instant.now();
		}
		if (this.modifiedAt == null) {
			modifiedAt = Instant.now();
		}
	}

	@PreUpdate
	public void preUpdate() {
		modifiedAt = Instant.now();
	}

}
