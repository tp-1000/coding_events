package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Tags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tags, Integer> {
}
