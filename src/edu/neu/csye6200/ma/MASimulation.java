package edu.neu.csye6200.ma;

public class MASimulation {
	
    private MARuleA ruleA = new MARuleA();
    private MARuleB ruleB = new MARuleB();
    private MARuleC ruleC = new MARuleC();
	private final static String aa = "RuleA";
    private final static String bb = "RuleB";
    private final static String cc = "RuleC";

	public MASimulation() {
		// TODO Auto-generated constructor stub
	}
	
	public void applyRule(MAFrame maf, String currRule) {
		MAFrame.pos[0]++;
		if(currRule.equals(aa)) {
			ruleA.applyRule(maf, MAFrame.pos[0]);
		}else if(currRule.equals(bb)) {
			ruleB.applyRule(maf, MAFrame.pos[0]);
		}else if(currRule.equals(cc)) {
			ruleC.applyRule(maf, MAFrame.pos[0]);
		}
	}

}
