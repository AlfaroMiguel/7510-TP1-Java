package ar.uba.fi.tdd.rulogic.model;

import java.util.Set;

public class Parser {

    private String rawDB;

    public Parser(String rawDB){
        this.rawDB = rawDB;
    }

    public boolean parseDB(Set<Fact> facts, Set<Rule> rules){
        String [] content = this.rawDB.split("\\n");
        for (String query : content){
            query = query.replaceAll("\\s+","");
            if(Fact.isFact(query)){
                //System.out.print("Agrego a la db (fact): " + query + "\n");
                facts.add(new Fact(query));
            }
            else if(Rule.isRule(query)){
                //System.out.print("Agrego a la db (rule): " + query + "\n");
                rules.add(new Rule(query));
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidQuery (String query){
        return query.matches("\\w+\\(\\w+(,\\w+)*\\).");
    }

    public static String getQueryName(String query){
        return query.substring(0,query.indexOf("("));
    }

}
