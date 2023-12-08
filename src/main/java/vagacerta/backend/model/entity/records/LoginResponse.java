package vagacerta.backend.model.entity.records;

import vagacerta.backend.model.entity.Candidate;
import vagacerta.backend.model.entity.Company;

public record LoginResponse(String token, Candidate candidate, Company company) {
}
