package com.etixapp.design.patterns.principles.OpenClose;

public class InterviewQuestionProcessor {

	// this class violate the open-close principle because it is tight couple to the InterviewQuestion because we have to check the type
	// that means if we add a new question category like JavaInterviewQuestions we have to change this class and this violate the open-close
	//**Solution:
	// 1.add an abstract method to InterviewQuestions Interface ex: execute()
	// 2.all InterviewQuestions implements InterviewQuestions Interface
	// 3.here just call the execute method
	public static void process(InterviewQuestions question){
		//**Solution:
		//question.execute();
		// this is a typical implementation of loosely coupled system
		// this class knows nothing about the question and its type
		// THIS is pure abstraction

		// this here is typical tight coupled example
		// in this case this class should always be aware of the question implementation and type
		if(question instanceof  AlgorithmsInterviewQuestions){
			AlgorithmsInterviewQuestions algorithms = (AlgorithmsInterviewQuestions) question;
			algorithms.executeAlgorithms();
		} else if(question instanceof  FinanceInterviewQuestions){
			FinanceInterviewQuestions finance = (FinanceInterviewQuestions) question;
			finance.executeFinance();
		}else if(question instanceof  AiInterviewQuestions){
			AiInterviewQuestions ai = (AiInterviewQuestions) question;
			ai.executeAi();
		}
	}
}
