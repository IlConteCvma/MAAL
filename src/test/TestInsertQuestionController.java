package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.bean.QuestionBean;
import logic.bean.QuestionProblemBean;
import logic.controller.InsertQuestionController;
import logic.model.QuestionFactory;
import logic.model.QuestionProblem;
import logic.model.QuestionProblemFactory;
import logic.model.QuestionType;

public class TestInsertQuestionController {
	private static final  String TESTSTRING = "Value for test";

	@Test
	public void testSaveTextReflection() {
		InsertQuestionController controller = new InsertQuestionController(createFactory(),createBean());
		
		
		try {
			controller.saveTextReflection(TESTSTRING);
		} catch (ReflectiveOperationException e) {
			fail("Reflective operation error");
		}
	
		
			QuestionProblem question = (QuestionProblem) controller.getQuestion();
		
		assertEquals(TESTSTRING,question.getText());
	}
	
	private QuestionBean createBean() {
		//function for create the correct bean for test
		QuestionProblemBean bean = new QuestionProblemBean();
		bean.setTitle(TESTSTRING);
		bean.setStudent(null);
		bean.setType(QuestionType.PROBLEM);
		bean.setText(TESTSTRING);
	
		return bean;
	}
	
	private QuestionFactory createFactory() {
		return new QuestionProblemFactory();
	}

}
