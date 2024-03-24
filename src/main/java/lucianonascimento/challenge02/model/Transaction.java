package lucianonascimento.challenge02.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "transactions")
@Entity(name = "transaction")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "from_account_id")
  @NotNull
  private Long fromAccountId;

  @NotNull
  @Column(name = "to_account_id")
  private Long toAccountId;

  @Column(name = "created_at")
  private Date createdAt;
}
