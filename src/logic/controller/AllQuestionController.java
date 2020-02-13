package logic.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import logic.bean.QuestionBean;
import logic.bean.QuestionExerciseBean;
import logic.bean.QuestionProblemBean;
import logic.model.Question;
import logic.model.dao.QuestionDao;



public class AllQuestionController {
	
	
	public AllQuestionController() {
		
	}
	
	public List<QuestionBean> getQuestions() {
		List<QuestionBean> bean = new ArrayList<>() ;
		
		try {
			List<Question> quest = QuestionDao.getQuestions();
			if(quest == null) {
				bean = null;
			}
			else {
				for(int i=0; i<quest.size();i++) {
					
					Question appQuest = quest.get(i);
					QuestionBean appBean;
					if(appQuest.whoAmI().equals("EXERCISE")) {
						appBean = new QuestionExerciseBean();
						
						Object returned = appQuest.getClass().getMethod("getText").invoke(appQuest);
						appBean.getClass().getMethod("setText", String.class).invoke(appBean,(String)returned);
						
						Object returned2 = appQuest.getClass().getMethod("getImage").invoke(appQuest);
						appBean.getClass().getMethod("setImage", String.class).invoke(appBean,(String)returned2);
					}
					else {
						appBean = new QuestionProblemBean();
						Object returned = appQuest.getClass().getMethod("getText").invoke(appQuest);
						appBean.getClass().getMethod("setText", String.class).invoke(appBean,(String)returned);
						
					}
					
					appBean.setId(appQuest.getId());
					appBean.setSolved(appQuest.isSolved());
					appBean.setTitle(appQuest.getTitle());
					appBean.setStudent(appQuest.getStudent().getName());
					appBean.setSubject(appQuest.getQuestionSub().getAbbrevation());
					appBean.setType(appQuest.whoAmI());

					bean.add(appBean);
				}
			}
		
		}
		catch(SQLException e) {
			bean = null;
		}
		catch(ReflectiveOperationException e) {
			bean = null;
		}
		
		
		
		return bean;
		
	}
	
	
	
}
