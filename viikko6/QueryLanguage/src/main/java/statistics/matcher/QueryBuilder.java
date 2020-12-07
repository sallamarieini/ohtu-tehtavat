package statistics.matcher;

import javax.management.Query;

public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {
        matcher = new All();
    }

    public Matcher build() {
        Matcher match = matcher;
        matcher = new All();
        return match;
    }

    public Matcher matcher() {
        return matcher;
    }

    public QueryBuilder playsIn(String team) {
        matcher = new And(new PlaysIn(team), matcher);
        return this;
    }

    public QueryBuilder hasAtLeast(int count, String category) {
        matcher = new And(new HasAtLeast(count, category), matcher);
        return this;
    }

    public QueryBuilder hasFewerThan(int count, String category) {
        matcher = new And(new HasFewerThan(count, category), matcher);
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        matcher = matchers[0];
        for (Matcher m: matchers) {
            matcher = new Or(matcher, m);
        }
        return this;
    }

}
