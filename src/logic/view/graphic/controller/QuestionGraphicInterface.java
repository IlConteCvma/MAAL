package logic.view.graphic.controller;

import java.io.IOException;
import execption.QuestionException;

public interface QuestionGraphicInterface {
	public void commit() throws QuestionException;
	public void back() throws IOException;
}
