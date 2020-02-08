package logic.model.Dao;

import java.sql.SQLException;
import java.util.Vector;
import logic.model.Lesson;
import logic.model.Room;
import logic.model.Seat;
import logic.model.Subject;

public class NextLessonDao {
	
	private LessonDao nextLessonDao;
	private RoomDao nextRoomDao;
	private SubjectDao nextSubjectDao;
	private SeatDao nextSeatDao;

	public NextLessonDao() {
		nextLessonDao = new LessonDao();
		nextRoomDao = new RoomDao();
		nextSubjectDao = new SubjectDao();
		nextSeatDao = new SeatDao();
	}
	
	public Lesson getNextLesson() {
		Lesson nextLesson = null;
		try {
			nextLesson = nextLessonDao.getLessonById(getIdNextLesson());
			nextLesson.setRoomLesson(getRoom());
			nextLesson.setSubjectLesson(getSubjectOfLesson());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nextLesson;
	}
	
	public int getIdNextLesson(){
		int id = 0;
		try {
			id = nextLessonDao.findIdNextLesson();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("La lezione ha questo ID: "+id);
		return id;
	}
	
	public String getRoomNextLesson(){
		String name= null;
		try {
			name = this.nextRoomDao.getInfoRoomByIdLesson(getIdNextLesson());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	public Vector<Seat> getSeatsOfRoom() {
		Vector<Seat> places = null;
		try {
			places = this.nextSeatDao.getSeatsOfRoom(getRoomNextLesson());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return places;
	}
	
	public Room getRoom() {
		Room roomOfLesson = null;
		try {
			roomOfLesson = this.nextRoomDao.getRoom(getRoomNextLesson());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomOfLesson;
	}
	
	public Subject getSubjectOfLesson() {
		Subject subjectLesson = null;
		try {
			subjectLesson = this.nextSubjectDao.getSubjectLesson(getIdNextLesson());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subjectLesson;
	}
	
}
