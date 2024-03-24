package lucianonascimento.challenge02.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

@Table(name = "accounts")
@Entity(name = "account")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id")
  private Long user;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "type")
  @JdbcType(PostgreSQLEnumJdbcType.class)
  private AccountTypeEnum type;

  @Column
  private double balance;
}
