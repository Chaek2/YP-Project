package com.example.yp_api_v3.Repositories;

import com.example.yp_api_v3.Models.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookGenreRepository extends JpaRepository<BookGenre,Integer> {
}