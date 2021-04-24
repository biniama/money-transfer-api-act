package com.act.moneytransferapi.respositories;

import com.act.moneytransferapi.domains.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Biniam Asnake
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {}
