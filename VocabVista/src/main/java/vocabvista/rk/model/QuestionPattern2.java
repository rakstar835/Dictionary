package vocabvista.rk.model;

public class QuestionPattern2 {

	private String question;
    private Options options;
    private String answer;

    public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public static class Options {
        private String A;
        private String B;
        private String C;
        private String D;
        private String E;
        private String F;
		public String getA() {
			return A;
		}
		public void setA(String a) {
			A = a;
		}
		public String getB() {
			return B;
		}
		public void setB(String b) {
			B = b;
		}
		public String getC() {
			return C;
		}
		public void setC(String c) {
			C = c;
		}
		public String getD() {
			return D;
		}
		public void setD(String d) {
			D = d;
		}
		public String getE() {
			return E;
		}
		public void setE(String e) {
			E = e;
		}
		public String getF() {
			return F;
		}
		public void setF(String f) {
			F = f;
		}
		
        
    }
}
