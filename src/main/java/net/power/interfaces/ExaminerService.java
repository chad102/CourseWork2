package net.power.interfaces;

import net.power.BadRequestException;
import net.power.Question;

import java.util.List;
import java.util.Set;

public interface ExaminerService {
    List<String> getQuestions(int amount);
}
