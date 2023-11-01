package com.example.yp_api_v3.Repositories;

import com.example.yp_api_v3.Models.BookSimilar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookSimilarRepository extends JpaRepository<BookSimilar,Integer> {
}