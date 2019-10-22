package com.virtusa.helper;
	import org.apache.log4j.Logger;
	import com.virtusa.dao.MentorDAO;
	import com.virtusa.dao.MentorDAOImpl;

	public final class FactoryMentorDAO {
		public static final Logger log = Logger.getLogger(FactoryMentorDAO.class.getName());
		public static MentorDAO createMentorDAO() {
			log.info("entered into factory class");
			MentorDAO mentorDAO = new MentorDAOImpl();
			return mentorDAO;
		}
	}

