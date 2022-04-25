package infrastructure.persistence.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Evidence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEvidence;
	
	private String urlRecourse;
	
	private String tipo;

}
