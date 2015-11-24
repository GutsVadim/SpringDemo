package org.guts.repositories;

import org.guts.entity.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface NotesRepository extends CrudRepository<Note, Long> {

    @Override
    Note findOne(Long id);

    @Override
    Collection<Note> findAll();

    @Override
    void delete(Long id);

    @Override
    Note save(Note note);

}
