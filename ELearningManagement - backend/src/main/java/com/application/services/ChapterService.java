package com.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import java.util.List;
import com.application.model.Chapter;
import com.application.repository.ChapterRepository;

import javax.transaction.Transactional;

@Service
public class ChapterService
{
	@Autowired
	private ChapterRepository chapterRepo;

	public Chapter saveChapter(Chapter chapter)
	{
		return chapterRepo.save(chapter);
	}
	public void addNewChapter(String coursename,String chaptername,String youtubeid)
  {
    System.out.println(coursename+chaptername+youtubeid);
    chapterRepo.addNewChapter(coursename,chaptername,youtubeid);

  }

	public List<Chapter> getAllChapters()
	{
		return (List<Chapter>)chapterRepo.findAll();
	}

	public List<Chapter> fetchByCoursename(String coursename)
	{
		return (List<Chapter>)chapterRepo.findByCoursename(coursename);
	}

  public int getChapter1(String course)
  {
    return chapterRepo.getChapter1(course);
  }
  public int getChapter2(String course)
  {
    return chapterRepo.getChapter2(course);
  }
  public int getChapter3(String course)
  {
    return chapterRepo.getChapter3(course);
  }
}
