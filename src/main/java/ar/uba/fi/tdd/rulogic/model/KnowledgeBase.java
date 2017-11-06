package ar.uba.fi.tdd.rulogic.model;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KnowledgeBase {

	private Set<Fact> facts = new HashSet<Fact>();
	private Set<Rule> rules = new HashSet<Rule>();

	public boolean answer(String query) {
		query = query.replaceAll("\\s+","");

		if(Parser.isValidQuery(query)){

			Fact fact = new Fact(query);
			if(facts.contains(fact)){
				return true;
			}
			String name = Parser.getQueryName(query);
			Rule rule = new Rule(query);
			if(rules.contains(rule)){
				for(Rule r : rules){
					if (r.equals(rule)){
						return r.evaluate(query, facts);
					}
				}
			}
		}

		return false;
	}

	public boolean parseDB(String fileName){
		String db;
		try{
			db = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
		}
		catch(java.io.FileNotFoundException e){
			return  false;
		}

		Parser parser = new Parser(db);
		return parser.parseDB(this.facts, this.rules);
	}

}
