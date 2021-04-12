package ContactList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactListRepository extends JpaRepository<Contact, Long> {

}
