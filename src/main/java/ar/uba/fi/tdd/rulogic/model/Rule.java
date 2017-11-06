package ar.uba.fi.tdd.rulogic.model;

import java.util.Set;

public class Rule {

    private String name;
    private String genericRule;


    public Rule(String genericRule){
        this.name = genericRule.substring(0,genericRule.indexOf("("));
        this.genericRule = genericRule;
    }

    public String getName(){
        return this.name;
    }

    private String[] getArguments(String rule){
        return rule.substring(rule.indexOf("(")+1,rule.indexOf(")")).split(",");
    }

    public boolean evaluate(String particularRule, Set<Fact> facts){
        String[] particularRuleArgs = getArguments(particularRule);
        String[] genericRuleArgs = getArguments(this.genericRule);
        String[] factsFromRule = this.genericRule.substring(this.genericRule.indexOf(":-") + 2).split("\\)\\W");
        for(String factStr : factsFromRule){
            factStr = factStr + ").";
            for(int i = 0; i < genericRuleArgs.length; i++){
                factStr = factStr.replaceAll(genericRuleArgs[i], particularRuleArgs[i]);
            }
            Fact fact = new Fact(factStr);
            if(!facts.contains(fact)){
                return false;
            }
        }
        return true;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rule rule = (Rule) o;

        return name.equals(rule.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public static boolean isRule(String rule){
        return rule.matches("\\w+\\(\\w+(,\\w+)*\\):-(\\w+\\(\\w+(,\\w+)*\\),)*\\w+\\(\\w+(,\\w+)*\\).");
    }

}
