package com.virtusa.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.virtusa.dao.MentorDAO;
import com.virtusa.dao.MentorDAOImpl;
import com.virtusa.entities.Mentor;

public class MentorViewDetailsTest {


	@Test
	public void viewMentor_possitive() {
		Mentor mentor = new Mentor();
		MentorDAO mentorDAO = new MentorDAOImpl();

		try {
			String userId = mentor.getMentorId();
			List<Mentor> mentors = mentorDAO.mentorProfileView(userId);
			assertNotNull(mentors);

		} catch (ClassNotFoundException | SQLException e) {
			assertTrue(false);
		}

	}
}
