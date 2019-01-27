package model.Strategy.ConcreteStrategy;

import model.Literature;
import model.Record;
import model.Strategy.Strategy;
import model.User;
import service.LiteratureService;
import service.RecordService;
import service.ServiceFactory;
import service.UserService;
import util.TimeUtil;

import java.sql.Timestamp;
import java.util.ArrayList;

import static util.ErrorCode.*;

public class TeacherStrategy implements Strategy {

    //教师可借专业书籍50本，其他书籍30本，期限6月
    private final int majorLimit = 50;
    private final int otherLimit = 30;
    private final int timeLimit = 6;
    private final int cost = 1;

    private UserService userService = ServiceFactory.getUserService();
    private RecordService recordService = ServiceFactory.getRecordService();
    private LiteratureService literatureService = ServiceFactory.getLiteratureService();

    @Override
    public int borrow(Literature literature, User user) {
        //已经借过本书
        if (recordService.getLastRecord(user.getId(), literature.getId()) != null) {
            return HaveBorrowed;
        }
        //本书已被借完
        if (literature.getNum() <= 0) {
            return NoMoreLiterature;
        }
        ArrayList<Record> records = recordService.getNRRecordByUid(user.getId());
        if (records != null && records.size() > 0) {
            int majorCont = 0, otherCont = 0;
            for (int i = 0; i < records.size(); i++) {
                Record record = records.get(i);
                if (user.getDepartment().contains(literatureService.getLiterature(record.getLid()).getCategory())) {
                    majorCont++;
                } else {
                    otherCont++;
                }
            }
            if (user.getDepartment().contains(literature.getCategory())) {
                majorCont++;
            } else {
                otherCont++;
            }
            //借书超出限制
            if (majorCont > majorLimit || otherCont > otherLimit) {
                return BorrowLimit;
            }
        }
        literature.setNum(literature.getNum() - 1);
        literatureService.updateLiterature(literature);
        Record record = new Record(user.getId(), literature.getId(), new Timestamp(System.currentTimeMillis()));
        record.setScheduleTime(TimeUtil.calScheduleTime(record.getStartTime(), timeLimit));
        recordService.addRecord(record);
        return SuccessBorrow;
    }

    @Override
    public int returnBook(Literature literature, User user) {
        Record record = recordService.getLastRecord(user.getId(), literature.getId());
        if (record == null) {
            return NoLiteratureToReturn;
        }
        literature.setNum(literature.getNum() + 1);
        literatureService.updateLiterature(literature);
        record.setEndTime(new Timestamp(System.currentTimeMillis()));
        int overdue = TimeUtil.getOverdue(record.getScheduleTime(), record.getEndTime());
        if (overdue <= 0) {
            return SuccessBorrow;
        } else {
            return overdue * cost;
        }
    }
}
