package com.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.application.model.Chapter;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
  public List<Chapter> findByCoursename(String Coursename);
  @Transactional
  @Modifying
  @Query(value = "update chapter set chapter1id=:id,chapter1name=:chap where coursename = :coursename", nativeQuery = true)
  public void addNewChapter( @Param("coursename")String coursename, @Param("chap")String chaptername, @Param("id")String youtubeid);
//
//  @Modifying
//  @Query(value = "UPDATE book SET :columnName = :columnValue WHERE id = :id", nativeQuery = true)
//  void updateColumn(@Param("id") Long id, @Param("columnName") String columnName, @Param("columnValue") String columnValue);



  @Query(value="SELECT count(*) from chapter c where c.coursename=?1 and c.chapter1id=''",nativeQuery = true)
  public int getChapter1(String course);

  @Query(value="SELECT count(*) from chapter c where c.coursename=?1 and c.chapter2id=''" ,nativeQuery = true)
  public int getChapter2(String course);

  @Query(value="SELECT count(*) from chapter c where c.coursename=?1 and c.chapter3id=''",nativeQuery = true)
  public int getChapter3(String course);
}
